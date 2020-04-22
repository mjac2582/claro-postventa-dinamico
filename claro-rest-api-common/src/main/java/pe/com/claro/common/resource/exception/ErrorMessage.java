package pe.com.claro.common.resource.exception;

import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.beanutils.BeanUtils;


@XmlRootElement
public class ErrorMessage {

	private int codigoRespuesta;
	private String mensajeRespuesta;
	private String mensajeError;

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

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	ErrorMessage(ApiException ex){
		try {
			
			BeanUtils.copyProperties(this, ex);
		} catch (IllegalAccessException e) {
			
		} catch (InvocationTargetException e) {
			
		}
	}

	ErrorMessage(ComunesExceptionBean ex){
		this.codigoRespuesta =ex.getCodigoRespueta();
		this.mensajeError =ex.getMessage();
		this.mensajeRespuesta = ex.getMensajeRespuesta();
	}

	public ErrorMessage() {}
}
