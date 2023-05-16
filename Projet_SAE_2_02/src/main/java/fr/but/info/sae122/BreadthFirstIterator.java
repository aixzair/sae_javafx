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
    private final ArrayDeque<PathElement> queue;
    private final Graph graph;

    /** Builds a new iterator.
     * @param graph the graph to iterate
     * @param firstNode the node to start from
     */
    public BreadthFirstIterator(Graph graph, String firstNode) {
        this.queue = new ArrayDeque<>();
        this.visitedNodes = new HashSet<>();
        this.graph = graph;
        queue.add(new PathElement(null,graph.getEdge(firstNode, firstNode)));
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
        var pathElement = queue.removeFirst();
        var dest = pathElement.getEdge().getToNode();
        if(pathElement.getEdge().getCapacity()==0 || pathElement.getEdge().getCapacity()==pathElement.getMaxFlow()) {
        	return pathElement;
        }
        if (! visitedNodes.contains(dest)) {
        	queue.add(new PathElement(pathElement,graph.getEdge(pathElement.getEdge().getFromNode(), dest)));
            visitedNodes.add(dest);
        }
        return pathElement;
    }
}
