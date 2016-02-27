package it.peruvianit.dto;

import java.io.Serializable;

import it.peruvianit.commons.util.token.UserDetails;

public class LoginAccessDto implements Serializable{
	private static final long serialVersionUID = 5376058694155071603L;

	UserDetails userDetails;
	String typeAccess;
	String accessStatus;
	String token;
	
	public LoginAccessDto(){}
	
	public LoginAccessDto(UserDetails userDetails, String typeAccess) {
		super();
		this.userDetails = userDetails;
		this.typeAccess = typeAccess;
	}
	
	public LoginAccessDto(UserDetails userDetails, String typeAccess, String accessStatus) {
		super();
		this.userDetails = userDetails;
		this.typeAccess = typeAccess;
		this.accessStatus = accessStatus;
	}
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public String getTypeAccess() {
		return typeAccess;
	}
	public void setTypeAccess(String typeAccess) {
		this.typeAccess = typeAccess;
	}
	public String getAccessStatus() {
		return accessStatus;
	}
	public void setAccessStatus(String accessStatus) {
		this.accessStatus = accessStatus;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}	
}
