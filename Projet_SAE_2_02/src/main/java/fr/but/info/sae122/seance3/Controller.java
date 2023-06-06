package fr.but.info.sae122.seance3;

import fr.but.info.sae122.seance3.model.*;
import fr.but.info.sae122.seance3.model.Edge;
import fr.but.info.sae122.seance3.model.Graph;
import fr.but.info.sae122.seance3.model.GraphIO;
import fr.but.info.sae122.seance3.model.Path;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.fxml.Initializable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
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
import java.util.concurrent.atomic.AtomicReference;

public class Controller implements Initializable {

    @FXML private Canvas canvas;
    @FXML private Pane pane;
    @FXML private ToggleButton calcule;
    @FXML private VBox vbox;
    @FXML private Button rtrFlux;
    @FXML private Button ajtFlux;
    @FXML private Button ameliore;
    @FXML private ComboBox<String> liste1;
    @FXML private ComboBox<String> liste2;
    @FXML private Button augmentingpath;
    @FXML private TextField flotmax;

    @FXML
    private Button charge;

    @FXML
    private Button noeud;



    @FXML
    private Button sauve;


    private Graph graph;
    private Path path;
    private Stage stage;


    private HashMap<String, GraphicNode> name;

    @FXML private Button charge;
    @FXML private Button noeud;
    @FXML private Button sauve;
    @FXML private BorderPane borderPane;
    @FXML private Label etat;
    
    private MouseController mouseController;

    /** Créer un Controller.
     * @param stage
     */
    public Controller(Stage stage) {
        name = new HashMap<>();
        graph = new Graph();
        this.stage=stage;
    }

    /** Initialise le controleur.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas.heightProperty().bind(pane.heightProperty());
        canvas.widthProperty().bind(pane.widthProperty());
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        name.put("a", new GraphicNode(20, 20, 25, Color.BEIGE));
        name.put("b", new GraphicNode(100, 20, 25, Color.BEIGE));
        name.put("c", new GraphicNode(100, 200, 25, Color.BEIGE));
        graph.addEdge("a", "b", 3);
        graph.addEdge("b", "c", 4);
        graph.addEdge("c", "a", 4);


        vbox.setVisible(false);
        calcule.setSelected(false);
        canvas.widthProperty().addListener(observable -> reDraw());
        canvas.heightProperty().addListener(observable -> reDraw());
        if(path == null) ameliore.setDisable(true);
        else ajtFlux.setDisable(false);

        calcule.selectedProperty().addListener(observable -> {
            if(calcule.isSelected()){
                vbox.setVisible(true);
                rtrFlux.setDisable(true);
                vbox.setManaged(true);
                if(path == null) ameliore.setDisable(true);
                else ajtFlux.setDisable(false);
            }else{
                vbox.setVisible(false);
                rtrFlux.setDisable(false);
                vbox.setManaged(false);
            }
        });

        vbox.visibleProperty().addListener(observable -> {
            AtomicReference<MaxFlowWithoutResidualGraph> maxFlow = new AtomicReference<>(prepareCalcul());
            liste1.setOnAction(actionEvent -> maxFlow.set(prepareCalcul()));
            liste2.setOnAction(actionEvent -> maxFlow.set(prepareCalcul()));

            augmentingpath.setOnAction(actionEvent -> {
                name.get(liste1.getSelectionModel().getSelectedItem()).setColor(Color.BLUE);
                name.get(liste2.getSelectionModel().getSelectedItem()).setColor(Color.RED);
                reDraw();
                path = maxFlow.get().getAugmentingPath();
                if(path != null) ameliore.setDisable(false);
                ameliore.setOnMouseClicked(event -> {
                    maxFlow.get().increaseFlow(path);
                    flotmax.setText(String.valueOf(path.getFlow()));
                    path = null;
                    reDraw();
                });
            });
        });

        calcule.setSelected(false);


        Graph graphe = new Graph();

        charge.setOnAction(event -> load());
        sauve.setOnAction(event-> save(graphe));

    }

    public MaxFlowWithoutResidualGraph prepareCalcul(){
        if(liste1.getItems().size() == 0) graph.getNodes().forEach(nodes -> liste1.getItems().add(nodes));
        if(liste2.getItems().size() == 0) graph.getNodes().forEach(nodes -> liste2.getItems().add(nodes));
        graph.getEdges().forEach(edge -> edge.setFlow(0));

        flotmax.setDisable(false);
        flotmax.setText("0");
        return new MaxFlowWithoutResidualGraph(graph,
                liste1.getSelectionModel().getSelectedItem(),
                liste2.getSelectionModel().getSelectedItem());
    }

    public void clearList(ComboBox<String> list){
        list.getItems().forEach(s -> list.getItems().remove(s));
    }

    /** Règle le controleur de la souris
	 * @param mouseController
	 */
	public void setMouseController(MouseController mouseController) {
		this.mouseController = mouseController;
	}
	
	/** Renvoie le canvas avec les éléments
	 * @return canvas
	 */
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	/** Renvoie l'état (partie basse de l'interface)
	 * @return etat
	 */
	public Label getEtat() {
		return this.etat;
	}

	/** Met à jours les éléments du canvas
	 */
    public void reDraw(){
        canvas.getGraphicsContext2D().clearRect(0, 0, pane.getHeight(), pane.getWidth());
       for(String s : graph.getNodes()){
            drawNode(s);
        }
        for(Edge edge : graph.getEdges()){
            drawEdge(edge.getFromNode(), edge.getToNode());
        }
    }

    /** Dessine un noeud.
     * @param nom
     */
    public void drawNode(String s){
        double x1 = name.get(s).getX();
        double y1 = name.get(s).getY();
        double radius = name.get(s).getRadius();
        double width = radius*2;
        Color color = name.get(s).getColor();

        canvas.getGraphicsContext2D().strokeRoundRect(x1, y1, width, width, radius, radius);
        canvas.getGraphicsContext2D().setFill(color);
        canvas.getGraphicsContext2D().fillRoundRect(x1, y1, width, width, radius, radius);
        canvas.getGraphicsContext2D().strokeText(s, x1 + radius, y1 + radius);
    }

    /** Dessine une arrête
     * @param source
     * @param fin
     */
    public void drawEdge(String source, String fin){
        canvas.getGraphicsContext2D().save();


        double x1 = name.get(source).getX();
        double x2 = name.get(fin).getX();
        double y1 = name.get(source).getY();
        double y2 = name.get(fin).getY();
        double radius = name.get(source).getRadius();

        double res = Math.toDegrees(Math.atan2(y2-y1, x2-x1));

        canvas.getGraphicsContext2D().translate(x1, y1);
        canvas.getGraphicsContext2D().rotate(res);

        /*canvas.getGraphicsContext2D().strokeLine(0, radius/2,(x2-x1)+10, (y2-y1)+radius/3);*/
        double formule = (Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2)));
        canvas.getGraphicsContext2D().strokeLine(0, 0, formule, 0);

        canvas.getGraphicsContext2D().strokeText(graph.getEdge(source, fin).getFlow() +  "/" +graph.getEdge(source, fin).getCapacity(), formule, formule);
        canvas.getGraphicsContext2D().restore();

    }
    
    /** Sauvegarde le graphique.
     * @param graphe
     */
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
     
    /** Charge le graphique.
     */
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
}
