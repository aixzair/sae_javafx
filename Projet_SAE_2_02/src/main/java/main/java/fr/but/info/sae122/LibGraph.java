<<<<<<<< HEAD:Projet_SAE_2_02/main/java/fr/but/info/sae122/LibGraph.java
========

>>>>>>>> orianne:Projet_SAE_2_02/src/main/java/main/java/fr/but/info/sae122/LibGraph.java
package main.java.fr.but.info.sae122;


import sae122.SimpleGraphDisplay;

/** Simple tool class to build a graphical view from a Graph */
public class LibGraph {

    /** Creates a window to display the specified graph
     * @param graph the graph to display
     * @return the window displaying the graph
     */
    public static SimpleGraphDisplay display(Graph graph) {
        SimpleGraphDisplay disp = new SimpleGraphDisplay("Graphe");
        for (String node : graph.getNodes())
            disp.addNode(node);
        for (Edge edge : graph.getEdges())
            disp.addEdge(edge.getFromNode(), edge.getToNode(), edge.getFlux() + " / " + edge.getCapacity());
        disp.display();
        return disp;
    }

}
