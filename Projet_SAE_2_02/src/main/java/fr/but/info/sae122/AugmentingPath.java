package main.java.fr.but.info.sae122;

public class AugmentingPath extends Path {

	public Graph graph;
	public String sourceNode;
	public String sinkNode;

	Graph residualGraph;
	
	/*
	* Crée un nouveau path
	* */

	public AugmentingPath(Graph _graph, String _sourceNode, String _sinkNode){
		this.graph=_graph;
		this.sourceNode=_sourceNode;
		this.sinkNode=_sinkNode;

		BreadthFirstIterator BFI= new BreadthFirstIterator(getResidualGraph(), sourceNode);

		PathElement pathElement = BFI.next();
		PathElement last = null;
		while(BFI.hasNext()) last = BFI.next();

		if(last == null || !(last.getEdge().getToNode().equals(sinkNode))) throw new IllegalArgumentException();
		this.flow = last.getMaxFlow();
		while (last != null){
			graph.getEdge(last.getEdge().getFromNode(), last.getEdge().getToNode()).setFlux(this.flow);
			addFirstEdge(last.getEdge());
			last = last.getParent();
		}
		this.residualGraph = graph;

	}
	
	public Graph getResidualGraph() {
		
		ResidualGraph graph1 = new ResidualGraph();
		
		return graph1.createFromGraph(this.graph); 
	}
	
	/*public Path getAugmentedPath() {
		BreadthFirstIterator BFI= new BreadthFirstIterator(this.getResidualGraph(),sinkNode);
		Path path = new Path();
		while (BFI.hasNext()) {
			PathElement element = BFI.next();
			path.setFlow(element.getMaxFlow());
			path.addFirstEdge(element.getEdge());
		}
		return path;
	}*/
}
