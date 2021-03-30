package it.polito.tdp.lab04.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		List<Corso> Corsi = model.getTuttiICorsi();
		
		for(Corso c : Corsi)
			System.out.println(c);
		
		Studente Studente = model.getStudenteByMatricola(146101);
		
		System.out.println(Studente);

	}

}
