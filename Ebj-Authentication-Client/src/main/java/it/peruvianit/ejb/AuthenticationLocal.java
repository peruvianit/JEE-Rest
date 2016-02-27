
package it.peruvianit.ejb;

import javax.ejb.Local;

import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.dto.LoginAccessDto;
import it.peruvianit.exception.AuthenticationSecurityException;

@Local
public interface AuthenticationLocal {
	AccountDto doLogin(AccountDto accountDto) throws AuthenticationSecurityException, Exception;	
	TokenTransfer generateToken(UserDetails userDetails);
	void saveLoginAccess(LoginAccessDto loginAccessDto) throws Exception;
}
