package pe.com.claro.postventa.dinamico.integration.client.proxy.rest;

import pe.com.claro.common.resource.exception.WSException;
import pe.com.claro.postventa.dinamico.model.bean.types.FlujoProcesosType;


public interface RestClient {
	FlujoProcesosType ejecutarRest(FlujoProcesosType flujoProcesosType, String msgTxIn) throws WSException;
}
