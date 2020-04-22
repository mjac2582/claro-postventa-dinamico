
package pe.com.claro.common.resource.exception;

public class BadRequestException extends ComunesExceptionBean {

	private static final long serialVersionUID = -7482288873992395827L;

	public BadRequestException(int code, String msg) {
		super(code, msg);
	}

	public BadRequestException(int status, int code, String msg, String developerMessage) {
		super(status, code, msg, developerMessage);
	}

	public BadRequestException(int code, String msg, String developerMessage) {
		super(code, msg, developerMessage);
	}
}
