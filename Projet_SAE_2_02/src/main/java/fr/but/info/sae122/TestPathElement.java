package src.main.java.fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPathElement {

	@Test
	void testConstructor() {
		Edge edge0 = new Edge("N1", "N2", 10);
		Edge edge1 = new Edge("N2", "N3", 10);
		
		PathElement pe0 = new PathElement(null, edge0);

		assertNotNull(pe0);
		assertTrue(pe0 instanceof PathElement);
		
		//PathElement pe1 = new PathElement(pe0, edge1);
		
	}
	
	@Test
	void testGetParent() {
		Edge edge0 = new Edge("N1", "N2", 10);
		Edge edge1 = new Edge("N2", "N3", 10);

		PathElement pe0 = new PathElement(null, edge0);
		PathElement pe1 = new PathElement(pe0, edge1);
		
		assertTrue(pe1.getParent() == pe0);
		
	}
	
	@Test
	void testGetMaxFlow() {
		Edge edge0 = new Edge("N1", "N2", 5);
		Edge edge1 = new Edge("N2", "N3", 10);

		PathElement pe0 = new PathElement(null, edge0);
		PathElement pe1 = new PathElement(pe0, edge1);
		
		assertTrue(pe1.getMaxFlow() == 5);
	}
	
	@Test
	void testGetEdge() {
		Edge edge0 = new Edge("N1", "N2", 5);

		PathElement pe0 = new PathElement(null, edge0);
		
		assertTrue(pe0.getEdge() == edge0);
	}

}
