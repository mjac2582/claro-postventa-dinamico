package pe.com.claro.postventa.dinamico.canonical.bean;

public class MessageResponseDatosTecnico {
	
	private Header Header;
	
	private BodyDatosTecnico Body;

	public Header getHeader() {
		return Header;
	}
	public void setHeader(Header header) {
		Header = header;
	}
	public BodyDatosTecnico getBody() {
		return Body;
	}
	public void setBody(BodyDatosTecnico body) {
		Body = body;
	}
	
}
