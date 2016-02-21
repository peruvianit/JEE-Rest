package it.peruvianit.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the DOPA database table.
 * 
 */
@Entity
@Table(name = "TBL1001_USER")
public class Tbl1001User implements Serializable {
	private static final long serialVersionUID = -1447613997013720449L;
	
	@Id
	@Column(name = "PRG_IDE_USR", nullable = false, insertable = true, updatable = true)
	private BigDecimal prgIdeUsr;

	@Column(name = "USR_NAM", nullable = false)
	private String usrNam;

	@Column(name = "MTC_LDP", nullable = false)
	private String mtcLdp;
	
	@Column(name = "PAS_USR", nullable = false)
	private String passUsr;
	
	@Column(name = "NOM_USR", nullable = false)
	private String nomUsr;
	
	@Column(name = "COG_USR", nullable = false)
	private String cogUsr;
	
	@Column(name = "EML_USR")
	private String emlUsr;
	
	@Column(name = "TEL_USR")
	private String telUsr;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_STA_VAL")
	private Date datStaVal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_END_VAL")
	private Date datEndVal;
			
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_ORA_ULT_MOD")
	private Date datOraUltMod;

	@Column(name = "COD_USR_ULT_MOD")
	private String codUsrUltMod;
	
	@Column(name = "PTN_ULT_MOD")
	private String ptnUltMod;

	
	@PreUpdate
	@PrePersist
	public void updateData() {
		datOraUltMod = new Date();
	}

	public Tbl1001User() {
	}

	public BigDecimal getPrgIdeUsr() {
		return prgIdeUsr;
	}

	public void setPrgIdeUsr(BigDecimal prgIdeUsr) {
		this.prgIdeUsr = prgIdeUsr;
	}

	public String getUsrNam() {
		return usrNam;
	}

	public void setUsrNam(String usrNam) {
		this.usrNam = usrNam;
	}

	public String getMtcLdp() {
		return mtcLdp;
	}

	public void setMtcLdp(String mtcLdp) {
		this.mtcLdp = mtcLdp;
	}

	public String getPassUsr() {
		return passUsr;
	}

	public void setPassUsr(String passUsr) {
		this.passUsr = passUsr;
	}

	public String getNomUsr() {
		return nomUsr;
	}

	public void setNomUsr(String nomUsr) {
		this.nomUsr = nomUsr;
	}

	public String getCogUsr() {
		return cogUsr;
	}

	public void setCogUsr(String cogUsr) {
		this.cogUsr = cogUsr;
	}

	public String getEmlUsr() {
		return emlUsr;
	}

	public void setEmlUsr(String emlUsr) {
		this.emlUsr = emlUsr;
	}

	public String getTelUsr() {
		return telUsr;
	}

	public void setTelUsr(String telUsr) {
		this.telUsr = telUsr;
	}

	public Date getDatStaVal() {
		return datStaVal;
	}

	public void setDatStaVal(Date datStaVal) {
		this.datStaVal = datStaVal;
	}

	public Date getDatEndVal() {
		return datEndVal;
	}

	public void setDatEndVal(Date datEndVal) {
		this.datEndVal = datEndVal;
	}

	public Date getDatOraUltMod() {
		return datOraUltMod;
	}

	public void setDatOraUltMod(Date datOraUltMod) {
		this.datOraUltMod = datOraUltMod;
	}

	public String getCodUsrUltMod() {
		return codUsrUltMod;
	}

	public void setCodUsrUltMod(String codUsrUltMod) {
		this.codUsrUltMod = codUsrUltMod;
	}

	public String getPtnUltMod() {
		return ptnUltMod;
	}

	public void setPtnUltMod(String ptnUltMod) {
		this.ptnUltMod = ptnUltMod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codUsrUltMod == null) ? 0 : codUsrUltMod.hashCode());
		result = prime * result + ((cogUsr == null) ? 0 : cogUsr.hashCode());
		result = prime * result + ((datEndVal == null) ? 0 : datEndVal.hashCode());
		result = prime * result + ((datOraUltMod == null) ? 0 : datOraUltMod.hashCode());
		result = prime * result + ((datStaVal == null) ? 0 : datStaVal.hashCode());
		result = prime * result + ((emlUsr == null) ? 0 : emlUsr.hashCode());
		result = prime * result + ((mtcLdp == null) ? 0 : mtcLdp.hashCode());
		result = prime * result + ((nomUsr == null) ? 0 : nomUsr.hashCode());
		result = prime * result + ((passUsr == null) ? 0 : passUsr.hashCode());
		result = prime * result + ((prgIdeUsr == null) ? 0 : prgIdeUsr.hashCode());
		result = prime * result + ((ptnUltMod == null) ? 0 : ptnUltMod.hashCode());
		result = prime * result + ((telUsr == null) ? 0 : telUsr.hashCode());
		result = prime * result + ((usrNam == null) ? 0 : usrNam.hashCode());
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
		Tbl1001User other = (Tbl1001User) obj;
		if (codUsrUltMod == null) {
			if (other.codUsrUltMod != null)
				return false;
		} else if (!codUsrUltMod.equals(other.codUsrUltMod))
			return false;
		if (cogUsr == null) {
			if (other.cogUsr != null)
				return false;
		} else if (!cogUsr.equals(other.cogUsr))
			return false;
		if (datEndVal == null) {
			if (other.datEndVal != null)
				return false;
		} else if (!datEndVal.equals(other.datEndVal))
			return false;
		if (datOraUltMod == null) {
			if (other.datOraUltMod != null)
				return false;
		} else if (!datOraUltMod.equals(other.datOraUltMod))
			return false;
		if (datStaVal == null) {
			if (other.datStaVal != null)
				return false;
		} else if (!datStaVal.equals(other.datStaVal))
			return false;
		if (emlUsr == null) {
			if (other.emlUsr != null)
				return false;
		} else if (!emlUsr.equals(other.emlUsr))
			return false;
		if (mtcLdp == null) {
			if (other.mtcLdp != null)
				return false;
		} else if (!mtcLdp.equals(other.mtcLdp))
			return false;
		if (nomUsr == null) {
			if (other.nomUsr != null)
				return false;
		} else if (!nomUsr.equals(other.nomUsr))
			return false;
		if (passUsr == null) {
			if (other.passUsr != null)
				return false;
		} else if (!passUsr.equals(other.passUsr))
			return false;
		if (prgIdeUsr == null) {
			if (other.prgIdeUsr != null)
				return false;
		} else if (!prgIdeUsr.equals(other.prgIdeUsr))
			return false;
		if (ptnUltMod == null) {
			if (other.ptnUltMod != null)
				return false;
		} else if (!ptnUltMod.equals(other.ptnUltMod))
			return false;
		if (telUsr == null) {
			if (other.telUsr != null)
				return false;
		} else if (!telUsr.equals(other.telUsr))
			return false;
		if (usrNam == null) {
			if (other.usrNam != null)
				return false;
		} else if (!usrNam.equals(other.usrNam))
			return false;
		return true;
	}
}