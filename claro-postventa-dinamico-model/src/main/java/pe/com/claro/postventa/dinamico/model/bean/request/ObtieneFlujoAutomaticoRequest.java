package pe.com.claro.postventa.dinamico.model.bean.request;

import java.util.List;

import pe.com.claro.postventa.dinamico.canonical.Parametros;

public class ObtieneFlujoAutomaticoRequest {
	
	private String transaccion;
	private String tecnologia;
	private int idtransversal;
	private List<Parametros> paramEnvio;
	//private String idflujo;
	/**
	 * @return the transaccion
	 */
	public String getTransaccion() {
		return transaccion;
	}
	/**
	 * @param transaccion the transaccion to set
	 */
	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}
	/**
	 * @return the tecnologia
	 */
	public String getTecnologia() {
		return tecnologia;
	}
	/**
	 * @param tecnologia the tecnologia to set
	 */
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	/**
	 * @return the idtransversal
	 */
	public int getIdtransversal() {
		return idtransversal;
	}
	/**
	 * @param idtransversal the idtransversal to set
	 */
	public void setIdtransversal(int idtransversal) {
		this.idtransversal = idtransversal;
	}
	/**
	 * @return the paramEnvio
	 */
	/**
	 * @return the paramEnvio
	 */
	public List<Parametros> getParamEnvio() {
		return paramEnvio;
	}
	/**
	 * @param paramEnvio the paramEnvio to set
	 */
	public void setParamEnvio(List<Parametros> paramEnvio) {
		this.paramEnvio = paramEnvio;
	}




}
