package pe.com.claro.common.property;

public class Constantes {
	
	// ---------------- GENERAL ----------------
	public static final String PERSISTENCE_CONTEXT					= "pe.com.claro.postventa.dinamico";
    public static final String NOMBRE_API 							= "claro-postventa-dinamico";
    public static final String API									= "api";
    public static final String PARENTESIS_INI 						= "(";
    public static final String PARENTESIS_FIN		 				= ")";
    public static final String CHAR_INTERROGACION 					= "?";
    public static final String CHAR_COMA 							= ",";
    public static final String OK 									= "OK";
    public static final String ERROR 								= "ERROR";
	public static final String CORCHETE_INI							= "[";
	public static final String CORCHETE_FIN							= "]";
	public static final String IGUAL								= "=";
	public static final String SALTO_LINEA							= "\n";
	public static final String TABULAR								= "\t";
	public static final String COMA									=",";
	public static final String PUNTO								=".";
	public static final String DOS_PUNTO							=":";
	public static final String GUION								="-";
	public static final String ESPACIO								=" ";
	public static final String PEPELINE								="\\|";
	public static final String ASTERISCOS							="*********";
	public static final String	PROPERTIES_EXTERNOS					= ".properties";
	public static final String	PROPERTIES_KEY						= "claro.properties";

	// ---------------- OTROS ----------------
	public static final String	PROCESO_COMODIN						= "Proceso Comodín 0";
	public static final String	SI									= "SI";
	public static final boolean	TRUE								= true;
	public static final boolean	FALSE								= false;
	public static final String	STATUS_CODE							= "response.header.statusCode";
	public static final String SALTO_LINEA_DOBLE					= "\\n";
	public static final String DOBLE_COMILLA						= "\\\"";
	public static final String COD_RESP								= "{CodResp}";
	public static final String MSJ_RESP								= "{MsjResp}";
	public static final String REQUEST_HEADER						= "request.header";
	public static final String REQUEST_BODY							= "request.body";
	public static final String RESPONSE_HEADER						= "response.header";
	public static final String RESPONSE_BODY						= "response.body";
	public static final String REQUEST_URL							= "request.url";
	public static final String DOLAR								= "$";
	public static final String PUNTO_CARACTER						= "\\.";
	
	
	 /// **** ENCODING
    public static final String defaulEncodingProperties 			= "ISO-8859-1";
    public static final String defaulEncodingApi 					= "UTF-8";
	
	public static final String TEXTO_VACIO 							= "";
	public static final String REL_NEXT								="next";
	public static final String ACTIVO								="A";
	
	public static final String LETRAH								= "H";
	public static final String DOBLEH								= "HH";
	public static final String LETRAM								= "m";
	public static final String DOBLEM								= "mm";
	
	public static final String DD_MM_YYYY 							= "dd/MM/yyyy";
	public static final String FORMATO_FECHA_DEFAULT 				= "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_FECHA_DEFAULT2				= "yyyy-MM-dd";
	public static final String FORMATO_FECHA_DEFAULT3				= "yyyy-MM-dd hh:mm:ss aa";
	public static final String FORMATO_FECHA_iso8601 				= "yyyy-MM-dd'T'HH:mm:ss";
	public static final String FORMATO_FECHA_DEFAULT4 				= "yyyy-MM-dd HH:mm:ss";
	public static final Object NULO									= null;
	
	public final static String NUM_CERO								= "0";
	public final static String NUM_UNO								= "1";
	public final static String NUM_DOS								= "2";
	public final static String NUM_TRES								= "3";
	public final static String NUM_CUATRO						    = "4";
	
	public final static int MENOS_UNO								= -1;
	public final static int CERO									= 0;
	public final static int UNO										= 1;
	public final static int DOS										= 2;
	public final static int TRES									= 3;
	public final static int CUATRO									= 4;
	public final static int CINCO									= 5;
	public final static int SEIS									= 6;
	public static final int SIETE                                   = 7;
	public final static int OCHO									= 8;
	public final static int NUEVE									= 9;
	public static final int DIEZ									= 10;
	public static final int ONCE									= 11;
	public static final int DOCE									= 12;
	public static final int TRECE									= 13;
	public static final int CATORCE									= 14;
	public static final int QUINCE									= 15;
	public static final int DIECISEIS								= 16;
	public static final int DIECISIETE								= 17;
	public static final int DIECIOCHO								= 18;
	public static final int DIECINUEVE								= 19;
	
	public static final int VEINTE									= 20;
	public static final int VEINTICUATRO							= 24;
	public static final int CIEN									= 100;
	public static final int SESENTA									= 60;
	public static final int TRESMILSEISCIENTOS						= 3600;
	
	public static final String SQLTIMEOUTEXCEP						= "SQLTimeoutException";
	public static final String SOCKETTIMEOUTEXCEP 					= "SocketTimeoutException";
	public static final String REMOTEACCESSEXCEP 					= "RemoteAccessException";
	public static final String WEBSERVICEEXCEP 						= "WebServiceException";
	public static final String CONNECTEXCEP 						= "ConnectException";
	public static final String TIMEOUTEXCEPTION 					= "Timeout";
	public static final String TIMEOUTEXCEPTION2 					= "Timed out";
	public static final String TIMEOUTEXCEPTION3 					= "TIME OUT";
	
	public static final String ERROR_TIMEOUT 						= "-1111";
	public static final String ERROR_NO_CONEXION 					= "-222";
	public static final String ERROR_DISPONIBILIDAD					= "-333";
	public static final String ERROR_GENERAL 						= "-444";
	public final static int STATUS_TIME_OUT 						= 504;
	public final static int STATUS_DISPONIBILIDAD 					= 404;
	
	public static final String PERSISTENCEEXCEPTION					= "javax.persistence.PersistenceException";
	public static final String GENERICJDBCEXCEPTION					= "org.hibernate.exception";
	public static final String HIBERNATEJDBCEXCEPTION 				= "The application must supply JDBC connections";
	public static final String CLASSTIMEOUTCONNECTION 				= "com.sun.xml.ws.connect.timeout";
    public static final String CLASSTIMEOUTREQUEST 					= "com.sun.xml.ws.request.timeout";
	
    // ---------------- Parametros de Auditoria - Header Request Transport ----------------
	public static final String ACCEPT 								= "accept";
	public static final String IDTRANSACCION 						= "idTransaccion";
	public static final String MSGID 								= "msgid";
	public static final String TIMESTAMP 							= "timestamp";
	public static final String USERID 								= "userId";
	
	// ----------------- GENERAL: PARAMETROS -----------------
	public static final String MENSAJEOK 							= "OK";
	public static final String MENSAJE_ERROR_NULO					= "nulo";
	public static final String MENSAJE_ERROR_VACIO					= "vacio";
	public static final String DOBLE_LLAVE							= "{}";
	public static final String DOBLE_CORCHETE 						= "[]";
	
	public static final String METHOD_POST							= "POST";
	public static final String METHOD_GET							= "GET";
	public static final String METHOD_PUT							= "PUT";
	public static final String METHOD_DELETE						= "DELETE";
	public static final String METHOD_HEAD							= "HEAD";
	public static final String CONTENT_TYPE							= "Content-Type";
	public static final String CONTENT_TYPE_VALOR					= "application/json;charset=utf-8";
	public static final String DEFAULT_ENCODING_API					= "UTF-8";
	public static final String VACIO="";
	public static final String HTTP_CLIENT_ERROR_EXCEPTION 			= "404 Not Found";
	
	public static final int	CODIGO_200								= 200;
	public static final String	MENSAJE_200							= "OK";
	public static final int	CODIGO_201								= 201;
	public static final String	MENSAJE_201							= "CREADO";
	public static final int	CODIGO_202								= 202;
	public static final String	MENSAJE_202							= "ACEPTADO";
	public static final int	CODIGO_204								= 204;
	public static final String	MENSAJE_204							= "SIN CONTENIDO";
	public static final int	CODIGO_205								= 205;
	public static final String	MENSAJE_205							= "SIN CONTENIDO, INICIALIZAR PAGINA";
	
	public static final int	CODIGO_400								= 400;
	public static final String	MENSAJE_400							= "PETICION INCORRECTA";
	public static final int	CODIGO_401								= 401;
	public static final String	MENSAJE_401							= "NO AUTORIZADO";
	public static final int	CODIGO_402								= 402;
	public static final String	MENSAJE_402							= "ERROR DE SOLICITUD";
	public static final int	CODIGO_404								= 404;
	public static final String	MENSAJE_404							= "NO ENCONTRADO";
	public static final int	CODIGO_405								= 405;
	public static final String	MENSAJE_405							= "METODO NO PERMITIDO";
	public static final int	CODIGO_406								= 406;
	public static final String	MENSAJE_406							= "INACEPTABLE";
	public static final int	CODIGO_409								= 409;
	public static final String	MENSAJE_409							= "CONFLICTO";
	public static final int	CODIGO_415								= 415;
	public static final String	MENSAJE_415							= "TIPO DE MEDIOS NO SOPORTADOS";
	public static final int	CODIGO_429								= 429;
	public static final String	MENSAJE_429							= "DEMASIADAS SOLICITUDES";
	public static final int	CODIGO_500 								= 500;
	public static final String	MENSAJE_500							= "ERROR EN LOS SERVIDORES";
	public static final int	CODIGO_502								= 502;
	public static final String	MENSAJE_502							= "MALA PUERTA DE ENLACE";
	public static final int	CODIGO_503								= 503;
	public static final String	MENSAJE_503							= "SERVICIO NO DISPONIBLE";
	public static final int	CODIGO_504								= 504;
	public static final String	MENSAJE_504							= "SE ACABO EL TIEMPO EN EL LA PUERTA DE ENLACE";
	
	public static final String ERROR_API_CONNECTION 				= "-111";
	public static final String ERROR_API_GENERAL 					= "-222";
	public static final String PORTABILIDAD_SI = "SI";
	public static final String PORTABILIDAD_NO = "NO";
	public static final String OPERACION_ORDENES_TRABAJO = "consultarOrdenesTrabajo";
	public static final String AUTHORIZATION = "Authorization";
	public static final String ACCESSTOKEN = "access_token";
	public static final String OPERACION_GEN_TOKEN = "generarToken";
	
	public static final String BASIC = "Basic ";
	public static final String RETORNO_CARRO = "\r";
	public static final String COMILLA = "\"";

	
}
