/**
 * Main class of the Java program.
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Part 1: The Graph With Adjacency Matrix:");
        String [] label = {"A", "B", "C", "D"};
        Graph g = new Graph(4, label);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,3);

        System.out.println(g);

        System.out.println("Part 2: The Graph With Adjacency List:");
        GraphM g2 = new GraphM();

        g2.addEdge("A","B");
        g2.addEdge("A","C");
        g2.addEdge("A","D");
        g2.addEdge("A","F");
        g2.addEdge("B","C");
        g2.addEdge("B","D");
        g2.addEdge("B","E");
        g2.addEdge("C","E");
        g2.addEdge("C","F");
        g2.addEdge("C","G");
        g2.addEdge("D","E");
        g2.addEdge("F","G");

        System.out.println(g2);

//        System.out.println("Part 3: Graph Traversal Algorithms:");
//
//        System.out.println("DFS:");
//        g2.dfs("A");
//
//        System.out.println(" ");
//
//
//        System.out.println("BFS:");
//        g2.bfs("B");
//
//        System.out.println();
//        System.out.println("Part 4: Dijkstra Algorithm:");
//
//        String [] l ={"A","B","C","D","E","F","G","H","I"};
//        Graph g3 = new Graph(9, l);
//        g3.addEdge(0,1,3);
//        g3.addEdge(0,2,7);
//        g3.addEdge(1,2,6);
//        g3.addEdge(1,3,3);
//        g3.addEdge(2,3,1);
//        g3.addEdge(2,4,6);
//        g3.addEdge(2,5,4);
//        g3.addEdge(3,5,5);
//        g3.addEdge(4,5,2);
//        g3.addEdge(4,6,5);
//        g3.addEdge(5,6,2);
//        g3.addEdge(5,7,3);
//        g3.addEdge(5,8,10);
//        g3.addEdge(6,8,2);
//        g3.addEdge(7,8,3);
//
//        g3.dijkstraAlg(0,8);
//        System.out.println();
//        g3.dijkstraAlg(2,7);
//
//
//        System.out.println();
//        System.out.println("Part 5: Dijkstra Algorithm:");
//
//        String [] l1 ={"A","B","C","D","E","F","G","H"};
//
//        g3 = new Graph(8, l1);
//        g3.addEdge(0,2,1);
//        g3.addEdge(0,1,2);
//        g3.addEdge(0,3,3);
//        g3.addEdge(2,3,2);
//
//        g3.addEdge(1,3,5);
//        g3.addEdge(1,5,10);
//        g3.addEdge(3,4,9);
//        g3.addEdge(3,6,5);
//
//        g3.addEdge(4,6,6);
//        g3.addEdge(4,5,8);
//        g3.addEdge(5,7,6);
//        g3.addEdge(6,7,15);
//
//
//        g3.dijkstraAlg(0,7);
//        System.out.println();
//        // g3.dijkstraAlg(2,7);
//
//        System.out.println();
//        System.out.println("Part 6: Dijkstra Algorithm:");
//
//        String [] l2 ={"A","B","C","D","E","F","G","H","I"};
//
//        g3 = new Graph(9, l2);
//
//        g3.addEdge(0,1,10); //e1
//        g3.addEdge(0,3,5); //e2
//        g3.addEdge(0,2,2); //e3
//        g3.addEdge(0,4,8); //e4
//
//        g3.addEdge(2,3,3); //e5
//        g3.addEdge(1,3,4); //e6
//        g3.addEdge(2,4,3); //e7
//        g3.addEdge(2,5,8); //e8
//
//        g3.addEdge(3,5,10); //e9
//        g3.addEdge(3,7,15); //e10
//        g3.addEdge(5,7,3); //e11
//        g3.addEdge(4,5,9); //e12
//
//        g3.addEdge(4,8,4); //e13
//        g3.addEdge(4,6,6); //e14
//        g3.addEdge(6,8,1); //e15
//        g3.addEdge(6,7,5); //e16
//
//
//        g3.dijkstraAlg(0,6);
//        System.out.println();
//        // g3.dijkstraAlg(2,7);




    }
}
