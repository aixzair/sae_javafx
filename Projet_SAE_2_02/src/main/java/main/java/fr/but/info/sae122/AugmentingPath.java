package main.java.fr.but.info.sae122;

public class AugmentingPath extends Path {

	Graph graph;
	String sourceNode;
	String sinkNode;
	Graph gr;
	
	public AugmentingPath(Graph _graph, String _sourceNode, String _sinkNode){
		
		this.graph=_graph;
		this.sourceNode=_sourceNode;
		this.sinkNode=_sinkNode;
		BreadthFirstIterator BFI= new BreadthFirstIterator(this.getResidualGraph(),sourceNode);
		 gr=new Graph();
		Edge edg = BFI.next().getEdge();
		while (edg.getToNode()!=sinkNode) {
			gr.addNode(edg.getFromNode());
			gr.addNode(edg.getToNode());
			gr.addEdge(edg.getFromNode(),edg.getToNode(),edg.getCapacity());
		}
	}
	
	public Graph getResidualGraph() {
		
		ResidualGraph graph1 = new ResidualGraph();
		graph1.createFromGraph(this.graph);
		
		return graph1; 
	}
	
	public Graph getGr() {
		return gr;
	}
}
