package fr.but.info.sae122.seance3;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class Controller {
	private MouseController mouseController;
	
	private @FXML Canvas canvas;
	//private @FXML barre de statut

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMouseController(MouseController _mouseController) {
		this.mouseController = _mouseController;
	}
	
	public void onMouseMoved(MouseEvent event)
	{
		
	}
	
	public void onMouseDragged(MouseEvent event)
	{
		//setMouseController(new DragMouseController(this));
	}
	
	public void onMousePressed(MouseEvent event)
	{
		//if( le bouton noeud a été pressé)
		//	setMouseController(new PlaceMouseController(this));
		//	this.controller.getCanvas().setCursor(Cursor.CROSSHAIR);
		//if(le bouton arrête+ a été pressé)
		//	setMouseController(new PlaceMouseController(this, true));
		//	this.controller.getCanvas().setCursor(Cursor.CROSSHAIR);
		//if(le bouton arrête- a été pressé)
		//	setMouseController(new PlaceMouseController(this, false));
		//	this.controller.getCanvas().setCursor(Cursor.CROSSHAIR);
	}
	
	public void onMouseReleased(MouseEvent event)
	{
		setMouseController(new IdleMouseController(this));
	}
	
	public void onMouseClicked(MouseEvent event)
	{
		//setMouseController(new PlaceMouseController(this));
	}
	
	public Canvas getCanvas()
	{
		return this.canvas;
	}

}
