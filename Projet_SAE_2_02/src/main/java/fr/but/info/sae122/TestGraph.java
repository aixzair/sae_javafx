package fr.but.info.sae122;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGraph {

	@Test
	void testConstructor() {
		
		Graph graph = new Graph();
		
		assertNotNull(graph);
		assertTrue(graph instanceof Graph);
	}

	@Test
	void testAddGetNodes() {
		Graph graph = new Graph();
		String node0 = "N0";
		
		assertTrue(graph.getNodes().size()==0);
		assertFalse(graph.getNodes().contains(node0));
		graph.addNode(node0);
		assertTrue(graph.getNodes().size()==1);
		assertTrue(graph.getNodes().contains(node0));
	}

	@Test
	void testAddGetEdges() {

		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		
		Edge edge0 = new Edge(node0, node1, 10);
		
		assertTrue(graph.getEdges().size()==0);
		assertFalse(graph.getEdges().contains(edge0));
		graph.addNode(node0);
		graph.addNode(node1);
		graph.addEdge(node0, node1, 10);
		assertEquals(1, graph.getEdges().size());
		assertTrue(graph.getEdges().contains(edge0));
	}

	@Test
	void testGetEdge() {

		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		
		graph.addNode(node0);
		graph.addNode(node1);
		
		Edge edge0 = new Edge(node0, node1, 10);
		
		graph.addEdge(node0, node1, 10);
		assertEquals(edge0, graph.getEdge(node0, node1));
	}

	@Test
	void testGetEdgesfrom() {

		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";
		String node3 = "N3";

		graph.addNode(node0);
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		Edge edge0 = new Edge(node0, node3, 10);
		Edge edge1 = new Edge(node0, node1, 10);
		Edge edge2 = new Edge(node1, node2, 10);
		Edge edge3 = new Edge(node2, node3, 10);

		graph.addEdge(node0, node3, 10);
		graph.addEdge(node0, node1, 10);
		graph.addEdge(node1, node2, 10);
		graph.addEdge(node2, node3, 10);
		
		assertTrue(graph.getEdgesFrom(node0).contains(edge0));
		assertTrue(graph.getEdgesFrom(node0).contains(edge1));
		assertFalse(graph.getEdgesFrom(node0).contains(edge2));
		assertFalse(graph.getEdgesFrom(node0).contains(edge3));
	}

	@Test
	void testGetEdgesTo() {

		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";
		String node3 = "N3";

		graph.addNode(node0);
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		
		Edge edge0 = new Edge(node0, node3, 10);
		Edge edge1 = new Edge(node0, node1, 10);
		Edge edge2 = new Edge(node1, node2, 10);
		Edge edge3 = new Edge(node2, node3, 10);

		graph.addEdge(node0, node3, 10);
		graph.addEdge(node0, node1, 10);
		graph.addEdge(node1, node2, 10);
		graph.addEdge(node2, node3, 10);
		
		assertTrue(graph.getEdgesTo(node3).contains(edge0));
		assertTrue(graph.getEdgesTo(node3).contains(edge3));
		assertFalse(graph.getEdgesTo(node3).contains(edge1));
		assertFalse(graph.getEdgesTo(node3).contains(edge2));
		
	}

	@Test
	void testToString() {

		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";

		graph.addNode(node0);
		graph.addNode(node1);
		graph.addNode(node2);

		graph.addEdge(node0, node1, 10);
		graph.addEdge(node1, node2, 10);
		
		
		assertEquals("Graph:\n- Node N0:\n  > Edge[fromNode=N0, toNode=N1, Capacity=10, Flux=0]\n- Node N1:\n  > Edge[fromNode=N1, toNode=N2, Capacity=10, Flux=0]\n- Node N2:\n", graph.toString());
		
		/*("Graph:\n");
	    for (var node: getNodes()) {
	      res.append("- Node ");
	      res.append(node);
	      res.append(":\n");
	      for(var edge: getEdgesFrom(node)) {
	        res.append("  > ");
	        res.append(edge.toString());
	        res.append("\n");*/
	}

}
