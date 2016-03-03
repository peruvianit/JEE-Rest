package it.peruvianit.web.bean;

import java.util.ArrayList;
import java.util.List;

public class BeanRequest {

	private List<BeanHeaders> listBeanHeaders = new ArrayList<>();

	public List<BeanHeaders> getListBeanHeaders() {
		return listBeanHeaders;
	}

	public void setListBeanHeaders(List<BeanHeaders> listBeanHeaders) {
		this.listBeanHeaders = listBeanHeaders;
	}
}
