package pe.com.claro.postventa.dinamico.canonical.request.input;

import javax.validation.constraints.NotNull;

public class ConsultarDatosTecnicoRequest {
	
	@NotNull(message="nroDocumento - No puede ser nulo o vacio")
	private String nroDocumento;
	
	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	
	public ConsultarDatosTecnicoRequest(){
		super();
	}
	
	@Override
	public String toString(){
		return "ConsultarDatosTecnicoRequest [nroDocumento" + nroDocumento + "]";
	}
}
