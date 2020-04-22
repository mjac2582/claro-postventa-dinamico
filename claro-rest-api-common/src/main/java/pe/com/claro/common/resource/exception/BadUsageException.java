package pe.com.claro.common.resource.exception;

public class BadUsageException extends ComunesExceptionBean {

	private static final long serialVersionUID = 1L;
	
     public BadUsageException (int code, String msg) {
       super(code, msg);
     }
     
 	public BadUsageException(int status, int code, String msg, String developerMessage) {
		super(status, code, msg, developerMessage);
	}

	public BadUsageException(int code, String msg, String developerMessage) {
		super(code, msg, developerMessage);
	}     
}
