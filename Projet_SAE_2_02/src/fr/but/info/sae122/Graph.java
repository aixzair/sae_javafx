package src.fr.but.info.sae122;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Graph {
	private ArrayList<Edge> edges;
	private ArrayList<String> nodes;

	public Graph() {
		this.edges = new ArrayList<Edge>();
		this.nodes = new ArrayList<String>();
	}
	
	/*
	 *	Fait :
	 *		- ajoute un noeud.
	 *
	 *	@param :
	 *		- name : nom du noeud.
	 *
	 *	@return :
	 *		-rien 
	 */
	public void addNode(String name)
	throws AddNodeException {		
		if (!this.nodes.contains(name)) {
			this.nodes.add(name);
		} else {
			throw new AddNodeException();
		}
	}
	
	/*
	 *	Fait :
	 *		- ajoute une arête.
	 *
	 *	@param :
	 *		- from : noeud de départ ;
	 *		- to : noeud d'arrivé ;
	 *		- label : nom de l'arête.
	 *
	 *	@return :
	 *		- l'arête créé.
	 */
	public Edge addEdge(String from, String to, String label)
	throws 	AddEdgeException,
			NoNodeException {
		
		if (!this.nodes.contains(from)) {
			throw new NoNodeException(from);
		} else if (!this.nodes.contains(to)) {
			throw new NoNodeException(to);
		}
		
		Edge arete = new Edge(from, to, label);
		
		if (this.getEdge(from, to) == null) {
			this.edges.add(arete);
		} else {
			throw new AddEdgeException();
		}
	    
	    return arete;
	}
	
	/*
	 *	@return :
	 *		- la collection de noeuds.
	 */
	public Collection<String> getNodes() {
	    return this.nodes;
	}
	
	/*
	 *	@return :
	 *		- la collection d'arêtes.
	 */
	public Collection<Edge> getEdges() {
	    return this.edges;
	}
	
	/*
	 *	Fait :
	 *		- retourne les arêtes qui partent d'un noeud.
	 *
	 *	@param :
	 *		- node : nom du noeud.
	 *
	 *	@return :
	 *		- une colection d'arêtes.
	 */
	public Collection<Edge> getEdgesFrom(String node)
	throws NoNodeException {
		
		if (!this.nodes.contains(node)) {
			throw new NoNodeException(node);
		}
		
	    Collection<Edge> edgesFrom = new ArrayList<Edge>();
	    Iterator iterator = this.edges.iterator();
	    
	    while (iterator.hasNext()) {
	    	Edge arete = (Edge) iterator.next();
	    	
	    	if (arete.getFromNode() == node) {
	    		edgesFrom.add(arete);
	    	}
	    }
	    
	    return edgesFrom;
	}
	
	/*
	 *	Fait :
	 *		- retourne les arêtes qui vont vers un noeud.
	 *
	 *	@param :
	 *		- node : nom du noeud.
	 *
	 *	@return :
	 *		- une colection d'arêtes.
	 */
	public Collection<Edge> getEdgesTo(String node)
	throws NoNodeException {
		
		if (!this.nodes.contains(node)) {
			throw new NoNodeException(node);
		}
		
		Collection<Edge> edgesTo = new ArrayList<Edge>();
	    Iterator iterator = this.edges.iterator();
	    
	    while (iterator.hasNext()) {
	    	Edge arete = (Edge) iterator.next();
	    	
	    	if (arete.getToNode() == node) {
	    		edgesTo.add(arete);
	    	}
	    }
	    
	    return edgesTo;
	}
	
	/*
	 *	Fait :
	 *		- retourne une arête entre deux noeuds.
	 *
	 *	@param :
	 *		- fromNode : noeuds de départs ;
	 *		- toNode: noeuds de destination.
	 *
	 *	@return :
	 *		- une arête.
	 */
	public Edge getEdge(String fromNode, String toNode)
	throws 	AddEdgeException,
			NoNodeException {
		
		if (!this.nodes.contains(fromNode)) {
			throw new NoNodeException(fromNode);
		} else if (!this.nodes.contains(toNode)) {
			throw new NoNodeException(toNode);
		}
		
	    Iterator iterator = this.edges.iterator();
	    
	    while (iterator.hasNext()) {
	    	Edge arete = (Edge) iterator.next();
	    	
	    	// Gain de temps car fait le second test seulement si le premier est valide
	    	if (arete.getFromNode() == fromNode) {
	    		if (arete.getToNode() == toNode) {
	    			return arete;
	    		}
	    	}
	    }
	    
	    return null;
	}
	
	/*
	 *	@return :
	 *		- une list des noeuds.
	 */
	public List<String> getNodeList() {
		List<String> nodeList = new ArrayList<String>();
		Iterator iterator = this.nodes.iterator();
	    
	    while (iterator.hasNext()) {
	    	nodeList.add((String) iterator.next());
	    }
		
		return nodeList;
	}
	
	@Override
	/*
	 * @return 
	 * 		"Arêtes : (arêtes) ; Noeuds : (noeuds)"
	 * 
	 */
	public String toString() {
		return "Arêtes : " + this.edges
				+ " ; Noeuds : " + this.nodes;
	}
}
