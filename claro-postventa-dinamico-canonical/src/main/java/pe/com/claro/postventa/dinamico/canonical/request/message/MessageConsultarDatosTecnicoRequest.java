package pe.com.claro.postventa.dinamico.canonical.request.message;

import pe.com.claro.postventa.dinamico.canonical.request.body.BodyConsultarDatosTecnico;
import pe.com.claro.postventa.dinamico.canonical.request.header.HeaderRequestType;

public class MessageConsultarDatosTecnicoRequest {
	
	private HeaderRequestType header;
	
	private BodyConsultarDatosTecnico body;

	public HeaderRequestType getHeader() {
		return header;
	}

	public void setHeader(HeaderRequestType header) {
		this.header = header;
	}

	public BodyConsultarDatosTecnico getBody() {
		return body;
	}

	public void setBody(BodyConsultarDatosTecnico body) {
		this.body = body;
	}
}
