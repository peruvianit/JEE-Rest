package it.peruvianit.interfaces;

import it.peruvanit.dto.UserDto;
import it.peruvianit.exception.AuthenticationSecurityException;

public interface SecurityAuthenticator {	
	UserDto doAuthentication() throws AuthenticationSecurityException, Exception;
}
