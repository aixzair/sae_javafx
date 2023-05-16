package fr.but.info.sae122;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPath {

	@Test
	void testConstructor() throws IncoherentSuccessivityException {
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
		assertTrue(path1 instanceof Path);
		
		assertNotNull(path1);
		path2 = new Path(nodes);//TO DO Erreur
		assertNotNull(path2);
		assertTrue(path2 instanceof Path);
		
	}
	
	@Test
	void testSetGetFlow()
	{
		Path path1 = new Path();
		assertTrue(path1.getFlow()==0);
		path1.setFlow(2);
		assertTrue(path1.getFlow()==2);
	}
	
	@Test
	void testAddFirstEdge()
	{
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";
		
		Edge edge0 = new Edge(node0, node1, 5);
		Edge edge1 = new Edge(node1, node2, 5);
		Edge edge2 = new Edge(node0, node2, 5);
		
		Path path1 = new Path();
		
		path1.addFirstEdge(edge0);
		assertTrue(path1.edgeList.get(0) == edge0);
		
		path1.addFirstEdge(edge1);
		assertTrue(path1.edgeList.get(0) == edge1);
		
	}
	
	@Test
	void testAddLastEdge()
	{
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";
		
		Edge edge0 = new Edge(node0, node1, 5);
		Edge edge1 = new Edge(node1, node2, 5);
		Edge edge2 = new Edge(node0, node2, 5);
		
		Path path1 = new Path();
		
		path1.addLastEdge(edge0);
		assertTrue(path1.edgeList.get(path1.edgeList.size()-1) == edge0);
	}

}
