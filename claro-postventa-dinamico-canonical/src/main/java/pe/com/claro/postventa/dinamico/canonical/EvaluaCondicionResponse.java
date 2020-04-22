package pe.com.claro.postventa.dinamico.canonical;

public class EvaluaCondicionResponse {
	private boolean validacion;
	private int codResp;
	private String msjResp;
	/**
	 * @return the validacion
	 */
	public boolean isValidacion() {
		return validacion;
	}
	/**
	 * @param validacion the validacion to set
	 */
	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}
	/**
	 * @return the codResp
	 */
	public int getCodResp() {
		return codResp;
	}
	/**
	 * @param codResp the codResp to set
	 */
	public void setCodResp(int codResp) {
		this.codResp = codResp;
	}
	/**
	 * @return the msjResp
	 */
	public String getMsjResp() {
		return msjResp;
	}
	/**
	 * @param msjResp the msjResp to set
	 */
	public void setMsjResp(String msjResp) {
		this.msjResp = msjResp;
	}
	
	
}
