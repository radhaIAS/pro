package dia;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleDijkstra {
    private static final int NO_PARENT = -1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 1. Read graph
        System.out.print("Enter number of vertices: ");
        int n = in.nextInt();
        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix (0 = no edge):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = in.nextInt();

        // 2. Read source
        System.out.print("Enter source vertex (0 to " + (n - 1) + "): ");
        int src = in.nextInt();

        // 3. Run Dijkstra
        int[] dist = new int[n];
        boolean[] used = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, NO_PARENT);
        dist[src] = 0;

        for (int it = 0; it < n - 1; it++) {
            // pick the unused vertex with smallest dist
            int u = -1, best = Integer.MAX_VALUE;
            for (int v = 0; v < n; v++)
                if (!used[v] && dist[v] < best) {
                    best = dist[v];
                    u = v;
                }
            if (u == -1) break;
            used[u] = true;

            // relax edges u→v
            for (int v = 0; v < n; v++) {
                int w = graph[u][v];
                if (w > 0 && !used[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                }
            }
        }

        // 4. Print result
        System.out.println("\nVertex  Distance  Path");
        for (int v = 0; v < n; v++) {
            if (v == src) continue;
            System.out.printf("  %d       %d       ", v, dist[v]);
            printPath(v, parent);
            System.out.println();
        }
        in.close();
    }

    private static void printPath(int v, int[] parent) {
        if (v == NO_PARENT) return;
        printPath(parent[v], parent);
        System.out.print(v + " ");
    }
    
}


// Enter number of vertices: 5
// Enter adjacency matrix (0 = no edge):
// 0  10  0   5   0
// 0   0   1   2   0
// 0   0   0   0   4
// 0   3   9   0   2
// 7   0   6   0   0
// Enter source vertex (0 to 4): 0

// Vertex  Distance  Path
//   1       8       0 3 1 
//   2       9       0 3 1 2 
//   3       5       0 3 
//   4       7       0 3 4 


// INPUT: 
//     - Graph as adjacency matrix (weights), size = N x N
//     - Source vertex: source

// INITIALIZE:
//     dist[] = array of size N, fill with INFINITY
//     visited[] = array of size N, fill with FALSE
//     parent[] = array of size N, fill with -1 (no parent)
//     dist[source] = 0

// FOR i = 1 to N-1 DO
//     u = vertex with minimum dist[u] where visited[u] == FALSE
//     visited[u] = TRUE

//     FOR each vertex v in 0 to N-1 DO
//         IF visited[v] == FALSE AND graph[u][v] > 0 THEN
//             IF dist[u] + graph[u][v] < dist[v] THEN
//                 dist[v] = dist[u] + graph[u][v]
//                 parent[v] = u
//             ENDIF
//         ENDIF
//     ENDFOR
// ENDFOR

// PRINT shortest distances and paths from source to each vertex using dist[] and parent[]
