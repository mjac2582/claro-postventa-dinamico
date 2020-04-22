package pe.com.claro.postventa.dinamico.model.bean.types;

import pe.com.claro.common.property.Constantes;

public class FlujoProcesosType {
	private int orden;
	private int idProceso;
	private String abreviacion;
	private String preProceso;
	private String postProceso;
	private String flagMandatorio;
	private int ordenCondicion;
	private int idcondicion;
	private String flagRegistrarTransaccion;
	private int reintentos;
	private String idProcesoError;
	private String ruta;
	private String cabecera;
	private String cuerpo;
	private String metodo;
	private int timeout;
	//agregado;
	//cambiar a jsonelement
	private String requestHeader;
	private String requestBody;
	private String responseHeader;
	private String responseBody;
	
	//regtrs
	private int estado = 1;
	private int numIntento = 0;
	private int CodigoRespuesta;
	private String MensajeRespuesta;
	
	public String [] listaPostProcesos() {
		String [] procesosCandidatos = null;
		if(this.postProceso!=null) {
			procesosCandidatos = this.postProceso.split(Constantes.COMA);
		}
		return procesosCandidatos;
	}
	
	public String obtieneJsonUrl(String requestResponseHeaderBody) {
		String json = null;
		if(requestResponseHeaderBody.startsWith(Constantes.REQUEST_HEADER)) {
			json = this.requestHeader;
		}else if(requestResponseHeaderBody.startsWith(Constantes.REQUEST_BODY)) {
			json = this.requestBody;
		}else if(requestResponseHeaderBody.startsWith(Constantes.RESPONSE_HEADER)) {
			json = this.responseHeader;
		}else if(requestResponseHeaderBody.startsWith(Constantes.RESPONSE_BODY)) {
			json = this.responseBody;
		}else if (requestResponseHeaderBody.startsWith(Constantes.REQUEST_URL)) {
			json = this.ruta;
		}
		return json;
	}
	

	public void reemplazaJsonUrl(String json, String requestResponseHeaderBody) {
		if(requestResponseHeaderBody.startsWith(Constantes.REQUEST_HEADER)) {
			this.requestHeader = json;
		}else if(requestResponseHeaderBody.startsWith(Constantes.REQUEST_BODY)) {
			this.requestBody = json;
		}else if(requestResponseHeaderBody.startsWith(Constantes.RESPONSE_HEADER)) {
			this.responseHeader = json;
		}else if(requestResponseHeaderBody.startsWith(Constantes.RESPONSE_BODY)) {
			this.responseBody = json;
		}else if(requestResponseHeaderBody.startsWith(Constantes.REQUEST_URL)) {
			this.ruta = json;
		}
	}
	
	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * @return the numIntento
	 */
	public int getNumIntento() {
		return numIntento;
	}

	/**
	 * @param numIntento the numIntento to set
	 */
	public void setNumIntento(int numIntento) {
		this.numIntento = numIntento;
	}

	/**
	 * @return the codigoRespuesta
	 */
	public int getCodigoRespuesta() {
		return CodigoRespuesta;
	}

	/**
	 * @param codigoRespuesta the codigoRespuesta to set
	 */
	public void setCodigoRespuesta(int codigoRespuesta) {
		CodigoRespuesta = codigoRespuesta;
	}

	/**
	 * @return the mensajeRespuesta
	 */
	public String getMensajeRespuesta() {
		return MensajeRespuesta;
	}

	/**
	 * @param mensajeRespuesta the mensajeRespuesta to set
	 */
	public void setMensajeRespuesta(String mensajeRespuesta) {
		MensajeRespuesta = mensajeRespuesta;
	}
	/**
	 * @return the orden
	 */
	public int getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(int orden) {
		this.orden = orden;
	}
	/**
	 * @return the idProceso
	 */
	public int getIdProceso() {
		return idProceso;
	}
	/**
	 * @param idProceso the idProceso to set
	 */
	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}
	/**
	 * @return the abreviacion
	 */
	public String getAbreviacion() {
		return abreviacion;
	}
	/**
	 * @param abreviacion the abreviacion to set
	 */
	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}
	/**
	 * @return the preProceso
	 */
	public String getPreProceso() {
		return preProceso;
	}
	/**
	 * @param preProceso the preProceso to set
	 */
	public void setPreProceso(String preProceso) {
		this.preProceso = preProceso;
	}
	/**
	 * @return the postProceso
	 */
	public String getPostProceso() {
		return postProceso;
	}
	/**
	 * @param postProceso the postProceso to set
	 */
	public void setPostProceso(String postProceso) {
		this.postProceso = postProceso;
	}
	/**
	 * @return the flagMandatorio
	 */
	public String getFlagMandatorio() {
		return flagMandatorio;
	}
	/**
	 * @param flagMandatorio the flagMandatorio to set
	 */
	public void setFlagMandatorio(String flagMandatorio) {
		this.flagMandatorio = flagMandatorio;
	}
	/**
	 * @return the ordenCondicion
	 */
	public int getOrdenCondicion() {
		return ordenCondicion;
	}
	/**
	 * @param ordenCondicion the ordenCondicion to set
	 */
	public void setOrdenCondicion(int ordenCondicion) {
		this.ordenCondicion = ordenCondicion;
	}
	/**
	 * @return the idcondicion
	 */
	public int getIdcondicion() {
		return idcondicion;
	}
	/**
	 * @param idcondicion the idcondicion to set
	 */
	public void setIdcondicion(int idcondicion) {
		this.idcondicion = idcondicion;
	}
	/**
	 * @return the flagRegistrarTransaccion
	 */
	public String getFlagRegistrarTransaccion() {
		return flagRegistrarTransaccion;
	}
	/**
	 * @param flagRegistrarTransaccion the flagRegistrarTransaccion to set
	 */
	public void setFlagRegistrarTransaccion(String flagRegistrarTransaccion) {
		this.flagRegistrarTransaccion = flagRegistrarTransaccion;
	}
	/**
	 * @return the reintentos
	 */
	public int getReintentos() {
		return reintentos;
	}
	/**
	 * @param reintentos the reintentos to set
	 */
	public void setReintentos(int reintentos) {
		this.reintentos = reintentos;
	}
	/**
	 * @return the idProcesoError
	 */
	public String getIdProcesoError() {
		return idProcesoError;
	}
	/**
	 * @param idProcesoError the idProcesoError to set
	 */
	public void setIdProcesoError(String idProcesoError) {
		this.idProcesoError = idProcesoError;
	}
	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}
	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	/**
	 * @return the cabecera
	 */
	public String getCabecera() {
		return cabecera;
	}
	/**
	 * @param cabecera the cabecera to set
	 */
	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}
	/**
	 * @return the cuerpo
	 */
	public String getCuerpo() {
		return cuerpo;
	}
	/**
	 * @param cuerpo the cuerpo to set
	 */
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	/**
	 * @return the metodo
	 */
	public String getMetodo() {
		return metodo;
	}
	/**
	 * @param metodo the metodo to set
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}
	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}



	/**
	 * @return the requestHeader
	 */
	public String getRequestHeader() {
		return requestHeader;
	}


	/**
	 * @param requestHeader the requestHeader to set
	 */
	public void setRequestHeader(String requestHeader) {
		this.requestHeader = requestHeader;
	}


	/**
	 * @return the requestBody
	 */
	public String getRequestBody() {
		return requestBody;
	}


	/**
	 * @param requestBody the requestBody to set
	 */
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}


	/**
	 * @return the responseHeader
	 */
	public String getResponseHeader() {
		return responseHeader;
	}


	/**
	 * @param responseHeader the responseHeader to set
	 */
	public void setResponseHeader(String responseHeader) {
		this.responseHeader = responseHeader;
	}


	/**
	 * @return the responseBody
	 */
	public String getResponseBody() {
		return responseBody;
	}


	/**
	 * @param responseBody the responseBody to set
	 */
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	

}