package pe.com.claro.postventa.dinamico.canonical;

import java.util.List;

public class TelefoniaServiceRequest {
	private String identifier;
	private String subscriberIdentifier;
	private String serviceType;
	private List<TelefoniaServiceAttributeType> attributes = null;
	private TelefoniaServiceDeviceType device;

	public String getIdentifier() {
	return identifier;
	}

	public void setIdentifier(String identifier) {
	this.identifier = identifier;
	}

	public String getSubscriberIdentifier() {
	return subscriberIdentifier;
	}

	public void setSubscriberIdentifier(String subscriberIdentifier) {
	this.subscriberIdentifier = subscriberIdentifier;
	}

	public String getServiceType() {
	return serviceType;
	}

	public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
	}

	/**
	 * @return the attributes
	 */
	public List<TelefoniaServiceAttributeType> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<TelefoniaServiceAttributeType> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the device
	 */
	public TelefoniaServiceDeviceType getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(TelefoniaServiceDeviceType device) {
		this.device = device;
	}


}
