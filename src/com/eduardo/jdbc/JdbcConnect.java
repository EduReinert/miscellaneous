package com.eduardo.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcConnect {

	private static final String dbURL = "jdbc:mysql://localhost:3306/";
	private static final String username = "root";
	private static final String password = "admin";
	
	public static JdbcRowSet getJdbcRowSet(String schemaName) {

		JdbcRowSet jdbcRS = null;

		try {

			jdbcRS = RowSetProvider.newFactory().createJdbcRowSet();

			jdbcRS.setUrl(dbURL + schemaName);
			jdbcRS.setUsername(username);
			jdbcRS.setPassword(password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return jdbcRS;
	}
	
	public static void getAllCustomers (JdbcRowSet jdbcRS) {
		
		try {
			jdbcRS.setCommand("select * from customer");
			jdbcRS.execute();
			
			while(jdbcRS.next()) {
				System.out.println(jdbcRS.getString("first_name")
						+ "\t" + jdbcRS.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getCustomerByName (JdbcRowSet jdbcRS, String nome) {
		
		try {
			jdbcRS.setCommand("select * from customer");
			jdbcRS.execute();
			
			int count = 0;
			
			while(jdbcRS.next()) {
				if (jdbcRS.getString("first_name").equals(nome)) {
					System.out.println(jdbcRS.getString("first_name")
							+ "\t" + jdbcRS.getString("last_name")
							+ "\t" + jdbcRS.getString("email"));
					count++;
				}
			}
			if(count == 0) {
				System.out.println("Nenhum cliente com este nome foi encontrado");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCustomer (JdbcRowSet jdbcRS, String nome, String novoNome) {
		
		try {
			jdbcRS.setCommand("select * from customer");
			jdbcRS.execute();
			
			while(jdbcRS.next()) {
				if (jdbcRS.getString("first_name").equals(nome)) {
					jdbcRS.updateString("first_name", novoNome.toUpperCase());
					jdbcRS.updateRow();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteCustomer (JdbcRowSet jdbcRS, String nome) {
		
		try {
			jdbcRS.setCommand("select * from customer");
			jdbcRS.execute();
			
			while(jdbcRS.next()) {
				if (jdbcRS.getString("first_name").equals(nome)) {
					jdbcRS.deleteRow();
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
