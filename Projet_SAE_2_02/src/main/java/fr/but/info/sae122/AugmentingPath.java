package main.java.fr.but.info.sae122;

public class AugmentingPath extends Path{

	static Graph graph;
	String sourceNode;
	String sinkNode;
	
	public AugmentingPath(Graph _graph, String _sourceNode, String _sinkNode){
		
		graph=_graph;
		this.sourceNode=_sourceNode;
		this.sinkNode=_sinkNode;
	}
	
	public static Graph getResidualGraph() {
		
		
		return graph; 
	}
}
