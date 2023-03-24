package src.fr.but.info.sae122;

/*
 * @author Lukas Siopathis
 */

import java.util.ArrayList;
import java.util.Iterator;

public class BreadthFirstIterator implements Iterator<Edge> {
	private Graph graph;				
	private String currentNode;			//Noeud actuel
	private ArrayList<String> nodesMet;	//Liste de noeuds rencontrés
	private Iterator<Edge> itrArr;		//Itérateur de la liste d'arrêtes
	private int index;					//Index de la liste de noeuds rencontrés

	/*
	 * Constructeur d'objets arrêtes
	 * Le premier noeud devient le noeud actuel
	 * @param graph : Graphe à parcourir
	 * @param firstNode : Premier noeud
	 */
	public BreadthFirstIterator(Graph graph, String firstNode) {
		this.graph = graph;
		this.currentNode = firstNode;
		this.index = 0;
		nodesMet = new ArrayList<String>();
		nodesMet.add(firstNode);
		update();
	}

	/*
	 * Met à jour la liste de Noeuds rencontrés
	 * @param fromNode : Noeud de départ
	 * @param toNode : Noeud de destination
	 * @param label : Etiquette
	 * @exception : Exception si fromNode et toNode ont la même valeur.
	 * Renvoie une exception si fromNode == toNode
	 */
	public void update()
	{
		ArrayList<Edge> al = (ArrayList<Edge>)this.graph.getEdgesFrom(this.currentNode);
		for(int i = 0; i < al.size(); i++)
		{
			if(!nodesMet.contains(al.get(i).getFromNode()))
			{
				this.nodesMet.add(al.get(i).getFromNode());
			}
		}
	}

	@Override
	public boolean hasNext() {
		itrArr = this.graph.getEdgesFrom(this.currentNode).iterator();
		return itrArr.hasNext(); 
	}

	/*
	 * @return : La prochaine arrête non-explorée 
	 */
	@Override
	public Edge next() {

		itrArr = this.graph.getEdgesFrom(this.currentNode).iterator();
			
		while(!this.hasNext())		
			//Incrémente l'index de la liste des noeuds rencontrés si le noeud actuel n'a pas de successeur
		{
			this.currentNode = this.nodesMet.get(index);
			update();
			index +=1;
			itrArr = this.graph.getEdgesFrom(this.currentNode).iterator();
		}
		Edge arr = this.itrArr.next();
		this.itrArr.remove();
		return arr;
	}
}
