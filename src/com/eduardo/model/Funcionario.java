package com.eduardo.model;

public class Funcionario {

	private String nome;
	private Integer idade;
	private String genero;
	private String cargo;
	private Double salario;
	
	public Funcionario() {
	}
	
	public Funcionario(String nome, Integer idade, String genero, String cargo, Double salario) {
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.cargo = cargo;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", idade=" + idade + ", genero=" + genero + ", cargo=" + cargo
				+ ", salario=" + salario + "]";
	}
}
