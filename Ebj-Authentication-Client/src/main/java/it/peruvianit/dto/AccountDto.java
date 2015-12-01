package it.peruvianit.dto;

import java.io.Serializable;

import it.peruvianit.enums.TypeAccessAccount;

public class AccountDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6278011650854233265L;
	
	private String account;
	private String password;
	private TypeAccessAccount typeAccessAccount;
	
	public AccountDto() {}

	public AccountDto(String account, String password , TypeAccessAccount typeAccessAccount) {
		super();
		this.account = account;
		this.password = password;
		this.typeAccessAccount = typeAccessAccount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypeAccessAccount getTypeAccessAccount() {
		return typeAccessAccount;
	}

	public void setTypeAccessAccount(TypeAccessAccount typeAccessAccount) {
		this.typeAccessAccount = typeAccessAccount;
	}
}
