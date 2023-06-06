package fr.but.info.sae122.seance3;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.Cursor;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class PlaceMouseController extends MouseController{
	
	private boolean creaNoeud = false;	//Reste actif tant qu'on cherche à créer un noeud

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
		this.controller.getCanvas().setCursor(Cursor.CROSSHAIR);
		this.creaNoeud = true;
		if(this.creaNoeud )	//Conditions spécifiques pour arrêtes : bouton arrête + clic noeud 1 + clic noeud 2
		{	
			showInputTextDialog();
		}
	}
	
	public void onMouseReleased(MouseEvent event)
	{
		
	}
	
	public void onMouseClicked(MouseEvent event)
	{
		
	}
	
	private void showInputTextDialog() {
		
        TextInputDialog dialog = new TextInputDialog("Création");
        
        while(this.creaNoeud)	//Boucle jusqu'à ce que le noeud soit créé ou bouton annuler
        {
	        dialog.setTitle("Noeud");
	        dialog.setHeaderText("Entrez le nom du noeud");
	        dialog.setContentText("Nom :");

	        Optional<String> result = dialog.showAndWait();
	
	        if(result.isPresent())
	        {
		        result.ifPresent(nom -> {		//Vérifier que noeud/arrête n'existe pas
		        	if(this.creaNoeud)
		        	{							//Créer le noeud avec le nom donné
		        		
		        		this.creaNoeud = false;
		        	}
		        });
	        }
	        else		//Bouton annuler ou quitter
	        {
	        	this.creaNoeud = false;
	        }
	        
        }
    }
	
}
