package pe.com.claro.postventa.dinamico.canonical.response;

import java.util.List;

import pe.com.claro.postventa.dinamico.canonical.types.ItemsRecetaType;

public class ConsultarRecetaResponse {
	private String codigo;
	private String mensaje;
	private List<ItemsRecetaType> listaReceta;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<ItemsRecetaType> getListaReceta() {
		return listaReceta;
	}
	public void setListaReceta(List<ItemsRecetaType> listaReceta) {
		this.listaReceta = listaReceta;
	}
	
	
}
