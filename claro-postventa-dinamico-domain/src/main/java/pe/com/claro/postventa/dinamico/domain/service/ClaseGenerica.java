package pe.com.claro.postventa.dinamico.domain.service;

public class ClaseGenerica<T> {
	private T objeto;
	public ClaseGenerica(T objeto) {
        this.objeto = objeto;
    }
	/**
	 * @return the objeto
	 */
	public T getObjeto() {
		return objeto;
	}
	/**
	 * @param objeto the objeto to set
	 */
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
}
