package main.java.fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TestResidualGraph {

	@Test
	void testCreateFromGraph() {
		Graph graph = new Graph();
		graph.addNode("N1");
		graph.addNode("N2");
		graph.addNode("N3");
		graph.addNode("N4");
		graph.addNode("N5");
		Edge ed1 = new Edge("N1", "N2", 10);
		Edge ed2 = new Edge("N2", "N3", 7);
		Edge ed3 = new Edge("N1", "N3", 8);
		Edge ed4 = new Edge("N3", "N4", 5);
		Edge ed5 = new Edge("N5", "N2", 6);

		ed1.setFlux(5);
		ed2.setFlux(5);
		ed3.setFlux(5);
		ed4.setFlux(5);
		ed5.setFlux(5);
		
		Graph resGraph = new ResidualGraph().createFromGraph(graph);
/*
		for(Edge edge : graph.getEdges())
		{
			System.out.println(edge.getFromNode() + ", " + edge.getToNode() + ", " + edge.getCapacity());
		}*/
		
		for(String node : resGraph.getNodes())
		{
			assertTrue(graph.getNodes().contains(node));
		}
		
		assertTrue(graph.getEdges().contains(new Edge("N1", "N2", 5)));
		assertTrue(graph.getEdges().contains(new Edge("N2", "N3", 2)));
		assertTrue(graph.getEdges().contains(new Edge("N1", "N3", 3)));
		assertFalse(graph.getEdges().contains(new Edge("N3", "N4", 0)) || graph.getEdges().contains(new Edge("N4", "N3", 0)));
		assertTrue(graph.getEdges().contains(new Edge("N2", "N5", 5)));
		
	}

}
