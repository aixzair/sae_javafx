package main.java.fr.but.info.sae122;
<<<<<<< HEAD:Projet_SAE_2_02/main/java/fr/but/info/sae122/TestGraphGenerator.java

=======
>>>>>>> 8c86f9227ac8501b9845af7222f7892100757769:Projet_SAE_2_02/src/main/java/fr/but/info/sae122/TestGraphGenerator.java


import java.io.*;

public class TestGraphGenerator {
    public static void main(String[] args) throws FileNotFoundException {
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
        /*var random = GraphGenerator.createRandom(5, 0.5);
        LibGraph.display(random);
        var large = GraphGenerator.createRandom(50, 0.02);
        LibGraph.display(large);*/
        try {
            InputStream stream = new FileInputStream("main/resources/fr/but/info/sae122/seance1/graph.csv");
            Graph g = GraphIO.read(stream);
            LibGraph.display(g);
            OutputStream stream1 = new FileOutputStream("main/resources/fr/but/info/sae122/seance1/graph2.csv");
            GraphIO.write(g, stream1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
