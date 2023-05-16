package fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBFI {

	@Test
	void testConstructor() {
		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		graph.addNode(node0);
		graph.addNode(node1);
		graph.addEdge("N0", "N1", 5);
		
		String firstNode = "N0";
		
		BreadthFirstIterator bfi = new BreadthFirstIterator(graph, firstNode); 
		
		assertNotNull(bfi);
		assertTrue(bfi instanceof BreadthFirstIterator);
	}
		@Test
		void testHasNext() {
			Graph graph = new Graph();
			String node0 = "N0";
			String node1 = "N1";
			Edge edge0 = new Edge("N0", "N1", 10);
			
			graph.addNode(node0);
			graph.addNode(node1);
			graph.addEdge(node0, node1, 10);
			
			String firstNode = "N0";
			BreadthFirstIterator bfi = new BreadthFirstIterator(graph, firstNode); 
			PathElement pe0 = new PathElement(bfi.next(), edge0);
			
			assertTrue(bfi.hasNext());
	}

	@Test
	void testNext() {
		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";
		graph.addEdge(node0, node1, 5);
		graph.addEdge(node1, node2, 5);
		
		String firstNode = node0;
		PathElement pe = new PathElement(null, new Edge(node0, node1, 5));
		BreadthFirstIterator bfi = new BreadthFirstIterator(graph, firstNode); 
		
		assertEquals(bfi.next(), pe);
	}

}
