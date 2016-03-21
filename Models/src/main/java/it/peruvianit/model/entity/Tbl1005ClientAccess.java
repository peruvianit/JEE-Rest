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
@Table(name = "TBL1005_CLIENT_ACCESS")
public class Tbl1005ClientAccess implements Serializable {
	private static final long serialVersionUID = 3539143904829496749L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRG_CLI_ACC", nullable = false, insertable = true, updatable = true)
	private BigDecimal prgCliAcc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_TIME", nullable = false)
	private Date loginTime;
	
	@Column(name = "USER_NAME", nullable = false, length = 30)
	private String userName;
	
	@Column(name = "IP_ADDRESS", nullable = false, length = 60)
	private String ipAddress;
	
	@Column(name = "TYPE_ACCESS", nullable = false, length = 20)
	private String typeAccess;
	
	@Column(name = "ID_USER_AGENT", nullable= true)
	private Integer idUserAgent;
	
	@Column(name = "BROWSER", nullable= true, length = 40)
	private String browser;
	
	@Column(name = "OS", nullable = true, length = 50)
	private String os;

	@PrePersist
	public void updateData() {
		loginTime = new Date();
	}

	public BigDecimal getPrgCliAcc() {
		return prgCliAcc;
	}

	public void setPrgCliAcc(BigDecimal prgCliAcc) {
		this.prgCliAcc = prgCliAcc;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((browser == null) ? 0 : browser.hashCode());
		result = prime * result + ((idUserAgent == null) ? 0 : idUserAgent.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((loginTime == null) ? 0 : loginTime.hashCode());
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((prgCliAcc == null) ? 0 : prgCliAcc.hashCode());
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
		Tbl1005ClientAccess other = (Tbl1005ClientAccess) obj;
		if (browser == null) {
			if (other.browser != null)
				return false;
		} else if (!browser.equals(other.browser))
			return false;
		if (idUserAgent == null) {
			if (other.idUserAgent != null)
				return false;
		} else if (!idUserAgent.equals(other.idUserAgent))
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
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (prgCliAcc == null) {
			if (other.prgCliAcc != null)
				return false;
		} else if (!prgCliAcc.equals(other.prgCliAcc))
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