package Djikstra;

import java.util.ArrayList;

public class Node {
    String id;
    int distance;
    Node previous = null;
    ArrayList<Edge> edges = new ArrayList<>();

    public Node (String id) {
        this.id = id;
        this.distance = Integer.MAX_VALUE;
    }

    public void addEdge(Node node, int weight){
        edges.add(new Edge(node, weight));
    }

}

class Edge {
    Node target;
    int weight;

    public Edge(Node target, int weight){
        this.target = target;
        this.weight = weight;
    }
}
