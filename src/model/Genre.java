package model;

public enum Genre {
	
	FICTION("Fiction"), 
	NON_FICTION("Non Fiction"),
	SCI_FI("Sci-Fi"),
	BIOGRAPHY("Biography"),
	HISTORY("History"),
	CHILDREN("Children");
	
	private String description;
	
	private Genre(String desc){
		description = desc;
	}
	
	@Override
	public String toString() {
		return description;
	}

	
}
