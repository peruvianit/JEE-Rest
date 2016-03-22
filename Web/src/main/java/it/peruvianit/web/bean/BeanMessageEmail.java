package it.peruvianit.web.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanMessageEmail {
	private String subject;
	private Map<String,Object> msg = new HashMap<>();
	private List<String> addTo = new ArrayList<String>();
	
	private String templateEmail;
	
	public BeanMessageEmail(String templateEmail){
		this.templateEmail = templateEmail;
	};
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Map<String, Object> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}
	public List<String> getAddTo() {
		return addTo;
	}
	public void setAddTo(List<String> addTo) {
		this.addTo = addTo;
	}

	public String getTemplateEmail() {
		return templateEmail;
	}

	public void setTemplateEmail(String templateEmail) {
		this.templateEmail = templateEmail;
	}
}
