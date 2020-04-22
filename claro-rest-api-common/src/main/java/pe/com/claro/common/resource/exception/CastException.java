package pe.com.claro.common.resource.exception;

public class CastException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public CastException(String string) {
		super(string);
	}

	public CastException(Exception exception) {
		super(exception);
	}

	public CastException(String string, Exception exception) {
		super(string, exception);
	}

	public CastException(String code, String message, Exception exception) {
		super(code, message, exception);
	}

	public CastException(String code, String message, String messageDeveloper, Exception exception, int status) {
		super(code, message, messageDeveloper, exception, status);
	}

	public CastException(String code, String message) {
		super(code, message);
	}
}
