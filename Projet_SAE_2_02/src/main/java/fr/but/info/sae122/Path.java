package main.java.fr.but.info.sae122;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Path {
	
	protected List<Edge> edgeList;
	protected int flow;
	
	/**
	 * Path constructor without any parameter
	 */
	public Path() {
		this.edgeList=new ArrayList<>();
		flow = 0;
	}

	/**
	 * Path constructor
	 * @param nodes list used to create edges
	 */
	public Path(ArrayList<Edge> nodes) {
		/*this.edgeList=new ArrayList<>();
		Random r = new Random();
		for(int i=0;i<nodes.length-1;i++) {
			edgeList.set(i, new Edge(nodes[i], nodes[i + 1], r.nextInt(10) + 1));
		}
		
		for(int i=0;i<edgeList.size()-1;i++) {
			
			if(this.edgeList.get(i).getToNode()!= this.edgeList.get(i + 1).getFromNode()) {
				throw new IncoherentSuccessivityException("Deux arêtes successives n'ont pas de lien");
			}
		}*/
		edgeList = nodes;
		flow = 0;
	}
	
	/**
	 * Sets the flow of this Path
	 * @param flow : new value of flow in Path
	 */
	
	public void setFlow(int flow) {
		this.flow=flow;
	}

	/**
	 * Gets the flow of this Path
	 * @return the flow of the Path
	 */
	public int getFlow() {
		return this.flow;
	}
	
	/**
	 * Adds an edge at the first place of the edge list
	 * @param edge added to the first place of the age list
	 */
	
	public void addFirstEdge(Edge edge) {
		if(edgeList.size() != 0){
			if(!edge.getToNode().equals(edgeList.get(0).getFromNode())) throw new IllegalArgumentException();
		}
		edgeList.add(0, edge);
	}
	
	/**
	 * Adds an edge at the last place of the edge list
	 * @param edge added to the last place of the age list
	 */
	
	public void addLastEdge(Edge edge) {
		if(edgeList.size() != 0){
			if(!edge.getFromNode().equals(edgeList.get(edgeList.size() - 1).getToNode())) throw new IllegalArgumentException();
		}
		edgeList.add(edgeList.size(), edge);
	}
}
