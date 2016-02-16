package it.peruvianit.commons.dto.dataAccess;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DataTableRequestDto implements Serializable{
	private static final long serialVersionUID = -3785399994319230624L;
	
	private Integer sEcho;
	private Integer iDisplayLength;
	private Integer iDisplayStart;
    private String sSortDir_0;
    
    private Map<String,? super Object> filterParams = new HashMap<String, Object>();
        
	public DataTableRequestDto(Integer sEcho, Integer iDisplayLength, Integer iDisplayStart, String sSortDir_0) {
		super();
		this.sEcho = sEcho;
		this.iDisplayLength = iDisplayLength;
		this.iDisplayStart = iDisplayStart;
		this.sSortDir_0 = sSortDir_0;
	}
	
	public Integer getsEcho() {
		return sEcho;
	}
	public void setsEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}
	public Integer getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	public Integer getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	public String getsSortDir_0() {
		return sSortDir_0;
	}
	public void setsSortDir_0(String sSortDir_0) {
		this.sSortDir_0 = sSortDir_0;
	}
	
	public Map<String,? super Object> getFilterParams() {
		return filterParams;
	}

	public void setFilterParams(Map<String, ? super Object> filterParams) {
		this.filterParams = filterParams;
	}

	@Override
	public String toString() {
		return "DataTableRequestDto [sEcho=" + sEcho + ", iDisplayLength=" + iDisplayLength + ", iDisplayStart="
				+ iDisplayStart + ", sSortDir_0=" + sSortDir_0 + "]";
	}
}
