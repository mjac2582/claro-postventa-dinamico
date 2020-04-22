package pe.com.claro.postventa.dinamico.canonical.request.message;

import pe.com.claro.postventa.dinamico.canonical.request.body.BodyConsultarPlanContratado;
import pe.com.claro.postventa.dinamico.canonical.request.header.HeaderRequestType;

public class MessageConsultarPlanContratadoRequest {

	private HeaderRequestType header;
	
	private BodyConsultarPlanContratado body;

	public HeaderRequestType getHeader() {
		return header;
	}

	public void setHeader(HeaderRequestType header) {
		this.header = header;
	}

	public BodyConsultarPlanContratado getBody() {
		return body;
	}

	public void setBody(BodyConsultarPlanContratado body) {
		this.body = body;
	}
	
	
}
