package it.peruvianit.data.dto;

import java.util.List;

public class PaginationContainerDto {
	private Integer iTotalRecords;
	private List<?> aaData;
	
	public Integer getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<?> getAaData() {
		return aaData;
	}
	public void setAaData(List<?> aaData) {
		this.aaData = aaData;
	}
}
