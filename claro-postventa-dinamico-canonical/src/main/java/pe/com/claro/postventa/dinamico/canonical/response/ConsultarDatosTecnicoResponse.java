package pe.com.claro.postventa.dinamico.canonical.response;

import pe.com.claro.postventa.dinamico.canonical.bean.Tecnico;

public class ConsultarDatosTecnicoResponse {

	private String codigo;
	private String mensaje;
	private Tecnico tecnico;

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

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

}
