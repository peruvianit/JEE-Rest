package it.peruvianit.web.resource.service;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import it.peruvanit.exception.RecordNotFoundException;
import it.peruvianit.commons.annotation.resource.ServiceIdentifier;
import it.peruvianit.commons.annotation.resource.TypeAccessService;
import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.data.repository.RepositoryPersistenceLocal;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.dto.LoginAccessDto;
import it.peruvianit.ejb.AuthenticationLocal;
import it.peruvianit.exception.AuthenticationSecurityException;
import it.peruvianit.exception.IncorrectCredentialsException;
import it.peruvianit.exception.SaveLoginAccessException;
import it.peruvianit.web.constant.WebConstant;
import it.peruvianit.web.exception.WebApplicationException;
import it.peruvianit.web.resource.base.AbstractResource;
import it.peruvianit.web.util.RequestUtil;
 
@Path("/user")
public class AuthenticationService extends AbstractResource {	
	@EJB
	AuthenticationLocal authenticationLocal;
	
	@EJB
	RepositoryPersistenceLocal repositoryPersistenceLocal;
	
	@ServiceIdentifier(identifier = 100, typeAccessService = TypeAccessService.PUBLIC)
	@Path("authenticate")
	@POST	
	@Produces(MediaType.APPLICATION_JSON)	
	public TokenTransfer authenticate(@NotNull AccountDto accountDtoRequest,
									  @Context HttpServletRequest requestContext) throws WebApplicationException, AuthenticationSecurityException, Exception {
		LoginAccessDto loginAccessDto = new LoginAccessDto();
		UserDetails userDetails = null;
		TokenTransfer tokenTransfer = null;
		
		try{
			userDetails = RequestUtil.getUserDetails(requestContext);			
			userDetails.setUsername(accountDtoRequest.getAccount());
			
			AccountDto accountDto = authenticationLocal.doLogin(accountDtoRequest);
			if ( accountDto == null){
				throw new WebApplicationException("Accesso denegato");
			}
			
			tokenTransfer = authenticationLocal.generateToken(userDetails, WebConstant.KEY_OAUTH_JWT, WebConstant.EXPIRATION_TOKEN_SECONDS);
			
			loginAccessDto.setAccessStatus(WebConstant.LOGIN_ACCESS_STATUS_SUCCESS);
			
			if (tokenTransfer != null){
				loginAccessDto.setToken(tokenTransfer.getToken());
			}			
		}catch(IncorrectCredentialsException | RecordNotFoundException iEx){
			loginAccessDto.setAccessStatus(WebConstant.LOGIN_ACCESS_STATUS_INCORRECT_CREDENTIAL);
			throw iEx;
		}
		finally {
			try{
				loginAccessDto.setUserDetails(userDetails);
				loginAccessDto.setTypeAccess(accountDtoRequest.getTypeAccessAccount().toString());
				
				authenticationLocal.saveLoginAccess(loginAccessDto);			
			}catch(Exception ex){			
				throw new SaveLoginAccessException(ex.getMessage());
			}			
		}
		
		return tokenTransfer;
	}
}