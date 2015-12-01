package it.peruvianit.authenticator;

import it.peruvianit.dto.AccountDto;
import it.peruvianit.interfaces.SecurityAuthenticator;

public final class BasicForm extends Account implements SecurityAuthenticator{
	public BasicForm(AccountDto accountDto) {
		super(accountDto);
	}

	@Override
	public boolean doAuthentication(){
		// Implementazione login estandar
		return false;
	}
}
