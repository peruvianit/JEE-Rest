package it.peruvianit.interfaces;

import it.peruvianit.exception.AuthenticationSecurityException;

public interface SecurityAuthenticator {	
	boolean doAuthentication() throws AuthenticationSecurityException;
}
