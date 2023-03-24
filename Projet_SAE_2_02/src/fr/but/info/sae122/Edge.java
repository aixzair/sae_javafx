
package fr.but.info.sae122;

package src.fr.but.info.sae122;

/*
 * @author Lukas Siopathis
 */

public final class Edge {

	private String fromNode;
	private String toNode;
	private String label;

	/*
	 * Constructeur d'objets arrêtes
	 * @param fromNode : Noeud de départ
	 * @param toNode : Noeud de destination
	 * @param label : Etiquette
	 * @exception : Exception si fromNode et toNode ont la même valeur.
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
		return this.fromNode;
	}

	/*
	 * @return le noeud de destination de l'arrête
	 */
	public String getToNode() {
		return this.toNode;
	}

	/*
	 * @return L'étiquette de l'arrête
	 */
	public String getLabel() {
		return this.label;
	}
	/*Compare l'égalité entre deux arrêtes
	 * @param Deuxième arrête
	 * @return Si les deux arrêtes sont les mêmes
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(getClass() != obj.getClass()) {
			return false;
		}
		return (this.fromNode == ((Edge) obj).getFromNode() && this.toNode == ((Edge) obj).getToNode() && this.label == ((Edge) obj).getLabel() );
	}
	
	/*
	@Override
	public int hashCode() {
		throw new UnsupportedOperationException("To be written");
	}
	*/
}
