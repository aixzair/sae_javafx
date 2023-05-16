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

        for(Edge e : graph.getEdgesFrom(firstNode)){
            queue.add(new PathElement(null, e));
        }
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
    public PathElement next() {

        /*var pathelement = queue.removeFirst();

        var dest = pathelement.getEdge();

        if(!visitedNodes.contains(dest.getToNode())) {
            for (Edge e : graph.getEdgesFrom(dest.getFromNode())) {
                if(e.getCapacity() != 0 && e.getCapacity() != e.getFlux()) {
                    queue.add(new PathElement(pathelement, e));
                    visitedNodes.add(e.getToNode());
                }
            }
        }
        return pathelement;*/
        PathElement element = queue.removeFirst();
        String dest = element.getEdge().getToNode();
        if(!visitedNodes.contains(dest)){
            for(Edge edge : graph.getEdgesFrom(dest)){
                queue.add(new PathElement(element, edge));
            }
            visitedNodes.add(dest);
        }
        return element;
    }
}
