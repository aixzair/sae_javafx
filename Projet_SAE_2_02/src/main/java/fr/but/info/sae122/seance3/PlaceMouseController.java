package fr.but.info.sae122.seance3;

import java.awt.Color;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.Cursor;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

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
	        dialog.setTitle("Noeud");
	        dialog.setHeaderText("Entrez le nom du noeud");
	        //dialog.setContentText("Nom du noeud:");

	        Optional<String> result = dialog.showAndWait();
	
	        if(result.isPresent() && !result.isEmpty())
	        {
		        result.ifPresent(nom -> {
		        	if(this.creaNoeud /*TO DO : remplacer par "nom de noeud existe déjà"*/)
		        	{
		        		//TO DO : Méthode qui crée un noeud avec cursX et cursY
		        		this.creaNoeud = false;
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
	        }
	        
        }
    }
	
}
