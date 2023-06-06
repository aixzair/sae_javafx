package fr.but.info.sae122.seance3;

import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

/**
 * @author Alexandre Lerosier
 */
public class IdleMouseController
extends MouseController {

	/** Créer une instance avec un Controller
	 * @param controleur
	 */
	public IdleMouseController(Controller _controleur) {
		super(_controleur);
	}
	
	/** Affiche rien et règle le curseur à "DEFAULT".
	 * @param event
	 */
	public void onMouseMoved(MouseEvent event) {
		super.controller.getCanvas().getGraphicsContext2D().strokeText(
			null,
			event.getX(),
			event.getY()
		);
		super.controller.getCanvas().setCursor(Cursor.DEFAULT);
	}
	
	/** Active le contrôleur de déplacement et régle le curseur à "CLOSED_HAND".
	 * @param event
	 */
	public void onMousePressed(MouseEvent event){
		super.controller.setMouseController(new DragMouseController(
			super.controller,
			"Déposez le noeud où vous voulez..."
		));
		super.controller.getCanvas().setCursor(Cursor.CLOSED_HAND);
	}
	
	/** Ne fait rien.
	 */
	public void onMouseDragged(MouseEvent event){
		// Vide.
	}
	
	/** Ne fait rien.
	 */
	public void onMouseReleased(MouseEvent event) {
		// Vide.
	}
	
	/** Ne fait rien.
	 */
	public void onMouseClicked(MouseEvent event) {
		// Vide.
	}
}
