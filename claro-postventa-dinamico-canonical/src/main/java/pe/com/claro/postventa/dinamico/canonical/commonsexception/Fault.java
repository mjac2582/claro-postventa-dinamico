package pe.com.claro.postventa.dinamico.canonical.commonsexception;

public class Fault {
	
	private String faultcode;
	
	private String faultstring;
	
	private String faultactor;
	
	private ErrorDetails detail;

	public String getFaultcode() {
		return faultcode;
	}

	public void setFaultcode(String faultcode) {
		this.faultcode = faultcode;
	}

	public String getFaultstring() {
		return faultstring;
	}

	public void setFaultstring(String faultstring) {
		this.faultstring = faultstring;
	}

	public String getFaultactor() {
		return faultactor;
	}

	public void setFaultactor(String faultactor) {
		this.faultactor = faultactor;
	}

	public ErrorDetails getDetail() {
		return detail;
	}

	public void setDetail(ErrorDetails detail) {
		this.detail = detail;
	}
}
