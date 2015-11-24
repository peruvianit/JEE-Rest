package it.peruvianit.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import it.peruvianit.commons.exception.IException;
import it.peruvianit.commons.util.GsonUtils;
import it.peruvianit.web.bean.BeanError;
import it.peruvianit.web.constant.WebConstant;
import it.peruvianit.web.error.StatusCode;

@Provider
public class ExceptionHttpStatusResolver implements ExceptionMapper<Throwable>{
	Logger logger = Logger.getLogger(ExceptionHttpStatusResolver.class);
	
	@Context 
	private HttpServletRequest request;
	
	@Override
	public Response toResponse(Throwable throwable){
		String typeException = null;
		StatusCode statusCode = null;
		String urlRelative = null;
		
		if (throwable instanceof NotFoundException) {
			statusCode = StatusCode.NOT_FOUND;			
		}else if (throwable instanceof BadRequestException) {
			statusCode = StatusCode.BAD_REQUEST;			
		}
		else{
			statusCode = StatusCode.GENERIC_ERROR;
			
			if (throwable instanceof IException<?>) {
				typeException = WebConstant.TYPE_EXCEPTION_APPLICATION;
			}else{
				typeException = WebConstant.TYPE_EXCEPTION_UNKNOWN;
			}
		}
		
		if (typeException == null){
			typeException = WebConstant.TYPE_EXCEPTION_RESTFUL;
		}
		
		if (request != null){
			urlRelative = request.getRequestURL().toString();
		}
		
		BeanError beanError = new BeanError(typeException,
											statusCode.getCode(),
											statusCode.getDesc(),
											throwable.getMessage(),
											urlRelative);
		logger.error(throwable.getMessage());
		
		return Response.status(statusCode.getCode()).entity(GsonUtils.objToJson(beanError)).build();		
	}
}
