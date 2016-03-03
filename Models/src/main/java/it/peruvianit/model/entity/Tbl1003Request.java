package it.peruvianit.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the DOPA database table.
 * 
 */
@Entity
@Table(name = "TBL1003_REQUEST")
public class Tbl1003Request implements Serializable {
	private static final long serialVersionUID = 4597002742176979697L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRG_IDE_REQUEST", nullable = false, insertable = true, updatable = true)
	private BigDecimal prgIdeRequest;

	@Column(name = "IDENTIFIER_REQUEST", length = 100)
	private String identifierRequest;
	
	@Column(name = "USER_NAME", length = 30)
	private String userName;

	@Column(name = "TOKEN", length = 60)
	private String token;
	
	@Column(name = "IP_ADDRESS_LOCAL", length = 60)
	private String ipAddressLocal;
	
	@Column(name = "IP_ADDRESS_REMOTE", length = 60)
	private String ipAddressRemote;
	
	@Column(name = "REQUEST_TIME")
	private Long requestTime;
	
	@Column(name = "RESPONSE_TIME")
	private Long responseTime;
	
	@Column(name = "ELAPSED_TIME")
	private Long elapsedTime;
	
	@Column(name = "URI_API_REST", length = 255)
	private String uriApiRest;
	
	@Column(name = "VERB_API_REST", length = 3)
	private String verbApiRest;
	
	@Column(name = "PAYLOAD_BODY", length = 4000)
	private String payloadBody;
	
	@Column(name = "AGENT_BROWSER", length = 100)
	private String agentBrowser;
		
	@Column(name = "CONTENT_TYPE", length = 200)
	private String contentType;
	
	@Column(name = "RESPONSE_CODE")
	private Integer responseCode;

	public BigDecimal getPrgIdeRequest() {
		return prgIdeRequest;
	}

	public void setPrgIdeRequest(BigDecimal prgIdeRequest) {
		this.prgIdeRequest = prgIdeRequest;
	}

	public String getIdentifierRequest() {
		return identifierRequest;
	}

	public void setIdentifierRequest(String identifierRequest) {
		this.identifierRequest = identifierRequest;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIpAddressLocal() {
		return ipAddressLocal;
	}

	public void setIpAddressLocal(String ipAddressLocal) {
		this.ipAddressLocal = ipAddressLocal;
	}

	public String getIpAddressRemote() {
		return ipAddressRemote;
	}

	public void setIpAddressRemote(String ipAddressRemote) {
		this.ipAddressRemote = ipAddressRemote;
	}

	public Long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Long requestTime) {
		this.requestTime = requestTime;
	}

	public Long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

	public Long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public String getUriApiRest() {
		return uriApiRest;
	}

	public void setUriApiRest(String uriApiRest) {
		this.uriApiRest = uriApiRest;
	}

	public String getVerbApiRest() {
		return verbApiRest;
	}

	public void setVerbApiRest(String verbApiRest) {
		this.verbApiRest = verbApiRest;
	}

	public String getPayloadBody() {
		return payloadBody;
	}

	public void setPayloadBody(String payloadBody) {
		this.payloadBody = payloadBody;
	}

	public String getAgentBrowser() {
		return agentBrowser;
	}

	public void setAgentBrowser(String agentBrowser) {
		this.agentBrowser = agentBrowser;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agentBrowser == null) ? 0 : agentBrowser.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((elapsedTime == null) ? 0 : elapsedTime.hashCode());
		result = prime * result + ((identifierRequest == null) ? 0 : identifierRequest.hashCode());
		result = prime * result + ((ipAddressLocal == null) ? 0 : ipAddressLocal.hashCode());
		result = prime * result + ((ipAddressRemote == null) ? 0 : ipAddressRemote.hashCode());
		result = prime * result + ((payloadBody == null) ? 0 : payloadBody.hashCode());
		result = prime * result + ((prgIdeRequest == null) ? 0 : prgIdeRequest.hashCode());
		result = prime * result + ((requestTime == null) ? 0 : requestTime.hashCode());
		result = prime * result + ((responseCode == null) ? 0 : responseCode.hashCode());
		result = prime * result + ((responseTime == null) ? 0 : responseTime.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((uriApiRest == null) ? 0 : uriApiRest.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((verbApiRest == null) ? 0 : verbApiRest.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tbl1003Request other = (Tbl1003Request) obj;
		if (agentBrowser == null) {
			if (other.agentBrowser != null)
				return false;
		} else if (!agentBrowser.equals(other.agentBrowser))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (elapsedTime == null) {
			if (other.elapsedTime != null)
				return false;
		} else if (!elapsedTime.equals(other.elapsedTime))
			return false;
		if (identifierRequest == null) {
			if (other.identifierRequest != null)
				return false;
		} else if (!identifierRequest.equals(other.identifierRequest))
			return false;
		if (ipAddressLocal == null) {
			if (other.ipAddressLocal != null)
				return false;
		} else if (!ipAddressLocal.equals(other.ipAddressLocal))
			return false;
		if (ipAddressRemote == null) {
			if (other.ipAddressRemote != null)
				return false;
		} else if (!ipAddressRemote.equals(other.ipAddressRemote))
			return false;
		if (payloadBody == null) {
			if (other.payloadBody != null)
				return false;
		} else if (!payloadBody.equals(other.payloadBody))
			return false;
		if (prgIdeRequest == null) {
			if (other.prgIdeRequest != null)
				return false;
		} else if (!prgIdeRequest.equals(other.prgIdeRequest))
			return false;		
		if (requestTime == null) {
			if (other.requestTime != null)
				return false;
		} else if (!requestTime.equals(other.requestTime))
			return false;
		if (responseCode == null) {
			if (other.responseCode != null)
				return false;
		} else if (!responseCode.equals(other.responseCode))
			return false;
		if (responseTime == null) {
			if (other.responseTime != null)
				return false;
		} else if (!responseTime.equals(other.responseTime))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (uriApiRest == null) {
			if (other.uriApiRest != null)
				return false;
		} else if (!uriApiRest.equals(other.uriApiRest))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (verbApiRest == null) {
			if (other.verbApiRest != null)
				return false;
		} else if (!verbApiRest.equals(other.verbApiRest))
			return false;
		return true;
	}	
}