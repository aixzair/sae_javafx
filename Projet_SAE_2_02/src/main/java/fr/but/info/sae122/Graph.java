package fr.but.info.sae122;

import java.util.*;

/**
 * A graph with a list of nodes and a list of edges.
 */
public class Graph {
  private final List<String> nodes;
  private final List<Edge> edges;

  /** Stores all the outgoing edges for ease of use */
  private final Map<String, List<Edge>> mapFrom;
  /** Stores all the ingoing edges for ease of use */
  private final Map<String, List<Edge>> mapTo;

  /** Builds an empty graph with no node nor edge. */
  public Graph() {
    nodes = new ArrayList<>();
    edges = new ArrayList<>();
    mapFrom = new HashMap<>();
    mapTo = new HashMap<>();
  }

  /** Adds a new node to this graph.
   * @param name the node to add
   * @throws IllegalArgumentException if the node already exists
   */
  public void addNode(String name) {
    if (nodes.contains(name)) throw new IllegalArgumentException("Node "+name+" already exists !");
    nodes.add(name);
    mapFrom.put(name, new ArrayList<>());
    mapTo.put(name, new ArrayList<>());
  }

  /** Adds a new edge to this graph.
   * @param from the node to start from
   * @param to the node to arrive at
   * @param label the edge's label
   * @return the newly built edge.
   * @throws IllegalArgumentException if the two nodes are not in this graph
   * @throws IllegalArgumentException if the new edge would link a node to itself
   */
  public Edge addEdge(String from, String to, String label) {
    if (from.equals(to)) throw new IllegalArgumentException("Autolink are forbidden !");
    List<Edge> fromList = mapFrom.get(from);
    List<Edge> toList = mapTo.get(to);
    if (fromList == null) throw new IllegalArgumentException(from+" node does not exist!");
    if (toList == null) throw new IllegalArgumentException(to+" node does not exist!");
    Edge edge = new Edge(from, to, label);
    edges.add(edge);
    fromList.add(edge);
    toList.add(edge);
    return edge;
  }

  /** Gets the nodes of this graph.
   * @return the unmodifiable collection of nodes in the graph.
   */
  public Collection<String> getNodes() {
    return Collections.unmodifiableList(nodes);
  }

  /** Gets the edges of this graph.
   * @return the unmodifiable collection of edges in this graph.
   */
  public Collection<Edge> getEdges() {
    return Collections.unmodifiableList(edges);
  }

  /** Gets the edges of this graph starting from the given node.
   * @param node the node to look edges starting from
   * @return the unmodifiable collection of edges in this graph that have the requested first node.
   */
  public Collection<Edge> getEdgesFrom(String node) {
    List<Edge> res = mapFrom.get(node);
    if (res != null)
      return Collections.unmodifiableList(res);
    else
      throw new IllegalArgumentException("No such node !");
  }

  /** Gets the edges of this graph ending at the given node.
   * @param node the node to look edges ending at
   * @return the unmodifiable collection of edges in this graph that have the requested last node.
   */
  public Collection<Edge> getEdgesTo(String node) {
    List<Edge> res = mapTo.get(node);
    if (res != null)
      return Collections.unmodifiableList(res);
    else
      throw new IllegalArgumentException("No such node !");
  }

  /** Gets the edge from one node to another.
   * If there are multiple edges possible, any one is returned.
   * @param fromNode the node the requested edge has to start from
   * @param toNode the node the requested edge has to arrive at
   * @return the requested edge
   * @throws IllegalArgumentException if the fist node is not in this graph
   * @throws IllegalArgumentException if the last node is not linked with the first
   */
  public Edge getEdge(String fromNode, String toNode) {
    Collection<Edge> edgesFrom = getEdgesFrom(fromNode);
    if (edgesFrom == null)
      throw new IllegalArgumentException("No such node "+fromNode);
    Edge res = edgesFrom.stream().filter(e -> e.getToNode().equals(toNode)).findAny().orElse(null);
    if (res != null)
      return res;
    else
      throw new IllegalArgumentException("No such edge !");
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder("Graph:\n");
    for (var node: getNodes()) {
      res.append("- Node ");
      res.append(node);
      res.append(":\n");
      for(var edge: getEdgesFrom(node)) {
        res.append("  > ");
        res.append(edge.toString());
        res.append("\n");
      }
    }
    return res.toString();
  }
}
