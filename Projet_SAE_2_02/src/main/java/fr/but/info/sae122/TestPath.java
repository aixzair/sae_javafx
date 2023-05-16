package fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPath {

	@Test
	void testConstructor() {
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";
		String nodes[] = {node0, node1, node2};
		
		Graph graph = new Graph();
		graph.addNode(node0);
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addEdge(node0, node1, 0);
		graph.addEdge(node1, node2, 0);
		
		Path path1 = new Path();
		Path path2;
		
		
		assertNotNull(path1);
		try {
			path2 = new Path(nodes);//TO DO Erreur
			assertNotNull(path2);
		} catch (IncoherentSuccessivityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
