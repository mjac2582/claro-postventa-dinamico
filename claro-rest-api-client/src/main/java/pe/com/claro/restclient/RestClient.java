package pe.com.claro.restclient;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import pe.com.claro.restclient.exception.ErrorResponse;
import pe.com.claro.restclient.entity.AuthenticationToken;
import pe.com.claro.restclient.entity.NamedParameter;

/**
 * The Class RestClient.
 */
// @Component
public final class RestClient{

	/** The Constant LOG. */
	private static final Logger				LOG	= LoggerFactory.getLogger( RestClient.class );

	/** The uri. */
	private String							baseURI;

	/** The token. */
	private AuthenticationToken				token;

	/** The password. */
	private String							password;

	/** The connection timeout. */
	private int								connectionTimeout;

	/** The headers. */
	private MultivaluedMap<String, Object>	headers;

	public RestClient(){
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Gets the.
	 * @param <T>
	 * the generic type
	 * @param restPath
	 * the rest path
	 * @param expectedResponse
	 * the expected response
	 * @param queryParams
	 * the query params
	 * @return the t
	 */
	public <T> T get( String restPath, Class<T> expectedResponse, Map<String, String> queryParams ){
		return call( HttpMethod.GET, restPath, expectedResponse, null, queryParams );
	}

	/**
	 * Post.
	 * @param restPath
	 * the rest path
	 * @param payload
	 * the payload
	 * @param queryParams
	 * the query params
	 * @return the response
	 */
	public ClientResponse post( String restPath, Object payload, Map<String, String> queryParams ){
		LOG.debug( "POST: {}", restPath );
		return call( HttpMethod.POST, restPath, ClientResponse.class, payload, queryParams );
	}

	/**
	 * Put.
	 * @param restPath
	 * the rest path
	 * @param payload
	 * the payload
	 * @param queryParams
	 * the query params
	 * @return the response
	 */
	public ClientResponse put( String restPath, Object payload, Map<String, String> queryParams ){
		LOG.debug( "PUT: {}", restPath );
		return call( HttpMethod.PUT, restPath, ClientResponse.class, payload, queryParams );
	}

	/**
	 * Delete.
	 * @param restPath
	 * the rest path
	 * @param queryParams
	 * the query params
	 * @return the response
	 */
	public ClientResponse delete( String restPath, Map<String, String> queryParams ){
		LOG.debug( "DELETE: {}", restPath );
		return call( HttpMethod.DELETE, restPath, ClientResponse.class, null, queryParams );
	}

	/**
	 * Delete.
	 * @param restPath
	 * the rest path
	 * @param queryParams
	 * the query params
	 * @return the response
	 */
	public ClientResponse delete( String restPath, Object payload, Map<String, String> queryParams ){
		LOG.debug( "DELETE: {}", restPath );
		return call( HttpMethod.DELETE, restPath, ClientResponse.class, payload, queryParams );
	}

	/**
	 * Gets the.
	 * @param <T>
	 * the generic type
	 * @param methodName
	 * the method name
	 * @param restPath
	 * the rest path
	 * @param expectedResponse
	 * the clazz
	 * @param payload
	 * the payload
	 * @param queryParams
	 * the query params
	 * @return the t
	 */
	@SuppressWarnings( "unchecked" )
	private <T> T call( String methodName, String restPath, Class<T> expectedResponse, Object payload, Map<String, String> queryParams ){

		WebResource webResource = createWebResource( restPath, queryParams );
		Builder builder = webResource.type( MediaType.APPLICATION_JSON );

		if( headers != null && !headers.isEmpty() ){
			for( Map.Entry<String, List<Object>> entry: headers.entrySet() ){
				for( Object v: entry.getValue() ){
					if( entry.getKey() != null && v != null ){
						LOG.debug( "PARAM: {} = {}", entry.getKey(), (String)v );
						builder.header( entry.getKey(), v );
					}
				}
			}
		}

		ClientResponse result = builder.method( methodName, ClientResponse.class, payload );

		if( expectedResponse.getName().equals( ClientResponse.class.getName() ) ){
			return (T)result;
		}

		if( result != null && result.hasEntity() && isStatusCodeOK( result, restPath ) ){
			return (T)result.getEntity( expectedResponse );
		}

		return null;
	}

	/**
	 * Checks if is status code ok.
	 * @param response
	 * the response
	 * @param uri
	 * the uri
	 * @return true, if is status code ok
	 */
	private boolean isStatusCodeOK( ClientResponse response, String uri ){
		if( response.getStatus() == Status.OK.getStatusCode() || response.getStatus() == Status.CREATED.getStatusCode() ){
			return true;
		}
		else if( response.getStatus() == Status.UNAUTHORIZED.getStatusCode() ){
			LOG.error( "UNAUTHORIZED: Your credentials are wrong. Please check your username/password or the secret key" );
		}
		else if( response.getStatus() == Status.CONFLICT.getStatusCode() || response.getStatus() == Status.NOT_FOUND.getStatusCode() || response.getStatus() == Status.FORBIDDEN.getStatusCode()
				|| response.getStatus() == Status.BAD_REQUEST.getStatusCode() ){
			ErrorResponse errorResponse = response.getEntity( ErrorResponse.class );
			LOG.error( "{} - {} on ressource {}", errorResponse.getException(), errorResponse.getMessage() + " :::: " + errorResponse.getRessource() );
		}
		else{
			LOG.error( "Unsupported status code: " + response );
		}
		LOG.error( response.toString() );

		return false;
	}

	/**
	 * Creates the web target.
	 * @param restPath
	 * the rest path
	 * @param queryParams
	 * the query params
	 * @return the web target
	 */
	private WebResource createWebResource( String restPath, Map<String, String> queryParams ){
		WebResource webResource;
		try{
			URI u = new URI( this.baseURI + restPath );
			Client client = Client.create();

			webResource = client.resource( u );
			if( queryParams != null && !queryParams.isEmpty() ){
				for( Map.Entry<String, String> entry: queryParams.entrySet() ){
					if( entry.getKey() != null && entry.getValue() != null ){
						LOG.debug( "PARAM: {} = {}", entry.getKey(), entry.getValue() );
						if( "extensionInfo".equals( entry.getKey() ) ){
							Type listType = new TypeToken<ArrayList<NamedParameter>>(){
							}.getType();
							List<NamedParameter> list = new Gson().fromJson( entry.getValue(), listType );
							for( NamedParameter nParameter: list ){
								webResource = webResource.queryParam( entry.getKey(), URLEncoder.encode( new Gson().toJson( nParameter ), "UTF-8" ) );
							}
						}
						else{
							webResource = webResource.queryParam( entry.getKey(), entry.getValue() );
						}
					}
				}
			}
		}
		catch( Exception e ){
			LOG.error( "Error", e );
			return null;
		}
		return webResource;
	}

	/**
	 * The Constructor.
	 * @param builder
	 * the builder
	 */
	public RestClient( RestClientBuilder builder ){
		this.baseURI = builder.baseURI;
		this.connectionTimeout = builder.connectionTimeout;
		this.setHeaders( builder.headers );
		this.token = builder.token;
	}

	/**
	 * The Class Builder.
	 */
	public static class RestClientBuilder{

		/** The uri. */
		private String							baseURI;

		/** The connection timeout. */
		private int								connectionTimeout;

		/** The headers. */
		private MultivaluedMap<String, Object>	headers;

		/** The token. */
		private AuthenticationToken				token;

		/**
		 * The Constructor.
		 * @param baseUri
		 * the base uri
		 */
		public RestClientBuilder( String baseUri ){
			this.headers = new MultivaluedHashMap<String, Object>();
			this.baseURI = baseUri;
		}

		/**
		 * Connection timeout.
		 * @param connectionTimeout
		 * the connection timeout
		 * @return the builder
		 */
		public RestClientBuilder connectionTimeoutBuilder( int connectionTimeout ){
			this.connectionTimeout = connectionTimeout;
			return this;
		}

		/**
		 * Headers.
		 * @param headers
		 * the headers
		 * @return the rest client builder
		 */
		public RestClientBuilder headersBuilder( MultivaluedMap<String, Object> headers ){
			this.headers = headers;
			return this;
		}

		/**
		 * Builds the.
		 * @return the rest client resource
		 */
		public RestClient build(){
			return new RestClient( this );
		}

	}

	/**
	 * Gets the uri.
	 * @return the uri
	 */
	public String getUri(){
		return baseURI;
	}

	/**
	 * Sets the uri.
	 * @param uri
	 * the new uri
	 */
	public void setUri( String uri ){
		this.baseURI = uri;
	}

	/**
	 * Gets the password.
	 * @return the password
	 */
	public String getPassword(){
		return password;
	}

	/**
	 * Sets the password.
	 * @param password
	 * the new password
	 */
	public void setPassword( String password ){
		this.password = password;
	}

	/**
	 * Gets the connection timeout.
	 * @return the connection timeout
	 */
	public int getConnectionTimeout(){
		return connectionTimeout;
	}

	/**
	 * Sets the connection timeout.
	 * @param connectionTimeout
	 * the new connection timeout
	 */
	public void setConnectionTimeout( int connectionTimeout ){
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * Gets the token.
	 * @return the token
	 */
	public AuthenticationToken getToken(){
		return token;
	}

	/**
	 * Sets the token.
	 * @param token
	 * the token
	 */
	public void setToken( AuthenticationToken token ){
		this.token = token;
	}

	/**
	 * Gets the headers.
	 * @return the headers
	 */
	public MultivaluedMap<String, Object> getHeaders(){
		return headers;
	}

	/**
	 * Sets the headers.
	 * @param headers
	 * the headers
	 */
	public void setHeaders( MultivaluedMap<String, Object> headers ){
		this.headers = headers;
	}

}
