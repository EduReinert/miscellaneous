package com.eduardo.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONArray;

import com.eduardo.model.Paciente;

public class RegistroPaciente {

	public static void main(String[] args) {

		Paciente paciente1 = new Paciente("Eduardo", "47-9326-2196", "Gripe", Calendar.getInstance().getTime(), true);

		Paciente paciente2 = new Paciente();
		paciente2.setNome("Julia");
		paciente2.setNumero("47-91235-6341");
		paciente2.setDoenca("Enxaqueca");
		paciente2.setEntradaHospital(null);
		paciente2.setQuartoPrivado(false);

		Paciente paciente3 = new Paciente();
		paciente3.setNome("Fernando");
		paciente3.setNumero("47-94335-1341");
		paciente3.setDoenca("Resfriado");
		paciente3.setEntradaHospital(null);
		paciente3.setQuartoPrivado(true);

		List<Paciente> list = new ArrayList<Paciente>();
		list.add(paciente1);
		list.add(paciente2);
		list.add(paciente3);

		JSONArray jsonArray = new JSONArray(list);

		System.out.println(jsonArray.toString(2));

		try (FileWriter file = new FileWriter("pacientes.json")) {
			jsonArray.write(file, 2, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
