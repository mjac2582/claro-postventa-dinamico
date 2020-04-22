
package pe.com.claro.common.resource.exception;

public class FormatException extends ComunesExceptionBean {

	private static final long serialVersionUID = -7482288873992395827L;

	public FormatException(int code, String msg) {
		super(code, msg);
	}

	public FormatException(int status, int code, String msg, String developerMessage) {
		super(status, code, msg, developerMessage);
	}

	public FormatException(int code, String msg, String developerMessage) {
		super(code, msg, developerMessage);
	}
}
