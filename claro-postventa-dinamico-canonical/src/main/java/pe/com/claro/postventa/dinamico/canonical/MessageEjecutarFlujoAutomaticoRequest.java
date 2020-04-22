package pe.com.claro.postventa.dinamico.canonical;

import pe.com.claro.postventa.dinamico.canonical.request.header.HeaderRequestType;

public class MessageEjecutarFlujoAutomaticoRequest {
	private HeaderRequestType header;
	private BodyEjecutarFlujoAutomatico body;
	
	public HeaderRequestType getHeader() {
		return header;
	}
	public void setHeader(HeaderRequestType header) {
		this.header = header;
	}
	public BodyEjecutarFlujoAutomatico getBody() {
		return body;
	}
	public void setBody(BodyEjecutarFlujoAutomatico body) {
		this.body = body;
	}
	
	
	
}
