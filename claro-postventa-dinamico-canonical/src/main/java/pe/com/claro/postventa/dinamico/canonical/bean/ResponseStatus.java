package pe.com.claro.postventa.dinamico.canonical.bean;

import java.util.List;

import pe.com.claro.postventa.dinamico.canonical.commonsexception.ErrorDetails;

public class ResponseStatus {
	
	private String status;
	
	private String codeResponse;
	
	private String descriptionResponse;
	
	private String errorLocation;
	
	private String date;
	
	private String origin;
	
	private List<ErrorDetails> errorDetails;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodeResponse() {
		return codeResponse;
	}

	public void setCodeResponse(String codeResponse) {
		this.codeResponse = codeResponse;
	}

	public String getDescriptionResponse() {
		return descriptionResponse;
	}

	public void setDescriptionResponse(String descriptionResponse) {
		this.descriptionResponse = descriptionResponse;
	}

	public String getErrorLocation() {
		return errorLocation;
	}

	public void setErrorLocation(String errorLocation) {
		this.errorLocation = errorLocation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public List<ErrorDetails> getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(List<ErrorDetails> errorDetails) {
		this.errorDetails = errorDetails;
	}
}
