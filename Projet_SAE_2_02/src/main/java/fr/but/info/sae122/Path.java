
package fr.but.info.sae122;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Path {
	
	protected List<Edge> edgeList;
	protected int flow;
	
	public Path() {
		
		this.edgeList=new ArrayList<>();
	}
	
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
	
	public void setFlow(int flow) {
		this.flow=flow;
	}

	public int getFlow() {
		return this.flow;
	}
	
	public void addFirstEdge(Edge edge) {
		
		this.edgeList.set(0, edge);
		
	}
	
	public void addLastEdge(Edge edge) {
		
		this.edgeList.set(edgeList.size(), edge);
	}
	
	
	
}
