package it.peruvianit.invoke;

import it.peruvianit.exception.AuthenticationSecurityException;
import it.peruvianit.interfaces.SecurityAuthenticator;

public class Authenticator {
	public Authenticator(){};
	
	public static boolean doLogin(SecurityAuthenticator securityAuthenticator) throws AuthenticationSecurityException{
		return securityAuthenticator.doAuthentication();
	}	
}
