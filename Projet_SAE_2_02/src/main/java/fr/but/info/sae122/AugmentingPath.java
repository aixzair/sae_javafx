
package fr.but.info.sae122;


public class AugmentingPath extends Path {

	Graph graph;
	String sourceNode;
	String sinkNode;
	
	/**
	 * 
	 * @param _graph will contain the residual graph needed to get the augmenting path
	 * @param _sourceNode node from which we start the operation
	 * @param _sinkNode node to which we want to go
	 */

	
	public AugmentingPath(Graph _graph, String _sourceNode, String _sinkNode){
		this.graph=_graph;
		this.sourceNode=_sourceNode;
		this.sinkNode=_sinkNode;
	}
	
	/**
	 * 
	 * @return a residual graph created from the graph origin
	 */
	public Graph getResidualGraph() {
		
		ResidualGraph graph1 = new ResidualGraph();
		
		return graph1.createFromGraph(this.graph); 
	}
	/**
	 * 
	 * @return the path corresponding to the augmentedPath 
	 */
	
	public Path getAugmentedPath() {
		BreadthFirstIterator BFI= new BreadthFirstIterator(this.getResidualGraph(),sinkNode);
		Path path = new Path();
		while (BFI.hasNext()) {
			PathElement element = BFI.next();
			path.setFlow(element.getMaxFlow());
			path.addFirstEdge(element.getEdge());
		}
		return path;
	}
}
