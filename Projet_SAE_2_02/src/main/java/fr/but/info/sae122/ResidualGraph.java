package fr.but.info.sae122;

import java.util.Collection;
import java.util.List;

import main.java.fr.but.info.sae122.Graph;

/*
 * Returns a graph of all nodes and not filled edges of a previous graph  e
 */
public class ResidualGraph { 
	
	Graph createFromGraph(Graph graph)
	{
		Graph resGraph = new Graph();
		/**Fills node list of the residual graph with the original's**/
		resGraph.nodes.addAll((List<String>) graph.getNodes());
		
		for(int i = 0; i < edgeList.size(); i++)
		{
			/**Fills the edge list with an edge with no flow if the original one isn't overflowed**/
			if(edgeList.get(i).getCapacity() - edgeList.get(i).getFlux() > 0 )
			{
				resGraph.edges.add(new Edge(edgeList.get(i).getFromNode(), 
						edgeList.get(i).getToNode(), 
						edgeList.get(i).getCapacity() - edgeList.get(i).getFlux()));
			}
			/**Fills the edge list with a reversed edge with no flow if the original is at least partially filled and is reduceable**/
			else if(edgeList.get(i).getFlux() != 0 )
			{
				resGraph.edges.add(new Edge(edgeList.get(i).getToNode(), 
						edgeList.get(i).getFromNode(),	
						edgeList.get(i).getFlux()));
			}
		}
		return resGraph;
	}
}
