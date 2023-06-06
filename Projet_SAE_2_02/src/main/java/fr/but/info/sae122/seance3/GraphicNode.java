package fr.but.info.sae122.seance3;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class GraphicNode {

    private SimpleDoubleProperty propertyX;
    private SimpleDoubleProperty propertyY;
    private SimpleDoubleProperty radius;
    private SimpleObjectProperty<Color> color;


    public GraphicNode(double x, double y, double radius, Color color) {
        propertyX = new SimpleDoubleProperty(x);
        propertyY = new SimpleDoubleProperty(y);
        this.radius = new SimpleDoubleProperty(radius);
        this.color = new SimpleObjectProperty<>(color);

    }

    public double getX() {
        return propertyX.get();
    }

    public SimpleDoubleProperty propertyXProperty() {
        return propertyX;
    }

    public double getY() {
        return propertyY.get();
    }

    public SimpleDoubleProperty propertyYProperty() {
        return propertyY;
    }

    public double getRadius() {
        return radius.get();
    }

    public SimpleDoubleProperty radiusProperty() {
        return radius;
    }

    public Color getColor() {
        return color.get();
    }

    public SimpleObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }
}
