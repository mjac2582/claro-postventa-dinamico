package pe.com.claro.postventa.dinamico.model.bean.response;

import java.util.List;

import pe.com.claro.postventa.dinamico.model.bean.types.DetCpType;

public class DevuelvePostDetCpResponse {
	private List<String> descripcionCorta;
	private List<DetCpType> listaDetCp;
	private String resultado;
	private String msgerr;
	
	public List<String> getDescripcionCorta(){
		return descripcionCorta;
	}
	
	public void setDescripcionCorta(List<String> descripcionCorta){
		this.descripcionCorta = descripcionCorta;
	}

	public List<DetCpType> getListaDetCp() {
		return listaDetCp;
	}

	public void setListaDetCp(List<DetCpType> listaDetCp) {
		this.listaDetCp = listaDetCp;
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
