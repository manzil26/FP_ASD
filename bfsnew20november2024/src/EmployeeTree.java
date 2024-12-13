
import java.util.*;

class EmployeeTree {
    Map<String, EmployeeNode> nodeMap;
    String rootName; // Keeps track of the root (CEO)

    public EmployeeTree() {
        nodeMap = new HashMap<>();
        rootName = null;
    }

    public void add(String name) {
        // your code goes here
       EmployeeNode node = new EmployeeNode(name);
       nodeMap.put(name, node);
       if (rootName == null){
           rootName = name;
       }



    }

    public void setLeftChild(String parentName, String childName) {
        // your code goes here
        EmployeeNode parent = nodeMap.get(parentName);
        parent.left = childName;
        nodeMap.put(childName, new EmployeeNode(childName));


    }

    public void setRightChild(String parentName, String childName) {
        // your code goes here
        EmployeeNode parent = nodeMap.get(parentName);
        parent.right = childName;
        nodeMap.put(childName, new EmployeeNode(childName));

    }

    public int findMaxDepth(String nodeName) {
        // your code goes here
        if (nodeName == null || !nodeMap.containsKey(nodeName)) return 0;

        EmployeeNode node = nodeMap.get(nodeName);
        int leftDepth = findMaxDepth(node.left);
        int rightDepth = findMaxDepth(node.right);

        return  Math.max(leftDepth, rightDepth) + 1;


    }

    public void listEmployeesByLevel() {
        // your code goes here
        if (rootName == null) return;

        Queue<String> queue = new LinkedList<>();
        queue.add(rootName);

        int level =1;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            System.out.println("Level" + level + ":");
            for (int i = 0; i<levelSize; i++){
                String currentName = queue.poll();
                EmployeeNode current = nodeMap.get(currentName);
                System.out.print(current.name + " ");
                if ((current.left != null )) queue.add(current.left);
                if (current.right != null ) queue.add(current.right);
            }
            System.out.println();
            level++;
        }


    }

    public boolean findEmployee(String nodeName, String name) {
        if (nodeName == null || !nodeMap.containsKey(nodeName)) return  false;
        EmployeeNode node = nodeMap.get(nodeName);
        if (node.getName().equals(name)) return  true;
        return  findEmployee(node.left, name) || findEmployee(node.right, name);
    }
}