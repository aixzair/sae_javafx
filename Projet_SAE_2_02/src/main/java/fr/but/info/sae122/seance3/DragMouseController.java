package fr.but.info.sae122.seance3;

import javafx.scene.input.MouseEvent;

/** Gère le déplacement d'un noeud.
 * @author Alexandre Lerosier
 */
public class DragMouseController
extends MouseController {

	/** Créer une instance avec un texet à afficher.
	 * @param controller
	 */
	public DragMouseController(Controller controller) {
		super(controller);
	}
	
	/** Déplace le noeud pointé.
	 * @param event
	 */
	@Override
	public void onMouseDragged(MouseEvent event) {
		GraphicNode noeud;
		
		if (event.getTarget() instanceof GraphicNode) {
			noeud = (GraphicNode) event.getTarget();
		} else {
			return;
		}
		
		noeud.setXY(event.getSceneX(), event.getSceneY());
		super.controller.reDraw();
	}
	
	/** Change les fonctions pour la souris du controleur.
	 * @param event
	 */
	@Override
	public void onMouseReleased(MouseEvent event) {
		super.controller.setMouseController(new IdleMouseController(super.controller));
	}
	
	/** Ne fait rien.
	 */
	@Override
	public void onMouseMoved(MouseEvent event) {
		// Vide.
	}
	
	/** Ne fait rien.
	 */
	@Override
	public void onMousePressed(MouseEvent event) {
		// Vide.
	}
	
	/** Ne fait rien.
	 */
	@Override
	public void onMouseClicked(MouseEvent event) {
		// Vide.
	}
}
