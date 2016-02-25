package it.peruvianit.web.util;

import javax.servlet.http.HttpServletRequest;

import eu.bitwalker.useragentutils.UserAgent;
import it.peruvianit.commons.util.token.UserDetails;

public class RequestUtil {
	public static UserDetails getUserDetails(HttpServletRequest requestContext){
		UserAgent userAgent = UserAgent.parseUserAgentString(requestContext.getHeader("User-Agent"));
		
		// INFO MACCHINE
		String ipAddress = requestContext.getRemoteAddr();
		String userRemote = "";
		String macAddress = "";
		
		// INFO BROWSER
		String browser = userAgent.getBrowser().getName();
		String browserType = userAgent.getBrowser().getBrowserType().getName();
		String browserVersion = userAgent.getBrowserVersion().getVersion();
		String nameOperatingSystem = userAgent.getOperatingSystem().getName();
		String deviceType = userAgent.getOperatingSystem().getDeviceType().getName();
		String manufacter = userAgent.getOperatingSystem().getManufacturer().getName();
		
		UserDetails userDetails = new UserDetails();
		userDetails.setIpAddress(ipAddress);
		userDetails.setMacAddress(macAddress);
		userDetails.setUsername(userRemote);
		userDetails.setBrowser(browser);
		userDetails.setBrowserType(browserType);
		userDetails.setBrowserVersion(browserVersion);
		userDetails.setNameOperatingSystem(nameOperatingSystem);
		userDetails.setDeviceType(deviceType);
		userDetails.setManufacter(manufacter);
		
		return userDetails;
	}
}
