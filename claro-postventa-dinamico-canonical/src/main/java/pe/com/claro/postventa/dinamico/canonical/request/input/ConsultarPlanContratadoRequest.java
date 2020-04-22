package pe.com.claro.postventa.dinamico.canonical.request.input;

import javax.validation.constraints.NotNull;

public class ConsultarPlanContratadoRequest {

	@NotNull(message="codSolot - No puede ser nulo o vacio")
	private String codSolot;
	
	@NotNull(message="codEscenario - No puede ser nulo o vacio")
	private String codEscenario;

	public String getCodSolot() {
		return codSolot;
	}

	public void setCodSolot(String codSolot) {
		this.codSolot = codSolot;
	}

	public String getCodEscenario() {
		return codEscenario;
	}

	public void setCodEscenario(String codEscenario) {
		this.codEscenario = codEscenario;
	}

	public ConsultarPlanContratadoRequest(){
		super();
	}
	
	@Override
	public String toString(){
		return "ConsultarPlanContratadoRequest [codSolot:" + codSolot + ", codEscenario:"+ codEscenario +"]";
	}
}
