package it.peruvianit.web.error;

public enum StatusCode {
	// Errori Api Estandar
	BAD_REQUEST(400, "The request cannot be fulfilled due to bad syntax"),
	AUTHORIZATION_REQUIRED(401, "Authorization Required"),
	NOT_FOUND(404, "Could not find resource"),
	
	// Errori Applicativi
	GENERIC_ERROR(500, "GENERIC_ERROR");
	
	private int code;
	private String desc;

	private StatusCode(final int code, final String desc) {
		this.code = code;
		this.setDesc(desc);
	}

	public int getCode() {
		return code;
	}

	public void setCode(final int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(final String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return code + " " + desc;
	}

}
