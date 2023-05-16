package main.java.fr.but.info.sae122;

import java.util.Objects;

public class AugmentingPath extends Path {

	public Graph graph;
	public String sourceNode;
	public String sinkNode;

	Graph residualGraph;

	/**
	 * @param _graph will contain the residual graph needed to get the augmenting path
	 * @param _sourceNode node from which we start the operation
	 * @param _sinkNode node to which we want to go
	 */
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
		/*
		 * Throws exception if there are no next element
		 */
		while(!Objects.equals(pathElement.getEdge().getToNode(), sinkNode)){
			if(!BFI.hasNext()) throw new IllegalArgumentException("");
			pathElement = BFI.next();
		}
		this.residualGraph = graph;
	}
	
	/**
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
