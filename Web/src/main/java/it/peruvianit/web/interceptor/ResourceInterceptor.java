package it.peruvianit.web.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.NotFoundException;
import org.jboss.resteasy.spi.interception.PostProcessInterceptor;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

import it.peruvianit.commons.exception.IException;
import it.peruvianit.commons.util.DateUtils;
import it.peruvianit.commons.util.GsonUtils;
import it.peruvianit.web.bean.BeanError;
import it.peruvianit.web.constant.WebConstant;
import it.peruvianit.web.dto.RequestDto;
import it.peruvianit.web.error.StatusCode;

@Provider
@ServerInterceptor
public class ResourceInterceptor implements PreProcessInterceptor, PostProcessInterceptor, ExceptionMapper<Throwable> {	
	Logger logger = Logger.getLogger(ResourceInterceptor.class);
	
	@Context
	private HttpServletRequest httpServletRequest;
	
	RequestDto requestDto;
	
	@Override
	public ServerResponse preProcess(HttpRequest httpRequest, ResourceMethod resourceMethod)
			throws Failure, WebApplicationException {
		requestDto.setStartRequest(DateUtils.getCurrentTimeUTC());
		fillRequestDto();
		return null;
	}

	@Override
	public void postProcess(ServerResponse response) {
		this.endResponse();
		
		requestDto.setResponseCode(response.getStatus());
		Object object = response.getEntity();
		
		if (object != null){
			requestDto.setPayloadLength(object.toString().length());
		}
	}
	
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
		
		if (httpServletRequest != null){
			urlRelative = httpServletRequest.getRequestURL().toString();
		}
		
		BeanError beanError = new BeanError(requestDto.getIdentifier(),
											typeException,
											statusCode.getCode(),
											statusCode.getDesc(),
											throwable.getMessage(),
											urlRelative);
		logger.error(throwable.getMessage());
		
		requestDto.setResponseCode(statusCode.getCode());
		
		return Response.status(statusCode.getCode()).entity(GsonUtils.objToJson(beanError)).build();		
	}
	
	// Metodi Privati
	
	private void fillRequestDto(){
		requestDto.setIpAddressLocale(httpServletRequest.getLocalAddr());
		requestDto.setIpAddressRemote(httpServletRequest.getRemoteAddr());
		requestDto.setMethod(httpServletRequest.getMethod());
		requestDto.setIpAddressRemote(httpServletRequest.getRemoteAddr());
		requestDto.setMethod(httpServletRequest.getMethod());
		requestDto.setAgent(httpServletRequest.getHeader("user-agent"));
		requestDto.setContentType(httpServletRequest.getHeader("content-type"));
		requestDto.setReference(httpServletRequest.getRequestURI());
	}

	private void endResponse(){		
		requestDto.setEndRequest(DateUtils.getCurrentTimeUTC());		
		requestDto.setElapsedTime(requestDto.getEndRequest() - requestDto.getStartRequest());
	}
	
	{
		requestDto = new RequestDto();
		requestDto.setIdentifier(UUID.randomUUID());
	}
}
