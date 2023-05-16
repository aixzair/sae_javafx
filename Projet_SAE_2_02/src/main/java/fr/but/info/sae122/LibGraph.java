package fr.but.info.sae122.seance1;

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
      disp.addEdge(edge.getFromNode(), edge.getToNode(), edge.getLabel());
    disp.display();
    return disp;
  }

}
