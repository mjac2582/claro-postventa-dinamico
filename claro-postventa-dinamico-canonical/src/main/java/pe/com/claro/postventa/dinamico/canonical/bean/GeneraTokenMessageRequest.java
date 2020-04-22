package pe.com.claro.postventa.dinamico.canonical.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneraTokenMessageRequest {
	@JsonProperty("Header")
	private HeaderDatapower header;

	@JsonProperty("Body")
	private BodyGeneraTokenRequest body;

	public HeaderDatapower getHeader() {
		return header;
	}

	public void setHeader(HeaderDatapower header) {
		this.header = header;
	}

	public BodyGeneraTokenRequest getBody() {
		return body;
	}

	public void setBody(BodyGeneraTokenRequest body) {
		this.body = body;
	}

}
