package it.peruvianit.web.resource.service.media;

import java.io.File;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import it.peruvianit.commons.annotation.resource.ServiceIdentifier;
import it.peruvianit.commons.util.random.GenerateRandom;
import it.peruvianit.web.resource.base.AbstractResource;
 
@Path("/media")
public class ImagesService extends AbstractResource {	
	
	@ServiceIdentifier(identifier = 90)
	@GET
	@Path("/images")
	@Produces("image/png")
	public Response getFile(@NotNull @QueryParam("path") final String pathImage) {

		File file = new File(pathImage);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition","inline; filename=" + GenerateRandom.randomAlphaNumeric(10));
		return response.build();
	}
}