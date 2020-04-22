package pe.com.claro.postventa.dinamico.canonical.request;

import pe.com.claro.postventa.dinamico.canonical.request.message.MessageConsultarDatosTecnicoRequest;

public class ConsultarDatosTecnico {
	
	private MessageConsultarDatosTecnicoRequest messageRequest;

	public MessageConsultarDatosTecnicoRequest getMessageRequest() {
		return messageRequest;
	}

	public void setMessageRequest(MessageConsultarDatosTecnicoRequest messageRequest) {
		this.messageRequest = messageRequest;
	}

}
