
package fr.but.info.sae122;

public class PathElement {
	
	PathElement parent = new PathElement(null,null);
	Edge edge;

	
	public PathElement(PathElement parent, Edge edge) {
		
		this.parent=parent;
		this.edge=edge;
		
	}

	public int getMaxFlow() {
		
		if(parent.getMaxFlow()<edge.getFlux()) {
			return parent.getMaxFlow();
		}
		return this.edge.getFlux();
	}

	
	public PathElement getParent(){
		return this.parent;
	}
	
	public Edge getEdge() {
		return this.edge;
	}
	
}
