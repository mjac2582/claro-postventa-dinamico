package pe.com.claro.common.bean;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.HttpHeaders;

import org.hibernate.validator.constraints.NotEmpty;

import pe.com.claro.common.property.Constantes;

@Entity
public class HeaderRequest {
	@NotNull(message="idTransaccion - No puede ser nulo")
	@NotEmpty(message="idTransaccion - No puede ser vacio")
	private String idTransaccion;
	
	@NotNull(message="msgid - No puede ser nulo")
	@NotEmpty(message="msgid - No puede ser vacio")
	private String msgid;
	
	@NotNull(message="timestamp - No puede ser nulo")
	@NotEmpty(message="timestamp - No puede ser vacio")
	private String timestamp;
	
	@NotNull(message="userId - No puede ser nulo")
	@NotEmpty(message="userId - No puede ser vacio")
	private String userId;
	
	@NotNull(message="accept - No puede ser nulo")
	@NotEmpty(message="accept - No puede ser vacio")
	private String accept;
	
	public HeaderRequest(){
		super();
	}

	public HeaderRequest(HeaderRequest headerRequest) {
		super();
		this.idTransaccion = headerRequest.getIdTransaccion()!= null
				? headerRequest.getIdTransaccion(): null;
		this.msgid = headerRequest.getMsgid()!= null
				? headerRequest.getMsgid(): null;
		this.userId = headerRequest.getUserId()!= null
				? headerRequest.getUserId(): null;
		this.accept = headerRequest.getAccept()!= null
				? headerRequest.getAccept(): null;
		this.timestamp = headerRequest.getTimestamp()!= null
				? headerRequest.getTimestamp(): null;
	}
	
	public HeaderRequest(HttpHeaders httpHeaders) {
		super();
		this.idTransaccion = httpHeaders.getRequestHeader(Constantes.IDTRANSACCION) != null
				? httpHeaders.getRequestHeader(Constantes.IDTRANSACCION).get(Constantes.CERO) : null;
		this.msgid = httpHeaders.getRequestHeader(Constantes.MSGID) != null
				? httpHeaders.getRequestHeader(Constantes.MSGID).get(Constantes.CERO) : null;
		this.userId = httpHeaders.getRequestHeader(Constantes.USERID) != null
				? httpHeaders.getRequestHeader(Constantes.USERID).get(Constantes.CERO) : null;
		this.accept = httpHeaders.getRequestHeader(Constantes.ACCEPT) != null
				? httpHeaders.getRequestHeader(Constantes.ACCEPT).get(Constantes.CERO) : null;
		this.timestamp= httpHeaders.getRequestHeader(Constantes.TIMESTAMP) != null
                ? httpHeaders.getRequestHeader(Constantes.TIMESTAMP).get(Constantes.CERO) : Constantes.VACIO;
	}
	
	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "HeaderRequest [idTransaccion=" + idTransaccion + 
							", msgid=" + msgid + 
							", timestamp=" + timestamp +
							", userId=" + userId + 
							", accept=" + accept + "]";
	}
	

}
