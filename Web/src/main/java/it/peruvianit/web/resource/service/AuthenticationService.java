package it.peruvianit.web.resource.service;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import it.peruvianit.ejb.AuthenticationLocal;
import it.peruvianit.web.exception.WebApplicationException;
 
@Path("/login")
public class AuthenticationService {
	@EJB
	AuthenticationLocal authenticationLocal;
	
	@GET
	@Produces("text/plain")
	public String get() {		
		return authenticationLocal.infoEJB();
	}
	
	@GET
	@Produces("text/plain")
	@Path("/create-error")
	public String getError() throws WebApplicationException {		
		throw new WebApplicationException("Create-error, Api RESTful");
	}
}