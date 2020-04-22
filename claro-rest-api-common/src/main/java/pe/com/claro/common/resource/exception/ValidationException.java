package pe.com.claro.common.resource.exception;

public class ValidationException extends BaseException{

	private static final long serialVersionUID = 1L;

	public ValidationException(){
		super();
	}

	public ValidationException( String msjError ){
		super( msjError );
	}

	public ValidationException( String codError, String msjError){
		super( codError, msjError);
	}
	
}
