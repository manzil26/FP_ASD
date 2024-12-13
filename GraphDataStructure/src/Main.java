public class Main {
    public static void main(String[] args) {
        // cek array
//        int a[][] = new int[2][2];
//        System.out.println(a[0][1]);

        // bikin graph yang Undirected graph
        String [] label = {"A", "B", "C", "D"};
        Graph g = new Graph(4, label);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,3);

        System.out.println(g);


        // graph M

        // adjency list
        // iki meh bingung endi gambar grafik e
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

        System.out.println("Graph M");
        System.out.println(g2);
    }
}