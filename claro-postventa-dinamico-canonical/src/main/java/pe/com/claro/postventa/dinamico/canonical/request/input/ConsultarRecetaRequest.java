package pe.com.claro.postventa.dinamico.canonical.request.input;

import javax.validation.constraints.NotNull;

public class ConsultarRecetaRequest {
	@NotNull(message="codSolot - No puede ser nulo o vacio")
	private String codSolot;
	

	public String getCodSolot() {
		return codSolot;
	}

	public void setCodSolot(String codSolot) {
		this.codSolot = codSolot;
	}

	public ConsultarRecetaRequest(){
		super();
	}

	@Override
	public String toString(){
		return "ConsultarRecetaRequest [codSolot:" + codSolot + "]";
	}
}
