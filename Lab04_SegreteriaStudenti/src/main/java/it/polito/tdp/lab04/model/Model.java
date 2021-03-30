package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.*;

public class Model {

	private CorsoDAO CorsoDAO;
	private StudenteDAO StudenteDAO;

	public Model() {
		CorsoDAO = new CorsoDAO();
		StudenteDAO = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi(){
		return CorsoDAO.getTuttiICorsi();
	}
	
	public Studente getStudenteByMatricola(int matricola) {
		return StudenteDAO.getStudentebyMatricola(matricola);
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		return CorsoDAO.getStudentiIscrittiAlCorso(corso);
	}
	
	public List<Corso> getCorsiByStudente(Studente Studente) {
		return StudenteDAO.getCorsiByStudente(Studente);
	}
	
	public List<Studente> getTuttiGliStudenti() {
		return StudenteDAO.getTuttiGliStudenti();
	}
	
}
