
package pe.com.claro.common.resource.exception;

public class NotFoundException extends ComunesExceptionBean {

	private static final long serialVersionUID = 8992570382210399390L;

	public NotFoundException(int code, String msg) {
		super(code, msg);
	}

	public NotFoundException(int status, int code, String msg, String developerMessage) {
		super(status, code, msg, developerMessage);
	}

	public NotFoundException(int code, String mensajeRespuesta, String developerMessage) {
		super(code, mensajeRespuesta, developerMessage);
	}
}
