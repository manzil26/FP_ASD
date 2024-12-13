import java.util.*;

public class SocialNetworkGraph {

    // membuat map dengan adjency list yang mengisi teman user
    private Map<String, List<String>> adjacencyList = new HashMap<>();

    public void addUser(String user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    public void addFriendship(String user1, String user2) {
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);
    }

    // BFS implementation
    public void bfs(String startUser) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startUser);
        visited.add(startUser);

        System.out.print("BFS: \n");
        while (!queue.isEmpty()) {
            String user = queue.poll();
            System.out.print(user + " ");

            for (String neighbor : adjacencyList.get(user)) {

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS implementation
    public void dfs(String startUser) {
        Set<String> visited = new HashSet<>();
        System.out.print("DFS: \n");
        dfsHelper(startUser, visited);
        System.out.println();
    }

    private void dfsHelper(String user, Set<String> visited) {
        if (visited.contains(user)) return;

        visited.add(user);
        System.out.print(user + " ");
        for (String neighbor : adjacencyList.get(user)) {
            dfsHelper(neighbor, visited);
        }
    }
}