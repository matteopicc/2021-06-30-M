/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.genes;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.genes.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnContaArchi"
    private Button btnContaArchi; // Value injected by FXMLLoader

    @FXML // fx:id="btnRicerca"
    private Button btnRicerca; // Value injected by FXMLLoader

    @FXML // fx:id="txtSoglia"
    private TextField txtSoglia; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doContaArchi(ActionEvent event) {
    	txtResult.clear();
    	double soglia;
    	try {
            soglia = Double.parseDouble(txtSoglia.getText());
    		if(soglia > this.model.getPmax() || soglia < this.model.getPmin()) {
    			txtResult.appendText("VALORE SOGLIA NON CONFROME ALLE SPECIFICHE\n");
    			return;
    		}
    		this.model.creaGrafo();
    		txtResult.appendText("GRAFO CREATO!!\n");
        	txtResult.appendText("#VERTICI: " +this.model.getnVertici()+"\n");
        	txtResult.appendText("#VERTICI: " +this.model.getnArchi()+"\n");
        	txtResult.appendText("#PESO MASSIMO RISCONTRATO: " +this.model.getPmax()+"\n");
        	txtResult.appendText("#PESO MINIMO RISCONTRATO: " +this.model.getPmin()+"\n");
    		txtResult.appendText("NEL GRAFO CREATO VI SONO "+this.model.nSU(soglia)+" ARCHI CON PESO MAGGIORE\n");
    		txtResult.appendText("NEL GRAFO CREATO VI SONO "+this.model.nGIU(soglia)+" ARCHI CON PESO MINORE\n");
    	}
    	catch(NumberFormatException e) {
    	this.model.creaGrafo();
    	txtResult.appendText("GRAFO CREATO!!\n");
    	txtResult.appendText("#VERTICI: " +this.model.getnVertici()+"\n");
    	txtResult.appendText("#VERTICI: " +this.model.getnArchi()+"\n");
    	txtResult.appendText("#PESO MASSIMO RISCONTRATO: " +this.model.getPmax()+"\n");
    	txtResult.appendText("#PESO MINIMO RISCONTRATO: " +this.model.getPmin()+"\n");
    	
    	}
    }

    @FXML
    void doRicerca(ActionEvent event) {
    	if(this.model.grafoCreato() == false) {
    		txtResult.appendText("NECESSARIO CREARE PRIMA IL GRAFICO PER ACCEDERE A QUESTA FUNZIONE!!\n");
    	}
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnContaArchi != null : "fx:id=\"btnContaArchi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSoglia != null : "fx:id=\"txtSoglia\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model ;
		
	}
}
