class Graph{
    // the class fields
    private int g [][];   // array 2 dimensi untuk memasukkan hubunagn edge
    private int size; // jumlah nodes
    private String label []; // masukkin label kyk a. b, c, d


    //constructors
    Graph(int s){
        this.size = s;
        this.g = new int[s][s];
    }

    Graph(int s, String [] l){
        this.size = s;
        this.g = new int[s][s];
        this.label = l;
    }

    //add unweigted edge
    void addEdge(int v1, int v2){
        g[v1][v2]=1;
        g[v2][v1]=1;
    }

    //add weigted edge
    void addEdge(int v1, int v2, int w){
        g[v1][v2]=w;
        g[v2][v1]=w;
    }

    //print the graph
    public String toString(){
        String output="";

        for(int i=0;i<g.length;i++){
            output+= label[i]+ "-->";
            for(int j=0; j<g[0].length;j++){
                if(g[i][j]>=1){
                    output+= label[j]+" ";
                }
            }
            output+="\n";
        }

        return output;
    }


    // untuk ori itu rootnya
    // untuk dest itu untuk tujuanya ,manh
    void dijkstraAlg(int ori, int dest){
        //initial distance from ori to each other node
        int [] dist = new int[this.size]; // buat nyimpen array yang udah update 
        for(int i=0;i<this.size;i++){
            dist[i] = Integer.MAX_VALUE; // menginsialilasi dengan nilai maksimum untuk node tujuan
        }

        //itiate the originate node to 0
        dist[ori] = 0;

        //checking whether visited;
        boolean isVisited [] = new boolean[this.size];

        //keep track the previous node
        int [] prev = new int[this.size];

        for(int i=0;i<this.size;i++){
            //update distance between ori and the visied node
            //findThe next node
            int nextNode = findTheNextNode(isVisited, dist);
            isVisited[nextNode]=true;
            //update the dist of all nextNode adjacent nodes
            for (int j = 0; j < this.size; j++) {
                if (!isVisited[j] && this.g[nextNode][j] != 0 && (dist[nextNode] + this.g[nextNode][j] < dist[j])) {
                    dist[j] = dist[nextNode] + this.g[nextNode][j];
                    prev[j] = nextNode;
                }
            }
        }

        System.out.println("the minimum distance from "+label[ori]+" to "+label[dest]+" is "+dist[dest]);
        System.out.println("routing:");
        route(dest,ori,dest,prev);
    }


    //find the route
    void route(int n, int from, int to, int [] prev){
        if(n==from) System.out.print(this.label[n]);
        else {
            route(prev[n],from,to,prev);
            System.out.print(" --> ");
            System.out.print(this.label[n]);
        }
    }

    //find the next visited node with minimum distance
    int findTheNextNode(boolean [] isVisited, int [] dist){
        int min = Integer.MAX_VALUE;
        int minVertex = -1;
        for (int i = 0; i < this.size; i++) {
            if (!isVisited[i] && dist[i] < min) {
                min = dist[i];
                minVertex = i;
            }
        }
        return minVertex;

    }
}