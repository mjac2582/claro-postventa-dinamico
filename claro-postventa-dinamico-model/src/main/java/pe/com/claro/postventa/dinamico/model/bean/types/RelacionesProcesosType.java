package pe.com.claro.postventa.dinamico.model.bean.types;

public class RelacionesProcesosType {
	private int idSeq;
	private int idFlujo;
	private int idProcesoPre;
	private String campoPre;
	private int idProcesoPost;
	private String campoPost;
	private String flagTransformacion;
	private String scriptTransformacion;
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
	 * @return the idProcesoPre
	 */
	public int getIdProcesoPre() {
		return idProcesoPre;
	}
	/**
	 * @param idProcesoPre the idProcesoPre to set
	 */
	public void setIdProcesoPre(int idProcesoPre) {
		this.idProcesoPre = idProcesoPre;
	}
	/**
	 * @return the campoPre
	 */
	public String getCampoPre() {
		return campoPre;
	}
	/**
	 * @param campoPre the campoPre to set
	 */
	public void setCampoPre(String campoPre) {
		this.campoPre = campoPre;
	}
	/**
	 * @return the idProcesoPost
	 */
	public int getIdProcesoPost() {
		return idProcesoPost;
	}
	/**
	 * @param idProcesoPost the idProcesoPost to set
	 */
	public void setIdProcesoPost(int idProcesoPost) {
		this.idProcesoPost = idProcesoPost;
	}
	/**
	 * @return the campoPost
	 */
	public String getCampoPost() {
		return campoPost;
	}
	/**
	 * @param campoPost the campoPost to set
	 */
	public void setCampoPost(String campoPost) {
		this.campoPost = campoPost;
	}
	/**
	 * @return the flagTransformacion
	 */
	public String getFlagTransformacion() {
		return flagTransformacion;
	}
	/**
	 * @param flagTransformacion the flagTransformacion to set
	 */
	public void setFlagTransformacion(String flagTransformacion) {
		this.flagTransformacion = flagTransformacion;
	}
	/**
	 * @return the scriptTransformacion
	 */
	public String getScriptTransformacion() {
		return scriptTransformacion;
	}
	/**
	 * @param scriptTransformacion the scriptTransformacion to set
	 */
	public void setScriptTransformacion(String scriptTransformacion) {
		this.scriptTransformacion = scriptTransformacion;
	}
	public int getIdSeq() {
		return idSeq;
	}
	public void setIdSeq(int idSeq) {
		this.idSeq = idSeq;
	}
	
	
}
