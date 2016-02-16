package it.peruvianit.commons.dto.dataAccess;

public class FilterParam <U,V> {
	private U typeData;
	private V value;
	
	public FilterParam(U typeData, V value) {
		super();
		this.typeData = typeData;
		this.value = value;
	}
	public U getTypeData() {
		return typeData;
	}
	public void setTypeData(U typeData) {
		this.typeData = typeData;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}
