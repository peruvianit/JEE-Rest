package it.peruvianit.authenticator;

import it.peruvianit.dto.AccountDto;
import it.peruvianit.interfaces.SecurityAuthenticator;

public final class LDap extends Account implements SecurityAuthenticator{
	public LDap(AccountDto accountDto) {
		super(accountDto);
	}

	@Override
	public boolean doAuthentication(){
		// Implementazione Active Directory
		return true;
	}
}
