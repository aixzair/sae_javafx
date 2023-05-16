package main.java.fr.but.info.sae122;

public class PathElement {
	
	private PathElement parent;
	private Edge edge;
	
	public PathElement(PathElement parent, Edge edge)
	{
		this.parent = parent;
		this.edge = edge;
	}
}
