package fr.but.info.sae122;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 A Breadth-First Iterator that enumerates all edges, starting from a given node.
 */
public class BreadthFirstIterator implements Iterator<PathElement> {

    private final Set<String> visitedNodes;
    private final ArrayDeque<Edge> queue;
    private final Graph graph;
    private PathElement pathElement;

    /** Builds a new iterator.
     * @param graph the graph to iterate
     * @param firstNode the node to start from
     */
    public BreadthFirstIterator(Graph graph, String firstNode) {
        this.queue = new ArrayDeque<>();
        this.visitedNodes = new HashSet<>();
        this.graph = graph;
        queue.addAll(graph.getEdgesFrom(firstNode));
        this.pathElement=new PathElement(null,null);
        visitedNodes.add(firstNode);
    }

    /** Tests whether the iteration is finished or not.
     * @return true if the iteration can continue - that is next() will not fail
     */
    @Override
    public boolean hasNext() {
        return ! queue.isEmpty();
    }

    /** Gets the next edge of the enumeration.
     * @return the next edge of the graph.
     * @throws java.util.NoSuchElementException if there is no more edge to enumerate
     */
    @Override
    public PathElement next() {
        var edge = queue.removeFirst();
        var dest = edge.getToNode();
        if(edge.getFlux()==0 || edge.getCapacity()==pathElement.getMaxFlow()) {
        	return pathElement;
        }
        if (! visitedNodes.contains(dest)) {
            queue.addAll(graph.getEdgesFrom(dest));
            visitedNodes.add(dest);
            pathElement=new PathElement(pathElement,edge);
        }
        return pathElement;
    }
}
