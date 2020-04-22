package pe.com.claro.postventa.dinamico.canonical;

import java.util.List;

public class CreateAccountRequest {
	private String identifier;
	private List<SubscriberType> subscribers = null;

	public String getIdentifier() {
	return identifier;
	}

	public void setIdentifier(String identifier) {
	this.identifier = identifier;
	}

	public List<SubscriberType> getSubscribers() {
	return subscribers;
	}

	public void setSubscribers(List<SubscriberType> subscribers) {
	this.subscribers = subscribers;
	}
}
