import java.util.*;

class Graph{
    // Your code goes here
    int [][] matrix;
    int size;



    Graph(int size){
        this.size = size;
        matrix = new int[size][size];
    }

    public void addEdge(int vertex1, int vertex2, int value){
        matrix[vertex1][vertex2] = value;
        matrix[vertex2][vertex1] = value;
    }

    public int [] [] getGraphMatrix() {
        return matrix;
    }



}