package it.peruvianit.web.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHttpStatusResolver implements ExceptionMapper<Throwable>{
	@Override
	public Response toResponse(Throwable throwable){
		return Response.status(Status.BAD_REQUEST).entity(throwable.getMessage()).build();
	}
}
