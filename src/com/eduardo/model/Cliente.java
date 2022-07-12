package com.eduardo.model;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class Cliente implements JSONStreamAware{

	private String nome;
	private String endereco;
	private int numero;
	private boolean maiorIdade;
	
	public Cliente(String nome, String endereco, int numero, boolean maiorIdade) {
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.maiorIdade = maiorIdade;
	}
	
	public Cliente() {
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isMaiorIdade() {
		return maiorIdade;
	}
	public void setMaiorIdade(boolean maiorIdade) {
		this.maiorIdade = maiorIdade;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + ", numero=" + numero + ", maiorIdade=" + maiorIdade
				+ "]\n";
	}

	@Override
	public void writeJSONString(Writer out) throws IOException {
		Map<String, Serializable> map = new LinkedHashMap<>();
		
		map.put("nome", nome);
		map.put("endereco", endereco);
		map.put("numero", numero);
		map.put("maiorIdade", maiorIdade);
		
		JSONValue.writeJSONString(map, out);
	}
}
