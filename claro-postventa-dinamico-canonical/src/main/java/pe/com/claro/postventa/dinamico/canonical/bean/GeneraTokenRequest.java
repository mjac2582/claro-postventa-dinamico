package pe.com.claro.postventa.dinamico.canonical.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeneraTokenRequest {

	@JsonProperty("MessageRequest")
	private GeneraTokenMessageRequest messageRequest;

	public GeneraTokenMessageRequest getMessageRequest() {
		return messageRequest;
	}

	public void setMessageRequest(GeneraTokenMessageRequest messageRequest) {
		this.messageRequest = messageRequest;
	}

	

}
