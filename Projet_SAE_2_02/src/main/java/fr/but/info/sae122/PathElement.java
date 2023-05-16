package src.main.java.fr.but.info.sae122;

public class PathElement {
	
	private String parent;
	private Edge edge;
	
	public PathElement(String parent, Edge edge)
	{
		this.parent = parent;
		this.edge = edge;
	}
}
