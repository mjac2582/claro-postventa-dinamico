
package pe.com.claro.common.resource.exception;

public class ApiException extends BaseException{

private static final long serialVersionUID = -4463545099205456203L;

	private int codigoRespuesta;
	private int status;
	private String nombreApi;
	private String nombreUri;
	
	public ApiException(String codError, String nombreApi, String nombreUri,
			String msjError, Exception objException) {
		super(codError, msjError, objException);
		this.nombreApi = nombreApi;
		this.nombreUri = nombreUri;
	}

	public ApiException(String codError, String nombreApi, String nombreUri,
			String msjError, Throwable objException) {
		super(codError, msjError, objException);
		this.nombreApi = nombreApi;
		this.nombreUri = nombreUri;
	}

	public ApiException(String msjError, Exception objException) {
		super(msjError, objException);
	}

	public ApiException(Exception objException) {
		super(objException);
	}

	public ApiException(String msjError) {
		super(msjError);
	}

	ApiException(int codigoRespuesta, String mensajeError) {
		super(mensajeError);
		this.codigoRespuesta = codigoRespuesta;
	}

	ApiException(int status, int codigoRespuesta, String mensajeError) {
		super(mensajeError);
		this.codigoRespuesta = codigoRespuesta;
		this.status = status;
	}

	ApiException(int codigoRespuesta, String msg, String mensajeError) {
		super(mensajeError);
		this.codigoRespuesta = codigoRespuesta;
	}

	public int getCodigoRespueta() {
		return codigoRespuesta;
	}

	public void setCodigoRespueta(int codigoRespueta) {
		this.codigoRespuesta = codigoRespueta;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNombreApi() {
		return nombreApi;
	}

	public void setNombreApi(String nombreApi) {
		this.nombreApi = nombreApi;
	}

	public String getNombreUri() {
		return nombreUri;
	}

	public void setNombreUri(String nombreUri) {
		this.nombreUri = nombreUri;
	}

	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
}
