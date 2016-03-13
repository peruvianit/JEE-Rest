package it.peruvianit.web.bean;

import java.util.ArrayList;
import java.util.List;

public class BeanMessageEmail {
	private String subject;
	private String msg;
	private List<String> addTo = new ArrayList<String>();
	
	public BeanMessageEmail(){};
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<String> getAddTo() {
		return addTo;
	}
	public void setAddTo(List<String> addTo) {
		this.addTo = addTo;
	}
}
