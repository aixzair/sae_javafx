package fr.but.info.sae122.seance3;

import fr.but.info.sae122.seance3.model.*;

import javafx.fxml.Initializable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.GridPane;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Canvas canvas;
    @FXML private Pane pane;
    @FXML private ToggleButton calcule;
    @FXML private VBox vbox;
    @FXML private Button rtrFlux;
    @FXML private Button ajtFlux;
    @FXML private Button ameliore;
    @FXML private ComboBox<String> liste1;
    @FXML private ComboBox<String> liste2;
    @FXML private Button augmentingpath;
    @FXML private Button charge;
    @FXML private Button noeud;
    @FXML private Button sauve;
    @FXML private BorderPane borderPane;
    @FXML private Label etat;
    
    private MouseController mouseController;
    private Graph graph;
    private Path path;
    private Stage stage;
   
    
    private HashMap<String, GraphicNode> name;

    public Controller(Stage stage) {
        name = new HashMap<>();
        graph = new Graph();
        this.stage=stage;


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas.heightProperty().bind(pane.heightProperty());
        canvas.widthProperty().bind(pane.widthProperty());
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        name.put("a", new GraphicNode(10, 10, 25, Color.RED));
        name.put("b", new GraphicNode(100, 10, 25, Color.RED));
        name.put("c", new GraphicNode(200, 500, 25, Color.RED));
        graph.addEdge("a", "b", 3);
        graph.addEdge("b", "c", 2);


        vbox.setVisible(false);
        canvas.widthProperty().addListener(observable -> reDraw());
        canvas.heightProperty().addListener(observable -> reDraw());
        if(path == null) ameliore.setDisable(true);
        else ajtFlux.setDisable(false);
        calcule.selectedProperty().addListener(observable -> {
            if(calcule.isSelected()){
                vbox.setVisible(true);
                rtrFlux.setDisable(true);
                if(path == null) ameliore.setDisable(true);
                else ajtFlux.setDisable(false);
            }else{
                vbox.setVisible(false);
                rtrFlux.setDisable(false);
                graph.getEdges().forEach(edge -> edge.setFlow(0));
                if(path != null) path.getPath().forEach(edge -> path.getPath().remove(edge));

                graph.getNodes().forEach(nodes -> liste1.getItems().add(nodes));
                graph.getNodes().forEach(nodes -> liste2.getItems().add(nodes));

                MaxFlowWithoutResidualGraph maxFlow = new MaxFlowWithoutResidualGraph(graph, liste1.getSelectionModel().getSelectedItem(), liste2.getSelectionModel().getSelectedItem());
                path = new AugmentingPath(graph, liste1.getSelectionModel().getSelectedItem(), liste2.getSelectionModel().getSelectedItem());
                augmentingpath.setOnAction(actionEvent -> {
                    path = maxFlow.getAugmentingPath();
                    maxFlow.computeMaxFlow();
                });
            }
        });

        calcule.setSelected(false);


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

    /** Règle le controleur de la souris
	 * @param mouseController
	 */
	public void setMouseController(MouseController mouseController) {
		this.mouseController = mouseController;
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public Label getEtat() {
		return this.etat;
	}
    
    public void reDraw(){
        canvas.getGraphicsContext2D().clearRect(0, 0, pane.getHeight(), pane.getWidth());
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
        double width = radius*2;
        Color color = name.get(s).getColor();

        canvas.getGraphicsContext2D().strokeRoundRect(x1, y1, width, width, radius, radius);
        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
        canvas.getGraphicsContext2D().fillRoundRect(x1, y1, width, width, radius, radius);
        canvas.getGraphicsContext2D().strokeText(s, x1 + radius, y1 + radius);
    }

    public void drawEdge(String source, String fin){
        canvas.getGraphicsContext2D().save();


        double x1 = name.get(source).getX();
        double x2 = name.get(fin).getX();
        double y1 = name.get(source).getY();
        double y2 = name.get(fin).getY();
        double radius = name.get(source).getRadius();

        double res = Math.atan2(y2-y1, x2-x1);

        canvas.getGraphicsContext2D().translate(x1, y1);
        canvas.getGraphicsContext2D().rotate(res);

        canvas.getGraphicsContext2D().strokeLine(0, radius/2,(x2-x1)+10, (y2-y1)+radius/3);
        canvas.getGraphicsContext2D().strokeText(graph.getEdge(source, fin).getFlow() +  "/" +graph.getEdge(source, fin).getCapacity(), (x2-x1)/2, (y2-y1)/2);
        canvas.getGraphicsContext2D().restore();

    }
    
    // ------------ Evènement ------------
    
    /** Evènement à comportement variable.
     * @param event
     */
    public void onMouseMoved(MouseEvent event) {
    	this.mouseController.onMouseMoved(event);
    }
    
    /** Evènement à comportement variable.
     * @param event
     */
    public void onMouseDragged(MouseEvent event) {
    	this.mouseController.onMouseDragged(event);
    }
    
    /** Evènement à comportement variable.
     * @param event
     */
    public void onMousePressed(MouseEvent event) {
    	this.mouseController.onMousePressed(event);
    }
    
    /** Evènement à comportement variable.
     * @param event
     */
    public void onMouseReleased(MouseEvent event) {
    	this.mouseController.onMouseReleased(event);
    }
    
    /** Evènement à comportement variable.
     * @param event
     */
    public void onMouseClicked(MouseEvent event) {
    	this.mouseController.onMouseClicked(event);
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
