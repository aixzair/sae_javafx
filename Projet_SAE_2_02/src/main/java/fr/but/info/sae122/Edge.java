package main.java.fr.but.info.sae122;

import java.util.Objects;

/**
 A simple edge, going from one node to another, with a String label.
 */
public final class Edge {
    private final String fromNode;
    private final String toNode;
    private int capacity;
    private int flux;

    /** Builds a new edge.
     * @param fromNode the node to start from
     * @param toNode the node to arrive at
     * @param capacity the label
     */
    public Edge(
            String fromNode,
            String toNode,
            int capacity) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.capacity = capacity;
    }

    /** Gets the node this edge starts from
     * @return the first node
     */
    public String getFromNode() {
        return fromNode;
    }

    /** Gets the node this edge ends at
     * @return the last node
     */
    public String getToNode() {
        return toNode;
    }

    /** Gets this edge's label
     * @return the label
     */
    public int getCapacity() {
        return capacity;
    }

    public int getFlux() {
        return flux;
    }

    public void setFlux(int flux) {
        this.flux = flux;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Edge) obj;
        return Objects.equals(this.fromNode, that.fromNode) &&
                Objects.equals(this.toNode, that.toNode) &&
                Objects.equals(this.capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromNode, toNode, capacity);
    }

    @Override
    public String toString() {
        return "Edge[" +
                "fromNode=" + fromNode + ", " +
                "toNode=" + toNode + ", " +
                "Capacity=" + capacity + ", " +
                "Flux=" + flux  + ']';
    }
}
