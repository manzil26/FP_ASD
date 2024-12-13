class Graph{
    int g[][];
    int size;
    String label []; //buat label  A B C

    // kontruktor untuk ambil nilai s
    Graph(int s){
        this.size = s;
        g = new int[s][s];
    }

    // kntruktor yang gak default
    Graph(int s, String [] l){
        this.size = s;
        g = new int [s][s];
        this.label = l;
    }

    // ketika edgenya sesuai maksudnaya sambungan maka dinilai 1
    void addEdge(int v1, int v2){
        g[v1][v2] = 1;
        g[v2][v1] = 1;
    }

    // buat ngeprint

    public String toString(){
        String output = " ";

        for(int i=0; i<g.length; i++){
            for (int j =0; j<g[0].length; j++){
                if (g[i][j] == 1){
                    output += label[i] + "-->"+ label[j] + " ";
                }
            }
            output += "\n";
        }
        return output;
    }
}