package it.peruvianit.authenticator;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.peruvanit.dto.UserDto;
import it.peruvanit.ejb.AdministrationLocal;
import it.peruvanit.exception.EjbAdministrationException;
import it.peruvianit.commons.cryptography.EncryptorAdapter;
import it.peruvianit.constant.AuthenticationConstant;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.exception.AuthenticationSecurityException;
import it.peruvianit.exception.IncorrectCredentialsException;
import it.peruvianit.interfaces.SecurityAuthenticator;

public final class BasicForm extends Account implements SecurityAuthenticator{
	
	public BasicForm(AccountDto accountDto) {
		super(accountDto);
	}
	
	@Override
	public UserDto doAuthentication() throws AuthenticationSecurityException, Exception{		
		try {
			EncryptorAdapter encryptorAdapter = new EncryptorAdapter();
			AdministrationLocal administrationLocal = (AdministrationLocal) InitialContext.doLookup(AuthenticationConstant.ADMINISTRATION_LOCAL_EJB_JNDI);
				
			UserDto userDto = administrationLocal.authentication(accountDto.getAccount());
			
			if (userDto != null){
				if (!encryptorAdapter.decrypt(accountDto.getPassword(), userDto.getPassword())){
					throw new IncorrectCredentialsException("Incorrect Credentials Exception {userName : '" + accountDto.getAccount() + "'}");
				}
			}
			
			return userDto;
			
		} catch (NamingException | EjbAdministrationException e) {
			throw new AuthenticationSecurityException(e.getMessage());
		}
	}
}
