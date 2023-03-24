/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.but.info.sae122.AddEdgeException;
import fr.but.info.sae122.AddNodeException;
import fr.but.info.sae122.Graph;
import fr.but.info.sae122.NoNodeException;

/**
 * @author alexl
 *
 */
class TestGraph {

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
		/*assertEquals(1, graph.getEdges().size());

		graph.addEdge("a", "c", "y");
		assertEquals(2, graph.getEdges().size());

		assertThrows(
			AddEdgeException.class,
			() -> graph.addEdge("a", "b", "3")
		);*/
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getNodes()}.
	 */
	@Test
	void testGetNodes() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getEdges()}.
	 */
	@Test
	void testGetEdges() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getEdgesFrom(java.lang.String)}.
	 */
	@Test
	void testGetEdgesFrom() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getEdgesTo(java.lang.String)}.
	 */
	@Test
	void testGetEdgesTo() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getEdge(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetEdge() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#getNodeList()}.
	 */
	@Test
	void testGetNodeList() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link fr.but.info.sae122.Graph#toString()}.
	 */
	@Test
	void testToString() {
		// fail("Not yet implemented");
	}

}
