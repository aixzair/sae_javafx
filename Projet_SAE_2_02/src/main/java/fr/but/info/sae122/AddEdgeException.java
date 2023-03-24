package fr.but.info.sae122;

public class AddEdgeException
extends Exception {

	public AddEdgeException() {
		super("Vous avez déjà ajouté cette arête !");
	}
	
}
