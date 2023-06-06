package fr.but.info.sae122.seance3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SaeFx extends Application {

	public static void main(String[] args) {
		launch(args);
	}


	Stage stage;

  @Override
  public void start(Stage primaryStage) {
	  
	this.stage = primaryStage;
	  
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
