package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choiceBoxLanguage;

    @FXML
    private TextArea txtInsert;

    @FXML
    private Button btnSpell;
    
    @FXML
    private TextArea txtResult;

    @FXML
    private Text txtError;

    @FXML
    private Button btnClear;

    @FXML
    private Text txtTime;
    
    private Dictonary dictonary;
    private Dictonary2 d2;

    @FXML
    void doClearText(ActionEvent event) {
    	this.txtResult.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	//this.dictonary.loadDictonary(this.choiceBoxLanguage.getValue());	// Commentato per svolgere es 2
    	this.d2.loadDictonary(this.choiceBoxLanguage.getValue());
    	
    	List<RichWord> result=new LinkedList<RichWord>();
    	int k=0;
    	String arr[]=this.txtInsert.getText().split(" ");
    	List<String> lTemp=new LinkedList<String>();
    	for(String s:arr)
    		lTemp.add(s);
    	
    	result=this.d2.spellCheckTextLinear(lTemp);
    	
    	for(RichWord r:result) {
    		if(!r.isCorrect()) {
    			this.txtResult.appendText(r.getWord()+"\n");
    			k++;
    		}
    	}
    	
    	if(k>0) {
    		if(k>1)
    			this.txtError.setText("The text contains "+k+" errors");
    		else
    			this.txtError.setText("The text contains "+k+" error");
    	}
    	else
    		this.txtError.setText("The text doesn't contains errors");
    	
    	this.txtTime.setText("Spellcheck completed in "+System.nanoTime()*0.000000000000001+" seconds");
    	this.txtInsert.clear();
    }
    
    public void setDictonary(Dictonary d) {
    	this.dictonary=d;
    }
    
    public void setDictonary2(Dictonary2 d2) {
    	this.d2=d2;
    }

    @FXML
    void initialize() {
        assert choiceBoxLanguage != null : "fx:id=\"choiceBoxLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

        ObservableList<String> list=FXCollections.observableArrayList();
        list.addAll("English", "Italian");
        choiceBoxLanguage.setItems(list);
        choiceBoxLanguage.setValue("Italian");
    }
}

