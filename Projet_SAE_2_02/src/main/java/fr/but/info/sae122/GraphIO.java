package main.java.fr.but.info.sae122;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

public class GraphIO {
  public static Graph read(InputStream from) throws IOException {
    Path file = Path.of("graph.csv");
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
            g.addEdge(edges[0], edges[3], edges[edges.length-1]);
            }
          }
        }
      reader.close();
    }catch (Exception e){
      e.printStackTrace();
    }
    return g;
  }
  public static void write(Graph graph, OutputStream from) throws IOException {


  }
}
