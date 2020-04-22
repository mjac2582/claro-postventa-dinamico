package pe.com.claro.postventa.dinamico.model.bean.response;

import java.util.List;

import pe.com.claro.postventa.dinamico.model.bean.types.SubTipoOrdenType;
import pe.com.claro.postventa.dinamico.model.bean.types.TipoOrdenType;

public class ObtenerTipoSubTipoOrdenResponse {
	
	private List<TipoOrdenType> listaTipoOrden;
	
	private List<SubTipoOrdenType> listaSubTipoOrden;
	
	private int codRespuesta;
	
	private String msgRespuesta;

	public List<TipoOrdenType> getListaTipoOrden() {
		return listaTipoOrden;
	}

	public List<SubTipoOrdenType> getListaSubTipoOrden() {
		return listaSubTipoOrden;
	}

	public void setListaSubTipoOrden(List<SubTipoOrdenType> listaSubTipoOrden) {
		this.listaSubTipoOrden = listaSubTipoOrden;
	}

	public int getCodRespuesta() {
		return codRespuesta;
	}

	public void setCodRespuesta(int codRespuesta) {
		this.codRespuesta = codRespuesta;
	}

	public String getMsgRespuesta() {
		return msgRespuesta;
	}

	public void setMsgRespuesta(String msgRespuesta) {
		this.msgRespuesta = msgRespuesta;
	}

	public void setListaTipoOrden(List<TipoOrdenType> listaTipoOrden) {
		this.listaTipoOrden = listaTipoOrden;
	}
}
