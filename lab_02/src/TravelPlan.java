import java.util.*;

class TravelPlan{
    //Your code goes here
    int[] distance;
    Map<Integer, String> paths;
    public void cheapestRoute(int[][] graphMatrix, String[] label, int start) {
        int size = graphMatrix.length;
        distance = new int[size];
        paths = new HashMap<>();


        for (int i = 0; i < size; i++) {
            distance[i] = Integer.MAX_VALUE;
            paths.put(i, "");
        }
        distance[start] = 0;
        paths.put(start, label[start]);


        PriorityQueue<Integer> waiting = new PriorityQueue<>((a, b) -> distance[a] - distance[b]);
        waiting.add(start);

        while (!waiting.isEmpty()) {
            int current = waiting.poll();

            for (int i = 0; i < size; i++) {
                if (graphMatrix[current][i] > 0) {
                    int newDistance = distance[current] + graphMatrix[current][i];
                    if (newDistance < distance[i]) {
                        distance[i] = newDistance;
                        waiting.add(i);
                        paths.put(i, paths.get(current) + " --> " + label[i]);
                    }
                }
            }
        }
    }
    public String toString(){
        String output = " ";
        for (int i=0; i< distance.length; i++){
            output += "Path: " + paths.get(i) + "\n";
            output += "Cost: " + distance[i] + "\n";
        }
        return output;
    }

}