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
     * @param couleur
     */
    public GraphicNode(double x, double y, double radius, Color color) {
        propertyX = new SimpleDoubleProperty(x);
        propertyY = new SimpleDoubleProperty(y);
        this.radius = new SimpleDoubleProperty(radius);
        this.color = new SimpleObjectProperty<>(color);
    }

    /** Renvoie la coordonnée X
     * @return X
     */
    public double getX() {
        return propertyX.get();
    }

    /** Renvoie la propertée X
     * @return propertyX
     */
    public SimpleDoubleProperty propertyXProperty() {
        return propertyX;
    }

    /** Renvoie la coordonnée Y
     * @return Y
     */
    public double getY() {
        return propertyY.get();
    }

    /** Renvoie la propertée Y
     * @return propertyY
     */
    public SimpleDoubleProperty propertyYProperty() {
        return propertyY;
    }

    /** Renvoie la propertée Y
     * @return propertyY
     */
    public double getRadius() {
        return radius.get();
    }

    /** Renvoie le radius
     * @return radius
     */
    public SimpleDoubleProperty radiusProperty() {
        return radius;
    }

    /** Renvoie la couleur
     * @return color
     */
    public Color getColor() {
        return color.get();
    }

    /** Renvoie la propertée couleur
     * @return SimpleObjectProperty<Color>
     */
    public SimpleObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }
    /** Change les coordonnées
     * @param X
     * @param Y
     */
    public void setXY(double X, double Y) {
    	this.propertyX.set(X);
    	this.propertyY.set(Y);
    }
}
