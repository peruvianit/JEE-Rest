package it.peruvianit.invoke;

import it.peruvianit.interfaces.SecurityAuthenticator;

public class Authenticator {
	public Authenticator(){};
	
	public static boolean doLogin(SecurityAuthenticator securityAuthenticator){
		return securityAuthenticator.doAuthentication();
	}	
}
