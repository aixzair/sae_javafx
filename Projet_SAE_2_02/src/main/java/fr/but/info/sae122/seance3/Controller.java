package fr.but.info.sae122.seance3;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class Controller {
	private MouseController mouseController;
	
	private @FXML Canvas canvas;

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMouseController(MouseController _mouseController) {
		this.mouseController = _mouseController;
	}

}
