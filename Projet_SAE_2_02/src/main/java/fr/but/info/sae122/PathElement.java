
package fr.but.info.sae122;

public class PathElement {
	
	PathElement parent = new PathElement(null,null);
	Edge edge;

	
	/**
	 * Creates a Path element
	 * @param parent is a PathElement linked to this PathElement
	 * @param edge contained in a PathElement
	 */
	public PathElement(PathElement parent, Edge edge) {
		
		this.parent=parent;
		this.edge=edge;
		
	}
	/**
	 * Gets the maximal flow of the PathElement
	 * @return the maximal flow of the PathElement
	 */

	public int getMaxFlow() {
		
		if(parent.getMaxFlow()<edge.getFlux()) {
			return parent.getMaxFlow();
		}
		return this.edge.getFlux();
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
