package pe.com.claro.postventa.dinamico.canonical;

public class RegistraTransaccionRequest {
	private int idTransaccion;
	private String tramaCabecera;
	private String tramaDetalle;
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
	 * @return the tramaCabecera
	 */
	public String getTramaCabecera() {
		return tramaCabecera;
	}
	/**
	 * @param tramaCabecera the tramaCabecera to set
	 */
	public void setTramaCabecera(String tramaCabecera) {
		this.tramaCabecera = tramaCabecera;
	}
	/**
	 * @return the tramaDetalle
	 */
	public String getTramaDetalle() {
		return tramaDetalle;
	}
	/**
	 * @param tramaDetalle the tramaDetalle to set
	 */
	public void setTramaDetalle(String tramaDetalle) {
		this.tramaDetalle = tramaDetalle;
	}
	
}
