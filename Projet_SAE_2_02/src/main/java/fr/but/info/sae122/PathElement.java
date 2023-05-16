package main.java.fr.but.info.sae122;

public class PathElement {
	
	PathElement parent;
	Edge edge;
	private int maxFlow;
	
	/**
	 * Creates a Path element
	 * @param parent is a PathElement linked to this PathElement
	 * @param edge contained in a PathElement
	 */
	public PathElement(PathElement parent, Edge edge) {
		this.parent=parent;
		this.edge=edge;
		if(parent == null){
			this.maxFlow= edge.getCapacity();
		}else{
			this.maxFlow = Math.min(edge.getCapacity(), parent.getMaxFlow());
		}
	}
	/**
	 * Gets the maximal flow of the PathElement
	 * @return the maximal flow of the PathElement
	 */

	public int getMaxFlow() {
		return maxFlow;
	}
	
	/**
	 * Gets the parent of the Path element
	 * @return the parent of this Path element
	 */

	public PathElement getParent(){
		return this.parent;
	}

	/**
	 * Gets Edge of this Path
	 * @return the edge of this path
	 */
	
	public Edge getEdge() {
		return this.edge;
	}
	
}
