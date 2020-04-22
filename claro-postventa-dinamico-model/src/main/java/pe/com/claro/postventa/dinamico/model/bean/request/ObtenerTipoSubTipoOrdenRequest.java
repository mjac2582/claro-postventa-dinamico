package pe.com.claro.postventa.dinamico.model.bean.request;

public class ObtenerTipoSubTipoOrdenRequest {
	
	private String codTipoOrden;
	
	private String codSubTipoOrden;

	public String getCodTipoOrden() {
		return codTipoOrden;
	}

	public void setCodTipoOrden(String codTipoOrden) {
		this.codTipoOrden = codTipoOrden;
	}

	public String getCodSubTipoOrden() {
		return codSubTipoOrden;
	}

	public void setCodSubTipoOrden(String codSubTipoOrden) {
		this.codSubTipoOrden = codSubTipoOrden;
	}
}
