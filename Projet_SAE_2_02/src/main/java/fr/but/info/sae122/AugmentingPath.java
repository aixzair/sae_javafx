package fr.but.info.sae122;

public class AugmentingPath extends Path {

	public Graph graph;
	public String sourceNode;
	public String sinkNode;
	
	

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
