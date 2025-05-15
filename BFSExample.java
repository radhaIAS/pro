package dia;

import java.util.*;

public class BFSExample  {
    public static void bfs(Map<String, List<String>> graph, String startNode) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> traversalOrder = new ArrayList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            traversalOrder.add(node);

            for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        System.out.println("BFS Traversal Order: " + traversalOrder);
        System.out.println("Total Number of Nodes Visited: " + visited.size());
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D", "E"));
        graph.put("C", Arrays.asList("F"));
        graph.put("D", Collections.emptyList());
        graph.put("E", Arrays.asList("F"));
        graph.put("F", Collections.emptyList());

        bfs(graph, "A");
    }
    
}


// BFS(graph, start_node):
//     Create an empty queue Q
//     Create an empty set visited

//     Enqueue start_node into Q
//     Add start_node to visited

//     While Q is not empty:
//         current = dequeue from Q
//         print current

//         For each neighbor of current in graph:
//             If neighbor not in visited:
//                 Enqueue neighbor into Q
//                 Add neighbor to visited

//     Print total nodes visited = size of visited

