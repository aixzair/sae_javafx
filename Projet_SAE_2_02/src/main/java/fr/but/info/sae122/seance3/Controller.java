package fr.but.info.sae122.seance3;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import fr.but.info.sae122.seance3.model.*;
import fr.but.info.sae122.seance3.model.Edge;
import fr.but.info.sae122.seance3.model.Graph;
import fr.but.info.sae122.seance3.model.GraphIO;
import fr.but.info.sae122.seance3.model.Path;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;

import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Label;
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
import java.lang.annotation.Target;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
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
    

    @FXML private BorderPane borderPane;
    @FXML private Label etat;
    private MouseController mouseController;

    protected int btToggle;
    private String nd1;
    private String nd2;
    private double radius;
    /** Créer un Controller.

     * @param stage
     */
    
    public Controller(Stage stage) {
        name = new HashMap<>();
        graph = new Graph();
        this.stage=stage;
    }

    /**
     * Initializes the controller, every parameters needed to display the view

     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mouseController = new IdleMouseController(this);

        canvas.heightProperty().bind(pane.heightProperty());
        canvas.widthProperty().bind(pane.widthProperty());

        calcule.setSelected(false);
        vbox.setDisable(true);
        vbox.setVisible(false);
        canvas.widthProperty().addListener(observable -> reDraw());
        canvas.heightProperty().addListener(observable -> reDraw());
        if(path == null) ameliore.setDisable(true);
        else ajtFlux.setDisable(false);

        calcule.selectedProperty().addListener(observable -> {
            if(calcule.isSelected()){
                vbox.setVisible(true);
                vbox.setDisable(false);
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
                try{
                    name.get(liste1.getSelectionModel().getSelectedItem()).setColor(Color.CORAL);
                    name.get(liste2.getSelectionModel().getSelectedItem()).setColor(Color.AQUA);
                    reDraw();
                    path = maxFlow.get().getAugmentingPath();
                    if(path != null) ameliore.setDisable(false);
                    for(Edge edge : path.getPath()){
                        canvas.getGraphicsContext2D().setStroke(Color.CYAN);
                        drawEdge(edge.getFromNode(), edge.getToNode());
                    }
                    canvas.getGraphicsContext2D().setStroke(Color.BLACK);

                    ameliore.setOnMouseClicked(event -> {
                        maxFlow.get().increaseFlow(path);
                        flotmax.setText(String.valueOf(path.getFlow()));
                        reDraw();
                        for(Edge edge : path.getPath()){
                            canvas.getGraphicsContext2D().setStroke(Color.CYAN);
                            drawEdge(edge.getFromNode(), edge.getToNode());
                        }
                        canvas.getGraphicsContext2D().setStroke(Color.BLACK);
                        path = null;
                        if(path != null) ameliore.setDisable(false);
                        else ameliore.setDisable(true);
                    });
                }catch (NoSuchElementException e){
                    Alert alert = new Alert(AlertType.ERROR, "No much more augmenting path");
                    alert.showAndWait();
                }
            });
        });

        calcule.setSelected(false);

        Graph graphe = new Graph();
       

        charge.setOnAction(event -> load());
        
        sauve.setOnAction(event-> save(graphe));

	    canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onMouseClicked);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::onMouseDragged);
        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, this::onMouseMoved);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, this::onMouseReleased);
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onMousePressed);
    }

    /**
     * Enables the resize of the draw while the maximizing or the minimizing of the window
     */

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

    /**
     * Clear the ComboxBox
     * @param list the combo box that it need to be clear
     * */
    public void clearList(ComboBox<String> list){
        list.getItems().forEach(s -> list.getItems().remove(s));
    }

    /** Sets the mouseController
	 * @param mouseController the controller that it need to be
	 */
	public void setMouseController(MouseController mouseController) {
		this.mouseController = mouseController;
	}

	
	/** Gets the canvas with all the elements
	 * @return canvas the canvas
	 */
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	/** Gets the status (partie basse de l'interface)
	 * @return etat the bar at the bottom
	 */
	public Label getEtat() {
		return this.etat;
	}

	/** Updates canvas' elements
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
    
    /**
     * Draws a node on the canvas
     * @param s is the name of the node
     */
    public void drawNode(String s){
        double x1 = name.get(s).getX();
        double y1 = name.get(s).getY();
        double radius = name.get(s).getRadius();
        double width = radius*2;
        Color color = name.get(s).getColor();
        this.radius = width;

        canvas.getGraphicsContext2D().strokeRoundRect(x1, y1, width, width, radius, radius);
        canvas.getGraphicsContext2D().setFill(color);
        canvas.getGraphicsContext2D().fillRoundRect(x1, y1, width, width, radius, radius);
        canvas.getGraphicsContext2D().strokeText(s, x1 + radius, y1 + radius);
    }

    /**
     * Draws an edge from the source to the sink(fin) on the canvas
     * @param source from which node we start
     * @param fin from which node we finish
     */
    public void drawEdge(String source, String fin){
    	
        canvas.getGraphicsContext2D().save();


        double x1 = name.get(source).getX();
        double x2 = name.get(fin).getX();
        double y1 = name.get(source).getY();
        double y2 = name.get(fin).getY();
        double radius = name.get(source).getRadius();

        double res = Math.toDegrees(Math.atan2(y2-y1, x2-x1));

        canvas.getGraphicsContext2D().translate(x1 +radius, y1 + radius);
        canvas.getGraphicsContext2D().rotate(res);


        canvas.getGraphicsContext2D().strokeLine(0,0,Math.sqrt(Math.pow((y2-y1),2)+Math.pow((x2-x1),2)),0);
        
        canvas.getGraphicsContext2D().setStroke(Color.RED);
        canvas.getGraphicsContext2D().setLineWidth(2);
        
        canvas.getGraphicsContext2D().strokeLine(Math.sqrt(Math.pow((y2-y1),2)+2+Math.pow((x2-x1),2)),0,Math.sqrt(Math.pow((y2-y1),2)+Math.pow((x2-x1),2)),-10); 
        canvas.getGraphicsContext2D().strokeLine(Math.sqrt(Math.pow((y2-y1),2)+Math.pow((x2-x1),2)),0,Math.sqrt(Math.pow((y2-y1),2)+Math.pow((x2-x1),2))-5,+5);
        
        canvas.getGraphicsContext2D().setStroke(Color.BLACK);
        canvas.getGraphicsContext2D().setLineWidth(1);
        
        canvas.getGraphicsContext2D().strokeText(graph.getEdge(source, fin).getFlow() +  "/" +graph.getEdge(source, fin).getCapacity(), (radius), (radius));
        
        canvas.getGraphicsContext2D().restore();

    }
	
    public void noeud()
    {
    	btToggle = 1;
		this.getCanvas().setCursor(Cursor.CROSSHAIR);
		
    }
	
    public void ajtFlux()
    {
    	btToggle = 2;
		this.getCanvas().setCursor(Cursor.CROSSHAIR);
    }
	
    public void rtrFlux()
    {
    	btToggle = 3;
		this.getCanvas().setCursor(Cursor.CROSSHAIR);
    }
	
	public Graph getGraph()
	{
		return this.graph;
	}
	
	public HashMap<String, GraphicNode> getName()
	{
		return this.name;
	}
    /**
     * Saves a graph on the disk
     * @param graphe wanted to be save
     * 
     */
   
    public void save(Graph graphe) {
  	  
     	 FileChooser fileChooser = new FileChooser();
     	 fileChooser.setTitle("Save as");
     	 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("txt", "*.txt"));
     	 
     	 File file = fileChooser.showSaveDialog(stage);
     	 
     	 
     	 OutputStream fileStream;
   	try {
   		fileStream = new FileOutputStream(file);
   	  	 GraphIO.write(graph,fileStream);
   	} catch (NullPointerException | FileNotFoundException e) {
   		// TODO Auto-generated catch block
   		Alert alert =new Alert(AlertType.ERROR,"Problems during saving...");
   		alert.showAndWait();
   		
   	}
     	   }
     
    /**
     * Loads a graph from the disk and displays it
     *  
     */

     public void load() {
   	  	
         canvas.getGraphicsContext2D().clearRect(0, 0, pane.getHeight(), pane.getWidth());

    	
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
   	  	} catch(NullPointerException | FileNotFoundException e){
   			Alert alert =new Alert(AlertType.ERROR,"Problems during loading...");
   			alert.showAndWait();
   	  	}

   	  	
   	  	ArrayList<GraphicNode> list= new ArrayList<GraphicNode>();
   	  	
   	  	int x=0;
   	  	int y=20;
   	  	double rad = 30;
   	  	Color color= Color.ALICEBLUE;
   	  	String temporaire=null;
   	  	
   	  	GridPane pane = new GridPane();
   	  	
   	  	for(String s : graph.getNodes()) {
   	  		
   	  		
   	  		name.put(s,new GraphicNode(x,y,rad,color));
   	  		
   	  		//GraphicNode node = new GraphicNode(x,y,rad,color);
   	  		drawNode(s);
   	  		
   	  		x=x+75;
   	  		if(temporaire!=null){
   	  			drawEdge(temporaire,s);
   	  		}
   	  		temporaire=s;
   	  		if (name.size()%5==0) {
   	  			x=0;
   	  			y+=100;
   	  		}
   	  		}
    }

     // ------------ Event ------------
     
     /** Variable behavior event
      * @param event
      */
     public void onMouseMoved(MouseEvent event) {
     	this.mouseController.onMouseMoved(event);
     }
     
     /** Variable behavior event
      * @param event
      */
     public void onMouseDragged(MouseEvent event) {
         setMouseController(new DragMouseController(this));
     	this.mouseController.onMouseDragged(event);
     }
     
     /** Variable behavior event
      * @param event
      */
     public void onMousePressed(MouseEvent event) {
     	this.mouseController.onMousePressed(event);
     }
     
     /** Variable behavior event
      * @param event
      */
     public void onMouseReleased(MouseEvent event) {
     	this.mouseController.onMouseReleased(event);
     }
     
     /** Variable behavior event
      * @param event
      */
     public void onMouseClicked(MouseEvent event) {//this.getCanvas().setCursor(Cursor.CROSSHAIR);
 		if( this.btToggle == 1)
 		{
 			setMouseController(new PlaceMouseController(this));
 			mouseController.onMousePressed(event);
 		}
 		if(this.btToggle == 2)
 		{
 			//this.getCanvas().setCursor(Cursor.CROSSHAIR);
 			setMouseController(new LinkMouseController(this, true));
 			double x = event.getX();
 			double y = event.getY();

 			this.getEtat().setText("Cliquez sur le noeud source");
 			if(nd1 == null)
 			{
	 			name.forEach((t, u) ->{
	 				double z = Math.abs((u.getX() -x)) + Math.abs((u.getY() -y)); 
	 				if( z < 2*radius) {
	 					nd1 = t;
	 				}
	 			});
	 			
 			}
 			else if(nd2 == null)
 			{
 				this.getEtat().setText("Cliquez sur le noeud source");
 				name.forEach((t, u) ->{
 					double z = Math.abs((u.getX() -x)) + Math.abs((u.getY() -y)); 
	 				if(z < 2*radius) {
	 					nd2 = t;
	 				}
	 			});
 				
 			}
 			this.mouseController.onMousePressed(event);
 		}
 		if(this.btToggle == 3)
 		{
 			
 			//this.getCanvas().setCursor(Cursor.CROSSHAIR);
 			setMouseController(new LinkMouseController(this, false));
 			double x = event.getX();
 			double y = event.getY();

 			this.getEtat().setText("Cliquez sur le noeud source");
 			if(nd1 == null)
 			{
	 			name.forEach((t, u) ->{
	 				double z = Math.abs((u.getX() -x)) + Math.abs((u.getY() -y)); 
	 				if( z < 1.5*radius) {
	 					nd1 = t;
	 				}
	 			});
	 			
 			}
 			else if(nd2 == null)
 			{
 				this.getEtat().setText("Cliquez sur le noeud source");
 				name.forEach((t, u) ->{
 					double z = Math.abs((u.getX() -x)) + Math.abs((u.getY() -y)); 
	 				if(z < 1.5*radius) {
	 					nd2 = t;
	 				}
	 			});
 				
 			}
 			this.mouseController.onMousePressed(event);

 		}
     }
     
     public String getNd1() {
    	 return nd1;
     }
     public String getNd2() {
    	 return nd2;
     }

    public void setNd1(String nd1) {
        this.nd1 = nd1;
    }

    public void setNd2(String nd2) {
        this.nd2 = nd2;
    }
}
