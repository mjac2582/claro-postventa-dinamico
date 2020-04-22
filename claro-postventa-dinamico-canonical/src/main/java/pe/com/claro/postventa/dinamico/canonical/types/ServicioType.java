package pe.com.claro.postventa.dinamico.canonical.types;

import java.util.List;

public class ServicioType {
	private String codigo;
	private String tipo;
	private String detalle;
	private List<EquiposType> listaPaqueteAdicional;
	private List<EquiposType> listaDecos;
	private List<EquiposType> listaEquipos;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public List<EquiposType> getListaPaqueteAdicional() {
		return listaPaqueteAdicional;
	}
	public void setListaPaqueteAdicional(List<EquiposType> listaPaqueteAdicional) {
		this.listaPaqueteAdicional = listaPaqueteAdicional;
	}
	public List<EquiposType> getListaDecos() {
		return listaDecos;
	}
	public void setListaDecos(List<EquiposType> listaDecos) {
		this.listaDecos = listaDecos;
	}
	public List<EquiposType> getListaEquipos() {
		return listaEquipos;
	}
	public void setListaEquipos(List<EquiposType> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
	
	

}
