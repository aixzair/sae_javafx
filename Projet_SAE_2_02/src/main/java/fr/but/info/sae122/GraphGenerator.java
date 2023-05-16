package main.java.fr.but.info.sae122;


import java.util.Random;

/** Tool class to build standard graphs */
public class GraphGenerator {
    /** Builds a linear graph with the requested number of nodes.
     * Each node is linked to the next one but the last.
     * @param nbNodes the number of nodes.
     * @return the new graph
     * @throws IllegalArgumentException if nbNodes is not at least 1
     */

    private static Random random = new Random();
    public static Graph createLinear(int nbNodes) {
        if (nbNodes < 1) throw new IllegalArgumentException("A graph should have at least one node!");
        Graph graph = new Graph();
        graph.addNode("N0");
        for (int i=1; i<nbNodes; ++i) {
            graph.addNode("N"+i);
            graph.addEdge("N"+(i-1), "N"+i, random.nextInt(10) + 1);
            graph.getEdge("N"+(i-1), "N"+i).setFlux(0);
        }
        return graph;
    }
    /** Builds a circular graph with the requested number of nodes.
     * Each node is linked to the next one and the last to the first.
     * @param nbNodes the number of nodes.
     * @return the new graph
     * @throws IllegalArgumentException if nbNodes is not at least 1
     */
    public static Graph createCircular(int nbNodes) {
        Graph graph = createLinear(nbNodes);
        graph.addEdge("N"+(nbNodes-1), "N0", random.nextInt(10) + 1);
        graph.getEdge("N"+(nbNodes-1), "N0").setFlux(0);
        return graph;
    }
    /** Builds a triangular graph with the requested number of nodes.
     * Each node is linked to all the following nodes.
     * @param nbNodes the number of nodes.
     * @return the new graph
     */
    public static Graph createTriangular(int nbNodes) {
        Graph graph = new Graph();
        for (int i=0; i<nbNodes; ++i) {
            graph.addNode("N"+i);
            for (int j=0; j<i; j++){
                graph.addEdge("N"+j, "N"+i, random.nextInt(10) + 1);
                graph.getEdge("N" + j, "N" + i).setFlux(0);
            }
        }
        return graph;
    }
    /** Builds a fully-connected graph with the requested number of nodes.
     * Each node is linked to all the other nodes.
     * @param nbNodes the number of nodes.
     * @return the new graph
     */
    public static Graph createFull(int nbNodes) {
        Graph graph = new Graph();
        for (int i=0; i<nbNodes; ++i) {
            graph.addNode("N"+i);
        }
        for (int i=0; i<nbNodes; ++i)
            for (int j = 0; j < nbNodes; j++)
                if (i != j){
                    graph.addEdge("N" + j, "N" + i, random.nextInt(10) + 1);
                    graph.getEdge("N" + j, "N" + i).setFlux(0);
                }

        return graph;
    }

    /** Builds a fully-connected graph with the requested number of nodes.
     * Each node is linked to all the other nodes with a given probability.
     * @param nbNodes the number of nodes.
     * @param edgeProbability the probability of each edge to be present.
     * @return the new graph
     */
    public static Graph createRandom(int nbNodes, double edgeProbability) {
        Graph graph = new Graph();
        for (int i=0; i<nbNodes; ++i) {
            graph.addNode("N"+i);
        }
        for (int i=0; i<nbNodes; ++i)
            for (int j = 0; j < nbNodes; j++)
                if (i != j && Math.random()<edgeProbability ){
                    graph.addEdge("N" + j, "N" + i, random.nextInt(10) + 1);
                    graph.getEdge("N" + j, "N" + i).setFlux(0);
                }
        return graph;
    }
}
