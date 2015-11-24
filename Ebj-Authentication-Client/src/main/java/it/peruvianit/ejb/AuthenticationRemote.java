package it.peruvianit.ejb;


import javax.ejb.Remote;

import it.peruvianit.util.token.TokenTransfer;
import it.peruvianit.util.token.UserDetails;

@Remote
public interface AuthenticationRemote {
	TokenTransfer generateToken(UserDetails userDetails);
	String infoEJB();
}
