package src.fr.but.info.sae122;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class TestBreadthFirstIterator {
	
	@Test
	void testConstructeur() throws AddNodeException, AddEdgeException
	{
		Graph graph = new Graph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addNode("E");
		
		graph.addEdge("A", "B", "AB");
		graph.addEdge("C", "B", "CB");
		graph.addEdge("A", "D", "AD");
		graph.addEdge("D", "C", "DC");
		graph.addEdge("D", "E", "DE");
		
		List<String> testNodeList = new ArrayList<String>();
		testNodeList.add("A");
		testNodeList.add("B");
		testNodeList.add("C");
		testNodeList.add("D");
		testNodeList.add("E");
		assertEquals(testNodeList, graph.getNodeList());

		BreadthFirstIterator bfi = new BreadthFirstIterator(graph, "A");
		
	}
	
	@Test
	void testHasNext() throws AddNodeException, AddEdgeException
	{
		Graph graph1 = new Graph();
		Graph graph2 = new Graph();
		
		graph1.addNode("A");
		graph1.addNode("B");
		graph1.addNode("C");
		graph1.addEdge("A", "B", "AB");
		graph1.addEdge("B", "C", "BC");
		
		graph2.addNode("A");
		
		BreadthFirstIterator bfi1 = new BreadthFirstIterator(graph1, "A");
		BreadthFirstIterator bfi2 = new BreadthFirstIterator(graph2, "A");
		
		assertTrue(bfi1.hasNext());
		assertFalse(bfi2.hasNext());
	}
	
	@Test
	void testNext() throws AddNodeException, AddEdgeException
	{
		Graph graph = new Graph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addEdge("A", "B", "AB");
		graph.addEdge("A", "C", "AC");
		graph.addEdge("C", "B", "CB");
		
		BreadthFirstIterator bfi = new BreadthFirstIterator(graph, "A");
		
		Edge t_Edge = new Edge("A", "B", "AB");
		assertEquals(t_Edge, bfi.next());
		
	}
}
