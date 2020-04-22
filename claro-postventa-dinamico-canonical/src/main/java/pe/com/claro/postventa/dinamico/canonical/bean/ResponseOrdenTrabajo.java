package pe.com.claro.postventa.dinamico.canonical.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseOrdenTrabajo {
	@JsonProperty("MessageResponse")
	private MessageResponseOrdenTrabajo MessageResponse;

	public MessageResponseOrdenTrabajo getMessageResponse() {
		return MessageResponse;
	}

	public void setMessageResponse(MessageResponseOrdenTrabajo messageResponse) {
		MessageResponse = messageResponse;
	}
}
