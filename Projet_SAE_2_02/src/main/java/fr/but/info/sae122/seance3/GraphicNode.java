package fr.but.info.sae122.seance3;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class GraphicNode {

    private SimpleDoubleProperty propertyX;
    private SimpleDoubleProperty propertyY;
    private SimpleDoubleProperty radius;
    private SimpleObjectProperty<Color> color;

    /** Créer un noeud.
     * @param x
     * @param y
     * @param radius (coins)
     * @param color
     */
    public GraphicNode(double x, double y, double radius, Color color) {
        propertyX = new SimpleDoubleProperty(x);
        propertyY = new SimpleDoubleProperty(y);
        this.radius = new SimpleDoubleProperty(radius);
        this.color = new SimpleObjectProperty<>(color);
    }

    /**
     * Gets the wrapped value of property X of the graphic node
     * @return the coordinate X
     */
    public double getX() {
        return propertyX.get();
    }
    
    /**
     * Gets the X property of the graphic node 
     * @return the X property
     */

    public SimpleDoubleProperty propertyXProperty() {
        return propertyX;
    }

    /**
     * Gets the wrapped value of property Y of the graphic node
     * @return the coordinate Y
     */

    public double getY() {
        return propertyY.get();
    }

    /**
     * Gets the property Y of the graphic node 
     * @return the Y property
     */
    
    public SimpleDoubleProperty propertyYProperty() {
        return propertyY;
    }
 

    /** Gets the wrapped value of the radius
     * @return the radius value
     */
    public double getRadius() {
        return radius.get();
    }
    
    /**
     * Gets the radius property
     * @return the radius property
     */

    public SimpleDoubleProperty radiusProperty() {
        return radius;
    }
    
    /**
     * Gets the wrapped color value of the graphic node
     * @return the wrapped color value
     */

    public Color getColor() {
        return color.get();
    }

    /**
     * the color property of the graphic node
     * @return SimpleObjectProperty<Color> the color property
     */
    public SimpleObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }
    /** Changes coordinates
     * @param X is the value by which we want to set X property
     * @param Y is the value by which we want to set Y property
     */
    public void setXY(double X, double Y) {
    	this.propertyX.set(X);
    	this.propertyY.set(Y);
    }
}
