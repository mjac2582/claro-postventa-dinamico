package pe.com.claro.common.resource.exception;

public class GeneralRuntimeException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public GeneralRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
