package pe.com.claro.restclient;

import pe.com.claro.restclient.RestClient;
import pe.com.claro.restclient.RestClient.RestClientBuilder;

public class AbstractRestClient {
	
	protected RestClient restClient;

    public void loadRestClient(String url, int connectionTimeout) {
    	restClient= new RestClientBuilder(url).connectionTimeoutBuilder(connectionTimeout).build();
    }

	public RestClient getRestClient() {
		return restClient;
	}
	
}
