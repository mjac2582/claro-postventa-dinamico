package pe.com.claro.postventa.dinamico.canonical.response;

import java.util.List;

import pe.com.claro.postventa.dinamico.canonical.types.ItemsResponseOrdenTrabajoType;

public class ConsultarOrdenesTrabajoResponse {
	
	private String codigo;
	private String mensaje;
	private String fecActual;
	private List<ItemsResponseOrdenTrabajoType> listaOrdenTrabajo;
	private List<ItemsResponseOrdenTrabajoType> listaOrdenTrabajoOtros;
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
	public String getFecActual() {
		return fecActual;
	}
	public void setFecActual(String fecActual) {
		this.fecActual = fecActual;
	}
	public List<ItemsResponseOrdenTrabajoType> getListaOrdenTrabajo() {
		return listaOrdenTrabajo;
	}
	public void setListaOrdenTrabajo(List<ItemsResponseOrdenTrabajoType> listaOrdenTrabajo) {
		this.listaOrdenTrabajo = listaOrdenTrabajo;
	}
	public List<ItemsResponseOrdenTrabajoType> getListaOrdenTrabajoOtros() {
		return listaOrdenTrabajoOtros;
	}
	public void setListaOrdenTrabajoOtros(List<ItemsResponseOrdenTrabajoType> listaOrdenTrabajoOtros) {
		this.listaOrdenTrabajoOtros = listaOrdenTrabajoOtros;
	}

	
	

}
