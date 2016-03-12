package it.peruvianit.web.messages;

import org.apache.log4j.Logger;

import it.peruvianit.commons.exception.CommonsException;
import it.peruvianit.commons.property.WebApplicationProperties;
import it.peruvianit.web.constant.WebConstant;
import it.peruvianit.web.exception.WebApplicationException;

public class SmtpEmail {
	private static Logger logger = Logger.getLogger(SmtpEmail.class);
	
	private static String host;
	private static Integer port;
	private static String username;
	private static String password;
	
	public static void sendMessage(){
		// TODO Implementazione invio Email
	}
	
	static {
		WebApplicationProperties webApplicationProperties = new WebApplicationProperties(WebConstant.SERVER_CONFIG_DIR,WebConstant.WEB_APLICATION_PROPERTIES);
		
		try {
			SmtpEmail.host = webApplicationProperties.getProperty("mail.smtp.host");
			SmtpEmail.port = new Integer(webApplicationProperties.getProperty("mail.smtp.port"));
			SmtpEmail.username = webApplicationProperties.getProperty("mail.smtp.username");
			SmtpEmail.password = webApplicationProperties.getProperty("mail.smtp.password");
		} catch (CommonsException e) {
			new WebApplicationException(e.getMessage());
		}		
	}
}
