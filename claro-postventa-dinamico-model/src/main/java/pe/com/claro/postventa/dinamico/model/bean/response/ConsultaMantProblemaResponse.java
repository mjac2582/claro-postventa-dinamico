package pe.com.claro.postventa.dinamico.model.bean.response;

import java.util.List;

public class ConsultaMantProblemaResponse {
	
	private String descripcionCorta;
	private String resultado;
	private String msgerr;

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getMsgerr() {
		return msgerr;
	}

	public void setMsgerr(String msgerr) {
		this.msgerr = msgerr;
	}
}
