package pe.com.claro.postventa.dinamico.canonical;

import java.util.List;

import javax.validation.constraints.NotNull;

public class EjecutarFlujoAutomaticoRequest {

	@NotNull(message="transaccion - No puede ser nulo o vacio")
	private String transaccion;
	
	@NotNull(message="tecnologia - No puede ser nulo o vacio")
	private String tecnologia;
	
	@NotNull(message="parametros - No puede ser nulo o vacio")
	private List<Parametros> parametros;
	



	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}


	/**
	 * @return the parametros
	 */
	public List<Parametros> getParametros() {
		return parametros;
	}

	/**
	 * @param parametros the parametros to set
	 */
	public void setParametros(List<Parametros> parametros) {
		this.parametros = parametros;
	}

	public EjecutarFlujoAutomaticoRequest(){
		super();
	}

	@Override
	public String toString() {
		return "ConsultarFlujoAutomaticoRequest [transaccion=" + transaccion + ", tecnologia=" + tecnologia
				+ ", parametros=" + parametros + "]";
	}

}
