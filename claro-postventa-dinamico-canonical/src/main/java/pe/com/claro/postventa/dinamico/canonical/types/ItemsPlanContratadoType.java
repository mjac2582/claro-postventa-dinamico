package pe.com.claro.postventa.dinamico.canonical.types;

import java.util.List;

public class ItemsPlanContratadoType {
	private String tipsrv;
	private String servicio;
    private List<ServicioType> listaServicio;
	
    public String getTipsrv() {
		return tipsrv;
	}
	public void setTipsrv(String tipsrv) {
		this.tipsrv = tipsrv;
	}
	
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public List<ServicioType> getListaServicio() {
		return listaServicio;
	}
	public void setListaServicio(List<ServicioType> listaServicio) {
		this.listaServicio = listaServicio;
	}
	
}
