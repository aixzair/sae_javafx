package fr.but.info.sae122.seance3;

import javafx.scene.input.MouseEvent;

/**
 * @author Alexandre Lerosier et Lukas Siopathis
 */
public abstract class MouseController {

	protected final Controller controller;
	
	/** Créer une instance avec un Controller
	 * @param controller
	 */
	public MouseController(Controller _controller) {
		this.controller = _controller;
	}
	
	public abstract void onMouseMoved(MouseEvent event);
	
	public abstract void onMouseDragged(MouseEvent event);
	
	public abstract void onMousePressed(MouseEvent event);
	
	public abstract void onMouseReleased(MouseEvent event);
	
	public abstract void onMouseClicked(MouseEvent event);
}
