package pe.com.claro.postventa.dinamico.canonical.response;

import java.util.List;

import pe.com.claro.postventa.dinamico.canonical.types.ItemsPlanContratadoType;

public class ConsultarPlanContratadoResponse {
	private String codigo;
	private String mensaje;
	private List<ItemsPlanContratadoType> listaPlanContratadoCable;
	private List<ItemsPlanContratadoType> listaPlanContratadoInternet;
	private List<ItemsPlanContratadoType> listaPlanContratadoTelefono;
	
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
	public List<ItemsPlanContratadoType> getListaPlanContratadoCable() {
		return listaPlanContratadoCable;
	}
	public void setListaPlanContratadoCable(List<ItemsPlanContratadoType> listaPlanContratadoCable) {
		this.listaPlanContratadoCable = listaPlanContratadoCable;
	}
	public List<ItemsPlanContratadoType> getListaPlanContratadoInternet() {
		return listaPlanContratadoInternet;
	}
	public void setListaPlanContratadoInternet(List<ItemsPlanContratadoType> listaPlanContratadoInternet) {
		this.listaPlanContratadoInternet = listaPlanContratadoInternet;
	}
	public List<ItemsPlanContratadoType> getListaPlanContratadoTelefono() {
		return listaPlanContratadoTelefono;
	}
	public void setListaPlanContratadoTelefono(List<ItemsPlanContratadoType> listaPlanContratadoTelefono) {
		this.listaPlanContratadoTelefono = listaPlanContratadoTelefono;
	}

	
}
