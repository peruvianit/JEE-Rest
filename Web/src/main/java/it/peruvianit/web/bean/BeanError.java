package it.peruvianit.web.bean;

import java.util.Date;
import java.util.UUID;

public class BeanError {
	private Date date;
	private UUID identifier;
	private String type;
	private int code;
	private String description;
	private String message;
	private String relative;
	
	// Constructors
	
	public BeanError(Date date, UUID identifier, String type, int code, String description, String message,
			String relative) {
		super();
		this.date = date;
		this.identifier = identifier;
		this.type = type;
		this.code = code;
		this.description = description;
		this.message = message;
		this.relative = relative;
	}

	// Getters and Setters
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UUID getIdentifier() {
		return identifier;
	}

	public void setIdentifier(UUID identifier) {
		this.identifier = identifier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
