
package it.peruvianit.ejb;

import javax.ejb.Local;

import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.exception.AuthenticationSecurityException;

@Local
public interface AuthenticationLocal {
	boolean doLogin(AccountDto accountDto) throws AuthenticationSecurityException;;
	TokenTransfer generateToken(UserDetails userDetails);
	String infoEJB();
}
