package pe.com.claro.postventa.dinamico.canonical;


public class TokenPruebaResponse {
	private String authorization;
	
	public String get(String parametro) {
		switch (parametro) {
		case "authorization":
			return this.authorization;
		default:
			return null;
		}
	}
	
	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	@Override
	public String toString() {
		return "TokenPruebaResponse [authorization=" + authorization + "]";
	}
	
}
