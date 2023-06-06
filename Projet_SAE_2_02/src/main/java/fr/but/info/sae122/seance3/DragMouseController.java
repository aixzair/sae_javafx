package fr.but.info.sae122.seance3;

import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/** Gère le déplacement d'un noeud.
 * @author Alexandre Lerosier & Alenso LOPES
 */
public class DragMouseController
extends MouseController {

	/** Créer une instance avec un texet à afficher.
	 * @param controller
	 */
	public DragMouseController(Controller controller) {
		super(controller);
	}
	
	// ------------ Evenement ------------
	
	/** Déplace le noeud pointé.
	 * @param mouseEvent
	 */
	@Override

	public void onMouseDragged(MouseEvent mouseEvent) {

		AtomicBoolean overNode = new AtomicBoolean(false);

		AtomicReference<String> nodeDragged = new AtomicReference<>("");

		this.controller.getName().forEach((name, node) -> {

			if (mouseEvent.getX() >= node.getX() - 2*node.getRadius() && mouseEvent.getX() <= node.getX() + 2*node.getRadius()
					&& mouseEvent.getY() >= node.getY() - 2*node.getRadius()) {

				overNode.set(true);
				nodeDragged.set(name);
			}

		});

		controller.getEtat().setText("Déposez le noeud où vous voulez...");

		controller.getName().replace(nodeDragged.get(), new GraphicNode(mouseEvent.getX(), mouseEvent.getY(), 25, Color.BEIGE));

		controller.reDraw();

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
