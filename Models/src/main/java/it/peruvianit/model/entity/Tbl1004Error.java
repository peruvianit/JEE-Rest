package it.peruvianit.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the DOPA database table.
 * 
 */
@Entity
@Table(name = "TBL1004_ERROR")
public class Tbl1004Error implements Serializable {
	private static final long serialVersionUID = 2906087494626366329L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRG_IDE_ERROR", nullable = false, insertable = true, updatable = true)
	private BigDecimal prgIdeError;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME_STAMP", nullable = false)
	private Date timestamp;

	@Column(name = "IDENTIFIER_REQUEST", length = 100)
	private String identifierRequest;
	
	@Column(name = "USER_NAME", length = 30)
	private String userName;

	@Column(name = "TOKEN", length = 500)
	private String token;
	
	@Column(name = "URI_API_REST", length = 255)
	private String uriApiRest;
	
	@Column(name = "VERB_API_REST", length = 3)
	private String verbApiRest;
	
	@Column(name = "PARAMS_QUERY", length = 4000)
	private String paramsQuery;
	
	@Column(name = "AGENT_BROWSER", length = 100)
	private String agentBrowser;
		
	@Column(name = "CONTENT_TYPE", length = 200)
	private String contentType;
	
	@Column(name = "RESPONSE_CODE")
	private Integer responseCode;
	
	@Column(name = "TYPE_EXCEPTION", length = 50)
	private String typeException;
	
	@Column(name = "MESSAGE_EXCEPTION", length = 4000)
	private String messageException;

	@PrePersist
	public void updateData() {
		timestamp = new Date();
	}
	
	public BigDecimal getPrgIdeError() {
		return prgIdeError;
	}

	public void setPrgIdeError(BigDecimal prgIdeError) {
		this.prgIdeError = prgIdeError;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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

	public String getParamsQuery() {
		return paramsQuery;
	}

	public void setParamsQuery(String paramsQuery) {
		this.paramsQuery = paramsQuery;
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

	public String getTypeException() {
		return typeException;
	}

	public void setTypeException(String typeException) {
		this.typeException = typeException;
	}

	public String getMessageException() {
		return messageException;
	}

	public void setMessageException(String messageException) {
		this.messageException = messageException;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agentBrowser == null) ? 0 : agentBrowser.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((identifierRequest == null) ? 0 : identifierRequest.hashCode());
		result = prime * result + ((messageException == null) ? 0 : messageException.hashCode());
		result = prime * result + ((paramsQuery == null) ? 0 : paramsQuery.hashCode());
		result = prime * result + ((prgIdeError == null) ? 0 : prgIdeError.hashCode());
		result = prime * result + ((responseCode == null) ? 0 : responseCode.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((typeException == null) ? 0 : typeException.hashCode());
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
		Tbl1004Error other = (Tbl1004Error) obj;
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
		if (identifierRequest == null) {
			if (other.identifierRequest != null)
				return false;
		} else if (!identifierRequest.equals(other.identifierRequest))
			return false;
		if (messageException == null) {
			if (other.messageException != null)
				return false;
		} else if (!messageException.equals(other.messageException))
			return false;
		if (paramsQuery == null) {
			if (other.paramsQuery != null)
				return false;
		} else if (!paramsQuery.equals(other.paramsQuery))
			return false;
		if (prgIdeError == null) {
			if (other.prgIdeError != null)
				return false;
		} else if (!prgIdeError.equals(other.prgIdeError))
			return false;
		if (responseCode == null) {
			if (other.responseCode != null)
				return false;
		} else if (!responseCode.equals(other.responseCode))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (typeException == null) {
			if (other.typeException != null)
				return false;
		} else if (!typeException.equals(other.typeException))
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

	