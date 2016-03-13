package it.peruvianit.web.interceptor;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
import org.springframework.beans.BeanUtils;

import it.peruvianit.commons.exception.IException;
import it.peruvianit.commons.util.DateUtils;
import it.peruvianit.commons.util.GsonUtils;
import it.peruvianit.dto.AccountDto;
import it.peruvianit.dto.ErrorRequestDto;
import it.peruvianit.dto.RequestDto;
import it.peruvianit.ejb.AuthenticationLocal;
import it.peruvianit.exception.AuthenticationSecurityException;
import it.peruvianit.web.bean.BeanError;
import it.peruvianit.web.bean.BeanMessageEmail;
import it.peruvianit.web.constant.WebConstant;
import it.peruvianit.web.error.StatusCode;
import it.peruvianit.web.messages.SmtpEmail;
import it.peruvianit.web.util.RequestUtil;
import it.peruvianit.web.util.SecurityUtil;

@Provider
@ServerInterceptor
public class ResourceInterceptor implements PreProcessInterceptor, PostProcessInterceptor, ExceptionMapper<Throwable> {	
	Logger logger = Logger.getLogger(ResourceInterceptor.class);
	
	@Context
	private HttpServletRequest httpServletRequest;
	
	@EJB
	AuthenticationLocal authenticationLocal;
	
	RequestDto requestDto;
	
	@Override
	public ServerResponse preProcess(HttpRequest httpRequest, ResourceMethod resourceMethod)
			throws Failure, WebApplicationException {
		
		ServerResponse response = null;
		BeanError beanError = null;
		
		final String requestUrl = httpRequest.getUri().getAbsolutePath().toString();
		
		this.startRequest();		
		this.fillRequestDto();
		
		requestDto.setParamsQuery(RequestUtil.captureParamsRequest(httpServletRequest));
		
		final boolean isSecured = SecurityUtil.isMethodSecure(resourceMethod);
		
		if (isSecured) {
			this.logger.debug("Request, richiesta Authenticazione");
			
			String publicApiKey = this.getUserDefinedHeader(httpRequest, WebConstant.PUBLIC_KEY_HEADER);
			String requestSignature = this.getUserDefinedHeader(httpRequest, WebConstant.SIGNATURE_HEADER);
			
			requestDto.setRequestSignature(requestSignature);
			
			if (publicApiKey != null && requestSignature != null) {
				this.logger.debug("REST Request Headers sono valite");
				
				AccountDto accountDto = null;
				try {
					accountDto = authenticationLocal.findByRequestSignature(requestSignature);
				} catch (AuthenticationSecurityException e) {
					beanError = createBeanError(WebConstant.TYPE_EXCEPTION_APPLICATION,
												StatusCode.GENERIC_ERROR,
												"authenticationLocal.findByRequestSignature : {requestSignature :" + requestSignature + "}",
												requestUrl);
				}
				
				final Date expirationDate = accountDto.getExpirationDate();
				
				if (expirationDate != null && System.currentTimeMillis() < expirationDate.getTime()){
					this.logger.debug("Request Signature Not Expired");	
					requestDto.setUserName(accountDto.getAccount());		
				}else{
					beanError = createBeanError(WebConstant.TYPE_EXCEPTION_APPLICATION,
												StatusCode.AUTHORIZATION_REQUIRED,
												"Invalid Request Signature : {requestSignature :" + requestSignature + "}",
												requestUrl);
				}				
			}else{
				beanError = createBeanError(WebConstant.TYPE_EXCEPTION_APPLICATION,
											StatusCode.BAD_REQUEST,
											"Headers, publicApiKey e/o requestSignature mancanti",
											requestUrl);
			}
			
			if (beanError != null){
				saveErrorRequest(beanError);
				response = this.buildResponse(StatusCode.BAD_REQUEST.getCode(),GsonUtils.objToJson(beanError));
			}				
		}
		
		return response;
	}

	@Override
	public void postProcess(ServerResponse response) {		
		requestDto.setResponseCode(response.getStatus());
		Object object = response.getEntity();
		
		if (object != null){
			requestDto.setPayloadLength(object.toString().length());
		}
		
		this.endResponse();
		
		saveRequest();
	}
	
	@Override
	public Response toResponse(Throwable throwable){
		String typeException = null;
		StatusCode statusCode = null;
		String urlRelative = null;
		
		this.startRequest();
		
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
		
		BeanError beanError = createBeanError(typeException,
											  statusCode,
											  throwable.getMessage(),
											  urlRelative);
		
		logger.error(throwable.getMessage());
		
		this.fillRequestDto();
		this.endResponse();
		requestDto.setResponseCode(statusCode.getCode());
		
		saveRequest();
		saveErrorRequest(beanError);
		sendEmail(beanError);
		
		return Response.status(statusCode.getCode()).entity(GsonUtils.objToJson(beanError)).build();		
	}
	
	// Metodi Privati
	
	private void fillRequestDto(){
		requestDto.setIpAddressLocale(httpServletRequest.getLocalAddr());
		requestDto.setIpAddressRemote(httpServletRequest.getRemoteAddr());
		requestDto.setMethod(httpServletRequest.getMethod());
		requestDto.setAgent(httpServletRequest.getHeader("user-agent"));
		requestDto.setContentType(httpServletRequest.getHeader("content-type"));
		requestDto.setReference(httpServletRequest.getRequestURI());
	}

	private void startRequest(){
		requestDto.setIdentifier(UUID.randomUUID());
		requestDto.setStartRequest(DateUtils.getCurrentTimeUTC());
	}

	private void endResponse(){		
		requestDto.setEndRequest(DateUtils.getCurrentTimeUTC());		
		requestDto.setElapsedTime(requestDto.getEndRequest() - requestDto.getStartRequest());
	}
	
	private String getUserDefinedHeader(final HttpRequest httpRequest, final String headerName) {
        String headerValue = null;
        final HttpHeaders headers = httpRequest.getHttpHeaders();

        final List<String> headerList = headers.getRequestHeader(headerName);
        if (headerList != null && !headerList.isEmpty()) {
            headerValue = headerList.get(0);
        }

        return headerValue;
    }
	
	private void saveRequest(){
		try {
			authenticationLocal.saveRequest(requestDto);
		} catch (AuthenticationSecurityException aEx) {
			logger.error(aEx.getMessage());
		}
	}
	
	private void saveErrorRequest(BeanError beanError){
		try {
			ErrorRequestDto errorRequestDto = new ErrorRequestDto();
			
			BeanUtils.copyProperties(requestDto, errorRequestDto);
			
			errorRequestDto.setType(beanError.getType());
			errorRequestDto.setMessage(beanError.getMessage());
			
			authenticationLocal.saveErrorRequest(errorRequestDto);
		} catch (AuthenticationSecurityException aEx) {
			logger.error(aEx.getMessage());
		}
	}
	
	private void sendEmail(BeanError beanError){
		try {
			BeanMessageEmail beanMessageEmail = new BeanMessageEmail();
			beanMessageEmail.setSubject("Problemi Applicazione JeeRestApi V.1.0");
			Map<String,Object> mapObject = new LinkedHashMap<>();
			mapObject.put("Response", requestDto);
			mapObject.put("Error", beanError);
			beanMessageEmail.setMsg(GsonUtils.objToJsonPrettyPrinting(mapObject));
			SmtpEmail.sendMessage(beanMessageEmail);
		} catch (it.peruvianit.web.exception.WebApplicationException e) {
			logger.error(e.getMessage());
		}
	}
	private BeanError createBeanError(String typeException,StatusCode statusCode,String messageError, String urlRelative){
		return new BeanError(new Date(),
							 requestDto.getIdentifier(),											
							 typeException,
							 statusCode.getCode(),
							 statusCode.getDesc(),
							 messageError,
							 urlRelative);
	}
	
	private ServerResponse buildResponse(final int statusCode, final String message) {
        this.logger.info("Creazione REST Response: " + statusCode + " - " + message);
        final ServerResponse response = new ServerResponse();
        response.setStatus(statusCode);
        response.setEntity(message);
        return response;
    }  
		
	{
		requestDto = new RequestDto();		
	}
}
