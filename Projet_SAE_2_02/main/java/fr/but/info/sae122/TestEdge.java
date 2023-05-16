package main.java.fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEdge {

	@Test
	void testConstructor() {
		//fail("Not yet implemented");
		
		Edge ed1 = new Edge("N1", "N2", 10);
		
		assertTrue(ed1 instanceof Edge && 
				ed1.getFromNode() == "N1"
				&& ed1.getToNode() == "N2" 
				&& ed1.getCapacity() == 10);
	}
	
	@Test
	void testEquals() {
		//fail("Not yet implemented");
		
		Edge ed1 = new Edge("N1", "N2", 10);
		Edge ed2 = new Edge("N1", "N2", 10);
		//Edge ed3 = new Edge("N1", "N3", 10);
		//Edge ed4 = new Edge("N1", "N2", 8);
		
		assertEquals(ed1, ed1);
		assertEquals(ed1, ed2);
	}
	
	@Test
	void testSet() {

}
