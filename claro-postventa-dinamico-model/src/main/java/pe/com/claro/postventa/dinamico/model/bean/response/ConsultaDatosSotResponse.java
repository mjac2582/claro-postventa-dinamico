package pe.com.claro.postventa.dinamico.model.bean.response;

import java.util.List;

public class ConsultaDatosSotResponse {

	private String flgPortable;
	private String plan;
	private List<String> contactoCliente;
	private List<String> descripcionCorta;
	private String resultado;
	private String msgerr;
	private String codigoCliente;
	private String descripcion;
	private String codigoEscenario;
	private String escenario;
	private String codigoTecnologia;
	private String tecnologia;
	
	public String getFlgPortable() {
		return flgPortable;
	}

	public void setFlgPortable(String flgPortable) {
		this.flgPortable = flgPortable;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public List<String> getContactoCliente() {
		return contactoCliente;
	}

	public void setContactoCliente(List<String> contactoCliente) {
		this.contactoCliente = contactoCliente;
	}

	public List<String> getDescripcionCorta(){
		return descripcionCorta;
	}
	
	public void setDescripcionCorta(List<String> descripcionCorta){
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

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEscenario() {
		return escenario;
	}

	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getCodigoEscenario() {
		return codigoEscenario;
	}

	public void setCodigoEscenario(String codigoEscenario) {
		this.codigoEscenario = codigoEscenario;
	}

	public String getCodigoTecnologia() {
		return codigoTecnologia;
	}

	public void setCodigoTecnologia(String codigoTecnologia) {
		this.codigoTecnologia = codigoTecnologia;
	}

	
}
