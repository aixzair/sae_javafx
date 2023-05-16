package main.java.fr.but.info.sae122;

import java.util.Collection;

public class MaxFlow {

    private Graph graph;
    private String sourceNode;
    private String sinkNode;

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
        Collection<Edge> edgeList = graph.getEdgesTo(sinkNode);
        int flow = 0;
        for (Edge edge : edgeList) {
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
            if(!(edge.getFlux() + flow > edge.getCapacity())){
                edge.setFlux(edge.getFlux() + flow);
            }
        }
    }

    public int computeMaxFlow() {
        Path path = new AugmentingPath(graph, sourceNode, sinkNode);
        boolean good = false;
        while(!good){

        }

    }

    public static void main(String[] args) throws IncoherentSuccessivityException {
        Graph g = GraphGenerator.createLinear(3);
        g.edges.get(0).setFlux(5);
        g.edges.get(1).setFlux(6);
        MaxFlow maxFlow = new MaxFlow(g, g.nodes.get(0), g.nodes.get(2));

        System.out.println(maxFlow.computeMaxFlow());
    }
}
