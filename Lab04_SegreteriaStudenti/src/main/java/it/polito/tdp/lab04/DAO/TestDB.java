package it.polito.tdp.lab04.DAO;

import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		CorsoDAO cdao = new CorsoDAO();
		List<Corso> CorsiDB = cdao.getTuttiICorsi();
		
		for(Corso c : CorsiDB)
			System.out.println(c);
		
		StudenteDAO sdao = new StudenteDAO();
		Studente StudenteDB = sdao.getStudentebyMatricola(146101);
		
		System.out.println(StudenteDB);
		
	}

}
