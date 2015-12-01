package it.peruvianit.web.resource.service;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import it.peruvianit.commons.annotation.resource.ServiceIdentifier;
import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.ejb.AuthenticationLocal;
import it.peruvianit.web.exception.WebApplicationException;
import it.peruvianit.web.resource.base.AbstractResource;
import it.peruvianit.web.util.RequestUtil;
 
@Path("/user")
public class AuthenticationService extends AbstractResource {	
	@EJB
	AuthenticationLocal authenticationLocal;
	
	@ServiceIdentifier(identifier = 1)
	@Path("authenticate")
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	public TokenTransfer authenticate(@NotNull AccountDto accountDto,
									  @Context HttpServletRequest requestContext) throws WebApplicationException {
		if (!authenticationLocal.doLogin(accountDto)){
			throw new WebApplicationException("Accesso denegato");
		}
		
		UserDetails userDetails = RequestUtil.getUserDetails(requestContext);
		
		return authenticationLocal.generateToken(userDetails);
	}
}