package fr.but.info.sae122;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGraph {

	@Test
	void testConstructor() {
		
		Graph graph = new Graph();
		
		assertNotNull(graph);
		assertTrue(graph instanceof Graph);
	}//TO DO

}
