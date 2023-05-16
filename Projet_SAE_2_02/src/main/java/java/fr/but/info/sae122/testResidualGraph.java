package main.java.java.fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testResidualGraph {

	@Test
	void testReturn() {
		//fail("Not yet implemented");
		Graph graph1 = new Graph();
		//Graph graph2 = new Graph();
		
		String node1 = "N1";
		String node2 = "N2";
		String node3 = "N3";
		
		graph1.addNode(node1);
		graph1.addNode(node2);
		graph1.addNode(node3);
		/*
		graph2.addNode(node1);
		graph2.addNode(node2);
		graph2.addNode(node3);*/
		
		graph1.addEdge(node1, node2, 10);
		graph1.addEdge(node2, node3, 5);
		graph1.addEdge(node1, node3, 8);
		
		//graph2.addEdge(node1, node2, 0);
		
		Graph resGraph = new ResidualGraph().createFromGraph(graph1);
		assertTrue(resGraph.getEdges().size() == graph1.getEdges().size());
		for(int i = 0; i < graph1.getEdges().size(); )
		{
			
		}
		
		//assertTrue(resGraph.getEdges() == graph1.getEdges() && resGraph.getNodes() == graph1.getNodes());
	}

}
