package fr.but.info.sae122;
import java.awt.Label;
import java.util.ArrayList;

public class GraphGenerator {
	
  public static Graph createLinear(int nbNodes) {
	  
	  Graph graphe = new Graph ();
	  ArrayList<Node> nodes = new ArrayList<Node>();
	  ArrayList<Edge> edges = new ArrayList<Edge>();
	  
	  if(nbNodes>=1) {
		  
		  nodes.add(new Node("N1"));
		  graphe.addNode((nodes.get(0).getName()));
		  
	  }
	  if(nbNodes>1) {
		  
		  for (int i=2; i<=nbNodes; i++) {
			  String nom_graphe = "N"+(char)i;
			  nodes.add(new Node(nom_graphe));
			  nodes.get(i-1).setVoisin(nodes.get(i));
			  edges.add(i,new Edge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName()));
			  graphe.addNode((nodes.get(i).getName()));
			  graphe.addEdge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName());
		  } 
		  
	  }
    
    return graphe;
  }
  
  
  
  public static Graph createCircular(int nbNodes) {
	  
	  Graph graphe = new Graph ();
	  ArrayList<Node> nodes = new ArrayList<Node>();
	  ArrayList<Edge> edges = new ArrayList<Edge>();
	  
	  if(nbNodes>=1) {
		  
		  nodes.add(new Node("N1"));
		  graphe.addNode((nodes.get(0).getName()));
		  
	  }
	  if(nbNodes>1) {
		  
		  for (int i=2; i<=nbNodes; i++) {
			  String nom_graphe = "N"+(char)i;
			  nodes.add(new Node(nom_graphe));
			  nodes.get(i-1).setVoisin(nodes.get(i));
			  edges.add(i,new Edge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName()));
			  graphe.addNode((nodes.get(i).getName()));
			  graphe.addEdge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName());
		  }		  
	  }
	  
	  nodes.get(nbNodes-1).setVoisin(nodes.get(0));
	  edges.add(new Edge (nodes.get(nbNodes-1).getName(),nodes.get(0).getName(),nodes.get(nbNodes-1).getName()+"-"+nodes.get(0).getName()));
	  graphe.addEdge(nodes.get(nbNodes-1).getName(),nodes.get(0).getName(),nodes.get(nbNodes-1).getName()+"-"+nodes.get(0).getName());
	  
    return graphe;
  }
  
  
  public static Graph createTriangular(int nbNodes) {
	  
	  Graph graphe = new Graph ();
	  ArrayList<Node> nodes = new ArrayList<Node>();
	  
	  if(nbNodes>=1) {
		  
		  nodes.add(new Node("N"+(char)nbNodes));
		  graphe.addNode((nodes.get(nbNodes).getName()));
	  }
	  
	  if(nbNodes>1) {
		  int compt = 0;
		  
		  for(int i=nbNodes-1;i<0;i--) {
			
			  String nom_graphe = "N"+(char)i;
			  nodes.add(new Node(nom_graphe)); 
		  }
		  
		  for(int i=0;i>nbNodes-1;i++) {
			  for(int j=1;j<nbNodes-1;j++) {
				  graphe.addEdge(nodes.get(i).getName(),nodes.get(j).getName(),nodes.get(i).getName()+"-"+nodes.get(j).getName());
			  }
		  }
		  
	  }	  	  
	  
    return graphe;
  }
  
  
  public static Graph createFullyConnected(int nbNodes) {
	  
	  
    throw new UnsupportedOperationException("To be written");
  }
  
  

  public static Graph createRandom(int nbNodes, double probability) {
    throw new UnsupportedOperationException("To be written");
  }
  
  

}
