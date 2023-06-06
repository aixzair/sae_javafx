package fr.but.info.sae122.seance3;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.Cursor;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class PlaceMouseController extends MouseController{
	
	private boolean creaNoeud = false;	//Reste actif tant qu'on cherche à créer un noeud
	private boolean creaArrete = false;	//Reste actif tant qu'on cherche à créer une arrete

	public PlaceMouseController(MouseController controller)
	{
		
	}
	
	public void onMouseMoved(MouseEvent event)
	{
		
	}
	
	public void onMouseDragged(MouseEvent event)
	{
		
	}
	
	public void onMousePressed(MouseEvent event)
	{

		
		boolean noeudClicked = false;	//Quand le bouton noeud a été cliqué. A remplacer 
		boolean arreteClicked = false;	//Quand le bouton arrete a été cliqué. A remplacer 
		
		//Bouton noeud
		if(noeudClicked)
		{
			this.canvas.setCursor(Cursor.CROSSHAIR);
			this.creaNoeud = true;	
			this.creaArrete = false;
		}
		//Bouton arrete
		if(arreteClicked)
		{
			this.canvas.setCursor(Cursor.CROSSHAIR);
			this.creaArrete = true;
			this.creaNoeud = false;
		}

		if(this.creaNoeud /*|| this.creaArrete*/ )	//Conditions spécifiques pour arrêtes : bouton arrête + clic noeud 1 + clic noeud 2
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
        
        while(this.creaNoeud || this.creaArrete)	//Boucle jusqu'à ce que le noeud soit créé ou bouton annuler
        {
			if(this.creaNoeud)
			{
		        dialog.setTitle("Noeud");
		        dialog.setHeaderText("Entrez le nom du noeud");
		        dialog.setContentText("Nom :");
			}
			else
			{
		        dialog.setTitle("Arrête");
		        dialog.setHeaderText("Entrez la capacité de l'arrête");
		        dialog.setContentText("Capacité :");
			}

	        Optional<String> result = dialog.showAndWait();
	
	        if(result.isPresent())
	        {
		        result.ifPresent(nom -> {		//Vérifier que noeud/arrête n'existe pas
		        	if(this.creaNoeud)
		        	{							//Créer le noeud avec le nom donné
		        		
		        		this.creaNoeud = false;
		        	}
		        	else
		        	{
		        		
		        		this.creaArrete = false;
		        	}
		        });
	        }
	        else		//Bouton annuler ou quitter
	        {
	        	this.creaNoeud = false;
	        	this.creaNoeud = false;
	        }
	        
        }
    }
	
}
