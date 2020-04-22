package pe.com.claro.postventa.dinamico.canonical.request.message;

import pe.com.claro.postventa.dinamico.canonical.request.body.BodyConsultarReceta;
import pe.com.claro.postventa.dinamico.canonical.request.header.HeaderRequestType;

public class MessageConsultarRecetaRequest {
	private HeaderRequestType header;
	private BodyConsultarReceta body;
	
	public HeaderRequestType getHeader() {
		return header;
	}
	public void setHeader(HeaderRequestType header) {
		this.header = header;
	}
	public BodyConsultarReceta getBody() {
		return body;
	}
	public void setBody(BodyConsultarReceta body) {
		this.body = body;
	}
	
	
}
