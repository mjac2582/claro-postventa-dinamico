package pe.com.claro.postventa.dinamico.canonical.bean;

public class BodyDatosTecnico {
	
	private ResponseStatus responseStatus;
	
	private ObtenerDatosTecnicoResponse responseData;

	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public ObtenerDatosTecnicoResponse getResponseData() {
		return responseData;
	}

	public void setResponseData(ObtenerDatosTecnicoResponse responseData) {
		this.responseData = responseData;
	}
	
}
