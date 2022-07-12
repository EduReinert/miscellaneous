package com.eduardo.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.eduardo.model.Contato;
import com.eduardo.model.Funcionario;

public class JsonArrays {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger("MyLog");
		FileHandler fh;

		try {

			// This block configure the logger with handler and formatter
			fh = new FileHandler("src/output/logfile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// the following statement is used to log any messages
			logger.info("My first log");

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Eduardo");
		funcionario1.setIdade(18);
		funcionario1.setGenero(null);
		funcionario1.setCargo("DONO");
		funcionario1.setSalario(2000d);
		logger.info("1° funcionário adicinado: " + funcionario1.toString());

		Contato contato1 = new Contato();
		contato1.setEmail("edu@mail.com");
		contato1.setTelefone("47-99268-9623");
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Pedro");
		funcionario2.setCargo("Pedro cargos");
		funcionario2.setSalario(1000d);
		logger.info("2° funcionário adicionado" + funcionario2.toString());
		
		JSONObject func1Json = new JSONObject(funcionario1);
		func1Json.append("contato", contato1.getEmail());
		func1Json.append("contato", contato1.getTelefone());
		JSONObject func2Json = new JSONObject(funcionario2);

		JSONArray funcArray = new JSONArray();
		funcArray.put(func1Json);
		funcArray.put(func2Json);

		System.out.println(funcArray.toString(2));

		try (FileWriter file = new FileWriter("src/output/funcionarios.json")) {
			funcArray.write(file, 2, 0);
			logger.info("adicionado ao .json com sucesso");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
