package it.peruvianit.web.messages;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import it.peruvianit.commons.exception.CommonsException;
import it.peruvianit.commons.property.WebApplicationProperties;
import it.peruvianit.web.bean.BeanMessageEmail;
import it.peruvianit.web.constant.WebConstant;
import it.peruvianit.web.exception.WebApplicationException;

public class SmtpEmail {
	private static Logger logger = Logger.getLogger(SmtpEmail.class);
	
	private static String hostName;
	private static Integer port;
	private static String username;
	private static String password;
	private static String from;
	
	public static void sendMessage(BeanMessageEmail beanMessageEmail) throws WebApplicationException{	
		String templateEmail = beanMessageEmail.getTemplateEmail();
		HtmlEmail email = new HtmlEmail();
		
		email.setHostName(SmtpEmail.hostName);
		email.setSmtpPort(SmtpEmail.port);
		email.setAuthenticator(new DefaultAuthenticator(SmtpEmail.username, SmtpEmail.password));
		email.setSSLOnConnect(true);
		
		try {			
			String serverConfigDir = System.getProperty(WebConstant.SERVER_CONFIG_DIR);
			
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);			
			cfg.setDirectoryForTemplateLoading(new File(serverConfigDir));			
			Template template = cfg.getTemplate(templateEmail);
			
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
       
	        Writer out = new StringWriter();
	        template.process(beanMessageEmail.getMsg(), out);
			
			email.setFrom(SmtpEmail.from);		
			email.setSubject(beanMessageEmail.getSubject());
			email.setHtmlMsg(out.toString());
			email.addTo(from);
			email.send();
			
		} catch (EmailException e) {
			logger.error(e.getMessage());
			throw new WebApplicationException("Invio email non riuscito, controllare parametri del Sistema");
		} catch (IOException ioEx) {
			logger.error(ioEx.getMessage());
			throw new WebApplicationException("Problemi con la apertura del file : {name : " + templateEmail + "}");
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static {
		WebApplicationProperties webApplicationProperties = new WebApplicationProperties(WebConstant.SERVER_CONFIG_DIR,WebConstant.WEB_APLICATION_PROPERTIES);
		
		try {
			SmtpEmail.hostName = webApplicationProperties.getProperty("mail.smtp.hostName");
			SmtpEmail.port = new Integer(webApplicationProperties.getProperty("mail.smtp.port"));
			SmtpEmail.username = webApplicationProperties.getProperty("mail.smtp.username");
			SmtpEmail.password = webApplicationProperties.getProperty("mail.smtp.password");
			SmtpEmail.from = webApplicationProperties.getProperty("mail.from.support.default");
		} catch (CommonsException e) {
			new WebApplicationException(e.getMessage());
		}		
	}
}
