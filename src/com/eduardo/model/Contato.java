package com.eduardo.model;

public class Contato {

	private String email;
	private String telefone;
	
	public Contato(String email, String telefone) {
		this.email = email;
		this.telefone = telefone;
	}

	public Contato() {
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Contato [email=" + email + ", telefone=" + telefone + "]";
	}
	
}
