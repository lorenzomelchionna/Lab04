package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
	ObservableList<String> CorsiChoiceBox = FXCollections.observableArrayList();
	//Dovrebbe contenere oggetti corso
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choiceCorso;

    @FXML
    private TextField txtMatricola;
    
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextArea txtOutput;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	txtOutput.clear();
    	
    	List<Corso> CorsiStudente = new ArrayList<>();
    	int numeroMatricola;
    	boolean trovata = false;
    	
    	try {
    		numeroMatricola = Integer.parseInt(txtMatricola.getText());
    	} catch(NumberFormatException nfe) {
    		txtOutput.setText("Errore matricola");
    		return;
    	}
    	
    	for(Studente s : model.getTuttiGliStudenti()) 
    		if(s.getMatricola() == numeroMatricola) {
    			CorsiStudente = model.getCorsiByStudente(s);
    			trovata = true;
    		}
    	
    	if(trovata == false) {
    		txtOutput.setText("Matricola non trovata!");
    		return;
    	}
    		
      	for(Corso c : CorsiStudente)
    		txtOutput.appendText(c.toString()+"\n");

    }


    @FXML
    void doCercaIscritti(ActionEvent event) {
    	
    	txtOutput.clear();
    	
    	if(choiceCorso.getValue().equals("") || choiceCorso.getValue() == null) {
    		txtOutput.setText("Devi selezionare un corso!");
    		return;
    	}
    	
    	List<Studente> StudentiIscritti = new ArrayList<>();
    	
    	for(Corso c : model.getTuttiICorsi()) {
    		if(c.getNome().equals(choiceCorso.getValue()))
    			StudentiIscritti = model.getStudentiIscrittiAlCorso(c);
    	}
    	
    	for(Studente s : StudentiIscritti) {
    		txtOutput.appendText(s.toString()+"\n");
    	}
    	
    }
    
    @FXML
    void doCompleta(ActionEvent event) {
    		
    	txtNome.clear();
    	txtCognome.clear();
    	
    	Studente Studente;
    	
    	try{
    		Studente = model.getStudenteByMatricola(Integer.parseInt(txtMatricola.getText()));
    	} catch(NumberFormatException nfe) {
    		throw new RuntimeException("Error input", nfe);
    	}
    	
    	txtNome.setText(Studente.getNome());
    	txtCognome.setText(Studente.getCognome());
    	
    }
    
    @FXML
    void doIscrivi(ActionEvent event) {

    	int matricola;
    	
    	try{
    		matricola = Integer.parseInt(txtMatricola.getText());
    	} catch(NumberFormatException nfe) {
    		throw new RuntimeException("Error input", nfe);
    	}
  
    	for(Corso c : model.getTuttiICorsi()) 
    		if(c.getNome().equals(choiceCorso.getValue())) 
    			for(Studente s : model.getTuttiGliStudenti()) {
    				
    				if(s.getMatricola() == matricola) {
    					
    					if(model.isStudenteIscrittoCorso(s, c))
    						txtOutput.setText("Studente già iscritto a questo corso!");
    					else {
    						
    						model.iscriviStudenteCorso(s, c);
    						txtOutput.setText("Studente iscritto con successo!");
   
    					}
    					
    				}
 
    			}
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    }
    
    void setModel(Model model) {
    	
    	this.model = model;
    	
    	List<Corso> Corsi = model.getTuttiICorsi();
    	
    	CorsiChoiceBox.add("");
    	for(Corso c : Corsi)
        	CorsiChoiceBox.add(c.getNome());
    	
    	choiceCorso.setItems(CorsiChoiceBox);
    	
    }

    @FXML
    void initialize() {
    	
        assert choiceCorso != null : "fx:id=\"choiceCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }
    
}
