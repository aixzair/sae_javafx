package fr.but.info.sae122.seance3;

import fr.but.info.sae122.seance3.model.Graph;
import fr.but.info.sae122.seance3.model.Path;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Canvas canvas;
    @FXML private BorderPane borderPane;

    private Graph graph;
    private Path path;

    private HashMap<String, GraphicNode> name;

    public Controller() {
        name = new HashMap<>();
        graph = new Graph();
        graph.addNode("aa");
        graph.getNodes().forEach(s -> name.put(s, new GraphicNode()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas.heightProperty().bind(borderPane.heightProperty());
        canvas.widthProperty().bind(borderPane.widthProperty());

        canvas.widthProperty().addListener(observable -> reDraw());
        canvas.heightProperty().addListener(observable -> reDraw());
    }

    public void reDraw(){
        for(String s : graph.getNodes()){
            drawNode(s);
        }
    }

    public void drawNode(String s){
        canvas.getGraphicsContext2D().strokeRoundRect(name.get(s).getX(), name.get(s).getY(), name.get(s).getRadius(), name.get(s).getRadius(), 0, 0);
        canvas.getGraphicsContext2D().fillRoundRect(name.get(s).getX(), name.get(s).getY(), name.get(s).getRadius(), name.get(s).getRadius(), 0, 0);
        canvas.getGraphicsContext2D().strokeText(s, name.get(s).getX(), name.get(s).getY());
    }

    public void drawEdge(String source, String fin){
        save();
        canvas.getGraphicsContext2D().translate(name.get(s).getX(), name.get(s).getY());
        Math.atan2();
    }
}
