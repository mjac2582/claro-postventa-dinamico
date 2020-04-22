package pe.com.claro.common.exception;

public class ConvertException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private Exception exception;
	private String code;
	private String message;
	private String messageDeveloper;

	public ConvertException(String code, String message, Exception exception) {
		super(message);
		this.exception = exception;
		this.code = code;
		this.message = message;
	}

	public ConvertException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public ConvertException(String message, Exception exception) {
		super(message);
		this.exception = exception;
		this.message = message;
	}

	public ConvertException(String code, String message, String messageDeveloper, Exception exception) {
		super(message);
		this.code = code;
		this.message = message;
		this.messageDeveloper = messageDeveloper;
		this.exception = exception;
	}

	public ConvertException(Exception exception) {
		this.exception = exception;
	}

	public ConvertException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getCode() {
		return code;
	}

	public String getMessageDeveloper() {
		return messageDeveloper;
	}

	public void setMessageDeveloper(String messageDeveloper) {
		this.messageDeveloper = messageDeveloper;
	}
}
