package it.peruvianit.commons.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import it.peruvianit.commons.exception.CommonsException;

public class WebApplicationProperties {
	private static Logger logger = Logger.getLogger(WebApplicationProperties.class);
	
	private String serverConfigDir;
	private String webApplicationProperties;
	
	private Properties properties;
	
	public WebApplicationProperties(String serverConfigDir,String webApplicationProperties){
		this.serverConfigDir = serverConfigDir;
		this.webApplicationProperties = webApplicationProperties;
	}
	
	public String getProperty(String keyPropertie) throws CommonsException{
		if (properties == null){
			this.init();
		}
		return properties.getProperty(keyPropertie);
	}
	
	public void init() throws CommonsException {
		try {
			properties = new Properties();

			InputStream stream = WebApplicationProperties.class.getResourceAsStream(this.webApplicationProperties);
			
			if (stream != null) {
				properties.load(stream);
				stream.close();
			}
			
			String configDir = System.getProperty(this.serverConfigDir);

			if (configDir != null) {
				String pathFile = configDir + "/" + this.webApplicationProperties;
				File file = new File(pathFile);

				try{
					properties.load(new FileInputStream(file));					
				} catch(Exception e) {
					logger.warn("file " + this.webApplicationProperties + " non trovato in: /" + pathFile);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new CommonsException(e.getMessage());
		}
	}
}
