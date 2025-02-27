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
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso Corso) {
		return CorsoDAO.getStudentiIscrittiAlCorso(Corso);
	}
	
	public List<Corso> getCorsiByStudente(Studente Studente) {
		return StudenteDAO.getCorsiByStudente(Studente);
	}
	
	public List<Studente> getTuttiGliStudenti() {
		return StudenteDAO.getTuttiGliStudenti();
	}
	
	public boolean isStudenteIscrittoCorso(Studente Studente, Corso Corso) {
		
		List<Studente> IscrittiCorso = CorsoDAO.getStudentiIscrittiAlCorso(Corso);
		
		for(Studente s : IscrittiCorso)
			if(s.getMatricola() == Studente.getMatricola())
				return true;
		
		return false;
		
	}
	
	public void iscriviStudenteCorso(Studente Studente, Corso Corso) {
		CorsoDAO.inscriviStudenteACorso(Studente, Corso);
	}
	
}
