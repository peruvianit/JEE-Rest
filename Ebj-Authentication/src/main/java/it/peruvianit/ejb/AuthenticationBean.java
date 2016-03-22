package it.peruvianit.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import it.peruvanit.dto.UserDto;
import it.peruvianit.authenticator.BasicForm;
import it.peruvianit.authenticator.LDap;
import it.peruvianit.commons.util.DateUtils;
import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.TokenUtils;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.data.dao.Tbl1002LoginAccessDao;
import it.peruvianit.data.dao.Tbl1003RequestDao;
import it.peruvianit.data.dao.Tbl1004ErrorDao;
import it.peruvianit.data.dao.Tbl1005ClientAccessDao;
import it.peruvianit.data.exception.DataAccesException;
import it.peruvianit.data.repository.RepositoryPersistenceLocal;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.dto.ErrorRequestDto;
import it.peruvianit.dto.LoginAccessDto;
import it.peruvianit.dto.RequestDto;
import it.peruvianit.exception.AuthenticationSecurityException;
import it.peruvianit.interfaces.SecurityAuthenticator;
import it.peruvianit.invoke.Authenticator;
import it.peruvianit.model.entity.Tbl1002LoginAccess;
import it.peruvianit.model.entity.Tbl1003Request;
import it.peruvianit.model.entity.Tbl1004Error;
import it.peruvianit.model.entity.Tbl1005ClientAccess;

/**
 * Session Bean implementation class Authentication
 */
@Stateless
public class AuthenticationBean implements AuthenticationRemote, AuthenticationLocal {
	
	@EJB
	RepositoryPersistenceLocal repositoryPersistenceLocal;
	
    public AuthenticationBean() {    	
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
    
    public TokenTransfer generateToken(UserDetails userDetails, byte[] secret, int expirationTokenSeconds){    	
    	return new TokenTransfer(TokenUtils.createTokenJWT(userDetails, secret, expirationTokenSeconds));
    }

	@Override
	public void saveLoginAccess(LoginAccessDto loginAccessDto) throws AuthenticationSecurityException {
		Tbl1002LoginAccess tbl1002LoginAccess = new Tbl1002LoginAccess();
		tbl1002LoginAccess.setUserName(loginAccessDto.getUserDetails().getUsername());
		tbl1002LoginAccess.setToken(loginAccessDto.getToken());
		tbl1002LoginAccess.setIpAddress(loginAccessDto.getUserDetails().getIpAddress());
		tbl1002LoginAccess.setTypeAccess(loginAccessDto.getTypeAccess());
		tbl1002LoginAccess.setIdUserAgent(loginAccessDto.getUserDetails().getId());
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
		tbl1003Request.setUserName(requestDto.getUserName());
		tbl1003Request.setToken(requestDto.getRequestSignature());
		tbl1003Request.setIpAddressLocal(requestDto.getIpAddressLocale());
		tbl1003Request.setIpAddressRemote(requestDto.getIpAddressRemote());
		tbl1003Request.setRequestTime(requestDto.getStartRequest());
		tbl1003Request.setResponseTime(requestDto.getEndRequest());
		tbl1003Request.setElapsedTime(requestDto.getElapsedTime());
		tbl1003Request.setUriApiRest(requestDto.getReference());
		tbl1003Request.setVerbApiRest(requestDto.getMethod());
		tbl1003Request.setParamsQuery(requestDto.getParamsQuery());
		tbl1003Request.setAgentBrowser(requestDto.getAgent());
		tbl1003Request.setContentType(requestDto.getContentType());		
		tbl1003Request.setResponseCode(requestDto.getResponseCode());
		
		try {
			Tbl1003RequestDao.getInstance(repositoryPersistenceLocal.getEntityManager()).save(tbl1003Request);
		} catch (Exception e) {
			throw new AuthenticationSecurityException(e.getMessage());
		}		
	}

	@Override
	public AccountDto findByRequestSignature(String requestSignature) throws AuthenticationSecurityException {
		AccountDto accountDto = null;
		try {
			Tbl1002LoginAccess tbl1002LoginAccess = Tbl1002LoginAccessDao.getInstance(repositoryPersistenceLocal.getEntityManager()).findByRequestSignature(requestSignature);
			
			if(tbl1002LoginAccess != null){
				accountDto = new AccountDto();
				
				accountDto.setAccount(tbl1002LoginAccess.getUserName());
				accountDto.setExpirationDate(DateUtils.addSeconds(tbl1002LoginAccess.getLoginTime(),21600)); // TODO Da implementare tabella, Parametri Sistema 21600 = 6 Ore, 			
			}			
		} catch (Exception e) {
			throw new AuthenticationSecurityException(e.getMessage());
		}
		return accountDto;
	}

	@Override
	public void saveErrorRequest(ErrorRequestDto errorRequestDto) throws AuthenticationSecurityException {
		Tbl1004Error tbl1004Error = new Tbl1004Error();
		
		tbl1004Error.setIdentifierRequest(errorRequestDto.getIdentifier().toString());		
		tbl1004Error.setUserName(errorRequestDto.getUserName());
		tbl1004Error.setToken(errorRequestDto.getRequestSignature());
		tbl1004Error.setUriApiRest(errorRequestDto.getReference());
		tbl1004Error.setVerbApiRest(errorRequestDto.getMethod());
		tbl1004Error.setParamsQuery(errorRequestDto.getParamsQuery());
		tbl1004Error.setAgentBrowser(errorRequestDto.getAgent());
		tbl1004Error.setContentType(errorRequestDto.getContentType());		
		tbl1004Error.setResponseCode(errorRequestDto.getResponseCode());
		tbl1004Error.setTypeException(errorRequestDto.getType());
		tbl1004Error.setMessageException(errorRequestDto.getMessage());
		
		try {
			Tbl1004ErrorDao.getInstance(repositoryPersistenceLocal.getEntityManager()).save(tbl1004Error);
		} catch (Exception e) {
			throw new AuthenticationSecurityException(e.getMessage());
		}	
		
	}	
	
	@Override
	public boolean isNewClientAccess(LoginAccessDto loginAccessDto) throws AuthenticationSecurityException {
		boolean isNewClient = false;
		try {
			List<Tbl1002LoginAccess> listTbl1002LoginAccess = Tbl1002LoginAccessDao.getInstance(repositoryPersistenceLocal.getEntityManager()).findByIdUserAgent(loginAccessDto.getUserDetails().getId());
			
			if(listTbl1002LoginAccess.size() == 0){
				Tbl1005ClientAccess tbl1005ClientAccess = new Tbl1005ClientAccess();
				tbl1005ClientAccess.setIdUserAgent(loginAccessDto.getUserDetails().getId());
				tbl1005ClientAccess.setUserName(loginAccessDto.getUserDetails().getUsername());
				tbl1005ClientAccess.setIpAddress(loginAccessDto.getUserDetails().getIpAddress());
				tbl1005ClientAccess.setTypeAccess(loginAccessDto.getTypeAccess());
				tbl1005ClientAccess.setOs(loginAccessDto.getUserDetails().getNameOperatingSystem());
				tbl1005ClientAccess.setBrowser(loginAccessDto.getUserDetails().getBrowser());
				Tbl1005ClientAccessDao.getInstance(repositoryPersistenceLocal.getEntityManager()).save(tbl1005ClientAccess);
				isNewClient = true;
			}			
		} catch (Exception e) {
			throw new AuthenticationSecurityException(e.getMessage());
		}
		return isNewClient;
	}
}
