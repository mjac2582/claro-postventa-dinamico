package pe.com.claro.postventa.dinamico.canonical;

public class RestHeaderResponse {
	private int StatusCode;
	private String StatusMessage;
	
	public Object get(String parametro) {
		switch (parametro) {
		case "StatusCode":
			return this.StatusCode;
		case "StatusMessage":
			return this.StatusMessage;
		default:
			return null;
		}
	}
	
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return StatusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return StatusMessage;
	}
	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		StatusMessage = statusMessage;
	}
	
}
