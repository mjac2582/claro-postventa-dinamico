package pe.com.claro.common.exception;

import javax.ws.rs.core.Response;

public class MappingResponseException {
	private String result;
	private String responsePrint;
	private Response resJSON;
	
	public MappingResponseException(String result, String responsePrint, Response resJSON) {
		super();
		this.result = result;
		this.responsePrint = responsePrint;
		this.resJSON = resJSON;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResponsePrint() {
		return responsePrint;
	}
	public void setResponsePrint(String responsePrint) {
		this.responsePrint = responsePrint;
	}
	public Response getResJSON() {
		return resJSON;
	}
	public void setResJSON(Response resJSON) {
		this.resJSON = resJSON;
	}
	
}
