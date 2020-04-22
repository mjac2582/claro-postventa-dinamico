package pe.com.claro.common.resource.exception;

public class ComunesExceptionBean extends ApiException {

	private static final long serialVersionUID = 1L;
	String mensajeRespuesta;

    ComunesExceptionBean(int codigoRespueta, String msg) {
        super(codigoRespueta, msg);
    }

    ComunesExceptionBean(int status, int codigoRespueta, String mensajeRespuesta, String mensajeError) {
        super(status, codigoRespueta, mensajeError);
        this.mensajeRespuesta = mensajeRespuesta;
    }

    ComunesExceptionBean(int codigoRespueta, String msg, String mensajeError) {
        super(codigoRespueta, msg, mensajeError);
        this.mensajeRespuesta = msg;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeError) {
        this.mensajeRespuesta = mensajeError;
    }
}
