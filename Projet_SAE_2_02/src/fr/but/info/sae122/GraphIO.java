package fr.but.info.sae122;

import main.java.fr.but.info.sae122.AddNodeException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class GraphIO {

  /*
  * @brief: Read the csv file that describe the graph
  * @params: InputStream from -> allow to read the file
  *
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
    } catch (AddEdgeException e) {
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
    Path file = Path.of("graph.csv");
    Writer writer = new OutputStreamWriter(from);
    try {
      BufferedWriter bw = new BufferedWriter(writer);

      StringBuilder line = new StringBuilder();

      for(String s : graph.getNodes()){
        line.append(s).append(";");
      }
      line.append("\n");

      String[] n = new String[graph.getNodes().size()];
      for (String s : graph.getNodes()) {
        for (int i = 0; i < graph.getNodes().size(); i++) {
          n[i] = s;
        }
      }

              String[] nodes = new String[graph.getNodes().size()];
              for (String s : graph.getNodes()) {
                  for (int i = 0; i < graph.getNodes().size(); i++) {
                      nodes[i] = s;
                  }
              }

              for (int i = 0; i < graph.getNodes().size(); i++) {
                  for (int j = i; j < graph.getNodes().size() - 1; j++) {
                      line.append(nodes[i]).append(nodes[j]).append(graph.getEdge(nodes[i], nodes[j]));
                  }
              }
              bw.write(String.valueOf(line));
              bw.close();
          } catch(FileNotFoundException e){
              e.printStackTrace();
          }
      }
}
