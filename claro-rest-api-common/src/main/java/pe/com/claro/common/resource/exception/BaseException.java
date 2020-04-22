package pe.com.claro.common.resource.exception;

public class BaseException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private Exception exception;
    private String code;
    private String message;
    private String messageDeveloper;
    private int status;
    private String nomService;
    
    public BaseException(){
    	super();
    }
    
    public BaseException(String code, String message, Throwable exception) {
		super(message, exception);
		this.code = code;
	}
    
    public BaseException(String code, String message, Exception exception) {
    	super(message, exception);
		this.code = code;
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    
    public BaseException(String code, String message, String nomService, Exception exception) {
        super(message);
        this.code = code;
        this.message = message;
        this.nomService = nomService;
        this.exception = exception;
    }
    public BaseException(String code, String message, String nomService) {
    	 super(message);
    	this.code = code;
        this.message = message;
        this.nomService = nomService;
    }
    
    public BaseException(String code, String message, String messageDeveloper, String nomService) {
        super(message);
        this.code = code;
        this.message = message;
        this.messageDeveloper = messageDeveloper;
        this.nomService = nomService;
    }

    public BaseException(String message, Exception exception) {
        super(message);
        this.exception = exception;
        this.message = message;
    }

    public BaseException(String code, String message, String messageDeveloper, Exception exception, int status) {
		super(message);
		this.code = code;
		this.message = message;
		this.messageDeveloper = messageDeveloper;
		this.exception = exception;
		this.status = status;
	}
    
    public BaseException(String code, String message, String messageDeveloper, Exception exception, int status, String nomService) {
		super(message);
		this.code = code;
		this.message = message;
		this.messageDeveloper = messageDeveloper;
		this.exception = exception;
		this.status = status;
		this.nomService = nomService;
	}

	public BaseException(Exception exception) {
        this.exception = exception;
    }

    public BaseException(String message) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

}
