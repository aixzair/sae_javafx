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
      Scene scene = new Scene(fxmlLoader.load());
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    Graph graphe = new Graph();
   
    graphe.addNode("A");
    graphe.addNode("B");
    graphe.addEdge("A","B", 0);
    
    save(graphe);
    
  
    
  }
  
  public void save(Graph graphe) {
	  
  	 FileChooser fileChooser = new FileChooser();
  	 fileChooser.setTitle("Save as");
  	 
  	 File file = fileChooser.showSaveDialog(stage);
  	 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
  	 
  	 OutputStream fileStream;
	try {
		fileStream = new FileOutputStream(file);
	  	 GraphIO.write(graphe,fileStream);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		Alert alert =new Alert(AlertType.ERROR,"Problems during saving...");
		alert.showAndWait();
		
	}
	 

  	   }
  
  public void load(Graph graphe) {
	  
	  	 FileChooser fileChooser = new FileChooser();
	  	 fileChooser.setTitle("Open");
	  	 
	  	 File file = fileChooser.showOpenDialog(stage);
	  	 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
	  	 
	  	InputStream fileStream;
	  	
	  	try {
		  		
			fileStream = new FileInputStream(file);
			try {
				GraphIO.read(fileStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	} catch(FileNotFoundException e){
			Alert alert =new Alert(AlertType.ERROR,"Problems during loading...");
			alert.showAndWait();
	  	}
	  	System.out.println(graphe);
	  	
	  	ArrayList<GraphicNode> list= new ArrayList<GraphicNode>();
	  	
	  	int x=0;
	  	int y=0;
	  	double rad = 5;
	  	Color color= Color.ALICEBLUE;
	  	
	  	for(String s : graphe.getNodes()) {
	  		
	  		
	  		list.add(new GraphicNode(x,y,rad,color));
	  		
	  	}
	  	
	  	

		}
		 

	  
  
  

  
}
