package it.peruvianit.web.constant;

public class WebConstant	 {
	public static final String VERSION_WEB_API_REST = "v1";
	public static final String TYPE_EXCEPTION_APPLICATION = "Applicativa";
	public static final String TYPE_EXCEPTION_RESTFUL= "RESTFul";
	public static final String TYPE_EXCEPTION_UNKNOWN = "Sconosciuto, Non Gestito";
	
	public static final String PUBLIC_KEY_HEADER = "apiKey";
	public static final String SIGNATURE_HEADER = "token";
	public static final byte[] KEY_OAUTH_JWT = new byte[] { 112, 101, 114, 117, 118, 105, 110, 105, 116};
	public static final int EXPIRATION_TOKEN_SECONDS = 21600;
	
	public static final String SERVER_CONFIG_DIR = "jboss.server.config.dir";
	public static final String WEB_APLICATION_PROPERTIES = "jeeRestApi.properties";
	
	public static final String LOGIN_ACCESS_STATUS_SUCCESS = "S";
	public static final String LOGIN_ACCESS_STATUS_INCORRECT_CREDENTIAL = "I";	
}