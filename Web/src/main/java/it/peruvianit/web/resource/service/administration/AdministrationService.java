package it.peruvianit.web.resource.service.administration;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import it.peruvanit.ejb.AdministrationLocal;
import it.peruvanit.exception.EjbAdministrationException;
import it.peruvianit.commons.annotation.resource.ServiceIdentifier;
import it.peruvianit.commons.dto.dataAccess.DataTableResponseDto;
import it.peruvianit.commons.dto.dataAccess.DataTableRequestDto;
import it.peruvianit.web.resource.base.AbstractResource;
 
@Path("/administration")
public class AdministrationService extends AbstractResource {	
	@EJB
	AdministrationLocal administrationLocal;
	
	@ServiceIdentifier(identifier = 10)
	@Path("users")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public DataTableResponseDto users(@QueryParam("sEcho") Integer sEcho,
									  @QueryParam("iDisplayLength") Integer iDisplayLength,
									  @QueryParam("iDisplayStart") Integer iDisplayStart,
								      @QueryParam("sSortDir_0") String sSortDir_0,
								      @QueryParam("username") String username,
									  @Context HttpServletRequest requestContext) throws EjbAdministrationException, Exception {
		
		DataTableRequestDto dataTableRequestDto = new DataTableRequestDto(sEcho, iDisplayLength, iDisplayStart, sSortDir_0);
		
		dataTableRequestDto.getFilterParams().put("username", username);
		
		return administrationLocal.getListUsers(dataTableRequestDto);
	}
}