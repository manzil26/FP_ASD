import java.util.*;

class ProjectTree {
    // your code goes here
    Map <String, ProjectNode>  nodeMap;
    private String rootName;

    public ProjectTree(){
        this.nodeMap = new HashMap<>();
        rootName = null;

    }

    public void addMainProject(String name){
        ProjectNode node = new ProjectNode(name);
        nodeMap.put(name, node);
        if (rootName == null){
            rootName = name;
        }

    }

    public void setLeftSubProject(String parentName, String subProjectName){
        ProjectNode parent = nodeMap.get(parentName);
        parent.leftSubProjectName = subProjectName;
        nodeMap.put(subProjectName, new ProjectNode(subProjectName));

    }

    public void setRightSubProject(String parentName, String subProjectName){
        ProjectNode parent = nodeMap.get(parentName);
        parent.rightSubProjectName = subProjectName;
        nodeMap.put(subProjectName, new ProjectNode(subProjectName));

    }

    public int countTotalProjects(String nodeName){
        ProjectNode node = nodeMap.get(nodeName);
        int count = 1;
        if (node.getLeftSubProjectName() != null) count = count + countTotalProjects(node.getLeftSubProjectName());
        if (node.getRightSubProjectName() != null) count = count + countTotalProjects(node.getRightSubProjectName());
        return count;

    }

    public void findLongestPath(String nodeName, List<String> path, List<String> longestPath) {
        ProjectNode node = nodeMap.get(nodeName);
        if (node == null)  return;

        path.add(nodeName);

        if (node.leftSubProjectName == null && node.rightSubProjectName == null) {
            if (path.size() > longestPath.size()) {
                longestPath.clear();
                longestPath.addAll(path);
            }
        }

        if (node.leftSubProjectName != null) findLongestPath(node.leftSubProjectName, path, longestPath);

        if (node.rightSubProjectName != null)  findLongestPath(node.rightSubProjectName, path, longestPath);

        path.remove(path.size() - 1);
    }

    public void findAllLeafProjects(String nodeName, List<String> leafProjects) {
        ProjectNode node = nodeMap.get(nodeName);

        if (node.leftSubProjectName == null && node.rightSubProjectName == null) {
            if (!leafProjects.contains(nodeName)) {
                leafProjects.add(nodeName);
            }
            return;
        }

        if (node.leftSubProjectName != null) findAllLeafProjects(node.leftSubProjectName, leafProjects);

        if (node.rightSubProjectName != null) findAllLeafProjects(node.rightSubProjectName, leafProjects);

    }


}

