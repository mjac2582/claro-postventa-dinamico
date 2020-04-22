package pe.com.claro.postventa.dinamico.domain.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import pe.com.claro.common.bean.HeaderRequest;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.resource.exception.BDException;
import pe.com.claro.common.util.ClaroUtil;
import pe.com.claro.common.util.PropertiesExternos;
import pe.com.claro.postventa.dinamico.canonical.EjecutarFlujoAutomaticoRequest;
import pe.com.claro.postventa.dinamico.canonical.EjecutarFlujoAutomaticoResponse;
import pe.com.claro.postventa.dinamico.canonical.EvaluaCondicionRequest;
import pe.com.claro.postventa.dinamico.canonical.EvaluaCondicionResponse;
import pe.com.claro.postventa.dinamico.canonical.RegistraTransaccionRequest;
import pe.com.claro.postventa.dinamico.canonical.RegistraTransaccionResponse;
import pe.com.claro.postventa.dinamico.canonical.TransformaValorRequest;
import pe.com.claro.postventa.dinamico.canonical.TransformaValorResponse;
import pe.com.claro.postventa.dinamico.domain.repository.DinamicoRepository;
import pe.com.claro.postventa.dinamico.integration.client.proxy.rest.impl.RestImpl;
import pe.com.claro.postventa.dinamico.model.bean.request.ObtieneFlujoAutomaticoRequest;
import pe.com.claro.postventa.dinamico.model.bean.response.ObtieneFlujoAutomaticoResponse;
import pe.com.claro.postventa.dinamico.model.bean.types.CondicionesProcesosType;
import pe.com.claro.postventa.dinamico.model.bean.types.FlujoProcesosType;
import pe.com.claro.postventa.dinamico.model.bean.types.RelacionesProcesosType;

@Stateless
public class DinamicoService {

	private static final Logger logger = LoggerFactory.getLogger(DinamicoService.class);

	@EJB
	private DinamicoRepository dinamicoRepository;

	public EjecutarFlujoAutomaticoResponse ejecutarFlujoAutomatico(PropertiesExternos propertiesExternos,
			HeaderRequest header, String IdTx, String msgTx, EjecutarFlujoAutomaticoRequest request) throws JsonProcessingException {
		String nombreMetodo = "ejecutarFlujoAutomatico";
		long tiempoInicio = System.currentTimeMillis();

		EjecutarFlujoAutomaticoResponse ejecutarFlujoAutomaticoResponse = new EjecutarFlujoAutomaticoResponse();
		

		ObtieneFlujoAutomaticoRequest obtieneFlujoAutomaticoRequest = new ObtieneFlujoAutomaticoRequest();
		ObtieneFlujoAutomaticoResponse obtieneFlujoAutomaticoResponse = new ObtieneFlujoAutomaticoResponse();

		try {
			logger.info(msgTx + "[INICIO] - METODO: [" + nombreMetodo + " - SERVICE]");

			logger.info(msgTx + "[Actividad 2. Obtener Flujo Automático]");
			

			obtieneFlujoAutomaticoRequest.setTransaccion(request.getTransaccion());
			obtieneFlujoAutomaticoRequest.setTecnologia(request.getTecnologia());
			obtieneFlujoAutomaticoRequest.setIdtransversal(propertiesExternos.vIdTransversal2);
			obtieneFlujoAutomaticoRequest.setParamEnvio(request.getParametros());
			obtieneFlujoAutomaticoResponse = dinamicoRepository.consultaFlujoAutomatico(propertiesExternos, msgTx,
					obtieneFlujoAutomaticoRequest);

			
			boolean validaProceso = false;

			if (obtieneFlujoAutomaticoResponse.getCodigoRespuesta() == Constantes.CERO) {
				ejecutarFlujoAutomaticoResponse.setIdTransaccion(obtieneFlujoAutomaticoResponse.getIdTransaccion());
				ejecutarFlujoAutomaticoResponse.setIdFlujo(obtieneFlujoAutomaticoResponse.getIdFlujo());
				ejecutarFlujoAutomaticoResponse.setDescripcionFlujo(obtieneFlujoAutomaticoResponse.getDescripcion());
				if (obtieneFlujoAutomaticoResponse.getListaFlujoProcesos() != null
						&& obtieneFlujoAutomaticoResponse.getListaFlujoProcesos().size() > 0) {
					ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDF0);
					ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF0);

					// ejecutar proceso
					validaProceso = true;
					
				} else {
					ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDF3);
					ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF3);
				}
			} else {
				String codigo = propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDF2;
				String mensaje = propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF2;
				mensaje = mensaje.replaceAll(Constantes.COD_RESP, Constantes.TEXTO_VACIO+obtieneFlujoAutomaticoResponse.getCodigoRespuesta()).replaceAll(Constantes.MSJ_RESP,obtieneFlujoAutomaticoResponse.getMensajeRespuesta());
				ejecutarFlujoAutomaticoResponse.setCodigo(codigo);
				ejecutarFlujoAutomaticoResponse.setMensaje(mensaje);
			}
			// ejecutar proceso
			if (validaProceso) {
				logger.info(msgTx + " [INICIO] [EJECUTAR PROCESOS]");
				msgTx+=" - ";
				String procesoEjecutado = Constantes.NUM_CERO;
				logger.info(msgTx+"Se agrega proceso Comodín");
				//agregando proceso comodin
				obtieneFlujoAutomaticoResponse.setListaFlujoProcesos(obtieneFlujoAutomaticoResponse.agregaProcesoComodin(header,request));
				logger.info(msgTx+"Proceso Comodín agregado");
				//formatear request - orden dinamico de parámetros
				logger.info(msgTx+"Se formateará llaves");
				obtieneFlujoAutomaticoResponse.formatearRequest();
				logger.info(msgTx+"Llaves formateadas");
				FlujoProcesosType flujoProcesosType = new FlujoProcesosType();
				boolean procesoError = Constantes.FALSE;
				int contProcesoError = Constantes.CERO;
				int idProcesoError = Constantes.CERO;
				List<Integer> procesosError = new ArrayList<Integer>();
				int contProcesos = Constantes.CERO;
				while (!procesoEjecutado.equals(Constantes.MENSAJEOK)) {
					RestImpl restImpl = new RestImpl();
					if (!procesoError) {
						flujoProcesosType = obtieneProcesoAEjecutar(propertiesExternos,msgTx,obtieneFlujoAutomaticoResponse,
								procesoEjecutado);
					}else if(procesoError && contProcesoError <= procesosError.size()){
						flujoProcesosType = obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorIdProceso(idProcesoError);
					}else if(procesoError && contProcesoError > procesosError.size()){
						flujoProcesosType = null;
					}
					if (flujoProcesosType != null) {
						contProcesos++;
						int reintentos = flujoProcesosType.getReintentos();
						String nombre = flujoProcesosType.getAbreviacion();
						logger.info(msgTx+" [INICIO] ["+nombre+"]");
						msgTx+=" - ";
						logger.info(msgTx+"Se ejecutará el proceso número: "+contProcesos);
						logger.info(msgTx+"Proceso: "+flujoProcesosType.getIdProceso());
						logger.info(msgTx+"Nombre: "+nombre);
						logger.info(msgTx+"Cantidad de Reintentos para el proceso: "+reintentos);
						logger.info(msgTx+"Pre Proceso(s): "+flujoProcesosType.getPreProceso());
						logger.info(msgTx+"Post Proces(s): "+flujoProcesosType.getPostProceso());
						logger.info(msgTx+"Proceso(s) Error: "+flujoProcesosType.getIdProcesoError());
						int statusCode = 0;
						while (reintentos>0 && (statusCode < Constantes.CODIGO_200
								|| statusCode > Constantes.CODIGO_205)) {
							logger.info(msgTx + "Número de intento: "+(flujoProcesosType.getNumIntento()+Constantes.UNO));
							// castea request siguiente
							// actualiza los parametros dentro la lista de procesos en
							// obtieneFlujoAutomaticoResponse
							obtieneFlujoAutomaticoResponse = casteaProceso(propertiesExternos,msgTx,obtieneFlujoAutomaticoResponse,
									flujoProcesosType);//TODO
							// obtengo el flujoProcesosType actualizado
							flujoProcesosType = obtieneFlujoAutomaticoResponse
									.obtenerFlujoProcesosTypePorIdProceso(flujoProcesosType.getIdProceso());
							// ejecuta proceso
							// se ejectua el proceso y se actualiza flujoProcesosType
							flujoProcesosType = restImpl.ejecutarRest(flujoProcesosType, msgTx);
							// reemplazo el flujoProcesosType actualizado
							obtieneFlujoAutomaticoResponse.reemplazaFlujoProcesoType(flujoProcesosType);
							procesoEjecutado = String.valueOf(flujoProcesosType.getIdProceso());
							String campoStatusCode = Constantes.STATUS_CODE;
							String json = flujoProcesosType.obtieneJsonUrl(campoStatusCode);
							statusCode = 0;
							if(campoStatusCode!=null) {
								JsonParser jsonParser = new JsonParser();
								JsonElement jsonElement = jsonParser.parse(json);
								JsonElement jsonElementValue = getLlave(jsonElement, obtieneLlave(campoStatusCode));
								if(jsonElementValue.isJsonPrimitive()) {
									JsonPrimitive valor = jsonElementValue.getAsJsonPrimitive();
									if(valor.isNumber()) {
										statusCode = valor.getAsInt();
									}
								}
							}
							reintentos--;
							logger.info(msgTx+"Registrar proceso: "+flujoProcesosType.getFlagRegistrarTransaccion());
							if(flujoProcesosType.getFlagRegistrarTransaccion().equals(Constantes.SI)) {
								registraTransaccion(msgTx,propertiesExternos,obtieneFlujoAutomaticoResponse);//TODO
							}
						}
						logger.info(msgTx+"Proceso(s) Error: "+flujoProcesosType.getFlagRegistrarTransaccion());
						//verificar si es error y tiene procesos error
						if(!procesoError && flujoProcesosType.getIdProcesoError()!=null && (statusCode<Constantes.CODIGO_200 || statusCode>Constantes.CODIGO_205)) {
							procesoError = Constantes.TRUE;
							logger.info(msgTx+"Ocurrió un Error o la Respuesta no es la esperada al ejecutar el proceso");
							logger.info(msgTx+"Se ejecutará Proceso(s) Error: "+flujoProcesosType.getIdProcesoError());
							String [] procesosErrorS = flujoProcesosType.getIdProcesoError().split(Constantes.COMA);
							for (int i = 0; i < procesosErrorS.length; i++) {
								procesosError.add(Integer.parseInt(procesosErrorS[i]));
							}
						}
						if (procesoError && contProcesoError < procesosError.size()) {
							idProcesoError = procesosError.get(contProcesoError);
							logger.info(msgTx + "Número Proceso Error: "+(contProcesoError+Constantes.UNO));
							logger.info(msgTx + "Proceso Error a ejecutar: "+idProcesoError);
						}
						if(procesoError) {
							contProcesoError++;
						}
						logger.info(msgTx+" [FIN] ["+nombre+"]");
						msgTx=msgTx.substring(0, msgTx.length()-3);
					} else {
						procesoEjecutado = Constantes.MENSAJEOK;
						logger.info(msgTx + " [FIN] [EJECUTAR PROCESOS]");
					}
				}
				FlujoProcesosType flujoProcesosType0 = obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorIdProceso(0);
				flujoProcesosType0.setCodigoRespuesta(Integer.parseInt(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDF0));
				flujoProcesosType0.setMensajeRespuesta(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF0);
				flujoProcesosType0.setResponseBody(ClaroUtil.printPrettyJSONString(ejecutarFlujoAutomaticoResponse).replace(Constantes.SALTO_LINEA_DOBLE, Constantes.SALTO_LINEA).replace(Constantes.DOBLE_COMILLA, Constantes.COMILLA));
				flujoProcesosType0.setEstado(Constantes.DOS);
				obtieneFlujoAutomaticoResponse.reemplazaFlujoProcesoType(flujoProcesosType0);
				ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDF0);
				ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF0);
				registraTransaccion(msgTx,propertiesExternos,obtieneFlujoAutomaticoResponse);//TODO
			}
		} catch (BDException e) {
			if (Constantes.ERROR_TIMEOUT == e.getCode()) {
				String msgIDT = StringUtils.replace(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT3,
						Constantes.DOBLE_LLAVE, e.getNomService());
				logger.error(msgTx + "ERROR: " + msgIDT);
				logger.error(msgTx + "ERROR: [BDException] - [" + "Error de timeout: ", e.getMessage(), e);
				ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDT3);
				ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT3);

			} else if (Constantes.ERROR_DISPONIBILIDAD == e.getCode()) {
				String msgIDT = StringUtils.replace(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT2,
						Constantes.DOBLE_LLAVE, e.getNomService());
				logger.error(msgTx + "ERROR: " + msgIDT);
				logger.error(msgTx + "ERROR: [BDException] - [" + "Error de disponibilidad: ", e.getMessage(),
						e);
				ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDT2);
				ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT2);
			} else {
				String msgIDT = StringUtils.replace(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT5,
						Constantes.DOBLE_LLAVE, e.getNomService());
				logger.error(msgTx + "ERROR: " + msgIDT);
				logger.error(msgTx + "ERROR: [BDException] - [" + "Error de conexion: ", e.getMessage(), e);
				ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDT5);
				ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT5);
			}
		} catch (Exception e) {
			if (e.getMessage() != null && e.getMessage().toString().contains(Constantes.HTTP_CLIENT_ERROR_EXCEPTION)) {
				logger.error(msgTx + "ERROR: " + propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT4);
				logger.error(msgTx + "ERROR: [Exception] - [" + "Error de conexion: ]", e.getMessage(), e);
			} else {
				logger.error(msgTx + "ERROR: " + propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT5);
				logger.error(msgTx + "ERROR: [Exception] - [" + "Error inesperado: ", e.getMessage(), e);
			}
			ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDF2);
			ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDF2);
		} finally {
			logger.info(msgTx + "Fin del método " + nombreMetodo + " - Tiempo Total Transacción(ms)= "
					+ (System.currentTimeMillis() - tiempoInicio));
		}
		return ejecutarFlujoAutomaticoResponse;
	}


	private void registraTransaccion(String msgTx, PropertiesExternos propertiesExternos,
			ObtieneFlujoAutomaticoResponse obtieneFlujoAutomaticoResponse) throws BDException, JsonProcessingException {
		
		//registra transaccion
		String tramaCabecera = Constantes.TEXTO_VACIO;
		String tramaDetalle = Constantes.TEXTO_VACIO;
		RegistraTransaccionRequest registraTransaccionRequest = new RegistraTransaccionRequest();
		
		tramaCabecera+=obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorIdProceso(Constantes.CERO).getResponseBody()+"|";
		tramaCabecera+=obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorIdProceso(Constantes.CERO).getEstado()+"|";
		tramaCabecera+=obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorIdProceso(Constantes.CERO).getCodigoRespuesta()+"|";
		tramaCabecera+=obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorIdProceso(Constantes.CERO).getMensajeRespuesta();
		
		List<FlujoProcesosType> listaFlujoProcesos = obtieneFlujoAutomaticoResponse.getListaFlujoProcesos();
		
		for (int i = 0; i < listaFlujoProcesos.size(); i++) {
			FlujoProcesosType flujoProcesosType = listaFlujoProcesos.get(i);
			tramaDetalle += flujoProcesosType.getIdProceso()+"|";
			if(flujoProcesosType.getRequestBody()!=null) {
				tramaDetalle += flujoProcesosType.getRequestBody().replace(Constantes.SALTO_LINEA_DOBLE, Constantes.SALTO_LINEA).replace(Constantes.DOBLE_COMILLA, Constantes.COMILLA);
			}
			tramaDetalle += "|";
			if(flujoProcesosType.getResponseBody()!=null) {
				tramaDetalle += flujoProcesosType.getResponseBody().replace(Constantes.SALTO_LINEA_DOBLE, Constantes.SALTO_LINEA).replace(Constantes.DOBLE_COMILLA, Constantes.COMILLA);
			}
			tramaDetalle += "|";
			
			tramaDetalle += flujoProcesosType.getEstado()+"|";
			tramaDetalle += flujoProcesosType.getNumIntento()+"|";
			
			tramaDetalle += flujoProcesosType.getCodigoRespuesta()+"|";
			if(flujoProcesosType.getMensajeRespuesta()!=null) {
				tramaDetalle += flujoProcesosType.getMensajeRespuesta();
			}
			tramaDetalle += "#";
		}
		tramaDetalle = tramaDetalle.substring(0, tramaDetalle.length()-1);
		registraTransaccionRequest.setIdTransaccion(obtieneFlujoAutomaticoResponse.getIdTransaccion());
		registraTransaccionRequest.setTramaCabecera(tramaCabecera);
		registraTransaccionRequest.setTramaDetalle(tramaDetalle);
		RegistraTransaccionResponse registraTransaccionResponse = dinamicoRepository.registraTransaccion(propertiesExternos, msgTx,
				registraTransaccionRequest);
		if(registraTransaccionResponse.getCodResp()==Constantes.CERO) {
			logger.info(msgTx + "Se registró la transacción con Éxito");
		}else {
			//error
			logger.error(msgTx + "No se registró la transacción");
		}
	}



	private ObtieneFlujoAutomaticoResponse casteaProceso(PropertiesExternos propertiesExternos, String msgTx, ObtieneFlujoAutomaticoResponse obtieneFlujoAutomaticoResponse,
			FlujoProcesosType flujoProcesosTypePost) throws JsonProcessingException, BDException {
		// obtener la lista de casteo para el proceso post
		List<RelacionesProcesosType> listaRelacionesProceso = obtieneFlujoAutomaticoResponse
				.listaRelacionesProcesosPorIdProceso(flujoProcesosTypePost.getIdProceso());
		logger.info(msgTx + " [INICIO] [Casteo Proceso]");
		msgTx+=" - ";
		for (int i = 0; i < listaRelacionesProceso.size(); i++) {
			// Obtener proceso pre
			FlujoProcesosType flujoProcesosTypePre = obtieneFlujoAutomaticoResponse
					.obtenerFlujoProcesosTypePorIdProceso(listaRelacionesProceso.get(i).getIdProcesoPre());
			logger.info(msgTx + " - - - Casteo número:"+(i+Constantes.UNO)+" del total: "+listaRelacionesProceso.size());
			logger.info(msgTx + " - - - ID Proceso Pre: "+flujoProcesosTypePre.getIdProceso()+" - ID Proceso Post: "+flujoProcesosTypePost.getIdProceso());
			logger.info(msgTx + " - - - Proceso Pre: "+flujoProcesosTypePre.getAbreviacion()+" - Proceso Post: "+flujoProcesosTypePost.getAbreviacion());
			logger.info(msgTx + " - - - Campo Pre: "+listaRelacionesProceso.get(i).getCampoPre()+" - Campo Post: "+listaRelacionesProceso.get(i).getCampoPost());
			logger.info(msgTx + " - - - Realizar transformación de valor: "+ listaRelacionesProceso.get(i).getFlagTransformacion());
			flujoProcesosTypePost = casteaRequest(propertiesExternos,msgTx,flujoProcesosTypePre, listaRelacionesProceso.get(i).getCampoPre(),
					flujoProcesosTypePost, listaRelacionesProceso.get(i).getCampoPost(),listaRelacionesProceso.get(i).getFlagTransformacion(),listaRelacionesProceso.get(i).getIdSeq());
		}
		logger.info(msgTx + " - - [FIN] [Casteo Proceso]");
		obtieneFlujoAutomaticoResponse.reemplazaFlujoProcesoType(flujoProcesosTypePost);
		return obtieneFlujoAutomaticoResponse;
	}
	
	private FlujoProcesosType casteaRequest(PropertiesExternos propertiesExternos, String msgTx, FlujoProcesosType flujoProcesosTypePre, String campoPre,
			FlujoProcesosType flujoProcesosTypePost, String campoPost, String flagTransformacion, int idSeq) throws BDException, JsonProcessingException {
		// obtener jsonPre
		String jsonPre = flujoProcesosTypePre.obtieneJsonUrl(campoPre);
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = jsonParser.parse(jsonPre);
		// obtener llave
		JsonElement jsonElementValue = getLlave(jsonElement, obtieneLlave(campoPre));
		String valorString = Constantes.TEXTO_VACIO;
		if(jsonElementValue != null) {
			valorString = jsonElementValue.toString();
		}
		logger.info(msgTx + " - - - Valor obtenido: "+valorString);
		valorString = Constantes.TEXTO_VACIO;
		if(flagTransformacion.equals(Constantes.SI)) {
			logger.info(msgTx + " - Se procede a realizar la transformación");
			String valor = Constantes.TEXTO_VACIO;
			if(jsonElementValue.isJsonArray()||jsonElementValue.isJsonObject()) {
				valor = jsonElementValue.toString();
			}else if(jsonElementValue.isJsonPrimitive()) {
				JsonPrimitive jsonPrimitive = jsonElementValue.getAsJsonPrimitive();
				if(jsonPrimitive.isNumber()) {
					valor = Constantes.TEXTO_VACIO+jsonPrimitive.getAsNumber();
				}else if(jsonPrimitive.isString()) {
					valor = Constantes.TEXTO_VACIO+jsonPrimitive.getAsString();
				}else if(jsonPrimitive.isBoolean()) {
					valor = Constantes.TEXTO_VACIO+jsonPrimitive.getAsBoolean();
				}
			}
			//ejecutar transformacion
			TransformaValorRequest transformaValorRequest = new TransformaValorRequest();
			transformaValorRequest.setIdSeq(idSeq);
			transformaValorRequest.setValor(valor);
			TransformaValorResponse transformaValorResponse = dinamicoRepository.transformaValor(propertiesExternos, msgTx,	transformaValorRequest);//TODO
			if(transformaValorResponse.getCodResp()==Constantes.CERO) {
				jsonElementValue = jsonParser.parse(transformaValorResponse.getValorTransformado());
				logger.info(msgTx + " - - - Se realizó la transformación con Éxito");
			}else {
				//error
				logger.error(msgTx + " - - - No se transformó correctamente");
				valor="";
				jsonElementValue = jsonParser.parse(valor);
			}
			if(jsonElementValue != null) {
				valorString = jsonElementValue.toString();
			}
			logger.info(msgTx + " - - - Valor transformado: "+valorString);
		}
		
		// obtener jsonPost
		String jsonUrlPost = flujoProcesosTypePost.obtieneJsonUrl(campoPost);
		String jsonUrl = null;
		if(!campoPost.startsWith(Constantes.REQUEST_URL)) {
			jsonElement = jsonParser.parse(jsonUrlPost);
			// setear jsonPost el valor de jsonPre
			jsonElement = setLlave(jsonElement, obtieneLlave(campoPost), jsonElementValue);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			jsonUrl = gson.toJson(jsonElement);
		}else {
			if(jsonElementValue.isJsonPrimitive()) {
				JsonPrimitive valor = jsonElementValue.getAsJsonPrimitive();
		        if (valor.isBoolean()) { 
		            jsonUrl = Constantes.TEXTO_VACIO+valor.getAsBoolean();
		        } else if (valor.isNumber()) {
		            jsonUrl = Constantes.TEXTO_VACIO+valor.getAsNumber();
		        } else if (valor.isString()) {
		            jsonUrl = Constantes.TEXTO_VACIO+valor.getAsString();
		        }
				jsonUrl = jsonUrlPost.replace(Constantes.DOLAR+obtieneLlave(campoPost), jsonUrl);
		    } else {
				logger.error(msgTx + " - - - No se seteó correctamente el valor");
				jsonUrl = jsonUrlPost.replace(Constantes.DOLAR+obtieneLlave(campoPost), Constantes.TEXTO_VACIO);
		    }
		}
		// reemplazando el json
		flujoProcesosTypePost.reemplazaJsonUrl(jsonUrl, campoPost);
		return flujoProcesosTypePost;
	}

	public static JsonElement getLlave(JsonElement jsonElement, String llaves) {
		String [] listaLlaves = llaves.split(Constantes.PUNTO_CARACTER);
		for (int i = 0; i < listaLlaves.length; i++) {
			if (jsonElement.isJsonObject()) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();
				jsonElement = jsonObject.get(listaLlaves[i]);
				if (i+1 == listaLlaves.length) {//último nivel
					return jsonElement;
				}
			}else if(jsonElement.isJsonArray()){
				JsonArray array = jsonElement.getAsJsonArray();
		        Iterator<JsonElement> iter = array.iterator();
		        int j = 0;
		        while (iter.hasNext()) {
		            JsonElement entrada = iter.next();
		            if (listaLlaves[i].equals(Constantes.TEXTO_VACIO+j)) {
		            	jsonElement = entrada;
		            	if(i+1 == listaLlaves.length) {//último nivel
							return jsonElement;
		            	}
		            	break;
		            }
		            j++;
		        }
			}
		}
		return null;
	}
	
	public static JsonElement setLlave(JsonElement jsonElement, String llaves, JsonElement jsonElementValue) {
		String [] listaLlaves = llaves.split(Constantes.PUNTO_CARACTER);
		JsonElement [] listaJsonElement = new JsonElement[listaLlaves.length];
		listaJsonElement[0] = jsonElement;
		
		for (int i = 0; i < listaLlaves.length-1; i++) {
			if (jsonElement.isJsonObject()) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();
				jsonElement = jsonObject.get(listaLlaves[i]);
				listaJsonElement[i+1] = jsonElement;
			}else if(jsonElement.isJsonArray()){
				JsonArray array = jsonElement.getAsJsonArray();
		        Iterator<JsonElement> iter = array.iterator();
		        int j = 0;
		        while (iter.hasNext()) {
		            JsonElement entrada = iter.next();
		            if (listaLlaves[i].equals(Constantes.TEXTO_VACIO+j)) {
		            	jsonElement = entrada;
						listaJsonElement[i+1] = jsonElement;
						break;
		            }
		            j++;
		        }
			}
		}
		jsonElement = jsonElementValue;
		for (int i = listaJsonElement.length-1; i > -1 ; i--) {
			if (listaJsonElement[i].isJsonObject()) {
				JsonObject jsonObject = listaJsonElement[i].getAsJsonObject();
				//se setea el jsonelement
				jsonObject.add(listaLlaves[i], jsonElement);
				jsonElement = jsonObject;
			}else if(listaJsonElement[i].isJsonArray()){
				JsonArray array = listaJsonElement[i].getAsJsonArray();
		        Iterator<JsonElement> iter = array.iterator();
		        int j = 0;
		        array = new JsonArray();
		        while (iter.hasNext()) {
		            JsonElement entrada = iter.next();
		            if (listaLlaves[i].equals(Constantes.TEXTO_VACIO+j)) {
		            	array.add(jsonElement);
		            }else {
		            	array.add(entrada);
		            }
		            j++;
		        }
		        jsonElement = array;
			}
		}
		return jsonElement;
	}
	
	private static String obtieneLlave(String llave) {
		String [] llaves = llave.split(Constantes.PUNTO_CARACTER);
		llave = Constantes.TEXTO_VACIO;
		for (int i = 2; i < llaves.length; i++) {
			llave = llave+llaves[i];
			if(i<llaves.length-1) {
				llave=llave+Constantes.PUNTO;
			}
		}
		return llave;
	}
	
	private FlujoProcesosType obtieneProcesoAEjecutar(PropertiesExternos propertiesExternos, String msgTx
			,ObtieneFlujoAutomaticoResponse obtieneFlujoAutomaticoResponse, String procesoEjecutado)
			throws JsonProcessingException, BDException {
		FlujoProcesosType flujoProcesosTypeNew = new FlujoProcesosType();
		FlujoProcesosType flujoProcesosTypeOld = new FlujoProcesosType();
		if (procesoEjecutado.equals(Constantes.NUM_CERO)) {
			flujoProcesosTypeNew = obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorPreProceso(procesoEjecutado);
			return flujoProcesosTypeNew;
		} else {
			// hallando proceso ejecutado
			flujoProcesosTypeOld = obtieneFlujoAutomaticoResponse
					.obtenerFlujoProcesosTypePorIdProceso(Integer.parseInt(procesoEjecutado));
			int procesoCandidato = 0;
			int ordenProcesoCondicion = 1;
			String[] procesosCandidatos = flujoProcesosTypeOld.listaPostProcesos();
			if (procesosCandidatos == null) {
				procesoCandidato = -1;
			}
			int procesoCandidatoAnterior=0;
			int cont=0;
			while (procesoCandidato >= 0) {
				procesoCandidato = -1;
				// encontrar proceso candidato que coincida con el orden de la condicion
				for (int j = 0; j < procesosCandidatos.length; j++) {
					procesoCandidato = Integer.parseInt(procesosCandidatos[j]);
					int ordenProcesoCandidatoCondicion = 0;
					// encuentro el ordenCondicion del proceso candidato
					ordenProcesoCandidatoCondicion = obtieneFlujoAutomaticoResponse
							.obtenerFlujoProcesosTypePorIdProceso(procesoCandidato).getOrdenCondicion();
					// valido si el orden condicion del proceso candidato es el que requiero
					if (ordenProcesoCandidatoCondicion == ordenProcesoCondicion) {
						ordenProcesoCondicion++;
						break;
					}
				}
				flujoProcesosTypeNew = obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorIdProceso(procesoCandidato);
				boolean cumpleCondicion = false;
				if (procesoCandidato > 0) {
					cont++;
					logger.info(msgTx+" - Número de Proceso Candidato: "+cont);
					logger.info(msgTx+" - ID Proceso siguiente Candidato: "+procesoCandidato);
					logger.info(msgTx+" - Proceso siguiente Candidato: "+obtieneFlujoAutomaticoResponse
							.obtenerFlujoProcesosTypePorIdProceso(procesoCandidato).getAbreviacion());
					// evaluar proceso candidato
					cumpleCondicion = false;
					//cumpleCondicion = true;
					cumpleCondicion = validaCondicion(propertiesExternos, msgTx, flujoProcesosTypeNew,obtieneFlujoAutomaticoResponse);
					logger.info(msgTx+" - Cumple Condición: "+cumpleCondicion);
				} // si es ok retornar
				if (procesoCandidato > 0 && cumpleCondicion) {
					// encontrar proceso que cumplió condición
					logger.info(" - Se ejecutará el proceso candidato");
					return flujoProcesosTypeNew;
				}
				if (ordenProcesoCondicion > procesosCandidatos.length || procesoCandidatoAnterior == procesoCandidato ) {
					procesoCandidato = -1;
				}
				procesoCandidatoAnterior = procesoCandidato;
			}
		}
		return null;
	}


	private boolean validaCondicion(PropertiesExternos propertiesExternos, String msgTx,
			FlujoProcesosType flujoProcesosType, ObtieneFlujoAutomaticoResponse obtieneFlujoAutomaticoResponse) throws BDException, JsonProcessingException {
		boolean validaParametros = false;
		int idFlujo = obtieneFlujoAutomaticoResponse.getIdFlujo();
		int idCondicion = flujoProcesosType.getIdcondicion();
		EvaluaCondicionResponse evaluaCondicionResponse = new EvaluaCondicionResponse();;
		
		List<CondicionesProcesosType> listCondicionesProcesos = obtieneFlujoAutomaticoResponse.listaCondicionesProcesosByIdCondicion(idCondicion);
		String tipo = listCondicionesProcesos.get(0).getAbreviacion();
		String parametros = "";
		logger.info(msgTx+" - Tipo de condición: "+tipo);
		if(listCondicionesProcesos != null) {
			if(tipo.equals("COND MUL")||tipo.equals("COND SIM")) {
				for (int i = 0; i < listCondicionesProcesos.size(); i++) {
					//debe estar ordenado por orden condicion
					// obtener json
					String campo = listCondicionesProcesos.get(i).getParametro();
					String [] llaves = campo.split(Constantes.PUNTO_CARACTER);
					FlujoProcesosType flujoProcesosTypeProceso = obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorIdProceso(Integer.parseInt(llaves[1]));

					String json = flujoProcesosTypeProceso.obtieneJsonUrl(obtieneLlave(campo));
					String strValor = "";
					if (json!=null) {
						JsonParser jsonParser = new JsonParser();
						JsonElement jsonElement = jsonParser.parse(json);
						// obtener llave
						JsonElement jsonElementValue = getLlave(jsonElement, obtieneLlave(obtieneLlave(campo)));
						System.out.println(jsonElementValue.toString());
						if (jsonElementValue.isJsonPrimitive()) {
					        JsonPrimitive valor = jsonElementValue.getAsJsonPrimitive();
					        if (valor.isBoolean()) { 
					        	strValor +=valor.getAsBoolean();
					        } else if (valor.isNumber()) {
					        	strValor +=valor.getAsNumber();
					        } else if (valor.isString()) {
					        	strValor +=valor.getAsString();
					        }
					    } 
					}
					parametros += strValor;
					if(i<listCondicionesProcesos.size()-1) {
						parametros += "|";
					}
					logger.info(msgTx+" - Parámetro: "+campo);
					logger.info(msgTx+" - Valor parámetro: "+strValor);
					logger.info(msgTx+" - Expresión Lógica: "+listCondicionesProcesos.get(i).getExpresionLogica());
					logger.info(msgTx+" - Valor a Comparar: "+listCondicionesProcesos.get(i).getValor());
					if(listCondicionesProcesos.get(i).getExpresionPosterior()!=null) {
						logger.info(msgTx+" - Expresión Posterior: "+listCondicionesProcesos.get(i).getExpresionPosterior());
					}
				}
				validaParametros = true;
			}else if(tipo.equals("COND SCR")) {
					//debe estar ordenado por orden condicion
					// obtener json
					String [] campos = listCondicionesProcesos.get(0).getParametro().split("|");
					logger.info(msgTx+" - Cantidad de parámetros para evaluar en SRIPT: "+campos.length);
					for (int i = 0; i < listCondicionesProcesos.size(); i++) {
						String [] llaves = campos[i].split(Constantes.PUNTO_CARACTER);
						FlujoProcesosType flujoProcesosTypeProceso = obtieneFlujoAutomaticoResponse.obtenerFlujoProcesosTypePorIdProceso(Integer.parseInt(llaves[1]));
	
						String json = flujoProcesosTypeProceso.obtieneJsonUrl(obtieneLlave(campos[i]));
						logger.info(msgTx+" - Parámetro: "+campos[i]);
						logger.info(msgTx+" - Valor parámetro: "+json);
						logger.info(msgTx+" - Expresión Lógica: "+listCondicionesProcesos.get(i).getExpresionLogica());
						logger.info(msgTx+" - Valor a Comparar: "+listCondicionesProcesos.get(i).getValor());
						if(listCondicionesProcesos.get(i).getExpresionPosterior()!=null) {
							logger.info(msgTx+" - Expresión Posterior: "+listCondicionesProcesos.get(i).getExpresionPosterior());
						}
						if (json!=null) {
							JsonParser jsonParser = new JsonParser();
							JsonElement jsonElement = jsonParser.parse(json);
							// obtener llave
							JsonElement jsonElementValue = getLlave(jsonElement, obtieneLlave(obtieneLlave(campos[i])));
							System.out.println(jsonElementValue.toString());
							if (jsonElementValue.isJsonPrimitive()) {
						        JsonPrimitive valor = jsonElementValue.getAsJsonPrimitive();
						        if (valor.isBoolean()) { 
						            parametros +=valor.getAsBoolean();
						        } else if (valor.isNumber()) {
						            parametros +=valor.getAsNumber();
						        } else if (valor.isString()) {
						            parametros +=valor.getAsString();
						        }
						    } 
						}
						if(i<listCondicionesProcesos.size()-1) {
							parametros += "|";
						}
					}
				validaParametros = true;
			}
			if(validaParametros) {
				EvaluaCondicionRequest evaluaCondicionRequest = new EvaluaCondicionRequest();
				evaluaCondicionRequest.setIdFlujo(idFlujo);
				evaluaCondicionRequest.setIdCondicion(idCondicion);
				evaluaCondicionRequest.setValores(parametros);
				evaluaCondicionResponse = dinamicoRepository.evaluaCondicion(propertiesExternos, msgTx, evaluaCondicionRequest);
				
			}
		}
		return evaluaCondicionResponse.isValidacion();
	}

}