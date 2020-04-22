package pe.com.claro.postventa.dinamico.canonical.generic.message.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderResponse {
	@JsonProperty("consumer")
	private String consumer;
	
	@JsonProperty("pid")
	private String pid;

	@JsonProperty("timestamp")
	private String timestamp;
	
	@JsonProperty("VarArg")
	private String VarArg;

	@JsonProperty("status")
    private StatusType status;

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVarArg() {
		return VarArg;
	}

	public void setVarArg(String varArg) {
		VarArg = varArg;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}
}
