package pe.com.claro.postventa.dinamico.canonical.bean;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ObtenerDatosTecnicoRequest {
	
	@NotNull
	private String nroDocumento;
	
	
	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	
	public ObtenerDatosTecnicoRequest(){
		super();
	}
}
