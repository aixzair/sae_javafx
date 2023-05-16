package main.java.java.fr.but.info.sae122;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestMaxFlow {
    @Test
    public void constructorTest(){
        Graph graph = GraphGenerator.createLinear(4);
        String[] nodes = {graph.nodes.get(0), graph.nodes.get(3)};
        MaxFlow maxFlow = new MaxFlow(graph, nodes[0], nodes[1]);
        assertEquals(maxFlow.getGraph(), graph);
        assertEquals(maxFlow.getSinkNode(), nodes[0]);
        assertEquals(maxFlow.getSourceNode(), nodes[1]);
    }

    @Test
    public void getSinkFlowTest(){
        Graph graph =new Graph();
        graph.addNode("N1");
        graph.addNode("N2");
        graph.addNode("N3");
        graph.addEdge("N1", "N2", 4);
        graph.addEdge("N1", "N2", 6);
        String[] nodes = {graph.nodes.get(0), graph.nodes.get(2)};
        MaxFlow maxFlow = new MaxFlow(graph, nodes[0], nodes[1]);
        graph.edges.get(0).setFlux(4);
        graph.edges.get(1).setFlux(1);
        assertEquals(maxFlow.getSinkFlow(), 5);
    }
}
