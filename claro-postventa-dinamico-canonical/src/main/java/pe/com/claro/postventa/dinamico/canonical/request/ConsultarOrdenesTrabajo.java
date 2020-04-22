package pe.com.claro.postventa.dinamico.canonical.request;

import pe.com.claro.postventa.dinamico.canonical.request.message.MessageConsultarOrdenesTrabajoRequest;

public class ConsultarOrdenesTrabajo {
	
	private MessageConsultarOrdenesTrabajoRequest messageRequest;

	public MessageConsultarOrdenesTrabajoRequest getMessageRequest() {
		return messageRequest;
	}

	public void setMessageRequest(MessageConsultarOrdenesTrabajoRequest messageRequest) {
		this.messageRequest = messageRequest;
	}
}
