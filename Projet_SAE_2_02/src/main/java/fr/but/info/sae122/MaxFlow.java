package main.java.fr.but.info.sae122;

import java.util.Collection;

public class MaxFlow {

    private final Graph graph;
    private final String sourceNode;
    private final String sinkNode;

    public MaxFlow(Graph graph, String sourceNode, String sinkNode) {
        this.graph = graph;
        this.sourceNode = sourceNode;
        this.sinkNode = sinkNode;
    }

    public Graph getGraph() {
        return graph;
    }

    public String getSourceNode() {
        return sourceNode;
    }

    public String getSinkNode() {
        return sinkNode;
    }

    public int getSinkFlow(){
        int flow = 0;
        for (Edge edge : graph.getEdgesTo(sinkNode)) {
            flow += edge.getFlux();
        }
        return flow;
    }

    public int getSourceFlow(){
        Collection<Edge> edgeCollection = graph.getEdgesFrom(sourceNode);
        int flow = 0;
        for (Edge edge : edgeCollection) {
            flow += edge.getFlux();
        }
        return flow;
    }

    public void increaseFlow(Path path){
        int flow = path.getFlow();
        for(Edge edge : path.edgeList){
            Edge graphedge = graph.getEdge(edge.getFromNode(), edge.getToNode());
            if(graphedge.getFlux() + flow <= graphedge.getCapacity()){
                graphedge.setFlux(graphedge.getFlux() + flow);
            }
        }
    }

    public int computeMaxFlow() {
        AugmentingPath path = null;
        boolean good = false;

            while(!good){
                try {
                path = new AugmentingPath(graph, sourceNode, sinkNode);
                path.getResidualGraph();
                increaseFlow(path);
            }catch (IllegalArgumentException e){
                good = true;
                }
        }
            return getSinkFlow();
    }

    public static void main(String[] args) throws IncoherentSuccessivityException {
        Graph g = new Graph();
        g.addNode("N1");
        g.addNode("N2");
        g.addNode("N3");
        g.addNode("N4");
        g.addNode("N5");
        Edge e = g.addEdge("N1", "N2", 5);
        Edge e1 = g.addEdge("N1", "N3", 6);
        Edge e2 = g.addEdge("N3", "N4", 10);
        Edge e3 = g.addEdge("N4", "N5", 4);

        MaxFlow maxFlow = new MaxFlow(g, "N1", "N5");

        System.out.println(maxFlow.computeMaxFlow());
    }
}
