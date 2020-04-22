package pe.com.claro.postventa.dinamico.canonical;

public class TelefoniaServiceDeviceType {
	private String identifier;
	private String type;
	private TelefoniaServiceChildType child;

	public String getIdentifier() {
	return identifier;
	}

	public void setIdentifier(String identifier) {
	this.identifier = identifier;
	}

	public String getType() {
	return type;
	}

	public void setType(String type) {
	this.type = type;
	}

	/**
	 * @return the child
	 */
	public TelefoniaServiceChildType getChild() {
		return child;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(TelefoniaServiceChildType child) {
		this.child = child;
	}


}
