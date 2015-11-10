package it.peruvianit.web.resource.service.authentication;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import it.peruvianit.ejb.AuthenticationLocal;
 
@Path("/login")
public class AuthenticationService {
	@EJB
	AuthenticationLocal authenticationLocal;
	
	@GET
	@Produces("text/plain")
	public String get() {				
		return authenticationLocal.infoEJB();
	}
}