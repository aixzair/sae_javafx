
package fr.but.info.sae122;

import java.util.Collection;

public class MaxFlow {

    private Graph graph;
    private String sourceNode;
    private String sinkNode;
    
    /**
     * 
     * @param graph anylized
     * @param sourceNode from which node we start
     * @param sinkNode to which we finish
     */

    public MaxFlow(Graph graph, String sourceNode, String sinkNode) {
        this.graph = graph;
        this.sourceNode = sourceNode;
        this.sinkNode = sinkNode;
    }

    /**
     * Gets the graph of the max flow
     * @return the graph of the maximal flow
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * Gets the sourceNode from which we start
     * @return the source node of the maximal flow
     */
    public String getSourceNode() {
        return sourceNode;
    }

    /**
     * Gets the sinkNode to which we finish
     * @return the sink node of the maximal flow
     */
    public String getSinkNode() {
        return sinkNode;
    }
    
    /**
     * Gets the Sink Flow 
     * @return the sink flow
     */

    public int getSinkFlow(){
        Collection<Edge> edgeList = graph.getEdgesTo(sinkNode);
        int flow = 0;
        for (Edge edge : edgeList) {
            flow += edge.getFlux();
        }
        return flow;
    }

    /**
     * Gets the sourceFlow
     * @return the source flow
     */
    public int getSourceFlow(){
        Collection<Edge> edgeCollection = graph.getEdgesFrom(sourceNode);
        int flow = 0;
        for (Edge edge : edgeCollection) {
            flow += edge.getFlux();
        }
        return flow;
    }
    /**
     * increases a flow from a path
     * @param path containing the flow
     */

    public void increaseFlow(Path path){
        int flow = path.getFlow();
        for(Edge edge : path.edgeList){
            if(!(edge.getFlux() + flow > edge.getCapacity())){
                edge.setFlux(edge.getFlux() + flow);
            }
        }
    }
    
    /**
     * Checks if the flow of a path is increasable
     * @param path containing the flow tested
     * @return if it's increasable or not
     */

    private boolean checkIfItsIncreasable(Path path){
        int nb = 0;
        for(Edge edge : path.edgeList){
            if(edge.getFlux() + path.getFlow() >= edge.getCapacity()) nb++;
        }
        if(nb != path.edgeList.size()) return false;
        return true;
    }

    /**
     * calculs an augmented path and enhance it as possible
     * @return the computed max flow
     * @throws IncoherentSuccessivityException
     */
    public int computeMaxFlow() throws IncoherentSuccessivityException {
        Path path = new Path(graph.getNodes().toArray(new String[0]));

        boolean good = false;
        while(!good){
            System.out.println(path.getFlow());
            if(checkIfItsIncreasable(path)) increaseFlow(path);
            else good = true;
        }
        return path.getFlow();
    }

    public static void main(String[] args) throws IncoherentSuccessivityException {
        Graph g = GraphGenerator.createLinear(3);
        g.edges.get(0).setFlux(5);
        g.edges.get(1).setFlux(6);
        MaxFlow maxFlow = new MaxFlow(g, g.nodes.get(0), g.nodes.get(2));

        System.out.println(maxFlow.computeMaxFlow());
    }
}
