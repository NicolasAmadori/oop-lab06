package it.unibo.generics.graph.impl;

public class Edge<N> {

    private final N start;
    private final N destination;

    public Edge(N n1, N n2) {
        start = n1;
        destination = n2;
    }

    public N getStart() {
        return this.start;
    }

    public N getDestination() {
        return this.destination;
    }
}
