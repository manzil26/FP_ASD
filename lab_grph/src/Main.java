public class Main {
    public static void main(String[] args) {
        System.out.println("part 1: Adjency Matrix ");

        String [] label = {"A", "B", "C", "D"};
        MatrixGraph matrixGrph = new MatrixGraph(4, label);
        matrixGrph.addEdge(0,1);
        matrixGrph.addEdge(0,2);
        matrixGrph.addEdge(1,3);
        matrixGrph.addEdge(2,3);
        System.out.println(matrixGrph);

        System.out.println("part 2; adjency list ");
        ListGraph

    }
}