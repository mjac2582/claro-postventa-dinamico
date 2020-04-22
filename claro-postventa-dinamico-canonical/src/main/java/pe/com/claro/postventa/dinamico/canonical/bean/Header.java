package pe.com.claro.postventa.dinamico.canonical.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.postventa.dinamico.canonical.generic.message.v1.HeaderResponse;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Header {
	@JsonProperty("HeaderResponse")
	private HeaderResponse HeaderResponse;

	public HeaderResponse getHeaderResponse() {
		return HeaderResponse;
	}

	public void setHeaderResponse(HeaderResponse headerResponse) {
		HeaderResponse = headerResponse;
	}
}
