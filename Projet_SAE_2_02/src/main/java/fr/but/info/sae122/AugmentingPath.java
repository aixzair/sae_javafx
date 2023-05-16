package fr.but.info.sae122;

public class AugmentingPath extends Path {

	Graph graph;
	String sourceNode;
	String sinkNode;
	
	public AugmentingPath(Graph _graph, String _sourceNode, String _sinkNode){
		this.graph=_graph;
		this.sourceNode=_sourceNode;
		this.sinkNode=_sinkNode;
	}
	
	public Graph getResidualGraph() {
		
		ResidualGraph graph1 = new ResidualGraph();
		
		return graph1.createFromGraph(this.graph); 
	}
	
	public void getAugmentedPath() {
		BreadthFirstIterator BFI= new BreadthFirstIterator(this.getResidualGraph(),sinkNode);
		Path path = new Path();
		while (BFI.hasNext()) {
			PathElement element = BFI.next();
			path.setFlow(element.getMaxFlow());
			path.addFirstEdge(element.getEdge());
		}
	}
}
