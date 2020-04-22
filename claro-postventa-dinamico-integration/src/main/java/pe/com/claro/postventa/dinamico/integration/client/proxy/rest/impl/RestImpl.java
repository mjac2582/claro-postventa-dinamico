package pe.com.claro.postventa.dinamico.integration.client.proxy.rest.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.resource.exception.WSException;
import pe.com.claro.common.util.ClaroUtil;
import pe.com.claro.postventa.dinamico.canonical.RestHeaderResponse;
import pe.com.claro.postventa.dinamico.integration.client.proxy.rest.RestClient;
import pe.com.claro.postventa.dinamico.model.bean.types.FlujoProcesosType;

@Service
public class RestImpl implements RestClient {

	private static final Logger logger = LoggerFactory.getLogger(RestImpl.class);

	@Override
	public FlujoProcesosType ejecutarRest(FlujoProcesosType flujoProcesosType, String msgTxIn) throws WSException {
		
		RestHeaderResponse restHeaderResponse = new RestHeaderResponse();
		String nombreWS = flujoProcesosType.getAbreviacion();
		String url = flujoProcesosType.getRuta();
		String metodo = flujoProcesosType.getMetodo();
		int timeout = flujoProcesosType.getTimeout();
		String headerRequest = flujoProcesosType.getRequestHeader();
		String bodyRequest = flujoProcesosType.getRequestBody();
		String nombreMetodo = "RestImpl - "+nombreWS;
		String msgTx = msgTxIn;
		logger.info(msgTx + " - - [INICIO] - WS [" + nombreMetodo + "]");
		logger.info(msgTx + " - - - PARAMETROS WS [URL]: " + url);
		logger.info(msgTx + " - - - PARAMETROS WS [METODO]: " + metodo);
		logger.info(msgTx + " - - - PARAMETROS WS [TIMEOUT]: " + timeout);
		logger.info(msgTx + " - - - PARAMETROS WS [INPUT]");
		logger.info(msgTx + " - - - PARAMETROS WS [Header]: " + headerRequest);
		logger.info(msgTx + " - - - PARAMETROS WS [Body]: " + bodyRequest);
		long tiempoInicio = System.currentTimeMillis();
		String bodyResponse = null;
		boolean validResponse = false;
		try {
			URL urlConnection = new URL(url);
			HttpURLConnection connection;
			connection = (HttpURLConnection) urlConnection.openConnection();
			if (metodo.equals(Constantes.METHOD_POST) || metodo.equals(Constantes.METHOD_PUT)|| metodo.equals(Constantes.METHOD_GET)) {
				validResponse = true;
			} else if (metodo.equals(Constantes.METHOD_DELETE) || metodo.equals(Constantes.METHOD_HEAD)) {
				validResponse = false;
			} else {
				logger.error(msgTx + " - - - Error el método: [" + nombreWS+"]["+metodo+"] no está disponible para la clase");
				return null;
			}
			connection.setRequestMethod(metodo);
			connection.setDoOutput(validResponse);
			connection.setRequestProperty(Constantes.CONTENT_TYPE, Constantes.CONTENT_TYPE_VALOR);
			headerRequest = headerRequest.replaceAll(Constantes.ESPACIO, Constantes.VACIO)
					.replaceAll(Constantes.COMILLA, Constantes.VACIO).replace(Constantes.COMA, Constantes.VACIO);
					//.replaceAll("{", Constantes.VACIO).replaceAll("}", Constantes.VACIO);
			String headerSplit[] = headerRequest.split(Constantes.SALTO_LINEA);
			for (int i = Constantes.CERO; i < headerSplit.length; i++) {
				if (headerSplit[i].contains(Constantes.DOS_PUNTO)) {
					headerSplit[i] = headerSplit[i].replaceAll(Constantes.RETORNO_CARRO, Constantes.VACIO);
					String headerLinea[] = headerSplit[i].split(Constantes.DOS_PUNTO);
					connection.setRequestProperty(headerLinea[Constantes.CERO], headerLinea[Constantes.UNO]);
				}
			}
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
			logger.info(msgTx + " - - - PARAMETROS WS [CONNECTION]: " + connection);

			if(!bodyRequest.equals(Constantes.DOBLE_LLAVE)) {
				OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
				osw.write(bodyRequest);
				osw.flush();
				osw.close();
			}
			connection.connect();
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line = "";
			int statusCode = connection.getResponseCode();
			String statusMessage = connection.getResponseMessage();
			
			flujoProcesosType.setCodigoRespuesta(statusCode);
			flujoProcesosType.setMensajeRespuesta(statusMessage);
			restHeaderResponse.setStatusCode(statusCode);
			restHeaderResponse.setStatusMessage(statusMessage);
			flujoProcesosType.setResponseHeader(ClaroUtil.printPrettyJSONString(restHeaderResponse));
			logger.info(msgTx + " - - - PARAMETROS WS [OUTPUT]");
			logger.info(msgTx + " - - - PARAMETROS WS [Header]: " + ClaroUtil.printPrettyJSONString(restHeaderResponse));
			if (statusCode>=Constantes.CERO) {
				//if (validResponse) {
					try {
						br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Constantes.defaulEncodingApi));
						while ((line = br.readLine()) != null) {
							sb.append(line);
						}
						bodyResponse = sb.toString();
						JsonParser jsonParser = new JsonParser();
						JsonElement jsonElement = jsonParser.parse(bodyResponse);
						Gson gson = new GsonBuilder().setPrettyPrinting().create();
						bodyResponse = gson.toJson(jsonElement);
						flujoProcesosType.setResponseBody(bodyResponse);
						logger.info(msgTx + " - - - PARAMETROS WS [Body]: " + bodyResponse);
					} catch (Exception e) {
						logger.warn(msgTx + " - - - Falló primera forma de obtener response");
						try {
							br = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Constantes.defaulEncodingApi));
							while ((line = br.readLine()) != null) {
								sb.append(line);
							}
							bodyResponse = sb.toString();
							JsonParser jsonParser = new JsonParser();
							JsonElement jsonElement = jsonParser.parse(bodyResponse);
							Gson gson = new GsonBuilder().setPrettyPrinting().create();
							bodyResponse = gson.toJson(jsonElement);
							flujoProcesosType.setResponseBody(bodyResponse);
							logger.info(msgTx + " - - - PARAMETROS WS [Body]: " + bodyResponse);
						} catch (Exception e2) {
							logger.warn(msgTx + " - - - Falló segunda forma de obtener response");
						}
					}
				//}
			}
			connection.disconnect ();
		} catch (Exception e) {
			String codigoError = Constantes.TEXTO_VACIO;
			if (e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION.toUpperCase())
					|| e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION2.toUpperCase())
					|| e.getMessage().toUpperCase().contains(Constantes.TIMEOUTEXCEPTION3.toUpperCase())) {
				logger.error(msgTx + " - - - Error de Timeout en WS: " + nombreWS);
				codigoError = Constantes.ERROR_TIMEOUT;
				throw new WSException(codigoError, e.getMessage(), nombreWS, e);
			} else {
				logger.error(msgTx + " - - - Error disponibilidad en WS: " + nombreWS);
				codigoError = Constantes.ERROR_DISPONIBILIDAD;
				throw new WSException(codigoError, e.getMessage(), nombreWS, e);
			}
		} finally {
			flujoProcesosType.setEstado(Constantes.DOS);//estado ejecutado 2
			flujoProcesosType.setNumIntento(flujoProcesosType.getNumIntento()+Constantes.UNO);//agregando número de reintento
			logger.info(msgTx + " - - [FIN] - WS [" + nombreMetodo + "] - Tiempo Total Transacción(ms) = " + (System.currentTimeMillis() - tiempoInicio));
		}
		return flujoProcesosType;
	}

}
