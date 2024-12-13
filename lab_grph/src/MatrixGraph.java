public class MatrixGraph {
    int[][] matrix;
    int size;

    String label[];
    MatrixGraph(int size, String label[]){
        this.size = size;
        this.matrix = new int[size][size];
        this.label = label;

    }

    void addEdge(int v1, int v2){
        matrix[v1][v2] = 1;
        matrix[v2][v1] = 1;

    }

    public String toString(){
        String output = "";
        for (int i =0; i< size; i++){
            output  += label[i] + "-->";
            for (int j=0; j< size; j++){
                if(matrix[i][j] == 1){
                    output += label[j] + " ";
                }
            }

            output += "/n";
        }
        return  output;

    }

}
