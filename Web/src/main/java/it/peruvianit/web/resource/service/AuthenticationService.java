package it.peruvianit.web.resource.service;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import it.peruvianit.commons.util.token.TokenTransfer;
import it.peruvianit.commons.util.token.UserDetails;
import it.peruvianit.ejb.AuthenticationLocal;
import it.peruvianit.web.resource.base.AbstractResource;
import it.peruvianit.web.util.RequestUtil;
 
@Path("/user")
public class AuthenticationService extends AbstractResource {	
	@EJB
	AuthenticationLocal authenticationLocal;
	
	@Path("authenticate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public TokenTransfer authenticate(@Context HttpServletRequest requestContext) {	
		UserDetails userDetails = RequestUtil.getUserDetails(requestContext);
		
		return authenticationLocal.generateToken(userDetails);
	}
}