
package pe.com.claro.common.resource.exception;

public class BDException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7482288873992395827L;


	public BDException(String code, String message) {
        super(code, message);
	}
	
	public BDException(String code, String message, String nomService, Exception exception) {
		super(code, message, nomService, exception);
	}

}
