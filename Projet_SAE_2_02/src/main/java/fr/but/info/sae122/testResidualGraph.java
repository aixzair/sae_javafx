package src.main.java.fr.but.info.sae122;

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
		graph.addEdge("N1", "N2", 10);
		graph.addEdge("N1", "N3", 5);
		graph.addEdge("N1", "N3", 8);
		
		Graph resGraph = new ResidualGraph().createFromGraph(graph);

		List<String> graphNodeList = (List<String>) graph.getNodes();
		List<String> resGraphNodeList = (List<String>) resGraph.getNodes();
		List<Edge> graphEdgeList = (List<Edge>) graph.getEdges();
		List<Edge> resGraphEdgeList = (List<Edge>) resGraph.getEdges();
		
		for(int i = 0; i < graph.getNodes().size(); i++)
		{
			assertTrue(graphNodeList.get(i)  == resGraphNodeList.get(i));
			assertEquals(graphEdgeList.get(i), resGraphEdgeList.get(i));
		}
	}

}
