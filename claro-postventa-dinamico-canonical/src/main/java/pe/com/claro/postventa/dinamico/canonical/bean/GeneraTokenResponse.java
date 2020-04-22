package pe.com.claro.postventa.dinamico.canonical.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneraTokenResponse {
	@JsonProperty("MessageResponse")
	private GeneraTokenMessageResponse messageResponse;

	public GeneraTokenMessageResponse getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(GeneraTokenMessageResponse messageResponse) {
		this.messageResponse = messageResponse;
	}

}
