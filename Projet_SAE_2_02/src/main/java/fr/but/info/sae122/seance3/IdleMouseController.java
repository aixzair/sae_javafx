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
	public IdleMouseController(Controller controleur) {
		super(controleur);
		super.controller.getEtat().setText("");
	}
	
	/** Affiche rien et règle le curseur à "DEFAULT".
	 * @param event
	 */
	@Override
	public void onMouseMoved(MouseEvent event) {
		super.controller.getEtat().setText("");
		super.controller.getCanvas().setCursor(Cursor.DEFAULT);
	}
	
	/** Active le contrôleur de déplacement et régle le curseur à "CLOSED_HAND".
	 * @param event
	 */
	@Override
	public void onMouseClicked(MouseEvent event){
		if (!(event.getTarget() instanceof GraphicNode)) {
			return;
		}
		
		super.controller.setMouseController(new DragMouseController(super.controller));
		super.controller.getEtat().setText("Déposez le noeud où vous voulez...");
		super.controller.getCanvas().setCursor(Cursor.CLOSED_HAND);
	}
	
	/** Indique que l'ont peut faire glisser le noeud si on est sur un noeud
	 * @param event
	 */
	@Override
	public void onMouseDragged(MouseEvent event){
		if (!(event.getTarget() instanceof GraphicNode)) {
			return;
		}
		
		super.controller.getEtat().setText("Vous pouvez glisser le noeud...");
		super.controller.getCanvas().setCursor(Cursor.OPEN_HAND);
	}
	
	/** Ne fait rien.
	 *
	 */
	@Override
	public void onMouseReleased(MouseEvent event) {
		// Vide.
	}
	
	/** Ne fait rien.
	 */
	@Override
	public void onMousePressed(MouseEvent event) {
		// Vide.
	}
}
