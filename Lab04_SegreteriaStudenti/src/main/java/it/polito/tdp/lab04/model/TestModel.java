package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		Studente s = new Studente(146101, "VIGGIANO", "CLAUDIO");
		Corso c = new Corso("02CIXPG", 8, "Sistemi informativi aziendali",1);
		
		boolean test = false;
		
		test = model.isStudenteIscrittoCorso(s, c);
		
		System.out.print(test);
		
	}

}
