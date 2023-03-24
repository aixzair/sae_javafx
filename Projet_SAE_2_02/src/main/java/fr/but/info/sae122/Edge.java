package main.java.fr.but.info.sae122;


public final class Edge {

	String fromNode;
	String toNode;
	String label;


	/*
	 * Constructeur d'objets arrêtes
	 * @param fromNode : Noeud de départ
	 * @param toNode : Noeud de destination
	 * @param label : Etiquette
	 * Renvoie une exception si fromNode == toNode
	 */
	public Edge(String fromNode,String toNode,String label) throws IllegalArgumentException{
		if(fromNode != toNode)
		{
			this.fromNode = fromNode;
			this.toNode = toNode;
			this.label = label;
		}
		else
		{
			throw new IllegalArgumentException("The origin and destination of the edge must be different.");

		}
	}

	/*
	 * @return le noeud d'origine de l'arrête
	 */
	public String getFromNode() {
		//throw new UnsupportedOperationException("To be written");
		return this.fromNode;
	}

	/*
	 * @return le noeud de destination de l'arrête
	 */
	public String getToNode() {
		//throw new UnsupportedOperationException("To be written");
		return this.toNode;
	}

	/*
	 * @return L'étiquette de l'arrête
	 */
	public String getLabel() {
		return this.label;
		//throw new UnsupportedOperationException("To be written");
	}
	/*
	 * @param Deuxième arrête
	 * @return Si les deux arrêtes sont les mêmes
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Edge) {
			return (this.fromNode == ((Edge) obj).getFromNode() && this.toNode == ((Edge) obj).getToNode() && this.label == ((Edge) obj).getLabel() );
		}
		else return false;
		//throw new UnsupportedOperationException("To be written");
	}

	@Override
	public int hashCode() {
		throw new UnsupportedOperationException("To be written");
	}
}
