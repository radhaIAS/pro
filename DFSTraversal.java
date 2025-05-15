package dia;
import java.util.*;

public class DFSTraversal {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    private List<Integer> traversalOrder = new ArrayList<>();

    // Add edge to the graph
    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // For undirected graph
    }

    // DFS utility function
    private void dfs(int node) {
        visited.add(node);
        traversalOrder.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }

    // Perform DFS from source
    public void performDFS(int source) {
        dfs(source);
        System.out.println("\nDFS Traversal Order: " + traversalOrder);
        System.out.println("Total Nodes Visited: " + traversalOrder.size());
    }

    // Main method
    public static void main(String[] args) {
        DFSTraversal dfsTraversal = new DFSTraversal();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int numNodes = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter edges (node1 node2):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            dfsTraversal.addEdge(u, v);
        }

        System.out.print("Enter the source node: ");
        int source = scanner.nextInt();

        System.out.println("\nStarting DFS from node " + source + "...");
        dfsTraversal.performDFS(source);

        scanner.close(); // 
    }
}





// DFS(graph, source):
//     Create a visited set to keep track of visited nodes
//     Create an empty list traversalOrder

//     Call DFSUtil(source, visited, traversalOrder)

//     Print traversalOrder
//     Print "Total nodes visited:" length of traversalOrder

// DFSUtil(node, visited, traversalOrder):
//     Mark node as visited
//     Add node to traversalOrder

//     For each neighbor in graph[node]:
//         If neighbor is not in visited:
//             Call DFSUtil(neighbor, visited, traversalOrder)


// Enter number of nodes: 5
// Enter number of edges: 4
// Enter edges (node1 node2):
// 0 1
// 0 2
// 1 3
// 3 4
// Enter the source node: 0
