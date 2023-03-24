package fr.but.info.sae122;
import java.util.ArrayList;

public class GraphGenerator {
	
	/*
	 * @author : Orianne ESSIENTH
	 */
	
  public static Graph createLinear(int nbNodes) {
	  
	  /*
	   * @brief : It creates a linear graph
	   * 
	   * @param : int number of nodes in the graph
	   * 
	   * @return : It returns the graph that has been created
	   */
	
  public static Graph createLinear(int nbNodes) {

	  Graph graphe = new Graph ();
	  ArrayList<Node> nodes = new ArrayList<Node>();
	  ArrayList<Edge> edges = new ArrayList<Edge>();
	  Graph graph1 = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
	  if(nbNodes>=1) {
		  graph1.addNode("N1");
		  nodes.add("N1");
		  graph1.addNode((nodes.get(0).getName()));

		  
		  nodes.add(new Node("N1"));
		  graphe.addNode((nodes.get(0).getName()));
	  }
	  if(nbNodes>1) {
		  
		  for (int i=2; i<=nbNodes; i++) {
			  String nodeName = "N"+(char)i;
			  String lastNodeName = "N"+(char)i-1;
			  graph1.addNode(nodeName);
			  graph1.addEdge(lastNodeName,nodeName,lastNodeName+"-"+nodeName);
			  nodes.add(nodeName);
			  
		  }			  String nom_graphe = "N"+(char)i;
			  nodes.add(new Node(nom_graphe));
			  nodes.get(i-1).setVoisin(nodes.get(i));
			  edges.add(i,new Edge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName()));
			  /raphe.addNode((nodes.get(i).getName()));
			  graphe.addEdge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName());
		  }
		  
	  }
    
    return graph1;
  }
  
  
  
  public static Graph createCircular(int nbNodes) {
	  
	  /*

	   * @brief : It creates a circular graph
	   * 
	   * @param : int number of nodes in the graph
	   * 
	   * @return : It returns the graph that has been created

	   */
	  
	  Graph graph1 = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
	  
	  if(nbNodes>=1) {
		  graph1.addNode("N1");
		  nodes.add("N1");
		  
	  }
	  if(nbNodes>1) {
		  
		  for (int i=2; i<=nbNodes; i++) {
			  String nodeName = "N"+(char)i;
			  String lastNodeName = "N"+(char)i-1;
			  graph1.addNode(nodeName);
			  graph1.addEdge(lastNodeName,nodeName,lastNodeName+"-"+nodeName);
			  nodes.add(nodeName);
		 for (int i=2; i<=nbNodes; i++) {
			  String nom_graphe = "N"+(char)i;
			  nodes.add(new Node(nom_graphe));
			  nodes.get(i-1).setVoisin(nodes.get(i));
			  edges.add(i,new Edge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName()));
			  graphe.addNode((nodes.get(i).getName()));
			  graphe.addEdge(nodes.get(i-1).getName(),nodes.get(i).getName(),nodes.get(i-1).getName()+"-"+nodes.get(i).getName());
		  }		  
	  }
	  
	  graph1.addEdge(nbNodes-1,nodes.get(0),nbNodes-1+"-"+nodes.get(0));
    return graph1;
  }
  
  
  public static Graph createTriangular(int nbNodes) {
	  
	  /*
	   * @brief : It creates a triangular graph
	   * 
	   * @param : int number of nodes in the graph
	   * 
	   * @return : It returns the graph that has been created
	   */
	  
	  Graph graph1 = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
 
	  Graph graphe = new Graph ();
	  ArrayList<Node> nodes = new ArrayList<Node>();
	  
	  if(nbNodes>=1) {
		  
		  String nodeName = ("N"+(char)nbNodes);
		  nodes.add(nodeName);
		  graph1.addNode(nodeName);
	  }
	  
	  if(nbNodes>1) {
		  
		  int counter = 1;		  
		  for(int i=nbNodes-1;i>0;i--) {
			  String nodeName = "N"+(char)i;
			  graph1.addNode(nodeName);
			  nodes.add(nodeName); 
		  }
		  
		  for(int i=0;i<nbNodes-1;i++) {
			  for(int j=counter;j<nbNodes-1;j++) {

				  graph1.addEdge(nodes.get(i),nodes.get(j),nodes.get(i)+"-"+nodes.get(j));
				  counter++;
		  for(int i=0;i>nbNodes-1;i++) {
			  for(int j=1;j<nbNodes-1;j++) {
				  graphe.addEdge(nodes.get(i).getName(),nodes.get(j).getName(),nodes.get(i).getName()+"-"+nodes.get(j).getName());
			  }
		  }
		  
	  }	  	  
	  
    return graph1;
  }
  
  
  public static Graph createFullyConnected(int nbNodes) {
	  
	  /*
	   * @brief : It creates a fully-connected graph
	   * 
	   * @param : int number of nodes in the graph
	   * 
	   * @return : It returns the graph that has been created
	   */
	  
	  Graph graph1 = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
	  
	  if(nbNodes>=1) {
		  
		  graph1.addNode("N1");
		  nodes.add("N1");
		  
	  }
	  
	  if(nbNodes>1) {
		  
		  for (int i=2; i<=nbNodes; i++) {
			  String nodeName = "N"+(char)i;
			  graph1.addNode(nodeName);
			  nodes.add(nodeName);
			  }
		  
		  for (int i=0; i<nbNodes;i++) {
			  for (int j=0;j<nbNodes;j++) {
				  if(nodes.get(i)!=nodes.get(j)) {
					  graph1.addEdge(nodes.get(i),nodes.get(j),nodes.get(i)+"-"+nodes.get(j));
				  }
			  }
		  }  
	  
	  }
	  return graph1;
  }
  
  

  public static Graph createRandom(int nbNodes, double probability) {
	  
	  /*
	   * @brief : It creates a graph randomly
	   * 
	   * @param1 : int number of nodes of the graph
	   * 
	   * @param2 : double probability used to create a new edge or not
	   * 
	   * @return : It returns the graph that has been created
	   * 
	   */
	  
	  Graph graph1 = new Graph ();
	  ArrayList<String> nodes = new ArrayList<String>();
	  
		if(nbNodes>=1) {
			
				  graph1.addNode("N1");
				  nodes.add("N1");				  
			  }
			  
		if(nbNodes>1) {
			
			for (int i=2; i<=nbNodes; i++) {

				  String nodeName = "N"+(char)i;
				  graph1.addNode(nodeName);
				  nodes.add(nodeName);
				  }
			}
		
		for (int i=0; i<nbNodes; i++) {
			for (int j=0; j<nbNodes;j++) {
				
				double na = Math.random();
				if (na<=probability) {
					graph1.addEdge(nodes.get(i),nodes.get(j),nodes.get(i)+"-"+nodes.get(j));
				}
				
			}
		}	   
	  
    return graph1;
  }
  }

}
