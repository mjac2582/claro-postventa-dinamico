package pe.com.claro.postventa.dinamico.canonical;

public class EvaluaCondicionRequest {
	private int idFlujo;
	private int idCondicion;
	private String valores;
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
	 * @return the idCondicion
	 */
	public int getIdCondicion() {
		return idCondicion;
	}
	/**
	 * @param idCondicion the idCondicion to set
	 */
	public void setIdCondicion(int idCondicion) {
		this.idCondicion = idCondicion;
	}
	/**
	 * @return the valores
	 */
	public String getValores() {
		return valores;
	}
	/**
	 * @param valores the valores to set
	 */
	public void setValores(String valores) {
		this.valores = valores;
	}
	
}
