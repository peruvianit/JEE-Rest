package it.peruvianit.commons.annotation.resource;

public enum TypeAccessService {
	PUBLIC("Accesso publico, senza restrizione"),
	PRIVATE("Controllo accesso basato sul Token");
	
	private String description;
	
	private TypeAccessService(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
