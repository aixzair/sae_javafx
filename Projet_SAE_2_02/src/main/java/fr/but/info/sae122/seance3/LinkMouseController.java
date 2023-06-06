package fr.but.info.sae122.seance3;

import java.util.NoSuchElementException;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LinkMouseController extends MouseController{

	private int ndSelect =0;
	private boolean creaArrete;
	private boolean destr;
	
	public LinkMouseController(Controller controller, boolean destr)
	{

		super(controller);
		creaArrete = true;
		this.destr = destr;
	}
	
	public void onMouseMoved(MouseEvent event)
	{
		
	}
	
	public void onMouseDragged(MouseEvent event)
	{
		
	}
	
	public void onMousePressed(MouseEvent event)
	{	
		creaArrete = true;
		if(controller.btToggle == 2) {
			showInputTextDialog();
			this.controller.setMouseController(new IdleMouseController(this.controller));
		}else if(controller.btToggle == 3) {
			removeEdge();
			this.controller.setMouseController(new IdleMouseController(controller));
		}
		
	}
	

	public void onMouseReleased(MouseEvent event)
	{
		
	}
	
	public void onMouseClicked(MouseEvent event)
	{
		
	}

	public void showInputTextDialog() {
		TextInputDialog dialog = new TextInputDialog();
        //boolean looped = false;
        
        dialog.setTitle("Arrête");
        dialog.setHeaderText("Entrez une capacité");
        if(controller.getNd1() != null && controller.getNd2() != null) {
        	while(this.creaArrete)	//Boucle jusqu'à ce que l'arrête soit créée ou bouton annuler
            {
    	        dialog.setTitle("Noeud");
				dialog.getEditor().textProperty().addListener((observableValue, s, t1) -> {
					try {
						if (Integer.parseInt(observableValue.getValue()) < 0 || controller.getName().containsKey(observableValue.getValue())) {
							dialog.getEditor().setStyle("-fx-text-fill: red");
						} else {
							dialog.getEditor().setStyle("-fx-text-fill: black");
						}
					}catch (NumberFormatException e){
						dialog.getEditor().setStyle("-fx-text-fill: red");
						}
					});


            	Optional<String> res = dialog.showAndWait();

            	try {
					try{
						if(this.controller.getGraph().getEdge(controller.getNd1(), controller.getNd2()) != null) {
							controller.getGraph().removeEdge(controller.getNd1(), controller.getNd2());
						}
					}catch (IllegalArgumentException e){

					}
	            		if(!res.isEmpty() && res.isPresent()) {
	                		try {
	    		        		this.creaArrete = false;
	                    		this.controller.getGraph().addEdge(this.controller.getNd1(), this.controller.getNd2(), Integer.parseInt(res.get()));
	                    		controller.drawEdge(this.controller.getNd1(), this.controller.getNd2());
	                			controller.reDraw();
	                			dialog.close();
	                			creaArrete = false;
	                		}catch (IllegalArgumentException e) {
	                			dialog.setContentText("Veuillez entrer une capacité supérieure au flux");
	        				}catch (NoSuchElementException e) {
	        					dialog.setContentText("Veuillez entrer une capacité");
	        				}
	                		
	                	}else {
	                		this.creaArrete = false;
	        	        	dialog.close();
	                	}
	            	}catch (NoSuchElementException e) {
	            		this.creaArrete = false;
	    	        	dialog.close();
	    			}

				controller.setNd1(null);
				controller.setNd2(null);
            }
        }

        this.controller.getEtat().setText("Arrête créée");
        
    }
	
	public void removeEdge() {
        if(controller.getNd1() != null && controller.getNd2() != null) {
        	controller.getGraph().removeEdge(controller.getNd1(), controller.getNd2());
			controller.reDraw();
			controller.setNd1(null);
			controller.setNd2(null);
        }
        this.controller.getEtat().setText("Arrête détruite");

    }
}
