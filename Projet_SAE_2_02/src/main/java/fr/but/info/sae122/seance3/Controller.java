package fr.but.info.sae122.seance3;

import fr.but.info.sae122.seance3.model.Edge;
import fr.but.info.sae122.seance3.model.Graph;
import fr.but.info.sae122.seance3.model.Path;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.io.File;
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

        graph.getNodes().forEach(s -> name.put(s, new GraphicNode(100, 10, 50, Color.RED)));

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
}
