package main.java.fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPathElement {
	//TO DO Erreur
	@Test
	void testConstructor() {
		Edge edge0 = new Edge("N1", "N2", 10);
		
		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";
		graph.addNode(node0);
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addEdge(node0, node1, 0);
		graph.addEdge(node1, node2, 0);
		
		BreadthFirstIterator BFI= new BreadthFirstIterator(graph,node0);
		
		PathElement pe0 = new PathElement(BFI.next(), edge0);

		assertNotNull(pe0);
		assertTrue(pe0 instanceof PathElement);
	}
	
	@Test
	void testGetParent() {
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";
		Edge edge0 = new Edge(node0, node1, 10);
		Edge edge1 = new Edge(node1, node2, 10);
		
		Graph graph = new Graph();
		graph.addNode(node0);
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addEdge(node0, node1, 0);
		graph.addEdge(node1, node2, 0);
		
		BreadthFirstIterator BFI= new BreadthFirstIterator(graph,node0);
		
		PathElement nextElement = BFI.next();
		PathElement pe0 = new PathElement(nextElement, edge0);
		
		assertTrue(pe0.getParent() == nextElement);
		
	}
	
	@Test
	void testGetMaxFlow() {
		Edge edge0 = new Edge("N0", "N1", 5);
		
		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		graph.addNode(node0);
		graph.addNode(node1);
		graph.addEdge(node0, node1, 5);
		
		BreadthFirstIterator BFI= new BreadthFirstIterator(graph,node0);
		
		PathElement nextElement = BFI.next();
		PathElement pe0 = new PathElement(nextElement, edge0);
		
		assertTrue(pe0.getMaxFlow() == 5);
	}
	
	@Test
	void testGetEdge() {
		Edge edge0 = new Edge("N1", "N2", 5);

		
		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		graph.addNode(node0);
		graph.addNode(node1);
		graph.addEdge(node0, node1, 0);
		
		BreadthFirstIterator BFI= new BreadthFirstIterator(graph,node0);
		
		PathElement nextElement = BFI.next();
		PathElement pe0 = new PathElement(nextElement, edge0);
		
		assertTrue(pe0.getEdge() == edge0);
	}

}
