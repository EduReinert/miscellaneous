package com.eduardo.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;

public class Main {

	public static void main(String[] args) {

		try (JdbcRowSet jdbcRS = JdbcConnect.getJdbcRowSet("sakila")) {
			Scanner input = new Scanner(System.in);
			Boolean loop = true;

			while (loop) {
				System.out.println("Escolha uma das opções: " 
								+ "\n1. Listar todos os clientes" 
								+ "\n2. Atualizar um cliente"
								+ "\n3. Deletar um cliente" 
								+ "\n4. Adicionar um cliente" 
								+ "\n5. Navegar pela lista de clientes"
								+ "\n6. Mostrar dados de cliente específico");
				

				int opcao = input.nextInt();

				switch (opcao) {
				case 1:
					JdbcConnect.getAllCustomers(jdbcRS);
					System.out.println();
					break;
				case 2:
					System.out.println("Digite o nome do cliente: ");
					String nome = input.next().toUpperCase();
					System.out.println("Digite o novo nome do cliente: ");
					String novoNome = input.next().toUpperCase();
					JdbcConnect.updateCustomer(jdbcRS, nome, novoNome);
					break;
				case 3:
					System.out.println("Digite o nome do cliente: ");
					nome = input.next().toUpperCase();
					JdbcConnect.deleteCustomer(jdbcRS, nome);
					break;
				case 4:

					break;
				case 5:
					
					break;

				case 6:
					System.out.println("Digite o nome do cliente: ");
					nome = input.next().toUpperCase();
					JdbcConnect.getCustomerByName(jdbcRS, nome);
					break;
				case 7:
					loop = false;
					break;
				default:
					System.out.println("Opção errada, insira novamente\n");
				}
			}

			input.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
