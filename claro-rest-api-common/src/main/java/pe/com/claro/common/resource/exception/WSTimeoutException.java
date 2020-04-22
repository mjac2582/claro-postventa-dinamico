package pe.com.claro.common.resource.exception;

public class WSTimeoutException extends BaseException{

	private static final long	serialVersionUID	= 1L;
	private String				nombreWS;

	/**
	 * Constructores
	 */
	public WSTimeoutException( String codError, String nombreWS, String msjError, Exception objException ){
		super( codError, msjError, objException );
		this.nombreWS = nombreWS;
	}

	/**
	 * Constructores
	 */
	public WSTimeoutException( String codError, String nombreWS, String msjError, Throwable objException ){
		super( codError, msjError );
		this.nombreWS = nombreWS;
	}

	/**
	 * Constructores
	 */
	public WSTimeoutException( String msjError, Exception objException ){
		super( msjError, objException );
	}

	/**
	 * Constructores
	 */
	public WSTimeoutException( Exception objException ){
		super( objException );
	}

	/**
	 * Constructores
	 */
	public WSTimeoutException( String msjError ){
		super( msjError );
	}

	public String getNombreWS(){
		return nombreWS;
	}

	public void setNombreWS( String nombreWS ){
		this.nombreWS = nombreWS;
	}

}
