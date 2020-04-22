package pe.com.claro.postventa.dinamico.canonical.request.message;

import pe.com.claro.postventa.dinamico.canonical.request.body.BodyConsultarOrdenesTrabajo;
import pe.com.claro.postventa.dinamico.canonical.request.header.HeaderRequestType;

public class MessageConsultarOrdenesTrabajoRequest {
	
	private HeaderRequestType header;
	
	private BodyConsultarOrdenesTrabajo body;

	public HeaderRequestType getHeader() {
		return header;
	}

	public void setHeader(HeaderRequestType header) {
		this.header = header;
	}

	public BodyConsultarOrdenesTrabajo getBody() {
		return body;
	}

	public void setBody(BodyConsultarOrdenesTrabajo body) {
		this.body = body;
	}

}
