package pe.com.claro.postventa.dinamico.resource;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import pe.com.claro.common.bean.HeaderRequest;
import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.resource.exception.FormatException;
import pe.com.claro.common.util.ClaroUtil;
import pe.com.claro.common.util.PropertiesExternos;
import pe.com.claro.postventa.dinamico.canonical.EjecutarFlujoAutomaticoRequest;
import pe.com.claro.postventa.dinamico.canonical.EjecutarFlujoAutomaticoResponse;
import pe.com.claro.postventa.dinamico.domain.service.DinamicoService;
import pe.com.claro.postventa.dinamico.resource.util.ValidadorUtil;

@Stateless
@Path("postventa/dinamico/v1.0.0")
@Api(value = "/dinamico", description = "¡Bienvenido!")
@Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
public class DinamicoResource {

	private static final Logger logger = LoggerFactory.getLogger(DinamicoResource.class);
	
	@Context
	private Configuration configuration;
	
	@EJB
	private DinamicoService dinamicoService;
	
	private PropertiesExternos propertiesExternos;
	
	public void initProperties(){
		propertiesExternos = new PropertiesExternos(configuration);
	}
	
	
	@SuppressWarnings("rawtypes")
	@POST
	@Path("/ejecuta/flujo")
    @Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "[ejecutarFlujoAutomatico] - Operación que ejecuto flujo automático.", notes = "", response = DinamicoResource.class)
	@ApiResponses(value = { @ApiResponse(code = Constantes.CODIGO_200, message = Constantes.MENSAJE_200),
							@ApiResponse(code = Constantes.CODIGO_400, message = Constantes.MENSAJE_400),
							@ApiResponse(code = Constantes.CODIGO_406, message = Constantes.MENSAJE_406) })
	
	 public Response ejecutaFlujoAutomatico(@Context HttpHeaders httpHeaders,
				@ApiParam(value = "El objeto request", required = true) EjecutarFlujoAutomaticoRequest request) 
						throws JsonProcessingException {
		
		initProperties();
		String nombreMetodo = "ejecutaFlujoAutomatico";
		Response resJSON = Response.ok().entity(Constantes.TEXTO_VACIO).build();
		
		HeaderRequest headerRequest = new HeaderRequest(httpHeaders);
		String idTx = headerRequest.getIdTransaccion();
		String msgid = headerRequest.getMsgid();
		String msgTx = "[" + nombreMetodo + " idTx=" + idTx + " msgid=" + msgid + "] ";
		
		long tiempoInicio = System.currentTimeMillis();
		String requestPrint = null;
		String responsePrint = null;
		StringBuilder camposNoOk = new StringBuilder();	
		EjecutarFlujoAutomaticoResponse ejecutarFlujoAutomaticoResponse = new EjecutarFlujoAutomaticoResponse();
		
		logger.info(msgTx + "[INICIO de metodo " + nombreMetodo + "]");
		logger.info(msgTx + "[Parametros de Entrada]");
		logger.info(msgTx + "[HttpRequestHeader] " + ClaroUtil.getAllHttpHeaders(httpHeaders));
		logger.info(msgTx +"**** Header Interpretado .... \n" +  ClaroUtil.printPrettyJSONString(headerRequest));
		
		logger.info(msgTx +"**** Body Recibido ....  " );
		logger.info(msgTx + "[HttpRequestBody] " + ClaroUtil.printPrettyJSONString(request));

		String result = null;
		
		try {
			logger.info(msgTx + "[Actividad 1. Validar Parametros de Entrada]");
			
			
			Set<ConstraintViolation<HeaderRequest>> constraintViolationsHeader = ValidadorUtil
					.validarParametrosObligatoriosHeader(msgTx, headerRequest);
			
			String datosValidosBody = ValidadorUtil.validarParametrosObligatoriosBody(msgTx, request);
			
			boolean datosValidosHeader = true;
			if (!datosValidosHeader || !datosValidosBody.isEmpty()) {
				for (ConstraintViolation constraint : constraintViolationsHeader) {
					camposNoOk.append(Constantes.CORCHETE_INI);
					camposNoOk.append(constraint.getMessage());
					camposNoOk.append(Constantes.CORCHETE_FIN);
				}
				
				camposNoOk.append(datosValidosBody);
				
				boolean busquedaError = camposNoOk.toString().contains(Constantes.MENSAJE_ERROR_NULO) || camposNoOk.toString().contains(Constantes.MENSAJE_ERROR_VACIO);
				
				if(!(busquedaError)){	
					String msgIDF = StringUtils.replace(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_COD_IDT1,
							Constantes.DOBLE_LLAVE, camposNoOk.toString());
					logger.info(msgTx + "Error: " + msgIDF);
					throw new FormatException(Integer.parseInt(propertiesExternos.OBTIENE_FLUJO_AUTOMATICO_MSG_IDT1), msgIDF, 
							msgIDF);
				} else {
					//String msgIDF = StringUtils.replace(propertiesExternos.OBTENER_RECETA_MSG_IDF1,
					//		Constantes.DOBLE_LLAVE, camposNoOk.toString());
					//logger.info(msgTx + "Error: " + msgIDF);
					//ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTENER_RECETA_COD_IDF2);
					//ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTENER_RECETA_MSG_IDF2);
				}
				
			} else {	
				ejecutarFlujoAutomaticoResponse = dinamicoService.ejecutarFlujoAutomatico(propertiesExternos, headerRequest, idTx, msgTx, request);
				result = ClaroUtil.printPrettyJSONString(ejecutarFlujoAutomaticoResponse);
				responsePrint = ClaroUtil.printPrettyJSONString(ejecutarFlujoAutomaticoResponse);
			}
		} catch(FormatException ex){
			logger.error(msgTx + "[Ocurrio un error FormatException]" + Constantes.SALTO_LINEA + ex.getMessage(), ex);
			
			//ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTENER_RECETA_COD_IDF2);
			//ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTENER_RECETA_MSG_IDF2);
		} catch (Exception ex) {
			logger.error(msgTx + "[Ocurrio un error Exception]" + ex.getMessage(), ex);
			
			//ejecutarFlujoAutomaticoResponse.setCodigo(propertiesExternos.OBTENER_RECETA_COD_IDF2);
			//ejecutarFlujoAutomaticoResponse.setMensaje(propertiesExternos.OBTENER_RECETA_MSG_IDF2);
		}finally {
			result = ClaroUtil.printPrettyJSONString(ejecutarFlujoAutomaticoResponse);
			responsePrint = ClaroUtil.printPrettyJSONString(ejecutarFlujoAutomaticoResponse);
			resJSON = Response.status(Status.OK).entity(result).build();
			logger.info(msgTx + "["+nombreMetodo+"] " +  responsePrint);
			logger.info(nombreMetodo + "[FIN de metodo "+nombreMetodo+"] [Tiempo total de proceso(ms): " + (System.currentTimeMillis() - tiempoInicio));
		}
		return resJSON;
	}
	
	
	

}
