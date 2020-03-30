package it.polito.tdp.spellchecker;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.spellchecker.FXMLController;
import it.polito.tdp.spellchecker.model.Dictonary;
import it.polito.tdp.spellchecker.model.Dictonary2;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	//Dictonary dictonary=new Dictonary();		Per testare il secondo esercizio
    	Dictonary2 d2=new Dictonary2();
    	FXMLController controller;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
    	
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	
    	controller=loader.getController();
    	//controller.setDictonary(dictonary); 	Per testare il secondo esercizio
    	controller.setDictonary2(d2);
    	        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
