package fr.but.info.sae122;
import java.util.ArrayList;

public class GraphGenerator {
	
  public static Graph createLinear(int nbNodes) {
	  
	  Graph graphe = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
	  ArrayList<Edge> edges = new ArrayList<Edge>();
	  
	  if(nbNodes>=1) {
		  
		  /*nodes.add(new Node("N1"));
		  graphe.addNode((nodes.get(0).getName()));*/
		  graphe.addNode("N1");
		  nodes.add("N1");
		  
	  }
	  if(nbNodes>1) {
		  
		  for (int i=2; i<=nbNodes; i++) {
			  String nodeName = "N"+(char)i;
			  String lastNodeName = "N"+(char)i-1;
			  graphe.addNode(nodeName);
			  graphe.addEdge(lastNodeName,nodeName,lastNodeName+"-"+nodeName);
			  nodes.add(nodeName);
			  /*nodes.add(new Node(nom_graphe));
			  nodes.get(i-1).setVoisin(nodes.get(i));
			  edges.add(i,new Edge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName()));
			  graphe.addNode((nodes.get(i).getName()));
			  graphe.addEdge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName());
			  */
			  
		  } 
		  
	  }
    
    return graphe;
  }
  
  
  
  public static Graph createCircular(int nbNodes) {
	  
	  Graph graphe = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
	  ArrayList<Edge> edges = new ArrayList<Edge>();
	  
	  if(nbNodes>=1) {
		  
		  /*nodes.add(new Node("N1"));
		  graphe.addNode((nodes.get(0).getName()));*/
		  graphe.addNode("N1");
		  nodes.add("N1");
		  
	  }
	  if(nbNodes>1) {
		  
		  for (int i=2; i<=nbNodes; i++) {
			  String nodeName = "N"+(char)i;
			  String lastNodeName = "N"+(char)i-1;
			  graphe.addNode(nodeName);
			  graphe.addEdge(lastNodeName,nodeName,lastNodeName+"-"+nodeName);
			  nodes.add(nodeName);
			  /*
			  nodes.get(i-1).setVoisin(nodes.get(i));
			  edges.add(i,new Edge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName()));
			  graphe.addNode((nodes.get(i).getName()));
			  graphe.addEdge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName());
			  */
		  }		  
	  }
	  
	  graphe.addEdge(nbNodes-1,nodes.get(0),nbNodes-1+"-"+nodes.get(0));
	  /*nodes.get(nbNodes-1).setVoisin(nodes.get(0));
	  edges.add(new Edge (nodes.get(nbNodes-1).getName(),nodes.get(0).getName(),nodes.get(nbNodes-1).getName()+"-"+nodes.get(0).getName()));
	  graphe.addEdge(nodes.get(nbNodes-1).getName(),nodes.get(0).getName(),nodes.get(nbNodes-1).getName()+"-"+nodes.get(0).getName());
	  */
    return graphe;
  }
  
  
  public static Graph createTriangular(int nbNodes) {
	  
	  Graph graphe = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
	  
	  if(nbNodes>=1) {
		  
		  String nodeName = ("N"+(char)nbNodes);
		  nodes.add(nodeName);
		  //graphe.addNode((nodes.get(nbNodes).getName()));
		  graphe.addNode(nodeName);
	  }
	  
	  if(nbNodes>1) {
		  
		  int compt = 1;		  
		  for(int i=nbNodes-1;i<0;i--) {
			
			  String nodeName = "N"+(char)i;
			  graphe.addNode(nodeName);
			  nodes.add(nodeName); 
		  }
		  
		  for(int i=0;i>nbNodes-1;i++) {
			  for(int j=compt;j<nbNodes-1;j++) {
				  graphe.addEdge(nodes.get(i),nodes.get(j),nodes.get(i)+"-"+nodes.get(j));
				  compt++;
			  }
		  }
		  
	  }	  	  
	  
    return graphe;
  }
  
  
  public static Graph createFullyConnected(int nbNodes) {
	  
	  Graph graphe = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
	  ArrayList<Edge> edges = new ArrayList<Edge>();
	  
	  if(nbNodes>=1) {
		  
		  graphe.addNode("N1");
		  nodes.add("N1");
		  
	  }
	  
	  if(nbNodes>1) {
		  
		  for (int i=2; i<=nbNodes; i++) {
			  String nodeName = "N"+(char)i;
			  graphe.addNode(nodeName);
			  nodes.add(nodeName);
			  }
		  
		  for (int i=0; i<nbNodes;i++) {
			  for (int j=0;j<nbNodes;j++) {
				  if(nodes.get(i)!=nodes.get(j)) {
					  graphe.addEdge(nodes.get(i),nodes.get(j),nodes.get(i)+"-"+nodes.get(j));
				  }
			  }
		  }  
	  
	  }
	  return graphe;
  }
  
  

  public static Graph createRandom(int nbNodes, double probability) {
	  
	  Graph graphe = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
	  
		if(nbNodes>=1) {
			
				  graphe.addNode("N1");
				  nodes.add("N1");				  
			  }
			  
		if(nbNodes>1) {
			
			for (int i=2; i<=nbNodes; i++) {

				  String nodeName = "N"+(char)i;
				  graphe.addNode(nodeName);
				  nodes.add(nodeName);
				  }
			}
		
		for (int i=0; i<nbNodes; i++) {
			for (int j=0; j<nbNodes;j++) {
				
				double na = Math.random();
				if (na<=probability) {
					graphe.addEdge(nodes.get(i),nodes.get(j),nodes.get(i)+"-"+nodes.get(j));
				}
				
			}
		}	   
	  
    return graphe;
  }
  
  

}
