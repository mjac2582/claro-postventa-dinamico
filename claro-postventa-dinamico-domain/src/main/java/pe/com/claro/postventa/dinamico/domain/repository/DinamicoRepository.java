package pe.com.claro.postventa.dinamico.domain.repository;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;

import org.hibernate.Session;
import org.hibernate.dialect.OracleTypesHelper;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;

import pe.com.claro.common.domain.repository.AbstractRepository;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.resource.exception.BDException;
import pe.com.claro.common.util.ClaroUtil;
import pe.com.claro.common.util.PropertiesExternos;
import pe.com.claro.postventa.dinamico.canonical.EvaluaCondicionRequest;
import pe.com.claro.postventa.dinamico.canonical.EvaluaCondicionResponse;
import pe.com.claro.postventa.dinamico.canonical.RegistraTransaccionRequest;
import pe.com.claro.postventa.dinamico.canonical.RegistraTransaccionResponse;
import pe.com.claro.postventa.dinamico.canonical.TransformaValorRequest;
import pe.com.claro.postventa.dinamico.canonical.TransformaValorResponse;
import pe.com.claro.postventa.dinamico.model.bean.request.ObtieneFlujoAutomaticoRequest;
import pe.com.claro.postventa.dinamico.model.bean.response.ObtieneFlujoAutomaticoResponse;
import pe.com.claro.postventa.dinamico.model.bean.types.CondicionesProcesosType;
import pe.com.claro.postventa.dinamico.model.bean.types.FlujoProcesosType;
import pe.com.claro.postventa.dinamico.model.bean.types.RelacionesProcesosType;

@Stateless
public class DinamicoRepository extends AbstractRepository<Object> implements Serializable {

	private static final long serialVersionUID = 4662487568791215272L;

	private static final Logger logger = LoggerFactory.getLogger(DinamicoRepository.class);

	@Context
	private Configuration configuration;

	@PersistenceContext(unitName = Constantes.PERSISTENCE_CONTEXT)
	public void setPersistenceUnit00(final EntityManager em) {
		this.entityManager = em;
	}

	@Override
	protected Predicate[] getSearchPredicates(Root<Object> root, Object example) {
		return new Predicate[0];
	}


//////////////////INICIO///////////////////////////
	public EvaluaCondicionResponse evaluaCondicion(PropertiesExternos propertiesExternos, String msgTx,
			EvaluaCondicionRequest request) throws BDException, JsonProcessingException {

		String nombreMetodo = "evaluaCondicion";
		String msgTxIn = msgTx + "[" + nombreMetodo + "]";
		long tiempoInicio = System.currentTimeMillis();

		EvaluaCondicionResponse response = new EvaluaCondicionResponse();
		StringBuffer storedProcedure = new StringBuffer();

		String bdNombre = propertiesExternos.vBdEvaluaCondicionNombre;

		logger.info(msgTx + "[INICIO] de metodo [" + nombreMetodo + "] - REPOSITORY]");
		storedProcedure.append(ClaroUtil.getStoredProcedureByParameters(propertiesExternos.vBdEvaluaCondicionEsquema,
				propertiesExternos.vBdEvaluaCondicionPaquete, propertiesExternos.vBdEvaluaCondicionSP));
		logger.info(msgTxIn + "Consultando a la BD: {}", bdNombre);
		logger.info(msgTx + "Timeout permitido de conexion: " + propertiesExternos.vBdEvaluaCondicionTimeout);
		logger.info(msgTx + "Ejecutando SP: " + storedProcedure);
		try {

			logger.info(msgTx + "Parametros SP [INPUT]: " + ClaroUtil.printPrettyJSONString(request));
			Session session = entityManager.unwrap(Session.class);
			session.doWork(new Work() {
				@Override
				public void execute(final Connection connection) throws SQLException {
					try {
						CallableStatement call = connection
								.prepareCall("call " + storedProcedure + " (?,?,?,?,?,?)");
						call.setQueryTimeout(Integer.parseInt(propertiesExternos.vBdEvaluaCondicionTimeout));

						call.setInt(Constantes.UNO, request.getIdFlujo());
						call.setInt(Constantes.DOS, request.getIdCondicion());
						call.setString(Constantes.TRES, request.getValores());
						
						call.registerOutParameter(Constantes.CUATRO, java.sql.Types.INTEGER);//ON_VALIDACION
						call.registerOutParameter(Constantes.CINCO, java.sql.Types.INTEGER);// ON_CODRESP
						call.registerOutParameter(Constantes.SEIS, java.sql.Types.VARCHAR);// OV_MSJRES

						//logger.info(msgTx + "antes del call");
						call.execute();
						//logger.info(msgTx + "despues del call");

						int codRespuesta = call.getInt(Constantes.CINCO);
						if(codRespuesta == Constantes.CERO) {
							
						}
						int valid = call.getInt(Constantes.CUATRO);
						boolean validacion = false;
						if (valid == Constantes.UNO) {
							validacion = true;
						}
						response.setCodResp(call.getInt(Constantes.CINCO));
						response.setMsjResp(call.getString(Constantes.SEIS));
						response.setValidacion(validacion);

					} catch (Exception e) {
						logger.error(msgTx + "Ocurrio un error al ejecutar el Statement");
						throw e;
					}
				}
			});
			logger.info(msgTx + "PARAMETROS [OUTPUT]: " + ClaroUtil.printPrettyJSONString(response));
		} catch (Exception ex) {
			StringWriter errors = new StringWriter();
			ex.printStackTrace(new PrintWriter(errors));
			String codigoError = Constantes.TEXTO_VACIO;
			logger.error(msgTx + errors.toString());
			if (errors.toString().toUpperCase(Locale.getDefault())
					.contains(Constantes.SQLTIMEOUTEXCEP.toUpperCase(Locale.getDefault()))) {
				codigoError = Constantes.ERROR_TIMEOUT;
				throw new BDException(codigoError, ex.getMessage(), bdNombre, ex);
			} else {
				codigoError = Constantes.ERROR_DISPONIBILIDAD;
				throw new BDException(codigoError, ex.getMessage(), bdNombre, ex);
			}
		} finally {
			logger.info(msgTx + " [FIN] - Metodo[" + nombreMetodo + "] - Tiempo Total del proceso(ms)= "
					+ (System.currentTimeMillis() - tiempoInicio));
		}
		return response;
	}
	
	public ObtieneFlujoAutomaticoResponse consultaFlujoAutomatico(PropertiesExternos propertiesExternos, String msgTx,
			ObtieneFlujoAutomaticoRequest request) throws BDException, JsonProcessingException {

		String nombreMetodo = "obtieneFlujoAutomatico";
		long tiempoInicio = System.currentTimeMillis();

		ObtieneFlujoAutomaticoResponse response = new ObtieneFlujoAutomaticoResponse();
		StringBuffer storedProcedure = new StringBuffer();

		String bdNombre = propertiesExternos.vBdFlujoAutomaticoNombre2;

		logger.info(msgTx + "[INICIO] de metodo [" + nombreMetodo + "] - REPOSITORY]");
		storedProcedure.append(ClaroUtil.getStoredProcedureByParameters(propertiesExternos.vBdFlujoAutomaticoEsquema2,
				propertiesExternos.vBdFlujoAutomaticoPaquete2, propertiesExternos.vBdFlujoAutomaticoSP2));
		logger.info(msgTx + " - Consultando a la BD: {}", bdNombre);
		logger.info(msgTx + " - Timeout permitido de conexion: " + propertiesExternos.vBdFlujoAutomaticoTimeout2);
		logger.info(msgTx + " - Ejecutando SP: " + storedProcedure);
		String param = ClaroUtil.printPrettyJSONString(request);
		try {

			logger.info(msgTx + " - Parametros SP [INPUT]: " + ClaroUtil.printPrettyJSONString(request));
			Session session = entityManager.unwrap(Session.class);
			session.doWork(new Work() {
				@Override
				public void execute(final Connection connection) throws SQLException {
					List<FlujoProcesosType> cursorFlujoProcesos = null;
					List<CondicionesProcesosType> cursorCondicionesProcesos = null;
					List<RelacionesProcesosType> cursorRelacionesProcesos = null;
					ResultSet kResultCursorFlujoProcesos = null;
					ResultSet kResultCursorCondicionesProcesos = null;
					ResultSet kResultCursorRelacionesProcesos = null;
					try {
						CallableStatement call = connection
								.prepareCall("call " + storedProcedure + " (?,?,?,?,?,?,?,?,?,?,?,?)");
						call.setQueryTimeout(Integer.parseInt(propertiesExternos.vBdFlujoAutomaticoTimeout2));

						call.setString(Constantes.UNO, request.getTransaccion());
						call.setString(Constantes.DOS, request.getTecnologia());
						call.setInt(Constantes.TRES, request.getIdtransversal());
						call.setString(Constantes.CUATRO, param);

						call.registerOutParameter(Constantes.CINCO, java.sql.Types.INTEGER);// ON_IDFLUJO
						call.registerOutParameter(Constantes.SEIS, java.sql.Types.VARCHAR);// OV_DESCRIPCION
						call.registerOutParameter(Constantes.SIETE, java.sql.Types.INTEGER);// ON_IDTRS
						call.registerOutParameter(Constantes.OCHO,
								OracleTypesHelper.INSTANCE.getOracleCursorTypeSqlType());// OC_DETFLUJO
						call.registerOutParameter(Constantes.NUEVE,
								OracleTypesHelper.INSTANCE.getOracleCursorTypeSqlType());// OC_DETCONDICION
						call.registerOutParameter(Constantes.DIEZ,
								OracleTypesHelper.INSTANCE.getOracleCursorTypeSqlType());// OC_RELPROCESOS
						call.registerOutParameter(Constantes.ONCE, java.sql.Types.INTEGER);// CON_CODRESP
						call.registerOutParameter(Constantes.DOCE, java.sql.Types.VARCHAR);// OV_MSJRES
						call.execute();
						int codRespuesta = call.getInt(Constantes.ONCE);
						String mensajeRespuesta = call.getString(Constantes.DOCE);

						kResultCursorFlujoProcesos = (ResultSet) call.getObject(Constantes.OCHO);
						kResultCursorCondicionesProcesos = (ResultSet) call.getObject(Constantes.NUEVE);
						kResultCursorRelacionesProcesos = (ResultSet) call.getObject(Constantes.DIEZ);

						if (kResultCursorFlujoProcesos != null) {
							cursorFlujoProcesos = new ArrayList<>();
							int i = Constantes.CERO;
							while (kResultCursorFlujoProcesos.next()) {
								FlujoProcesosType flujoProcesosType = new FlujoProcesosType();

								flujoProcesosType.setOrden(kResultCursorFlujoProcesos.getInt(Constantes.UNO));
								flujoProcesosType.setIdProceso(kResultCursorFlujoProcesos.getInt(Constantes.DOS));
								flujoProcesosType.setAbreviacion(kResultCursorFlujoProcesos.getString(Constantes.TRES));
								flujoProcesosType
										.setPreProceso(kResultCursorFlujoProcesos.getString(Constantes.CUATRO));
								flujoProcesosType
										.setPostProceso(kResultCursorFlujoProcesos.getString(Constantes.CINCO));
								flujoProcesosType
										.setFlagMandatorio(kResultCursorFlujoProcesos.getString(Constantes.SEIS));
								flujoProcesosType
										.setOrdenCondicion(kResultCursorFlujoProcesos.getInt(Constantes.SIETE));
								flujoProcesosType.setIdcondicion(kResultCursorFlujoProcesos.getInt(Constantes.OCHO));
								flujoProcesosType.setFlagRegistrarTransaccion(
										kResultCursorFlujoProcesos.getString(Constantes.NUEVE));
								flujoProcesosType.setReintentos(kResultCursorFlujoProcesos.getInt(Constantes.DIEZ));
								flujoProcesosType
										.setIdProcesoError(kResultCursorFlujoProcesos.getString(Constantes.ONCE));
								flujoProcesosType.setRuta(kResultCursorFlujoProcesos.getString(Constantes.DOCE));
								flujoProcesosType.setRequestHeader(kResultCursorFlujoProcesos.getString(Constantes.TRECE));
								flujoProcesosType.setRequestBody(kResultCursorFlujoProcesos.getString(Constantes.CATORCE));
								flujoProcesosType.setMetodo(kResultCursorFlujoProcesos.getString(Constantes.QUINCE));
								flujoProcesosType.setTimeout(kResultCursorFlujoProcesos.getInt(Constantes.DIECISEIS));
								//TODO agregado
								flujoProcesosType.setEstado(1);//estado en proceso
								flujoProcesosType.setCodigoRespuesta(-1);//inicializar codResp
								flujoProcesosType.setNumIntento(0);//inicializar número de intento
								cursorFlujoProcesos.add(flujoProcesosType);
								i++;
								//logger.info(msgTx + flujoProcesosType.getOrden());
							}
							logger.info(msgTx + " - Se encontraron "+i+" registros para el cursor OC_DETFLUJO");
						} else {
							logger.info(msgTx + " - No se encontraron registros para el cursor OC_DETFLUJO");
						}

						if (kResultCursorCondicionesProcesos != null) {
							cursorCondicionesProcesos = new ArrayList<>();
							int i = Constantes.CERO;
							while (kResultCursorCondicionesProcesos.next()) {
								CondicionesProcesosType condicionesProcesosType = new CondicionesProcesosType();

								condicionesProcesosType
										.setIdTipoCondicion(kResultCursorCondicionesProcesos.getInt(Constantes.UNO));
								condicionesProcesosType
										.setAbreviacion(kResultCursorCondicionesProcesos.getString(Constantes.DOS));
								condicionesProcesosType
										.setOrderCondicion(kResultCursorCondicionesProcesos.getInt(Constantes.TRES));
								condicionesProcesosType
										.setIdCondicion(kResultCursorCondicionesProcesos.getInt(Constantes.CUATRO));
								condicionesProcesosType
										.setOrden(kResultCursorCondicionesProcesos.getInt(Constantes.CINCO));
								condicionesProcesosType
										.setParametro(kResultCursorCondicionesProcesos.getString(Constantes.SEIS));
								condicionesProcesosType.setIdExpresionLogica(
										kResultCursorCondicionesProcesos.getInt(Constantes.SIETE));
								condicionesProcesosType.setExpresionLogica(
										kResultCursorCondicionesProcesos.getString(Constantes.OCHO));
								condicionesProcesosType
										.setValor(kResultCursorCondicionesProcesos.getString(Constantes.NUEVE));
								condicionesProcesosType.setIdExpresionPosterior(
										kResultCursorCondicionesProcesos.getInt(Constantes.DIEZ));
								condicionesProcesosType.setExpresionPosterior(
										kResultCursorCondicionesProcesos.getString(Constantes.ONCE));
								condicionesProcesosType
										.setCantidad(kResultCursorCondicionesProcesos.getInt(Constantes.DOCE));

								cursorCondicionesProcesos.add(condicionesProcesosType);
								i++;
								//logger.info(msgTx + condicionesProcesosType.getOrden());
							}
							logger.info(msgTx + " - Se encontraron "+i+" registros para el cursor OC_DETCONDICION");
						} else {
							logger.info(msgTx + " - No se encontraron registros para el cursor OC_DETCONDICION");
						}
						
						if (kResultCursorRelacionesProcesos != null) {
							cursorRelacionesProcesos = new ArrayList<>();
							int i = Constantes.CERO;
							while (kResultCursorRelacionesProcesos.next()) {
								RelacionesProcesosType relacionesProcesosType = new RelacionesProcesosType();
								relacionesProcesosType
								.setIdSeq(kResultCursorRelacionesProcesos.getInt(Constantes.UNO));
								relacionesProcesosType
										.setIdFlujo(kResultCursorRelacionesProcesos.getInt(Constantes.DOS));
								relacionesProcesosType
										.setIdProcesoPre(kResultCursorRelacionesProcesos.getInt(Constantes.TRES));
								relacionesProcesosType
										.setCampoPre(kResultCursorRelacionesProcesos.getString(Constantes.CUATRO));
								relacionesProcesosType
										.setIdProcesoPost(kResultCursorRelacionesProcesos.getInt(Constantes.CINCO));
								relacionesProcesosType
										.setCampoPost(kResultCursorRelacionesProcesos.getString(Constantes.SEIS));
								relacionesProcesosType
										.setFlagTransformacion(kResultCursorRelacionesProcesos.getString(Constantes.SIETE));
								relacionesProcesosType.setScriptTransformacion(
										kResultCursorRelacionesProcesos.getString(Constantes.OCHO));

								cursorRelacionesProcesos.add(relacionesProcesosType);
								i++;
								//logger.info(msgTx + condicionesProcesosType.getOrden());
							}
							logger.info(msgTx + " - Se encontraron "+i+" registros para el cursor OC_RELPROCESOS");
						} else {
							logger.info(msgTx + " - No se encontraron registros para el cursor OC_RELPROCESOS");
						}
						
						response.setCodigoRespuesta(codRespuesta);
						response.setMensajeRespuesta(mensajeRespuesta);
						response.setIdFlujo(call.getInt(Constantes.CINCO));
						response.setDescripcion(call.getString(Constantes.SEIS));
						response.setIdTransaccion(call.getInt(Constantes.SIETE));
						response.setListaFlujoProcesos(cursorFlujoProcesos);
						response.setListaCondicionesProcesos(cursorCondicionesProcesos);
						response.setListaRelacionesProcesos(cursorRelacionesProcesos);

					} catch (Exception e) {
						logger.error(msgTx + " - Ocurrio un error al ejecutar el Statement");
						throw e;
					}
				}
			});
			logger.info(msgTx + "PARAMETROS [OUTPUT]: " + ClaroUtil.printPrettyJSONString(response).replace(Constantes.SALTO_LINEA_DOBLE, Constantes.SALTO_LINEA).replace("\\\"", "\""));
		} catch (Exception ex) {
			StringWriter errors = new StringWriter();
			ex.printStackTrace(new PrintWriter(errors));
			String codigoError = Constantes.TEXTO_VACIO;
			logger.error(msgTx + errors.toString());
			if (errors.toString().toUpperCase(Locale.getDefault())
					.contains(Constantes.SQLTIMEOUTEXCEP.toUpperCase(Locale.getDefault()))) {
				codigoError = Constantes.ERROR_TIMEOUT;
				throw new BDException(codigoError, ex.getMessage(), bdNombre, ex);
			} else {
				codigoError = Constantes.ERROR_DISPONIBILIDAD;
				throw new BDException(codigoError, ex.getMessage(), bdNombre, ex);
			}
		} finally {
			logger.info(msgTx + " [FIN] - Metodo[" + nombreMetodo + "] - Tiempo Total del proceso(ms)= "
					+ (System.currentTimeMillis() - tiempoInicio));
		}
		return response;
	}
	
	public RegistraTransaccionResponse registraTransaccion(PropertiesExternos propertiesExternos, String msgTx,
			RegistraTransaccionRequest request) throws BDException, JsonProcessingException {

		String nombreMetodo = "registraTransaccion";
		String msgTxIn = msgTx + "[" + nombreMetodo + "]";
		long tiempoInicio = System.currentTimeMillis();

		RegistraTransaccionResponse response = new RegistraTransaccionResponse();
		StringBuffer storedProcedure = new StringBuffer();

		String bdNombre = propertiesExternos.vBdRegistraTransaccionNombre;

		/*
		 * String IV_TRANSACCION = request.getTransaccion(); String IV_TECNOLOGIA =
		 * request.getTecnologia(); int IN_IDTRANSVERSAL = request.getIdtransversal();
		 * Clob IB_PARAM_ENVIO = request.getParamEnvio();
		 */

		logger.info(msgTx + "[INICIO] de metodo [" + nombreMetodo + "] - REPOSITORY]");
		storedProcedure.append(ClaroUtil.getStoredProcedureByParameters(propertiesExternos.vBdRegistraTransaccionEsquema,
				propertiesExternos.vBdRegistraTransaccionPaquete, propertiesExternos.vBdRegistraTransaccionSP));
		logger.info(msgTxIn + "Consultando a la BD: {}", bdNombre);
		logger.info(msgTx + "Timeout permitido de conexion: " + propertiesExternos.vBdRegistraTransaccionTimeout);
		logger.info(msgTx + "Ejecutando SP: " + storedProcedure);
		try {

			logger.info(msgTx + "Parametros SP [INPUT]: " + ClaroUtil.printPrettyJSONString(request).replace("\\n", "\n").replace("\\\"", "\"").replace("\\r", "\r"));
			Session session = entityManager.unwrap(Session.class);
			session.doWork(new Work() {
				@Override
				public void execute(final Connection connection) throws SQLException {
					try {
						CallableStatement call = connection
								.prepareCall("call " + storedProcedure + " (?,?,?,?,?)");
						call.setQueryTimeout(Integer.parseInt(propertiesExternos.vBdRegistraTransaccionTimeout));

						call.setInt(Constantes.UNO, request.getIdTransaccion());
						call.setString(Constantes.DOS, request.getTramaCabecera());
						call.setString(Constantes.TRES, request.getTramaDetalle());
						
						call.registerOutParameter(Constantes.CUATRO, java.sql.Types.INTEGER);// ON_CODRESP
						call.registerOutParameter(Constantes.CINCO, java.sql.Types.VARCHAR);// OV_MSJRES

						//logger.info(msgTx + "antes del call");
						call.execute();
						//logger.info(msgTx + "despues del call");

						
						response.setCodResp(call.getInt(Constantes.CUATRO));
						response.setMsjResp(call.getString(Constantes.CINCO));

					} catch (Exception e) {
						logger.error(msgTx + "Ocurrio un error al ejecutar el Statement");
						throw e;
					}
				}
			});
			logger.info(msgTx + "PARAMETROS [OUTPUT]: " + ClaroUtil.printPrettyJSONString(response));
		} catch (Exception ex) {
			StringWriter errors = new StringWriter();
			ex.printStackTrace(new PrintWriter(errors));
			String codigoError = Constantes.TEXTO_VACIO;
			logger.error(msgTx + errors.toString());
			if (errors.toString().toUpperCase(Locale.getDefault())
					.contains(Constantes.SQLTIMEOUTEXCEP.toUpperCase(Locale.getDefault()))) {
				codigoError = Constantes.ERROR_TIMEOUT;
				throw new BDException(codigoError, ex.getMessage(), bdNombre, ex);
			} else {
				codigoError = Constantes.ERROR_DISPONIBILIDAD;
				throw new BDException(codigoError, ex.getMessage(), bdNombre, ex);
			}
		} finally {
			logger.info(msgTx + " [FIN] - Metodo[" + nombreMetodo + "] - Tiempo Total del proceso(ms)= "
					+ (System.currentTimeMillis() - tiempoInicio));
		}
		return response;
	}
	
	public TransformaValorResponse transformaValor(PropertiesExternos propertiesExternos, String msgTx,
			TransformaValorRequest request) throws BDException, JsonProcessingException {

		String nombreMetodo = "transformaValor";
		String msgTxIn = msgTx + "[" + nombreMetodo + "]";
		long tiempoInicio = System.currentTimeMillis();

		TransformaValorResponse response = new TransformaValorResponse();
		StringBuffer storedProcedure = new StringBuffer();

		String bdNombre = propertiesExternos.vBdTransformaValorNombre;

		/*
		 * String IV_TRANSACCION = request.getTransaccion(); String IV_TECNOLOGIA =
		 * request.getTecnologia(); int IN_IDTRANSVERSAL = request.getIdtransversal();
		 * Clob IB_PARAM_ENVIO = request.getParamEnvio();
		 */

		logger.info(msgTx + "[INICIO] de metodo [" + nombreMetodo + "] - REPOSITORY]");
		storedProcedure.append(ClaroUtil.getStoredProcedureByParameters(propertiesExternos.vBdTransformaValorEsquema,
				propertiesExternos.vBdTransformaValorPaquete, propertiesExternos.vBdTransformaValorSP));
		logger.info(msgTxIn + "Consultando a la BD: {}", bdNombre);
		logger.info(msgTx + "Timeout permitido de conexion: " + propertiesExternos.vBdTransformaValorTimeout);
		logger.info(msgTx + "Ejecutando SP: " + storedProcedure);
		try {

			logger.info(msgTx + "Parametros SP [INPUT]: " + ClaroUtil.printPrettyJSONString(request));
			Session session = entityManager.unwrap(Session.class);
			session.doWork(new Work() {
				@Override
				public void execute(final Connection connection) throws SQLException {
					try {
						CallableStatement call = connection
								.prepareCall("call " + storedProcedure + " (?,?,?,?,?)");
						call.setQueryTimeout(Integer.parseInt(propertiesExternos.vBdTransformaValorTimeout));

						call.setInt(Constantes.UNO, request.getIdSeq());
						call.setString(Constantes.DOS, request.getValor());
						
						call.registerOutParameter(Constantes.TRES, java.sql.Types.VARCHAR);// ON_VALORTRANSFORMADO
						call.registerOutParameter(Constantes.CUATRO, java.sql.Types.INTEGER);// ON_CODRESP
						call.registerOutParameter(Constantes.CINCO, java.sql.Types.VARCHAR);// OV_MSJRES

						//logger.info(msgTx + "antes del call");
						call.execute();
						//logger.info(msgTx + "despues del call");

						response.setValorTransformado(call.getString(Constantes.TRES));
						response.setCodResp(call.getInt(Constantes.CUATRO));
						response.setMsjResp(call.getString(Constantes.CINCO));

					} catch (Exception e) {
						logger.error(msgTx + "Ocurrio un error al ejecutar el Statement");
						throw e;
					}
				}
			});
			logger.info(msgTx + "PARAMETROS [OUTPUT]: " + ClaroUtil.printPrettyJSONString(response));
		} catch (Exception ex) {
			StringWriter errors = new StringWriter();
			ex.printStackTrace(new PrintWriter(errors));
			String codigoError = Constantes.TEXTO_VACIO;
			logger.error(msgTx + errors.toString());
			if (errors.toString().toUpperCase(Locale.getDefault())
					.contains(Constantes.SQLTIMEOUTEXCEP.toUpperCase(Locale.getDefault()))) {
				codigoError = Constantes.ERROR_TIMEOUT;
				throw new BDException(codigoError, ex.getMessage(), bdNombre, ex);
			} else {
				codigoError = Constantes.ERROR_DISPONIBILIDAD;
				throw new BDException(codigoError, ex.getMessage(), bdNombre, ex);
			}
		} finally {
			logger.info(msgTx + " [FIN] - Metodo[" + nombreMetodo + "] - Tiempo Total del proceso(ms)= "
					+ (System.currentTimeMillis() - tiempoInicio));
		}
		return response;
	}
}
