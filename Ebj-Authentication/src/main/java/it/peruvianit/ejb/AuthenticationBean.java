package it.peruvianit.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import it.peruvanit.dto.UserDto;
import it.peruvianit.authenticator.BasicForm;
import it.peruvianit.authenticator.LDap;
import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.TokenUtils;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.data.dao.Tbl1002LoginAccessDao;
import it.peruvianit.data.dao.Tbl1003RequestDao;
import it.peruvianit.data.exception.DataAccesException;
import it.peruvianit.data.repository.RepositoryPersistenceLocal;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.dto.LoginAccessDto;
import it.peruvianit.dto.RequestDto;
import it.peruvianit.exception.AuthenticationSecurityException;
import it.peruvianit.interfaces.SecurityAuthenticator;
import it.peruvianit.invoke.Authenticator;
import it.peruvianit.model.entity.Tbl1002LoginAccess;
import it.peruvianit.model.entity.Tbl1003Request;

/**
 * Session Bean implementation class Authentication
 */
@Stateless
public class AuthenticationBean implements AuthenticationRemote, AuthenticationLocal {
	
	@EJB
	RepositoryPersistenceLocal repositoryPersistenceLocal;
	
    public AuthenticationBean() {
        // TODO Auto-generated constructor stub
    }
    
    public AccountDto doLogin(AccountDto accountDto) throws AuthenticationSecurityException, Exception{
    	AccountDto accountDtoResponse = null;
    	SecurityAuthenticator securityAuthenticator = null;
    	
    	switch (accountDto.getTypeAccessAccount()) {
			case BASIC_FORM:
				securityAuthenticator = new BasicForm(accountDto);
				break;
			case LDAP:
				securityAuthenticator = new LDap(accountDto);
				break;	
			default:
				break;
		}
    	
    	UserDto userDto = Authenticator.doLogin(securityAuthenticator);
    	
    	if (userDto != null){
    		accountDtoResponse = new AccountDto();
    		accountDtoResponse.setAccount(userDto.getUsername());
    		accountDtoResponse.setName(userDto.getName());
    		accountDtoResponse.setLastName(userDto.getLastName());
    		accountDtoResponse.setAccount(userDto.getUsername());
    	}
    	
    	return accountDtoResponse;
    }
    
    public TokenTransfer generateToken(UserDetails userDetails){    	
    	return new TokenTransfer(TokenUtils.createToken(userDetails));
    }

	@Override
	public void saveLoginAccess(LoginAccessDto loginAccessDto) throws AuthenticationSecurityException {
		Tbl1002LoginAccess tbl1002LoginAccess = new Tbl1002LoginAccess();
		tbl1002LoginAccess.setUserName(loginAccessDto.getUserDetails().getUsername());
		tbl1002LoginAccess.setToken(loginAccessDto.getToken());
		tbl1002LoginAccess.setIpAddress(loginAccessDto.getUserDetails().getIpAddress());
		tbl1002LoginAccess.setTypeAccess(loginAccessDto.getTypeAccess());
		tbl1002LoginAccess.setBrowser(loginAccessDto.getUserDetails().getBrowser());
		tbl1002LoginAccess.setOs(loginAccessDto.getUserDetails().getNameOperatingSystem());
		tbl1002LoginAccess.setStatus(loginAccessDto.getAccessStatus());
		
		try {
			Tbl1002LoginAccessDao.getInstance(repositoryPersistenceLocal.getEntityManager()).save(tbl1002LoginAccess);
		} catch (DataAccesException e) {
			throw new AuthenticationSecurityException(e.getMessage());
		}		
	}

	@Override
	public void saveRequest(RequestDto requestDto) throws AuthenticationSecurityException {
		Tbl1003Request tbl1003Request = new Tbl1003Request();
		
		tbl1003Request.setIdentifierRequest(requestDto.getIdentifier().toString());
		tbl1003Request.setUserName("--MANCANTE--");
		tbl1003Request.setToken("--MANCANTE--");
		tbl1003Request.setIpAddressLocal(requestDto.getIpAddressLocale());
		tbl1003Request.setIpAddressRemote(requestDto.getIpAddressRemote());
		tbl1003Request.setRequestTime(requestDto.getStartRequest());
		tbl1003Request.setResponseTime(requestDto.getEndRequest());
		tbl1003Request.setElapsedTime(requestDto.getElapsedTime());
		tbl1003Request.setUriApiRest(requestDto.getReference());
		tbl1003Request.setVerbApiRest(requestDto.getMethod());
		tbl1003Request.setPayloadBody("--MANCANTE--");
		tbl1003Request.setAgentBrowser(requestDto.getAgent());
		tbl1003Request.setContentType(requestDto.getContentType());		
		tbl1003Request.setResponseCode(requestDto.getResponseCode());
		
		try {
			Tbl1003RequestDao.getInstance(repositoryPersistenceLocal.getEntityManager()).save(tbl1003Request);
		} catch (Exception e) {
			throw new AuthenticationSecurityException(e.getMessage());
		}
		
	}	
}
