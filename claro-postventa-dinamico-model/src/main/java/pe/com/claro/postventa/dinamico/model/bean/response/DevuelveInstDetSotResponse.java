package pe.com.claro.postventa.dinamico.model.bean.response;

import java.util.List;

import pe.com.claro.postventa.dinamico.model.bean.types.DetSotType;

public class DevuelveInstDetSotResponse {

	private List<DetSotType> listaDetSot;
	private String resultado;
	private String msgerr;
	
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

	public List<DetSotType> getListaDetSot() {
		return listaDetSot;
	}

	public void setListaDetSot(List<DetSotType> listaDetSot) {
		this.listaDetSot = listaDetSot;
	}
	
}
