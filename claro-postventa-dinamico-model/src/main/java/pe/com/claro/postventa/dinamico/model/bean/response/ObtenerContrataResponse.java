package pe.com.claro.postventa.dinamico.model.bean.response;

public class ObtenerContrataResponse {
	
	private String nombreContrata;
	private int codigoRespuesta;
	private String mensajeRespuesta;
	
	public String getNombreContrata() {
		return nombreContrata;
	}
	public void setNombreContrata(String nombreContrata) {
		this.nombreContrata = nombreContrata;
	}
	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
	
}
