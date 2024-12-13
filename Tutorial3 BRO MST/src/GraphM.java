import java.util.*;

class GraphM{
    // atributes
    Map<String, ArrayList<String>> g;

    GraphM(){
        this.g = new TreeMap<String, ArrayList<String>>();
    }

    //add edge
    void addEdge(String v1, String v2){
        ArrayList<String> al = g.get(v1);
        if(al==null){
            al = new ArrayList<String>();
            al.add(v2);
            g.put(v1,al);
        }
        else{
            al.add(v2);
        }

        ArrayList<String> al2 = g.get(v2);
        if(al2==null){
            al2 = new ArrayList<String>();
            al2.add(v1);
            g.put(v2,al2);
        }
        else{
            al2.add(v1);
        }

    }

    //print the graph
    public String toString(){
        String output="";

        for(String k: g.keySet()){
            output+= k+"-->";
            for(String a:g.get(k)){
                output+= a+" ";

            }
            output+="\n";
        }

        return output;
    }

    //DFS algorithm
    void dfs(String root){
        ArrayList<String> visitedNodes = new  ArrayList<String>();
        Stack<String> adj = new Stack<String>();

        // 1. Start by putting any one of the graph's vertices on top of a stack.
        adj.push(root);

        while(!adj.empty()){
            // 2.Take the top item of the stack and add it to the visited list.
            String v = adj.pop();

            if(!visitedNodes.contains(v)){
                visitedNodes.add(v);
            }

            //3. Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the top of the stack.
            ArrayList<String> al = g.get(v);

            //sort the adjeceny nodes in descending order
            Collections.sort(al, Collections.reverseOrder());

            for(String n:al){
                if(!visitedNodes.contains(n)){
                    adj.push(n);
                }

            }
            //4. Keep repeating steps 2 and 3 until the stack is empty.
        }

        //print the nodes traversal
        for(int i=0; i< visitedNodes.size()-1;i++){
            System.out.print(visitedNodes.get(i)+" --> ");
        }

        System.out.print(visitedNodes.get(visitedNodes.size()-1));
    }

    //BFS algorithm
    void bfs(String root){
        ArrayList<String> visitedNodes = new  ArrayList<String>();
        Queue<String> adj = new LinkedList<String>();

        // 1. Start by putting any one of the graph's vertices at the back of a queue.
        adj.add(root);

        while(!adj.isEmpty()){
            // 2. Take the front item of the queue and add it to the visited list.
            String v = adj.poll();
            if(!visitedNodes.contains(v)){
                visitedNodes.add(v);
            }

            // 3. Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the back of the queue.
            ArrayList<String> al = g.get(v);
            Collections.sort(al);

            for(String n:al){
                if(!visitedNodes.contains(n)){
                    adj.add(n);
                }

            }
            //3. Keep repeating steps 2 and 3 until the queue is empty.
        }

        //print the nodes traversal
        for(int i=0; i< visitedNodes.size()-1;i++){
            System.out.print(visitedNodes.get(i)+" --> ");
        }

        System.out.print(visitedNodes.get(visitedNodes.size()-1));

    }

}
    

    


    