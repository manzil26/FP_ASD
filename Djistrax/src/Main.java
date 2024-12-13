package Djikstra;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");

        a.addEdge(b, 3);
        a.addEdge(c, 7);

        b.addEdge(a, 3);
        b.addEdge(c, 6);
        b.addEdge(d, 3);

        c.addEdge(a, 7);
        c.addEdge(b, 6);
        c.addEdge(d, 1);
        c.addEdge(e, 6);
        c.addEdge(f, 4);

        d.addEdge(b, 3);
        d.addEdge(c, 1);
        d.addEdge(f, 5);

        e.addEdge(c, 6);
        e.addEdge(f, 2);
        e.addEdge(g, 5);

        f.addEdge(c, 4);
        f.addEdge(d, 5);
        f.addEdge(e, 2);
        f.addEdge(g, 2);
        f.addEdge(h, 3);
        f.addEdge(i, 10);

        g.addEdge(e, 5);
        g.addEdge(f, 2);
        g.addEdge(i, 2);

        h.addEdge(f, 3);
        h.addEdge(i, 3);

        i.addEdge(f, 10);
        i.addEdge(g, 2);
        i.addEdge(h, 3);

        djikstra(c);

        System.out.println("Distance from C to H: " + h.distance);

        ArrayList<Node> path = getShortestPath(h);
        System.out.print("Shortest path from C to H: ");
        for(Node node : path) {
            System.out.print(node.id + " ");
        }
    }

    public static void djikstra(Node source) {
        ArrayList<Node> unvisited = new ArrayList<>();
        source.distance = 0;
        unvisited.add(source);

        while(!unvisited.isEmpty()) {
            Node currentNode = getMinDistance(unvisited);

            unvisited.remove(currentNode);

            for(Edge edge : currentNode.edges) {
                Node neighbor = edge.target;
                int newDist = currentNode.distance + edge.weight;

                if(newDist < neighbor.distance) {
                    neighbor.distance = newDist;
                    neighbor.previous = currentNode;
                    if(!unvisited.contains(neighbor)) {
                        unvisited.add(neighbor);
                    }
                }
            }
        }
    }

    public static Node getMinDistance(ArrayList<Node> nodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;

        for(Node node:nodes) {
            if(node.distance < minDistance) {
                minNode = node;
                minDistance = node.distance;
            }
        }
        return minNode;
    }

    public static ArrayList<Node> getShortestPath(Node target) {
        ArrayList<Node> path = new ArrayList<>();
        for(Node node = target; node != null; node = node.previous) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }
}


/*
// Dijkstra's Algorithm in Java

public class Dijkstra {

  public static void dijkstra(int[][] graph, int source) {
    int count = graph.length;
    boolean[] visitedVertex = new boolean[count];
    int[] distance = new int[count];
    for (int i = 0; i < count; i++) {
      visitedVertex[i] = false;
      distance[i] = Integer.MAX_VALUE;
    }

    // Distance of self loop is zero
    distance[source] = 0;
    for (int i = 0; i < count; i++) {

      // Update the distance between neighbouring vertex and source vertex
      int u = findMinDistance(distance, visitedVertex);
      visitedVertex[u] = true;

      // Update all the neighbouring vertex distances
      for (int v = 0; v < count; v++) {
        if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
          distance[v] = distance[u] + graph[u][v];
        }
      }
    }
    for (int i = 0; i < distance.length; i++) {
      System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
    }

  }

  // Finding the minimum distance
  private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
    int minDistance = Integer.MAX_VALUE;
    int minDistanceVertex = -1;
    for (int i = 0; i < distance.length; i++) {
      if (!visitedVertex[i] && distance[i] < minDistance) {
        minDistance = distance[i];
        minDistanceVertex = i;
      }
    }
    return minDistanceVertex;
  }

  public static void main(String[] args) {
    int graph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
        { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };
    Dijkstra T = new Dijkstra();
    T.dijkstra(graph, 0);
  }
}
 */