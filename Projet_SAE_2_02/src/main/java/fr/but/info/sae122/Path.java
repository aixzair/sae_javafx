package main.java.fr.but.info.sae122;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Path {
	
	List<Edge> edgeList;
	int flow;
	
	public Path() {
		this.edgeList=new ArrayList<>();
		flow = 0;
	}
	
	public Path(ArrayList<Edge> nodes) throws IncoherentSuccessivityException {

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
	
	public void setFlow(int flow) {
		this.flow=flow;
	}

	public int getFlow() {
		return this.flow;
	}
	
	public void addFirstEdge(Edge edge) {
		if(edgeList.size() != 0){
			if(!edge.getToNode().equals(edgeList.get(0).getFromNode())){
				throw new IllegalArgumentException();
			}
		}
		edgeList.add(0, edge);
	}
	
	public void addLastEdge(Edge edge) {
		if(edgeList.size() != 0){
			if(!edge.getFromNode().equals(edgeList.get(edgeList.size() - 1).getToNode())){
				throw new IllegalArgumentException();
			}
		}
		edgeList.add(edgeList.size(), edge);
	}
	
	
	
}
