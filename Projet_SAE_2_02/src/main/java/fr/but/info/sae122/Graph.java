package main.java.fr.but.info.sae122;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Graph {
	private Collection<Edge> edges;
	private Collection<String> nodes;

	public Graph() {
		// Vide.
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
	public void addNode(String name) {
		// vérifier qu'il n'est pas déjà inclu.
		
		if (!this.nodes.contains(name)) {
			this.nodes.add(name);
		} // else exception
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
	public Edge addEdge(String from, String to, String label) {
		// vérifier qu'il n'est pas déjà inclu.
		
		if (!this.nodes.contains(from)) {
			return null; // Exception
		} else if (!this.nodes.contains(to)) {
			return null; // Exception
		}
		
		Edge arete = new Edge(from, to, label);
			
	    this.edges.add(arete);
	    
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
	public Collection<Edge> getEdgesFrom(String node) {
	    Collection<Edge> edgesFrom = null;
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
	public Collection<Edge> getEdgesTo(String node) {
		Collection<Edge> edgesTo = null;
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
	public Edge getEdge(String fromNode, String toNode) {
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
	public String toString() {
		throw new UnsupportedOperationException("To be written");
	}
}
