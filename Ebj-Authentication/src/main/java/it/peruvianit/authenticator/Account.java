package it.peruvianit.authenticator;

import it.peruvianit.dto.AccountDto;

public class Account{
	protected AccountDto accountDto;
	
	public Account(AccountDto accountDto) {
		this.accountDto = accountDto;
	}
	
	// Getters and Setters
	
	public AccountDto getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDto accountDto) {
		this.accountDto = accountDto;
	}
}
