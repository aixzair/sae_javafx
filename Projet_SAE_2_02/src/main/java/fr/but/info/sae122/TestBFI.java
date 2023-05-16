package fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBFI {

	@Test
	void testConstructor() {
		Graph graph = new Graph();
		graph.addNode("N1");
		graph.addNode("N2");
		graph.addEdge("N1", "N2", 5);
		
		String firstNode = "N1";
		
		BreadthFirstIterator bfi = new BreadthFirstIterator(graph, firstNode); 
		
		assertNotNull(bfi);
		assertTrue(bfi instanceof BreadthFirstIterator);
	}
		@Test
		void testHasNext() {
			Graph graph = new Graph();
			graph.addNode("N1");
			graph.addNode("N2");
			graph.addEdge("N1", "N2", 5);
			
			String firstNode = "N1";
			
			BreadthFirstIterator bfi = new BreadthFirstIterator(graph, firstNode); 
			
			assertTrue(bfi.hasNext());
	}

	@Test
	void testNext() {
		Graph graph = new Graph();
		graph.addNode("N1");
		graph.addNode("N2");
		graph.addNode("N3");
		graph.addEdge("N1", "N2", 5);
		graph.addEdge("N2", "N3", 5);
		
		String firstNode = "N1";
		PathElement pe = new PathElement(null, new Edge("N1", "N2", 5));
		
		BreadthFirstIterator bfi = new BreadthFirstIterator(graph, firstNode); 
		
		assertEquals(bfi.next(), pe);

		
	}

}
