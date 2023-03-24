package src.fr.but.info.sae122;

public class NoNodeException extends Exception {

	public NoNodeException(String node) {
		super("Noeud : " + node + " inexistant.");
	}

}
