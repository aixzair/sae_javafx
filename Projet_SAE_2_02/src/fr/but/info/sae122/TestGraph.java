/**
 * 
 */
package src.fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;


/** 
 * @author alexandre lerosier
 * 
 * */
class TestGraph {
	@Test
	void testConstructeur() {
		Graph graph = new Graph();
		
		assertEquals(Graph.class, graph.getClass());
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#addNode(java.lang.String)}.
	 * - test longueur de nodes x2 ;
	 * - test exception.
	 * 
	 * @throws AddNodeException 
	 */
	@Test
	void testAddNode()
	throws AddNodeException {

		Graph graph = new Graph();

		graph.addNode("a");
		assertEquals(1, graph.getNodes().size());

		graph.addNode("b");
		assertEquals(2, graph.getNodes().size());

		assertThrows(
			AddNodeException.class,
			() -> graph.addNode("a")
		);
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#addEdge(java.lang.String, java.lang.String, java.lang.String)}.
	 * 
	 * - test longueur de edges x2 ;
	 * - test exception x3.
	 * 
	 * @throws AddEdgeException 
	 * @throws AddNodeException 
	 * @throws NoNodeException 
	 */
	@Test
	void testAddEdge()
	throws 	AddEdgeException,
			AddNodeException,
			NoNodeException {
		
		Graph graph = new Graph();
		graph.addNode("a");
		
		assertThrows(
			NoNodeException.class,
			() -> graph.addEdge("a", "b", "3")
		);
		
		assertThrows(
			NoNodeException.class,
			() -> graph.addEdge("b", "a", "3")
		);
		
		graph.addNode("b");
		graph.addNode("c");

		graph.addEdge("a", "b", "x");
		assertEquals(1, graph.getEdges().size());

		graph.addEdge("a", "c", "y");
		assertEquals(2, graph.getEdges().size());

		assertThrows(
			AddEdgeException.class,
			() -> graph.addEdge("a", "b", "3")
		);
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getNodes()}.
	 * @throws AddNodeException 
	 */
	@Test
	void testGetNodes()
	throws AddNodeException {
		
		ArrayList<String> list = new ArrayList<String>();
		Graph graph = new Graph();
		
		graph.addNode("a");
		graph.addNode("b");

		
		list.add("a");
		list.add("b");
		
		assertEquals(list, graph.getNodes());
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getEdges()}.
	 * @throws AddNodeException 
	 * @throws NoNodeException 
	 * @throws AddEdgeException 
	 */
	@Test
	void testGetEdges()
	throws 	AddNodeException,
			AddEdgeException,
			NoNodeException {
		
		ArrayList<Edge> list = new ArrayList<Edge>();
		Graph graph = new Graph();
		
		graph.addNode("a");
		graph.addNode("b");
		graph.addEdge("a", "b", "x");

		
		list.add(new Edge("a", "b", "x"));
		
		assertEquals(list, graph.getEdges());
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getEdgesFrom(java.lang.String)}.
	 * @throws NoNodeException 
	 * @throws AddNodeException 
	 * @throws AddEdgeException 
	 */
	@Test
	void testGetEdgesFrom()
	throws 	NoNodeException,
			AddNodeException,
			AddEdgeException {
		
		ArrayList<Edge> list = new ArrayList<Edge>();
		Graph graph = new Graph();
		
		graph.addNode("a");
		graph.addNode("b");
		graph.addEdge("a", "b", "x");

		
		list.add(new Edge("a", "b", "x"));
		
		assertEquals(list, graph.getEdgesFrom("a"));
		
		assertThrows(
			NoNodeException.class,
			() -> graph.getEdgesFrom("x")
		);
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getEdgesTo(java.lang.String)}.
	 * @throws AddNodeException 
	 * @throws NoNodeException 
	 * @throws AddEdgeException 
	 */
	@Test
	void testGetEdgesTo()
	throws 	AddNodeException,
			AddEdgeException,
			NoNodeException {
		
		ArrayList<Edge> list = new ArrayList<Edge>();
		Graph graph = new Graph();
		
		graph.addNode("a");
		graph.addNode("b");
		graph.addEdge("a", "b", "x");

		
		list.add(new Edge("a", "b", "x"));
		
		assertEquals(list, graph.getEdgesTo("b"));
		
		assertThrows(
			NoNodeException.class,
			() -> graph.getEdgesTo("x")
		);
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getEdge(java.lang.String, java.lang.String)}.
	 * @throws AddNodeException 
	 * @throws NoNodeException 
	 * @throws AddEdgeException 
	 */
	@Test
	void testGetEdge()
	throws 	AddNodeException,
			AddEdgeException,
			NoNodeException {
		
		ArrayList<Edge> list = new ArrayList<Edge>();
		Graph graph = new Graph();
		
		graph.addNode("a");
		
		assertThrows(
			NoNodeException.class,
			() -> graph.getEdge("a", "b")
		);
		
		assertThrows(
			NoNodeException.class,
			() -> graph.getEdge("b", "a")
		);
		
		assertThrows(
			NoNodeException.class,
			() -> graph.getEdge("b", "c")
		);
		
		graph.addNode("b");
		graph.addNode("c");
		graph.addEdge("a", "b", "x");
		
		assertEquals(new Edge("a", "b", "x"), graph.getEdge("a", "b"));
		assertEquals(null, graph.getEdge("b", "c"));
	}

}
