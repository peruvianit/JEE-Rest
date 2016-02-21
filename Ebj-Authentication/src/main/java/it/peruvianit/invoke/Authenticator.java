package it.peruvianit.invoke;

import it.peruvanit.dto.UserDto;
import it.peruvianit.exception.AuthenticationSecurityException;
import it.peruvianit.interfaces.SecurityAuthenticator;

public class Authenticator {
	public Authenticator(){};
	
	public static UserDto doLogin(SecurityAuthenticator securityAuthenticator) throws AuthenticationSecurityException, Exception{
		return securityAuthenticator.doAuthentication();
	}	
}
