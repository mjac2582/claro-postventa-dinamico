package pe.com.claro.postventa.dinamico.canonical.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResponseOrdenTrabajo {
	
	@JsonProperty("Header")
	private Header Header;
	
	@JsonProperty("Body")
	private BodyOrdenTrabajo Body;

	public Header getHeader() {
		return Header;
	}

	public void setHeader(Header header) {
		Header = header;
	}

	public BodyOrdenTrabajo getBody() {
		return Body;
	}

	public void setBody(BodyOrdenTrabajo body) {
		Body = body;
	}
	
	
}
