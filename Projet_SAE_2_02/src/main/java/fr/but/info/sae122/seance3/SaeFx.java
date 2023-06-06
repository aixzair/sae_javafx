package fr.but.info.sae122.seance3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SaeFx extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/saeFX.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
