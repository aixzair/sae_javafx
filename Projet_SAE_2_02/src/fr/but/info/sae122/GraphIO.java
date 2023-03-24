

package fr.but.info.sae122;


import sae122.SimpleGraphDisplay;
=======
package src.fr.but.info.sae122;
>>>>>>> lukas

import java.io.*;
import java.util.*;

public class GraphIO {

    /*
    * Author : Alenso
    * */


  /*
  * @brief: Read the csv file that describe the graph
  * @params: InputStream from -> allow to read the file
  * @return The graph that has been created
  * */
  public static Graph read(InputStream from) throws IOException {
    Reader r = new InputStreamReader(from);
    Graph g = new Graph();
    String ligne = null;
    try{
      BufferedReader reader = new BufferedReader(r);
      ligne = reader.readLine();
      String[] nodes = ligne.split(";");
      for(String s : nodes){
        g.addNode(s);
      }
      boolean e = false;
      while((ligne = reader.readLine()) != null){
        if(Objects.equals(ligne, "\n")){
          e = true;
        }
        if(e){
          String[] edges = ligne.split(";");
          if(!(edges.length > 3)){
            g.addEdge(edges[0], edges[1], edges[2]);
          }else{
            int node = 0, arr = 0;
            for(int i = 0; i < edges.length; i++){
              if(i%2==0) node = i;
              else arr = i;

              if(node != 0 && arr != 0) g.addEdge(edges[0], edges[node], edges[arr]);
              }
            }
          }
        }
      reader.close();
    }catch (FileNotFoundException e){
      e.printStackTrace();
    } catch (AddEdgeException | AddNodeException | NoNodeException e) {
      throw new RuntimeException(e);
    }
    return g;
  }

  /*
  * @brief Write in the csv file, the function create the file that describe the graph
  * @params Graph graph the graph which is describe
  * @params OutputStream from allow to write in the file
  * */
  public static void write(Graph graph, OutputStream from) throws IOException {
    Writer writer = new OutputStreamWriter(from);
    try {
      BufferedWriter bw = new BufferedWriter(writer);

      StringBuilder line = new StringBuilder();

      for(String s : graph.getNodes()){
        line.append(s).append(";");
      }
      line.append('\n');

      ArrayList<String> nodes = new ArrayList<>(graph.getNodes());

      for (int i = 0; i < graph.getNodes().size(); i++) {
          for (int j = 0; j < graph.getNodes().size(); j++) {
              if(i != j && graph.getEdge(nodes.get(i), nodes.get(j)) != null){
                  line.append(nodes.get(i))
                          .append(";")
                          .append(nodes.get(j))
                          .append(";")
                          .append(graph.getEdge(nodes.get(i), nodes.get(j)).getLabel());
                  line.append("\n");
              }

          }
      }
          bw.write(String.valueOf(line));
          bw.close();
          } catch(FileNotFoundException e){
              e.printStackTrace();
          }
      }


      public static SimpleGraphDisplay readGraphDisplay(InputStream from){
        Reader r = new InputStreamReader(from);
        String ligne = null;
        SimpleGraphDisplay display = new SimpleGraphDisplay("Simple display");
        ArrayList<String> l = new ArrayList<>();
        try{
          BufferedReader reader = new BufferedReader(r);

          ligne = reader.readLine();
          String[] nodes = ligne.split(";");

          for(String s : nodes){
            display.addNode(s);
          }

          reader.readLine();

          while((ligne = reader.readLine()) != null){
              String[] args = ligne.split(";");
            for (int i = 1; i < args.length; i+=2) {
              display.addEdge(args[0], args[i], args[i+1]);
            }

          }

          reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return display;
      }


  public static void main(String[] args) throws FileNotFoundException {
      readGraphDisplay(new FileInputStream("graph.csv")).display();

  }
}
