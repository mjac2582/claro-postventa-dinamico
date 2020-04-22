package pe.com.claro.postventa.dinamico.canonical.request;

import pe.com.claro.postventa.dinamico.canonical.request.message.MessageConsultarRecetaRequest;

public class ConsultarReceta {

	private MessageConsultarRecetaRequest messageRequest;

	public MessageConsultarRecetaRequest getMessageRequest() {
		return messageRequest;
	}

	public void setMessageRequest(MessageConsultarRecetaRequest messageRequest) {
		this.messageRequest = messageRequest;
	}
	
	
}
