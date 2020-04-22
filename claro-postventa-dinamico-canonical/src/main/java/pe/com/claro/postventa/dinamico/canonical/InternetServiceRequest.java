package pe.com.claro.postventa.dinamico.canonical;

import java.util.List;

public class InternetServiceRequest {
	private String identifier;
	private String subscriberIdentifier;
	private String serviceType;
	private List<InternetServiceAttributeType> attributes;
	private InternetServiceDeviceType device;

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
	public List<InternetServiceAttributeType> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<InternetServiceAttributeType> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the device
	 */
	public InternetServiceDeviceType getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(InternetServiceDeviceType device) {
		this.device = device;
	}
	
}
