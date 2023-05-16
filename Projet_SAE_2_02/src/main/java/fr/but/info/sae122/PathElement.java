package main.java.fr.but.info.sae122;

public class PathElement {
	
	PathElement parent;
	Edge edge;
	private int maxFlow;
	
	public PathElement(PathElement parent, Edge edge) {
		this.parent=parent;
		this.edge=edge;
		if(parent == null){
			this.maxFlow= edge.getCapacity();
		}else{
			this.maxFlow = Math.min(edge.getCapacity(), parent.getMaxFlow());
		}
	}

	public int getMaxFlow() {
		return maxFlow;
	}

	
	public PathElement getParent(){
		return this.parent;
	}
	
	public Edge getEdge() {
		return this.edge;
	}
	
}
