package fr.but.info.sae122.seance1;

/**
 * Simple test class to check displaying of graphs and iterations
 */
public class TestDisplayGraph {
  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addNode("D");
    graph.addNode("E");
    graph.addNode("F");
    graph.addEdge("A", "B", "AB");
    graph.addEdge("B", "C", "BC");
    graph.addEdge("C", "D", "CD");
    graph.addEdge("D", "E", "DE");
    graph.addEdge("F", "E", "FE");
    graph.addEdge("B", "E", "BE");
    graph.addEdge("B", "F", "BF");
    graph.addEdge("D", "A", "DA");
    graph.addEdge("A", "D", "AD");
    System.out.println(graph);
    var display = LibGraph.display(graph);
    BreadthFirstIterator bfi = new BreadthFirstIterator(graph, "A");
    while (bfi.hasNext()) {
      Edge edge = bfi.next();
      System.out.println(edge.toString());
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      display.markEdge(edge.getFromNode(), edge.getToNode());
      //display.getEdge("%s-%s".formatted(edge.getFromNode(),edge.getToNode())).setAttribute("ui.class","marked");
    }
    System.out.println("Done iterating");
  }
}
