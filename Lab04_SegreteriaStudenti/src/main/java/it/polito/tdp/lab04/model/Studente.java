package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

public class Studente {
	
	private int matricola;
	private String nome;
	private String cognome;
	
	List<Corso> Corsi;

	public Studente(int matricola, String nome, String cognome) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		Corsi = new ArrayList<>();
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Matricola= " + matricola + ", Nome= " + nome + ", Cognome= " + cognome + ".";
	}
	
}
