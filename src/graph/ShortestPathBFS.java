package graph;

import java.util.LinkedList;
import java.util.List;

public class ShortestPathBFS {

    public void printShortestDistance(List<List<Integer>> adj, int s, int dest, int v) {

        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s

        int pred[] = new int[v];
        int dist[] = new int[v];

//        boolean isFound = false;
        if (performBFS(adj, s, dest, v, pred, dist) == false) {
            System.out.println("Given source and destination" +
                    "are not connected");
            return;
        }

        // LinkedList to store path
        List<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        // Print distance
        System.out.println("Shortest path length is: " + dist[dest]);

        // Print path
        System.out.println("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    // a modified version of BFS that stores predecessor
    // of each vertex in array pred
    // and its distance from source in array dist
    private static boolean performBFS(List<List<Integer>> adj, int src, int dest, int v, int pred[], int dist[]) {

        // a queue to maintain queue of vertices whose
        // adjacency list is to be scanned as per normal
        // BFS algorithm using LinkedList of Integer type
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean visited[] = new boolean[v];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        // bfs Algorithm
        while (!queue.isEmpty()) {

            int u = queue.remove();

            for (int i = 0; i < adj.get(u).size(); i++) {

                int e = adj.get(u).get(i);

                if (visited[e] == false) {
                    visited[e] = true;
                    dist[e] = dist[u] + 1;
                    pred[e] = u;
                    queue.add(e);

                    // stopping condition (when we find
                    // our destination)
                    if (e == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
