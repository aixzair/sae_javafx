package fr.but.info.sae122.seance3;

import java.awt.event.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.canvas.*;

/**
 * @author Alexandre Lerosier
 */
public class IdleMouseController
extends MouseController {
	private final MouseController controleur;
	private @FXML Canvas canvas;

	public IdleMouseController(MouseController _controleur) {
		this.controleur = _controleur;
	}
	
	/** Affiche rien et règle le curseur à "DEFAULT".
	 * @param MouseEvent event
	 */
	public void onMouseMoved(MouseEvent event) {
		/*this.canvas.getGraphicsContext2D().strokeText(
			null,
			event.getX(),
			event.getY()
		);
		this.canvas.setCursor(Cursor.DEFAULT);*/
	}
	
	public void onMouseDragged(MouseEvent event){
		// Vide.
	}
	
	/** Active le contrôleur de déplacement et régle le curseur à "CLOSED_HAND".
	 * @param MouseEvent event
	 */
	public void onMousePressed(MouseEvent event){
		
		//this.controleur.set DragMouseController(“Déposez le noeud où vous voulez...”);
		// this.controleur.canvas.setCursor(Cursor.CLOSED_HAND);
	}
	
	public void onMouseReleased(MouseEvent event) {
		// Vide.
	}
	
	public void onMouseClicked(MouseEvent event) {
		// Vide.
	}
}
