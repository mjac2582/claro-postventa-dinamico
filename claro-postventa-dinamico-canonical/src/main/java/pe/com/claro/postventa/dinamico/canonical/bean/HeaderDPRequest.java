package pe.com.claro.postventa.dinamico.canonical.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderDPRequest {
	@JsonProperty("consumer")
	private String consumer;

	@JsonProperty("country")
	private String country;

	@JsonProperty("dispositivo")
	private String dispositivo;

	@JsonProperty("language")
	private String language;

	@JsonProperty("modulo")
	private String modulo;

	@JsonProperty("msgType")
	private String msgType;

	@JsonProperty("operation")
	private String operation;

	@JsonProperty("pid")
	private String pid;

	@JsonProperty("system")
	private String system;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("wsIp")
	private String wsIp;

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
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

	public String getWsIp() {
		return wsIp;
	}

	public void setWsIp(String wsIp) {
		this.wsIp = wsIp;
	}

}
