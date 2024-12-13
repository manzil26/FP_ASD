//import java.util.*;
//
//public class WeighdGraphAL {
//
//    Map<String, List<Edge>> adjacencyList;
//    public WeighdGraphAL ( ){
//        this.adjacencyList = new HashMap<>();
//
//    }
//
//    public void addEdge(String node1, String node2, int weight) {
//        if(!adjacencyList.containsKey(node1)){
//            adjacencyList.put(node1, new ArrayList<>());
//        }
//        adjacencyList.get(node1).add(new Edge(node2, weight));
//
//        if (!adjacencyList.containsKey(node2)){
//            adjacencyList.put(node2, new ArrayList<>());
//        }
//        adjacencyList.get(node2).add(new Edge(node1, weight));
//
//    }
//
//    @Override
//    public String toString() {
//        String output = "";
//        for (String node : adjacencyList.keySet()) {
//            output += node + " ---> ";
//            for (Edge edge : adjacencyList.get(node)) {
//                output += edge.targetNode + "(" + edge.weight + ") ";
//            }
//            output += "\n";
//        }
//        return output;
//    }
//
//
//    public void dijkstra(String start, String end) {
//        Map<String, Integer> distance = new HashMap<>();
//        Map<String, String> previousNode = new HashMap<>();
//        Map<String, Boolean> visited = new HashMap<>();
//
//        for (String node : adjacencyList.keySet()) {
//            distance.put(node, Integer.MAX_VALUE);
//            previousNode.put(node, null);
//            visited.put(node, false);
//        }
//
//        distance.put(start, 0);
//
//        for (int i = 0; i < adjacencyList.size(); i++) {
//
//            String current = null;
//            int minDistance = Integer.MAX_VALUE;
//
//            for (String node : adjacencyList.keySet()) {
//                if (!visited.get(node) && distance.get(node) < minDistance) {
//                    current = node;
//                    minDistance = distance.get(node);
//                }
//            }
//
//            if (current == null) break;
//
//            visited.put(current, true);
//
//
//            for (Edge edge : adjacencyList.get(current)) {
//                if (!visited.get(edge.targetNode)) {
//                    int newDist = distance.get(current) + edge.weight;
//                    if (newDist < distance.get(edge.targetNode)) {
//                        distance.put(edge.targetNode, newDist);
//                        previousNode.put(edge.targetNode, current);
//                    }
//                }
//            }
//        }
//
//        String[] path = new String[adjacencyList.size()];
//        int index = 0;
//        String temp = end;
//
//        while (temp != null) {
//            path[index++] = temp;
//            temp = previousNode.get(temp);
//        }
//
//
//        String pathString = "";
//        for (int i = index - 1; i >= 0; i--) {
//            pathString += path[i];
//            if (i > 0) pathString += "->";
//        }
//
//        System.out.println("Path: " + pathString);
//        System.out.println("Shortest distance: " + distance.get(end));
//    }
//}