package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
        Queue<N> q = new ArrayDeque<N>();
        int[] color = new int[this.nodes.size()];//0 = WHITE, 1 = GRAY, 2 = BLACK
        int[] d = new int[this.nodes.size()];
        List<N> p = new LinkedList<>();
        for(int i = 0; i < this.nodes.size(); i++) {
            color[i] = 0;//WHITE
            d[i] = Integer.MAX_VALUE;
            p.add(null);
        }
        color[this.getNodeIndex(source)] = 1;
        d[this.getNodeIndex(source)] = 0;
        
        q.add(source);
        while(q.size() > 0) {
            N u = q.element();
            N[] adjNs = (N[])this.linkedNodes(u).toArray();
            for (N v : adjNs) {
                if(color[this.getNodeIndex(v)] == 0) {
                    color[this.getNodeIndex(v)] = 1;
                    d[this.getNodeIndex(v)] = d[this.getNodeIndex(u)] + 1;
                    p.set(this.getNodeIndex(v), u);
                    q.add(v);
                }
            }
            q.remove();
            color[this.getNodeIndex(u)] = 2;
        }

        N prec = target;
        List<N> reversePath = new LinkedList<>();
        List<N> path = new LinkedList<>();
        for(;prec != null; prec = p.get(this.getNodeIndex(prec))) {
            reversePath.add(prec);
        }

        for (int i = reversePath.size() - 1; i >= 0; i--) {
            path.add(reversePath.get(i));
        }
        return path;
    }

    private int getNodeIndex(N node) {
        N[] nodesArray = (N[])this.nodes.toArray();

        for(int i = 0; i < nodesArray.length; i++) {
            if(nodesArray[i] == node) {
                return i;
            }
        }
        return -1;
    }
}
