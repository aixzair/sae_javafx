package fr.but.info.sae122.seance3;

import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class LinkMouseController extends MouseController{

	private int ndSelect =0;
	private boolean creaArrete;
	private boolean destr;
	
	public LinkMouseController(Controller controller, boolean destr)
	{
		super(controller);
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
		switch(this.ndSelect)
		{
			case 0:
				//barreStatut.setText("Cliquez sur le noeud source");
				this.ndSelect++;
			break;
			case 1:
				//barreStatut.setText("Cliquez sur le noeud destination");
				this.ndSelect++;
			break;
			case 2:
				if(this.destr)
				{
					//détruire l'arrête si elle existe
				}
				else
				{
					showInputTextDialog();	//Création d'arrête
				}
				this.ndSelect = 0;
			break;
		}
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
        
        dialog.setTitle("Arrête");
        dialog.setHeaderText("Entrez une capacité");
        
        while(this.creaArrete)	//Boucle jusqu'à ce que l'arrête soit créée ou bouton annuler
        {
	        Optional<String> result = dialog.showAndWait();
	
	        if(result.isPresent() && !result.isEmpty())
	        {
		        result.ifPresent(capa -> {
		        	if(Integer.parseInt(capa) > 0 /*|| Integer.parseInt(capa) > flux*/)
		        	{
		        		//TO DO : Méthode qui crée une arrête entre nd 1 et nd2 de capacité capa OU qui modifie l'éventuelle arrête existante
		        		//Si chemin augmentant, le supprimer. Conserver le flux
		        		this.creaArrete = false;
		        	}
		        	else
		        	{
		        		dialog.setContentText("Veuillez entrer une capacité supérieure au flux");	//TO DO : Le mettre en rouge
		        	}
		        });
	        }
	        else if(result.isEmpty())
	        {
	        	dialog.setContentText("Veuillez entrer une capacité");	//TO DO : Le mettre en rouge
	        	//dialog.getEditor()(Color.red);
	        }
	        else		//Bouton annuler ou quitter
	        {
	        	this.creaArrete = false;
	        }
        }
    }
}
