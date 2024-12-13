import java.lang.reflect.Array;
import java.util.*;

class GraphM{
    Map<String, ArrayList<String>> g;

    GraphM(){
        this.g = new TreeMap<String, ArrayList<String>>();
    }

    // coba ini coret coret nanti tapi sekrang se
    // ini key set buat nentuin array
    void addEdge(String v1, String v2){
        ArrayList<String> al= g.get(v1);
        if(al == null){
            al = new ArrayList<String>();
            al.add(v2); // masukkan value
            g.put(v1, al) ; // print key and value
        } else {
            al.add(v2);
        }
    }



    // gae ngeprint seng graphmap
    public String toString(){
        String output = "";

        for (String k: g.keySet()){
            output += k + "-->";
            for (String a: g.get(k)){
                output += a+" ";
            }

            output += "\n";
        }
        return output;
    }


    // iki mulai golongan e adjency adjency iku
    // coba latihan nak kerta iki kuwi auto gak turu horee semamgat

    void dfs(String root){
        ArrayList<String> visitedNodes = new ArrayList<String>();
        Stack<String> adj = new Stack<String>();
        adj.push(root);

        while (!adj.empty()){
            String v = adj.pop();

            if(!visitedNodes.contains(v)){
                visitedNodes.add(v);
                System.out.println(v+ "-->");
            }

            ArrayList<String> al = g.get(v);

            Collections.sort(al, Collections.reverseOrder());

            for (String n:al){
                if (!visitedNodes.contains(n)){
                    adj.push(n);
                }
            }
        }
    }



}