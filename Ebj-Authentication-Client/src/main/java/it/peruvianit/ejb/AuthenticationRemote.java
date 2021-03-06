package it.peruvianit.ejb;


import javax.ejb.Remote;

import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.dto.ErrorRequestDto;
import it.peruvianit.dto.LoginAccessDto;
import it.peruvianit.dto.RequestDto;
import it.peruvianit.exception.AuthenticationSecurityException;

@Remote
public interface AuthenticationRemote {
	AccountDto doLogin(AccountDto accountDto) throws AuthenticationSecurityException, Exception;
	TokenTransfer generateToken(UserDetails userDetails, byte[] secret, int expirationTokenSeconds);
	void saveLoginAccess(LoginAccessDto loginAccessDto) throws AuthenticationSecurityException;
	void saveRequest(RequestDto requestDto) throws AuthenticationSecurityException;
	AccountDto findByRequestSignature(String requestSignature) throws AuthenticationSecurityException;
	void saveErrorRequest(ErrorRequestDto errorRequestDto) throws AuthenticationSecurityException;
	boolean isNewClientAccess(LoginAccessDto loginAccessDto) throws AuthenticationSecurityException;
}
