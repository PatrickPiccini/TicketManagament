package com.massa.dbutilities;

public enum ConectionTypes {
	
	SQLITE("jdbc:sqlite:");
	
	private ConectionTypes (String tipo) {
		this.tipo = tipo;	
	}
	
	private String tipo;

	
	public String getTipo() {
		return tipo;
	}

}
