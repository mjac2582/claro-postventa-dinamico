package pe.com.claro.postventa.dinamico.canonical;

public class IncognitoApiGenericHeader {
	private String source;
	private String authorization;
	private String transactionId;
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the authorization
	 */
	public String getAuthorization() {
		return authorization;
	}
	/**
	 * @param authorization the authorization to set
	 */
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
}
