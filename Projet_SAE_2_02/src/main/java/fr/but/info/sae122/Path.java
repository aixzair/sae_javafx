
package fr.but.info.sae122;

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
	}
	
	/**
	 * Path constructor
	 * @param nodes list used to create edges 
	 * @throws IncoherentSuccessivityException if two successive edges in the edge list are not linked
	 */
	
	public Path(String[] nodes) throws IncoherentSuccessivityException {

		this.edgeList=new ArrayList<>();
		Random r = new Random();
		for(int i=0;i<nodes.length-1;i++) {
			edgeList.set(i, new Edge(nodes[i], nodes[i + 1], r.nextInt(10) + 1));
		}
		
		for(int i=0;i<edgeList.size()-1;i++) {
			
			if(this.edgeList.get(i).getToNode()!= this.edgeList.get(i + 1).getFromNode()) {
				throw new IncoherentSuccessivityException("Deux arêtes successives n'ont pas de lien");
			}
		}
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
		
		this.edgeList.set(0, edge);
		
	}
	
	/**
	 * Adds an edge at the last place of the edge list
	 * @param edge added to the last place of the age list
	 */
	
	public void addLastEdge(Edge edge) {
		
		this.edgeList.set(edgeList.size(), edge);
	}
	
	
	
}
