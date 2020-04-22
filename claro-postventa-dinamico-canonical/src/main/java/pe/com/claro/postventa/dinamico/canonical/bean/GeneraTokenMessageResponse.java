package pe.com.claro.postventa.dinamico.canonical.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneraTokenMessageResponse {
	@JsonProperty("Header")
	private Header header;

	@JsonProperty("Body")
	private GeneraTokenBodyResponse cuerpo;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public GeneraTokenBodyResponse getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(GeneraTokenBodyResponse cuerpo) {
		this.cuerpo = cuerpo;
	}
}
