
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
        try{
            while(true){
                path = new AugmentingPath(graph, sourceNode, sinkNode);
                increaseFlow(path);
            }
        }catch (IllegalArgumentException e){
            return path.getFlow();
        }
    }

    public static void main(String[] args) throws IncoherentSuccessivityException {
        Graph g = new Graph();
        g.addNode("N1");
        g.addNode("N2");
        g.addNode("N3");
        Edge e = g.addEdge("N1", "N2", 5);
        Edge e1 = g.addEdge("N1", "N3", 6);
        System.out.println(g);

        Graph g2 = GraphGenerator.createLinear(5);
        System.out.println(g2);
        MaxFlow maxFlow = new MaxFlow(g2, g2.nodes.get(0), g2.nodes.get(4));

        System.out.println(maxFlow.computeMaxFlow());
    }
}
