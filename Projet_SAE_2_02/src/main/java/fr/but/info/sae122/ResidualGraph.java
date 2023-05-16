package main.java.fr.but.info.sae122;

import java.util.List;

public class ResidualGraph{ 
	
	Graph createFromGraph(Graph graph)
	{
		Graph resGraph = new Graph();
		resGraph.nodes.addAll((List<String>) graph.getNodes());
		//this.edges.addAll((List<Edge>) graph.getEdges());
		
		//List<String> nodeList = (List<String>)graph.getNodes();
		List<Edge> edgeList = (List<Edge>)graph.getEdges();
		for(int i = 0; i < edgeList.size(); i++)
		{
			if(edgeList.get(i).getCapacity() - edgeList.get(i).getFlux() >0 )
			{
				Edge newEdge = new Edge(edgeList.get(i).getFromNode(),
						edgeList.get(i).getToNode(),
						edgeList.get(i).getCapacity() - edgeList.get(i).getFlux());
				newEdge.setFlux(0);
				resGraph.edges.add(newEdge);
			}
			else if(edgeList.get(i).getCapacity() - edgeList.get(i).getFlux() < 0 )
			{
				Edge newEdge = new Edge(edgeList.get(i).getToNode(),
						edgeList.get(i).getFromNode(),
						edgeList.get(i).getFlux());
				newEdge.setFlux(0);
				resGraph.edges.add(newEdge);
			}
		}
		return resGraph;
	}
}
