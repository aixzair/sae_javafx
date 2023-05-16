package src.main.java.fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAugmentingPath {

	@Test
	void testConstructor() {
		Graph graph = new Graph();
		graph.addNode("N1");
		graph.addNode("N2");
		graph.addNode("N3");
		
		Graph resGraph = new ResidualGraph().createFromGraph(graph);
		
		String sourceNode = "N1";
		String sinkNode = "N3";
		
		AugmentingPath ap = new AugmentingPath(graph, sourceNode, sinkNode);
		
		assertTrue(ap instanceof AugmentingPath);
		assertTrue(ap.graph == graph);
		assertTrue(ap.sourceNode == sourceNode);
		assertTrue(ap.sinkNode == sinkNode);
	}
	
	@Test
	void testGetResidualGraph() {
		Graph graph = new Graph();
		graph.addNode("N1");
		graph.addNode("N2");
		graph.addNode("N3");
		
		String sourceNode = "N1";
		String sinkNode = "N3";
		
		AugmentingPath ap = new AugmentingPath(graph, sourceNode, sinkNode);
		Graph resGraph = ap.getResidualGraph();
		
		assertTrue(resGraph instanceof Graph);
		for(Edge edge : resGraph.getEdges())
		{
			assertTrue(edge.getFlux()==0);
		}
	}
	
	

}
