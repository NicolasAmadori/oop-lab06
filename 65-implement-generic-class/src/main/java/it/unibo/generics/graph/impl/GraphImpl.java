package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N>{

    private static int edgeCounter;

    private final Set<N> nodes;
    private final Map<Integer, Edge> edges;    

    public GraphImpl() {
        nodes = new HashSet<>();
        edges = new HashMap<>();
        edgeCounter = 0;
    }

    public void addNode(N node) {
        if(node == null || this.nodes.contains(node)) {
            return;
        }

        nodes.add(node);
    }
    
    public void addEdge(N source, N target) {
        if(target == null) {
            return;
        }

        Edge newEdge = new Edge<N>(source, target);
        for (int i : this.edges.keySet()) {
            if(this.edges.get(i) == newEdge) {
                return;
            }
        }

        this.edges.put(GraphImpl.edgeCounter, newEdge);
        GraphImpl.edgeCounter++;
    }
    
    public Set<N> nodeSet() {        
        return Set.copyOf(this.nodes);
    }
    
    public Set<N> linkedNodes(N node) {
        Set<N> linkedNodes = new HashSet<>();
        for (int i : this.edges.keySet()) {
            Edge e = this.edges.get(i);
            if(e.getStart() == node) {
                linkedNodes.add((N)e.getDestination());                
            }
        }

        return linkedNodes;
    }
    
    public List<N> getPath(N source, N target) {
        int[] color = new int[this.nodes.size()];
        int[] d = new int[this.nodes.size()];
        int[] p = new int[this.nodes.size()];
        for(int i = 0; i < this.nodes.size(); i++) {
            color[i] = 0;//WHITE
            d[i] = Integer.MAX_VALUE;
            p[i] = -1;
        }
        
        return null;
    }

    private int getNodeNumber(N node) {
        for(int i = 0; i < this.nodes.size(); i++) {
            if(this.nodes.[i] == node) {
                return i;
            }
        }
        return -1;
    }
}
