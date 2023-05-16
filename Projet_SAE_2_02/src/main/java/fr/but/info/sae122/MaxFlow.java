package main.java.fr.but.info.sae122;

import java.util.Collection;
import java.util.List;

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
        for(Edge edge : path.getEdge()){
            if(!(edge.getFlux() + flow > edge.getCapacity())){
                edge.setFlux(edge.getFlux() + flow);
            }
        }
    }
}
