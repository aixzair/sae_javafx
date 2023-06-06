package fr.but.info.sae122.seance3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public abstract class MouseController{

	protected Canvas canvas;
	private MouseController controller;
	/*
	public MouseController(Canvas canvas)
	{
		this.canvas = canvas;
	}*/
	
	public abstract void onMouseMoved(MouseEvent event);
	/*{
		this.controller.onMouseMoved(event);
	}*/
	
	public abstract void onMouseDragged(MouseEvent event);
	/*{
		this.controller.onMouseDragged(event);
	}*/
	
	public abstract void onMousePressed(MouseEvent event);
	/*{
		this.setController(new PlaceMouseController(this));
		this.controller.onMousePressed(event);
	}*/
	
	public abstract void onMouseReleased(MouseEvent event);
	/*{
		this.controller.onMouseReleased(event);
		
	}*/
	
	public abstract void setController(MouseController controller);
	/*{
		this.controller = controller;
	}*/
	
	public abstract void onMouseClicked(MouseEvent event);
	/*{
		this.controller.onMouseClicked(event);
	}*/

	/*
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.setController(new IdleMouseController(this));
		
	}*/
}
