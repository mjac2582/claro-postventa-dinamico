package pe.com.claro.postventa.dinamico.canonical;


public class EjecutarFlujoAutomaticoResponse {
	private int idTransaccion;
	private int idFlujo;
	private String descripcionFlujo;
	private String codigo;
	private String mensaje;
	
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
	/**
	 * @return the idTransaccion
	 */
	public int getIdTransaccion() {
		return idTransaccion;
	}
	/**
	 * @param idTransaccion the idTransaccion to set
	 */
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	/**
	 * @return the idFlujo
	 */
	public int getIdFlujo() {
		return idFlujo;
	}
	/**
	 * @param idFlujo the idFlujo to set
	 */
	public void setIdFlujo(int idFlujo) {
		this.idFlujo = idFlujo;
	}
	/**
	 * @return the descripcionFlujo
	 */
	public String getDescripcionFlujo() {
		return descripcionFlujo;
	}
	/**
	 * @param descripcionFlujo the descripcionFlujo to set
	 */
	public void setDescripcionFlujo(String descripcionFlujo) {
		this.descripcionFlujo = descripcionFlujo;
	}
	
}
