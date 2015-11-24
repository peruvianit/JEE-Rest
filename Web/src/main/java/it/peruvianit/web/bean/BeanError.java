package it.peruvianit.web.bean;

public class BeanError {
	private String type;
	private int code;
	private String description;
	private String message;
	private String relative;
	
	// Constructors
	
	public BeanError(String type, int code, String description, String message, String relative) {
		super();
		this.type = type;
		this.code = code;
		this.description = description;
		this.message = message;
		this.relative = relative;
	}

	// Getters and Setters
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type= type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRelative() {
		return relative;
	}

	public void setRelative(String relative) {
		this.relative = relative;
	}
}
