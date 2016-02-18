package it.peruvianit.authenticator;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.peruvanit.dto.UserDto;
import it.peruvanit.ejb.AdministrationLocal;
import it.peruvanit.exception.EjbAdministrationException;
import it.peruvianit.constant.AuthenticationConstant;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.exception.AuthenticationSecurityException;
import it.peruvianit.interfaces.SecurityAuthenticator;

public final class BasicForm extends Account implements SecurityAuthenticator{
	
	public BasicForm(AccountDto accountDto) {
		super(accountDto);
	}
	
	@Override
	public boolean doAuthentication() throws AuthenticationSecurityException{		
		try {
			AdministrationLocal administrationLocal = (AdministrationLocal) InitialContext.doLookup(AuthenticationConstant.ADMINISTRATION_LOCAL_EJB_JNDI);
			
			UserDto userDto = new UserDto();			
			userDto.setUsername(accountDto.getAccount());
			userDto.setUsername(accountDto.getPassword());
			
			return administrationLocal.authentication(userDto);
			
		} catch (NamingException | EjbAdministrationException e) {
			throw new AuthenticationSecurityException(e.getMessage());
		}
	}
}
