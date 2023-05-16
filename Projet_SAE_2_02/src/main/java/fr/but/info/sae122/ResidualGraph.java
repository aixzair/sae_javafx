package fr.but.info.sae122;

import java.util.Collection;
import java.util.List;


/*
 * Returns a graph of all nodes and not filled edges of a previous graph  e
 */
public class ResidualGraph { 
	
	Graph createFromGraph(Graph graph)
	{
		Graph resGraph = new Graph();
		/**Fills node list of the residual graph with the original's**/
		resGraph.nodes.addAll((List<String>) graph.getNodes());
		

		for(Edge edge : graph.getEdges())

		{
			/**Fills the edge list with an edge with no flow if the original one isn't overflowed**/
			if(edge.getCapacity() - edge.getFlux() > 0 )
			{
				resGraph.edges.add(new Edge(edge.getFromNode(), 
						edge.getToNode(), 
						edge.getCapacity() - edge.getFlux()));
			}
			/**Fills the edge list with a reversed edge with no flow if the original is reduceable**/
			else if(edge.getFlux() != 0 )
			{
				resGraph.edges.add(new Edge(edge.getToNode(), 
						edge.getFromNode(),	
						edge.getFlux()));
			}
		}
		return resGraph;
	}
}
