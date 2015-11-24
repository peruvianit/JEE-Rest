package it.peruvianit.web.util;

import javax.servlet.http.HttpServletRequest;

import it.peruvianit.commons.util.token.UserDetails;

public class RequestUtil {
	public static UserDetails getUserDetails(HttpServletRequest requestContext){
		String ipAddress = requestContext.getRemoteAddr();
		String userRemote = "";
		String macAddress = "";
		UserDetails userDetails = new UserDetails();
		userDetails.setIpAddress(ipAddress);
		userDetails.setMacAddress(macAddress);
		userDetails.setUsername(userRemote);
		return userDetails;
	}
}
