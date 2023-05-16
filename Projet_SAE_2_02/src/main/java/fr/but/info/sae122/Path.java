package main.java.fr.but.info.sae122;

public class Path {
	
	Edge[] edgeList;
	int flow;
	
	
	public Path() {
		
		this.edgeList=new Edge[10000];
		
	}
	
	public Path(String[] nodes, int capacity) throws IncoherentSuccessivityException {
		
		this.edgeList=new Edge[10000];
		
		for(int i=0;i<nodes.length-1;i++) {
			edgeList[i]=new Edge(nodes[i],nodes[i+1],capacity);
		}
		
		for(int i=0;i<edgeList.length-1;i++) {
			
			if(this.edgeList[i].getToNode()!=this.edgeList[i+1].getFromNode()) {
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
		
		this.edgeList[0]=edge;
		
	}
	
	public void addLastEdge(Edge edge) {
		
		this.edgeList[edgeList.length]=edge;
	}
	
	
	
}
