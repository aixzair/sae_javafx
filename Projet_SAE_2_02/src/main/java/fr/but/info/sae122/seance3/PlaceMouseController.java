package fr.but.info.sae122.seance3;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PlaceMouseController extends MouseController{
	
	private boolean creaNoeud = false;	//Reste actif tant qu'on cherche à créer un noeud
	private double cursX;
	private double cursY;
	
	/**
	 * 
	 * @param controller
	 */
	public PlaceMouseController(Controller controller)
	{
		super(controller);
	}
	
	public void onMouseMoved(MouseEvent event)
	{
		
	}
	
	public void onMouseDragged(MouseEvent event)
	{
		
	}
	
	public void onMousePressed(MouseEvent event)
	{
		this.creaNoeud = true;
		this.cursX = event.getSceneX();
		this.cursY = event.getSceneY();
		showInputTextDialog();
		this.controller.setMouseController(new IdleMouseController(this.controller));
	}
	
	public void onMouseReleased(MouseEvent event)
	{
		
	}
	
	public void onMouseClicked(MouseEvent event)
	{
		
	}
	
	private void showInputTextDialog() {
		
        TextInputDialog dialog = new TextInputDialog("Création");
        boolean looped = false;
        while(this.creaNoeud)	//Boucle jusqu'à ce que le noeud soit créé ou bouton annuler
        {
	       /* dialog.setTitle("Noeud");
	        dialog.setHeaderText("Entrez le nom du noeud");
	        //dialog.setContentText("Nom du noeud:");

	        Optional<String> result = dialog.showAndWait();
	
	        if(!result.isEmpty())
	        {
		        result.ifPresent(nom -> {
		        	if(!this.controller.getName().containsKey(nom))
		        	{
	        			GraphicNode noeud = new GraphicNode(cursX, cursY, 20, Color.BLACK);
	        			this.controller.getGraph().addNode(nom);
	        			this.controller.getName().put(nom, noeud);
	        			this.controller.reDraw();
	        			this.creaNoeud = false;
	        			dialog.close();
	        			
		        	}
		        	else
		        	{
		        		dialog.setContentText("Veuillez entrer un nom non utilisé");	//TO DO : Le mettre en rouge
		        	}
		        });
	        }
	        else if(result.isEmpty())
	        {
	        	dialog.setContentText("Veuillez entrer un nom non-vide");	//TO DO : Le mettre en rouge
	        	//dialog.getEditor()(Color.red);
	        }
	        else		//Bouton annuler ou quitter
	        {
	        	this.creaNoeud = false;
	        	dialog.close();
	        }*/
        	dialog.setTitle("Noeud");
        	
        	Optional<String> res = dialog.showAndWait();
        	try {
        		if(!res.isEmpty() && res.isPresent()) {
            		try {
            			GraphicNode node = new GraphicNode(cursX, cursY, 20, Color.BLACK);
                		this.controller.getGraph().addNode(res.get());
            			this.controller.getName().put(res.get(), node);
            			controller.reDraw();
            			dialog.close();
            			creaNoeud = false;
            		}catch (IllegalArgumentException e) {
            			dialog.setContentText("Veuillez entrer un nom non utilisé");
    				}catch (NoSuchElementException e) {
    					dialog.setContentText("Veuillez entrer un nom non-vide");
    				}
            		
            	}else {
            		this.creaNoeud = false;
    	        	dialog.close();
            	}
        	}catch (NoSuchElementException e) {
        		this.creaNoeud = false;
	        	dialog.close();
			}
        	
	        
        }
    }
	
}
