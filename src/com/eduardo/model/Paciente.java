package com.eduardo.model;

import java.util.Calendar;
import java.util.Date;

import org.json.JSONPropertyIgnore;
import org.json.JSONPropertyName;

public class Paciente {

	private String nome;
	private String numero;
	private String doenca;
	private Date entradaHospital;
	private Boolean quartoPrivado;

	public Paciente(String nome, String numero, String doenca, Date entradaHospital, Boolean quartoPrivado) {
		this.nome = nome;
		this.numero = numero;
		this.doenca = doenca;
		this.entradaHospital = entradaHospital;
		this.quartoPrivado = quartoPrivado;
	}

	public Paciente() {
	}

	@JSONPropertyName("nome")
	public String getNome() {
		return nome;
	}

	@JSONPropertyName("numero")
	public String getNumero() {
		return numero;
	}

	@JSONPropertyName("doenca")
	public String getDoenca() {
		return doenca;
	}

	@JSONPropertyName("entrada_hospital")
	public Date getEntradaHospital() {
		return entradaHospital;
	}

	//@JSONPropertyName("quarto_privado")
	@JSONPropertyIgnore
	public Boolean getQuartoPrivado() {
		return quartoPrivado;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

	public void setEntradaHospital(Date entradaHospital) {
		this.entradaHospital = entradaHospital;
	}

	public void setQuartoPrivado(Boolean quartoPrivado) {
		this.quartoPrivado = quartoPrivado;
	}

	@Override
	public String toString() {
		return "Paciente [nome=" + nome + ", numero=" + numero + ", doenca=" + doenca + ", entradaHospital="
				+ entradaHospital + ", quartoPrivado=" + quartoPrivado + "]";
	}

	
}
