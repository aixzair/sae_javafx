package fr.but.info.sae122.seance3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Objects;

import fr.but.info.sae122.seance3.model.Graph;
import fr.but.info.sae122.seance3.model.GraphIO;

public class SaeFx extends Application {

  public static void main(String[] args) {
    launch(args);
  }
  
  Stage stage;

  @Override
  public void start(Stage primaryStage) {
	  
	  this.stage=primaryStage;
	  
    try {
    	
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/saeFX.fxml"));
      Controller controller = new Controller(stage);
      fxmlLoader.setController(controller);
      Scene scene = new Scene(fxmlLoader.load());
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    
    
  
    
  }
  
  
		 

	  
  
  

  
}
