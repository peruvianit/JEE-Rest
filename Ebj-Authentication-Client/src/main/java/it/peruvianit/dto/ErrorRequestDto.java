package it.peruvianit.dto;

import java.io.Serializable;
import java.util.Date;

public class ErrorRequestDto extends RequestDto implements Serializable {
	private static final long serialVersionUID = -1582546177179970726L;

	private Date timeStamp;
	private String type;
	private int code;
	private String description;
	private String message;
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
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
}
