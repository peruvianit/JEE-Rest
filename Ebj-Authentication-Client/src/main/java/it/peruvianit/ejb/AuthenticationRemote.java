package it.peruvianit.ejb;


import javax.ejb.Remote;

import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.dto.AccountDto;

@Remote
public interface AuthenticationRemote {
	boolean doLogin(AccountDto accountDto);
	TokenTransfer generateToken(UserDetails userDetails);
	String infoEJB();
}
