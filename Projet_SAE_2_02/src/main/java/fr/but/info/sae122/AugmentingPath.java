package src.main.java.fr.but.info.sae122;

public class AugmentingPath {

	public Graph graph;
	public String sourceNode;
	public String sinkNode;
	
	public AugmentingPath(Graph _graph, String _sourceNode, String _sinkNode){
		
		this.graph=_graph;
		this.sourceNode=_sourceNode;
		this.sinkNode=_sinkNode;
	}
	
	public Graph getResidualGraph() {
		
		
		return graph; 
	}
}
