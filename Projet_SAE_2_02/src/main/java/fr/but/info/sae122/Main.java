package main.java.fr.but.info.sae122;


public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		String node0 = "N0";
		String node1 = "N1";
		String node2 = "N2";

		graph.addNode(node0);
		graph.addNode(node1);
		graph.addNode(node2);

		graph.addEdge(node0, node1, 10);
		graph.addEdge(node1, node2, 10);
		
		System.out.println(graph.toString());

	}

}
