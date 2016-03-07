package it.peruvianit.dto;

import java.io.Serializable;
import java.util.UUID;

public class RequestDto implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8966422593491960592L;
	
	// UUID	
	private UUID identifier;
	
	// Info Request
	private Long startRequest;
	private String ipAddressLocale;
	private String ipAddressRemote;	
	private String method;
	private String agent;
	private String contentType;
	private String reference;
	
	// Info Response
	private String paramsQuery;
	private Integer payloadLength;
	private Long endRequest;
	private Integer responseCode;
	
	// Summary Metrics	
	private Long elapsedTime;
	
	// Token
	
	private String requestSignature;
	
	public RequestDto() {}
	
	public UUID getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(UUID identifier) {
		this.identifier = identifier;
	}


	public Long getStartRequest() {
		return startRequest;
	}

	public void setStartRequest(Long startRequest) {
		this.startRequest = startRequest;
	}

	public String getIpAddressLocale() {
		return ipAddressLocale;
	}

	public void setIpAddressLocale(String ipAddressLocale) {
		this.ipAddressLocale = ipAddressLocale;
	}

	public String getIpAddressRemote() {
		return ipAddressRemote;
	}

	public void setIpAddressRemote(String ipAddressRemote) {
		this.ipAddressRemote = ipAddressRemote;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getParamsQuery() {
		return paramsQuery;
	}

	public void setParamsQuery(String paramsQuery) {
		this.paramsQuery = paramsQuery;
	}

	public Integer getPayloadLength() {
		return payloadLength;
	}

	public void setPayloadLength(Integer payloadLength) {
		this.payloadLength = payloadLength;
	}

	public Long getEndRequest() {
		return endRequest;
	}

	public void setEndRequest(Long endRequest) {
		this.endRequest = endRequest;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public Long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	public String getRequestSignature() {
		return requestSignature;
	}

	public void setRequestSignature(String requestSignature) {
		this.requestSignature = requestSignature;
	}

	{
		startRequest = 0L;
		endRequest = 0L;
		payloadLength = 0;
	}
}
