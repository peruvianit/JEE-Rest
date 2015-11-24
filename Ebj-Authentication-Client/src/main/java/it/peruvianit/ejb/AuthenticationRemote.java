package it.peruvianit.ejb;


import javax.ejb.Remote;

import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.UserDetails;

@Remote
public interface AuthenticationRemote {
	TokenTransfer generateToken(UserDetails userDetails);
	String infoEJB();
}
