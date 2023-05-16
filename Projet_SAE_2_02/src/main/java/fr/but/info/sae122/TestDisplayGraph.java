package src.main.java.fr.but.info.sae122;


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
        graph.addEdge("A", "B", 8);
        graph.addEdge("B", "C", 4);
        graph.addEdge("C", "D", 5);
        graph.addEdge("D", "E", 7);
        graph.addEdge("F", "E", 9);
        graph.addEdge("B", "E", 7);
        graph.addEdge("B", "F", 10);
        graph.addEdge("D", "A", 1);
        graph.addEdge("A", "D", 100);
        System.out.println(graph);
        var display = LibGraph.display(graph);
        BreadthFirstIterator bfi = new BreadthFirstIterator(graph, "A");
        while (bfi.hasNext()) {
            PathElement pe = bfi.next();
            System.out.println(pe.toString());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            display.markEdge(edge.getFromNode(), edge.getToNode());	//erreur
            //display.getEdge("%s-%s".formatted(edge.getFromNode(),edge.getToNode())).setAttribute("ui.class","marked");
        }
        System.out.println("Done iterating");
    }
}
