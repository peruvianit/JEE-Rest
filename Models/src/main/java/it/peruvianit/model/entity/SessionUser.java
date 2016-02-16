package it.peruvianit.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SessionUser implements Serializable {
	private static final long serialVersionUID = 3717745954954789122L;

	@Id	
	private BigDecimal session_user_id;
	
	private BigDecimal id_user;
	private String token_access;
	private String localAddress;
	private String remoteAddress;
	private String method_request;
	private String user_agent;
	private String content_type;
	private String uri;
	private Long start_execution;
	private Long end_execution;
	private Long elapsed_time;

	public SessionUser() {
	}

	public BigDecimal getSession_user_id() {
		return session_user_id;
	}

	public void setSession_user_id(BigDecimal session_user_id) {
		this.session_user_id = session_user_id;
	}

	public BigDecimal getId_user() {
		return id_user;
	}

	public void setId_user(BigDecimal id_user) {
		this.id_user = id_user;
	}

	public String getToken_access() {
		return token_access;
	}

	public void setToken_access(String token_access) {
		this.token_access = token_access;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public String getMethod_request() {
		return method_request;
	}

	public void setMethod_request(String method_request) {
		this.method_request = method_request;
	}

	public String getUser_agent() {
		return user_agent;
	}

	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Long getStart_execution() {
		return start_execution;
	}

	public void setStart_execution(Long start_execution) {
		this.start_execution = start_execution;
	}

	public Long getEnd_execution() {
		return end_execution;
	}

	public void setEnd_execution(Long end_execution) {
		this.end_execution = end_execution;
	}

	public Long getElapsed_time() {
		return elapsed_time;
	}

	public void setElapsed_time(Long elapsed_time) {
		this.elapsed_time = elapsed_time;
	}
}