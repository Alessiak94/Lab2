package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.*;

import it.polito.tdp.spellchecker.model.*;
import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SpellCheckerController {
	private Dictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLingua;

    @FXML
    private TextArea txtTesto;

    @FXML
    private TextArea txtCorrezione;
    
    @FXML
    private TextFlow txtProva;

    @FXML
    private Label lblErrori;

    @FXML
    private Label lblTempo;

    @FXML
    void doClearText(ActionEvent event) {
    	
    	txtCorrezione.clear();
    	txtTesto.clear();
    	lblErrori.setText("");
    	lblTempo.setText("");

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	long inizio=System.currentTimeMillis();
    	txtCorrezione.clear();
    	selezionaDizionario();
    	txtCorrezione.setText(confrontaTesto(txtTesto.getText().toLowerCase()).toString());
		if(txtCorrezione.getText().length()!=0)
			lblErrori.setText("Il testo contiene errori!");
		else lblErrori.setText("Testo scritto correttamente!");
		long fine=System.currentTimeMillis();
		double tempo=(fine-inizio)*0.0001;
		lblTempo.setText("Testo controllato in "+tempo+" s");

    }
    public void selezionaDizionario(){
    	if(cmbLingua.getValue().compareTo("Italiano")==0)
    		model=new ItalianDictionary();
    	if(cmbLingua.getValue().compareTo("English")==0)
    		model=new EnglishDictionary();
    	model.loadDictionary();
    }
    
    public List<RichWord> confrontaTesto(String testo){
    	List<String> lista= new LinkedList<String>();
    	String txt=testo.replaceAll("\n", " ");
    	String[] a=txt.split(" ");
    	for(int i=0;i<a.length;i++)
    	  lista.add(a[i]);
    	return model.ricercaDicotomica(lista);
    	
    }
    
    

    public void setModel(Dictionary model){
    	this.model=model;
    }
    
    
    @FXML
    void initialize() {
        assert cmbLingua != null : "fx:id=\"cmbLingua\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtCorrezione != null : "fx:id=\"txtCorrezione\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblErrori != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTempo != null : "fx:id=\"lblTempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        cmbLingua.getItems().addAll("Italiano","English");
        cmbLingua.setValue("Italiano");
        
        
    }
}
