package it.peruvianit.ejb;


import javax.ejb.Remote;

@Remote
public interface AuthenticationRemote {
	String infoEJB();
}
