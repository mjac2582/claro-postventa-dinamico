package pe.com.claro.common.resource.exception;

public class DataPowerException extends BaseException {
	
private static final long serialVersionUID = 1L;
	
	public DataPowerException(String msjError) {
		super(msjError);
	}

	public DataPowerException(String codError, String msjError) {
		super(codError, msjError);
	}
	
	public DataPowerException(String codError, String msjError, Exception objException) {
		super(codError, msjError, objException);
	}

}
