package com.eduardo.json;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CdlParseExemplo {

	public static void main(String[] args) {

		JSONObject estudantesJson = new JSONObject();
		
		JSONArray nomesArray = CDL.rowToJSONArray(new JSONTokener("Eduardo, Augusto, Reinert, Paulo, Silva"));
	
		estudantesJson.put("nomes", nomesArray);

		System.out.println(estudantesJson.toString(2));

		JSONArray camposArray = CDL.rowToJSONArray(new JSONTokener(
				"ID, StatusEmprestimo, QuantidadeEmprestimo, Termo, CreditoPontuacao, RendaAnual, Casa, BalancoCredito"));

		System.out.println(camposArray);

		JSONObject emprestimoJson = CDL.rowToJSONObject(camposArray,
				new JSONTokener("c89ed12c, Pago 100%, 31523, Curto Periodo, 750.0, 1351235.0, Apartamento, 123512"));

		System.out.println(emprestimoJson.toString(2));

		/*
		 * header e conteudo definido
		 */
		JSONArray headerArray = new JSONArray();
		headerArray.put("nome");
		headerArray.put("idade");
		headerArray.put("genero");
		// comma = virgula
		String commaDelimitedText = 
				"Eduardo, 19, homem \n" + 
				"Augusto, 15, homem \n" + 
				"Joana, 25, mulher \n"+ 
				"Julia, 21, mulher";
	
		JSONArray array = CDL.toJSONArray(headerArray, commaDelimitedText);
		System.out.println(array.toString(2));

		/*
		 * tudo definido no mesmo campo
		 */
		
		String commaDelimitedText2 = 
				"nome, idade, genero \n" +
				"Maria, 32, mulher \n" +
				"Jorge, 50, homem \n" +
				"Fabricio, 39, homem"
		;
		
		JSONArray array2 = CDL.toJSONArray(commaDelimitedText2);
		System.out.println(array2.toString(2));
	}
}
