package main.java.fr.but.info.sae122;

import java.util.Collection;
import java.util.List;


/*
 * Returns a graph of all nodes and not filled edges of a previous graph  e
 */
public class ResidualGraph { 


	/**
	 * Create a graph only with a optimized path with the capacity
	 * @param graph the graph that we want to modify
	 * @return the new graph with the path*/
	public Graph createFromGraph(Graph graph)
	{
		Graph resGraph = new Graph();
		/**Fills node list of the residual graph with the original's**/

		for(String s : graph.getNodes()){
			resGraph.addNode(s);
		}

		graph.getEdges().forEach(edge -> {
			if(edge.getCapacity() != edge.getFlux()) resGraph.addEdge(edge.getFromNode(), edge.getToNode(), edge.getCapacity() - edge.getFlux());
			if(edge.getFlux() != 0) resGraph.addEdge(edge.getToNode(), edge.getFromNode(), edge.getFlux());
		});
		return resGraph;
	}
}
