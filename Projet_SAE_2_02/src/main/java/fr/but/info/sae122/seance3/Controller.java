package fr.but.info.sae122.seance3;

import fr.but.info.sae122.seance3.model.Edge;
import fr.but.info.sae122.seance3.model.Graph;
import fr.but.info.sae122.seance3.model.GraphIO;
import fr.but.info.sae122.seance3.model.Path;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.JFrame;

public class Controller implements Initializable {

    @FXML
    Canvas canvas;
    @FXML private BorderPane borderPane;
    
    @FXML
    private Button charge;

    @FXML
    private Button noeud;

    @FXML
    private Button ajtFlux;

    @FXML
    private Button rtrFlux;

    @FXML
    private Button sauve;

    @FXML
    private ToggleButton calcule;

    private Graph graph;
    private Path path;
    private Stage stage;
   
    
    private HashMap<String, GraphicNode> name;

    public Controller(Stage stage) {
        name = new HashMap<>();
        graph = new Graph();
        graph.addNode("aa");
        this.stage=stage;

        graph.getNodes().forEach(s -> name.put(s, new GraphicNode(100, 100, 50, Color.RED)));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //canvas.heightProperty().bind(borderPane.heightProperty());
        //canvas.widthProperty().bind(borderPane.widthProperty()); // changer BORDERPANE EN PANE

        canvas.widthProperty().addListener(observable -> reDraw());
        canvas.heightProperty().addListener(observable -> reDraw());
        
        Graph graphe = new Graph();
        
        charge.setOnAction(event -> load());
        sauve.setOnAction(event-> save(graphe));
       
        
        
        
        
        graphe.addNode("A");
        graphe.addNode("B");
        graphe.addEdge("A","B", 0);
        graphe.addNode("C");
        graphe.addEdge("B","C", 0);
        graphe.addNode("D");
        graphe.addEdge("C","D", 0);
        graphe.addNode("E");
        graphe.addEdge("D","E", 0);
        graphe.addNode("F");
        graphe.addEdge("E","F", 0);

      
    }

   
    
    public void reDraw(){
       for(String s : graph.getNodes()){
            drawNode(s);
        }
        for(Edge edge : graph.getEdges()){
            drawEdge(edge.getFromNode(), edge.getToNode());
        }
    }

    public void drawNode(String s){
        double x1 = name.get(s).getX();
        double y1 = name.get(s).getY();
        double radius = name.get(s).getRadius();
        Color color = name.get(s).getColor();

        canvas.getGraphicsContext2D().setFill(color);
        canvas.getGraphicsContext2D().strokeRoundRect(x1, y1, radius, radius, 8, 8);
        canvas.getGraphicsContext2D().fillRoundRect(x1, y1, radius, radius, 8, 8);
        canvas.getGraphicsContext2D().strokeText(s, name.get(s).getX() + radius/2-9, name.get(s).getY() + radius/2+5);
    }

    public void drawEdge(String source, String fin){


        double x1 = name.get(source).getX();
        double x2 = name.get(fin).getX();
        double y1 = name.get(source).getY();
        double y2 = name.get(fin).getY();
        canvas.getGraphicsContext2D().translate(x1, y1);

        double res = Math.toDegrees(Math.atan2(y2-y1, x2-x1));
        canvas.getGraphicsContext2D().rotate(res);
        canvas.getGraphicsContext2D().beginPath();
        canvas.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
        canvas.getGraphicsContext2D().strokeText(graph.getEdge(source, fin).toString(), x2-x1, y2-y1);

    }
   
    public void save(Graph graphe) {
  	  
     	 FileChooser fileChooser = new FileChooser();
     	 fileChooser.setTitle("Save as");
     	 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("txt", "*.txt"));
     	 
     	 File file = fileChooser.showSaveDialog(stage);
     	 
     	 
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
     
     public void load() {
   	  
   	  	 FileChooser fileChooser = new FileChooser();
   	  	 fileChooser.setTitle("Open");
   	  	 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("txt", "*.txt"));
   	  	 
   	  	 File file = fileChooser.showOpenDialog(stage);
   	  	 
   	  	 
   	  	 
   	  	 InputStream fileStream;
   	  	
   	  	try {
   		  		
   			fileStream = new FileInputStream(file);
   			try {
   				graph = GraphIO.read(fileStream);
   			} catch (IOException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   	  	} catch(FileNotFoundException e){
   			Alert alert =new Alert(AlertType.ERROR,"Problems during loading...");
   			alert.showAndWait();
   	  	}
   	  	System.out.println(graph);
   	  	
   	  	ArrayList<GraphicNode> list= new ArrayList<GraphicNode>();
   	  	
   	  	int x=0;
   	  	int y=0;
   	  	double rad = 30;
   	  	Color color= Color.ALICEBLUE;
   	  	String temporaire=null;
   	  	
   	  	GridPane pane = new GridPane();
   	  	
   	  	for(String s : graph.getNodes()) {
   	  		
   	  		
   	  		name.put(s,new GraphicNode(x,y,rad,color));
   	  		
   	  		//GraphicNode node = new GraphicNode(x,y,rad,color);
   	  		drawNode(s);
   	  		
   	  		x=x+50;
   	  		if(temporaire!=null){
   	  			drawEdge(temporaire,s);
   	  		}
   	  		temporaire=s;
   	  		if (name.size()%5==0) {
   	  			x=0;
   	  			y+=50;
   	  		}
   	  		
   	  		
   	    	  
   	  		}
   	  	
   	  	
   	  	
   		}
}
