package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		CorsoDAO cdao = new CorsoDAO();
	
		boolean i = cdao.inscriviStudenteACorso(new Studente(146101, "VIGGIANO", "CLAUDIO"), new Corso("01NBAPG", 8, "Ingegneria della qualità",1));
		
		System.out.print(i);
		
	}

}
