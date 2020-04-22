package pe.com.claro.postventa.dinamico.canonical.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderDatapower {
	@JsonProperty("HeaderRequest")
	private HeaderDPRequest headerRequest;

	public HeaderDPRequest getHeaderRequest() {
		return headerRequest;
	}

	public void setHeaderRequest(HeaderDPRequest headerRequest) {
		this.headerRequest = headerRequest;
	}

}
