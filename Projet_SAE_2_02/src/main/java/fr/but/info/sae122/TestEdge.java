
package fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEdge {

	@Test
	void testConstructor() {
		//fail("Not yet implemented");
		
		Edge ed1 = new Edge("N1", "N2", 10);

		assertNotNull(ed1);
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
	void testGet() 
	{
		Edge ed1 = new Edge("N1", "N2", 10);
		
		assertTrue(ed1.getFlux() == 0);
		assertTrue(ed1.getCapacity() ==10);
		assertTrue(ed1.getFromNode() == "N1");
		assertTrue(ed1.getToNode() == "N2");
	}
	
	@Test
	void testSetFlux() 
	{
		Edge ed1 = new Edge("N1", "N2", 10);
		Edge ed2 = new Edge("N1", "N2", 10);
		
		ed1.setFlux(2);
		
		assertTrue(ed1.getFlux() == 2);
		assertFalse(ed1.getFlux() == ed2.getFlux());
	}
	
	@Test
	void testToString() //Erreur : Deux string identiques mais renvoie faux
	{
		Edge ed1 = new Edge("N1", "N2", 10);
		//System.out.println(ed1.toString());
		//System.out.println("Edge[fromNode=N1, toNode=N2, Capacity=" + 10 + ", Flux=" + 0  + "]");
		assertTrue(ed1.toString() == ("Edge[fromNode=N1, toNode=N2, Capacity=" + 10 + ", Flux=" + 0  + "]") );
	}
	
	
}
