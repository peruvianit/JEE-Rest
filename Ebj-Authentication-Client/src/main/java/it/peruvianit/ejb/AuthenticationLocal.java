
package it.peruvianit.ejb;

import javax.ejb.Local;

import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.UserDetails;

@Local
public interface AuthenticationLocal {
	TokenTransfer generateToken(UserDetails userDetails);
	String infoEJB();
}
