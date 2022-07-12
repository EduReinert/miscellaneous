package com.eduardo.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.eduardo.model.Cliente;

public class ClienteMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		JSONArray clientesList = new JSONArray();
		while(true) {
			System.out.println("\nDigite a opção: ");
			System.out.println("1: adicionar cliente;\n2: listar clientes;\n3: criar JSON;\n4: sair");
			int opcao = input.nextInt();
			
			
			
			switch (opcao) {
			case 1:
				System.out.println("nome");
				String nome = input.next();
				
				System.out.println("endereço");
				String endereco = input.next();
				
				System.out.println("número");
				int numero = input.nextInt();
				
				System.out.println("idade");
				int idade = input.nextInt();
				Boolean maiorIdade;
				
				if (idade < 18) {
					maiorIdade = false;
				} else {
					maiorIdade = true;
				}
				
				Cliente cli = new Cliente(nome, endereco, numero, maiorIdade);
				
				clientesList.add(cli);
				break;
			case 2:
				System.out.println(clientesList);
				break;
			case 3:
				try(FileWriter file = new FileWriter("clientes.json")) {
					clientesList.writeJSONString(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.exit(1);
			default:
				System.out.println("opção errada!");
				break;
			}
		}
		
	}

}
