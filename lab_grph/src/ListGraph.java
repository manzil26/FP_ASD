import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ListGraph {
    Map<String, ArrayList<String>> map;

    ListGraph(){
        map = new TreeMap<>();

    }

    void addEdge(String v1, String v2){
        ArrayList<String> arrayList = map.get(v1);
        if (arrayList == null){
            arrayList = new ArrayList<>();
            arrayList.add((v1));
            map.put(v2, arrayList); // undirected


        }
        else {
           arrayList.add(v2);
        }
    }

    public String toString (){
        String output = " ";
        for (String vertex : map.keySet()){
            output += vertex + "-->";
            for (String neighbor : map.get(vertex)){
                output += neighbor + " ";
            }

        }
    }
}

