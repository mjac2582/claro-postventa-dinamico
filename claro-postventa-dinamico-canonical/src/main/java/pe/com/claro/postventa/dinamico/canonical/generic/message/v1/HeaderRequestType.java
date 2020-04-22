package pe.com.claro.postventa.dinamico.canonical.generic.message.v1;

import javax.xml.datatype.XMLGregorianCalendar;

public class HeaderRequestType {
	 
	  protected String country;
	  
	  protected String language;
	  
	  protected String consumer;
	  
	  protected String system;
	  
	  protected String modulo;
	  
	  protected String pid;
	  
	  protected String userId;
	  
	  protected String dispositivo;
	  
	  protected String wsIp;
	  
	  protected String operation;
	  
	  protected XMLGregorianCalendar timestamp;
	  
	  protected String msgType;
	  
	  protected VarArgType varArg;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String getWsIp() {
		return wsIp;
	}

	public void setWsIp(String wsIp) {
		this.wsIp = wsIp;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public XMLGregorianCalendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(XMLGregorianCalendar timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public VarArgType getVarArg() {
		return varArg;
	}

	public void setVarArg(VarArgType varArg) {
		this.varArg = varArg;
	}

}
