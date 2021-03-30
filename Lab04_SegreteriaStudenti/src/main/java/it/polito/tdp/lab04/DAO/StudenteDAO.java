package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente> getTuttiGliStudenti() {
		
		final String sql = "SELECT * "
				+ "FROM studente s ";
		
		List<Studente> Studenti = new LinkedList<>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				int matricoladb = rs.getInt("matricola");
				String nomedb = rs.getString("nome");
				String cognomedb = rs.getString("cognome");
				
				Studenti.add(new Studente(matricoladb, nomedb, cognomedb));
				
			}
			
			conn.close();
				
			return Studenti;
			
		} catch(SQLException e) {
			throw new RuntimeException("Error db", e);
		}
		
	}
	
	public Studente getStudentebyMatricola(int matricola) {
		
		final String sql = "SELECT * "
				+ "FROM studente s "
				+ "WHERE s.matricola = ?";
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			
			ResultSet rs = st.executeQuery();
			
			rs.first();
			
			int matricoladb = rs.getInt("matricola");
			String nomedb = rs.getString("nome");
			String cognomedb = rs.getString("cognome");
			
			Studente s = new Studente(matricoladb, nomedb, cognomedb);
			
			st.close();
			conn.close();
			
			return s;
			
		} catch(SQLException e) {
			throw new RuntimeException("Error db", e);
		}
		
	}
	
	public List<Corso> getCorsiByStudente(Studente Studente) {
		
		final String sql = "SELECT * "
				+ "FROM corso c, iscrizione i "
				+ "WHERE i.matricola = ? AND i.codins = c.codins";
		
		List<Corso> CorsiStudente = new LinkedList<>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, Studente.getMatricola());
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				String codicedb = rs.getString("codins");
				int creditidb = rs.getInt("crediti");
				String nomedb = rs.getString("nome");
				int pddb = rs.getInt("pd");
				
				CorsiStudente.add(new Corso(codicedb, creditidb, nomedb, pddb));
				
			}
			
			conn.close();
			
			return CorsiStudente;
			
		} catch(SQLException e) {
			throw new RuntimeException("Error db", e);
		}
		
	}
	
}
