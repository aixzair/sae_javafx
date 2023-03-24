
package fr.but.info.sae122;

package src.fr.but.info.sae122;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestEdge {

	@Test
	void testEquals() {

		Edge arr1 = new Edge("node1", "node2", "arr1");
		Edge arr2 = new Edge("node1", "node2", "arr1");
		Edge arr3 = new Edge("node1", "node2", "arr3");
		Edge arr4 = new Edge("node3", "node2", "arr4");
		Edge arr5 = new Edge("node1", "node3", "arr5");
		
		assertTrue(arr1.equals(arr1));
		assertTrue(arr1.equals(arr2));
		assertFalse(arr1.equals(arr3));
		assertFalse(arr1.equals(arr4));
		assertFalse(arr1.equals(arr5));
	}
	
	@Test
	void testConstructeur()
	{
		Edge arr = new Edge("node1", "node2", "arr");
		assertEquals("node1",arr.getFromNode());
		assertEquals("node2",arr.getToNode());
		assertEquals("arr",arr.getLabel());
	}
}
