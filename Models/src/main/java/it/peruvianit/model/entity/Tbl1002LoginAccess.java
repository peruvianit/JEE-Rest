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
@Table(name = "TBL1002_LOGIN_ACCESS")
public class Tbl1002LoginAccess implements Serializable {
	private static final long serialVersionUID = -5188274470237651251L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRG_LOG_ACC", nullable = false, insertable = true, updatable = true)
	private BigDecimal prgLogAcc;

	@Column(name = "USER_NAME", nullable = false, length = 30)
	private String userName;

	@Column(name = "TOKEN", nullable = false, length = 500)
	private String token;
	
	@Column(name = "IP_ADDRESS", nullable = false, length = 60)
	private String ipAddress;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_TIME", nullable = false)
	private Date loginTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGOUT_TIME", nullable = true)
	private Date logoutTime;
	
	@Column(name = "ELAPSED_TIME", nullable = true)
	private Integer elapsedTime;
	
	@Column(name = "TYPE_ACCESS", nullable = false, length = 20)
	private String typeAccess;
	
	@Column(name = "ID_USER_AGENT", nullable= true)
	private Integer idUserAgent;
	
	@Column(name = "BROWSER", nullable= true, length = 40)
	private String browser;
	
	@Column(name = "OS", nullable = true, length = 50)
	private String os;
	
	@Column(name = "STATUS", length = 1)
	private String status;

	@PrePersist
	public void updateData() {
		loginTime = new Date();
	}
	
	public BigDecimal getPrgLogAcc() {
		return prgLogAcc;
	}

	public void setPrgLogAcc(BigDecimal prgLogAcc) {
		this.prgLogAcc = prgLogAcc;
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

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public Integer getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Integer elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public String getTypeAccess() {
		return typeAccess;
	}

	public void setTypeAccess(String typeAccess) {
		this.typeAccess = typeAccess;
	}

	
	public Integer getIdUserAgent() {
		return idUserAgent;
	}

	public void setIdUserAgent(Integer idUserAgent) {
		this.idUserAgent = idUserAgent;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUserAgent == null) ? 0 : idUserAgent.hashCode());
		result = prime * result + ((browser == null) ? 0 : browser.hashCode());
		result = prime * result + ((elapsedTime == null) ? 0 : elapsedTime.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((loginTime == null) ? 0 : loginTime.hashCode());
		result = prime * result + ((logoutTime == null) ? 0 : logoutTime.hashCode());
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((prgLogAcc == null) ? 0 : prgLogAcc.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((typeAccess == null) ? 0 : typeAccess.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Tbl1002LoginAccess other = (Tbl1002LoginAccess) obj;
		if (idUserAgent == null) {
			if (other.idUserAgent != null)
				return false;
		} else if (!idUserAgent.equals(other.idUserAgent))
			return false;
		if (browser == null) {
			if (other.browser != null)
				return false;
		} else if (!browser.equals(other.browser))
			return false;
		if (elapsedTime == null) {
			if (other.elapsedTime != null)
				return false;
		} else if (!elapsedTime.equals(other.elapsedTime))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (loginTime == null) {
			if (other.loginTime != null)
				return false;
		} else if (!loginTime.equals(other.loginTime))
			return false;
		if (logoutTime == null) {
			if (other.logoutTime != null)
				return false;
		} else if (!logoutTime.equals(other.logoutTime))
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (prgLogAcc == null) {
			if (other.prgLogAcc != null)
				return false;
		} else if (!prgLogAcc.equals(other.prgLogAcc))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (typeAccess == null) {
			if (other.typeAccess != null)
				return false;
		} else if (!typeAccess.equals(other.typeAccess))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}	
}