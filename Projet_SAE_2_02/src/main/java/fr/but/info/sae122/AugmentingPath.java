package fr.but.info.sae122;

public class AugmentingPath extends Path {

	public Graph graph;
	public String sourceNode;
	public String sinkNode;
	
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

		BreadthFirstIterator BFI= new BreadthFirstIterator(getResidualGraph(), sourceNode);
		/*while (BFI.hasNext()) {
			PathElement element = BFI.next();
			path.setFlow(element.getMaxFlow());
			path.addFirstEdge(element.getEdge());
		}*/

		PathElement pathElement = BFI.next();
		/*
		 * Throws exception if there are no next element
		 */
		while(pathElement.getEdge().getToNode() != sinkNode){
			if(!BFI.hasNext()) throw new IllegalArgumentException("");
			pathElement = BFI.next();
		}

		while(pathElement.getParent() != null){
			Edge e = pathElement.getEdge();
			try{
				addFirstEdge(e);
			}catch (IllegalArgumentException e1){
				e1.printStackTrace();
			}
			pathElement = pathElement.getParent();
		}
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
