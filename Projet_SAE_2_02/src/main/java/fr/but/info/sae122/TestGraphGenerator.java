package main.java.fr.but.info.sae122;

public class TestGraphGenerator {
  public static void main(String[] args) {
    /*
    var linear = GraphGenerator.createLinear(5);
    LibGraphTest.display(linear);
    var circular = GraphGenerator.createCircular(5);
    LibGraphTest.display(circular);
    var triangular = GraphGenerator.createTriangular(5);
    LibGraphTest.display(triangular);
    var full = GraphGenerator.createFull(5);
    LibGraphTest.display(full);
     */
    var random = GraphGenerator.createRandom(5, 0.5);
    LibGraph.display(random);
    var large = GraphGenerator.createRandom(50, 0.02);
    LibGraph.display(large);

  }
}
