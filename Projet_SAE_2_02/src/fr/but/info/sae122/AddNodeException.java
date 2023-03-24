package src.fr.but.info.sae122;

public class AddNodeException
extends Exception {
	
	public AddNodeException() {
		super("Il y a déjà un noeud du même nom !");
	}
	
}
