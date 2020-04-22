package pe.com.claro.postventa.dinamico.canonical.request;

import pe.com.claro.postventa.dinamico.canonical.request.message.MessageConsultarPlanContratadoRequest;

public class ConsultarPlanContratado {

	private MessageConsultarPlanContratadoRequest messageRequest;

	public MessageConsultarPlanContratadoRequest getMessageRequest() {
		return messageRequest;
	}

	public void setMessageRequest(MessageConsultarPlanContratadoRequest messageRequest) {
		this.messageRequest = messageRequest;
	}
	
}
