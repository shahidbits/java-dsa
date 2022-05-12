package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DependencyResolution {

    public void resolve(List<List<Integer>> adjList) {

        if (adjList == null || adjList.size() == 0) {
            return;
        }

        Set<Integer> visited = new HashSet<>();
        List<Integer> resolved = new ArrayList<>();

        for (int i = 0; i < adjList.size(); i++) {
            if (!visited.contains(i)) {
                try {
                    performDFS(i, adjList, visited, resolved);
                } catch (Exception e) {
                    System.out.println("ERROR: " + e.getMessage());
                    return;
                }
            }
        }

        for (Integer i : resolved) {
            System.out.print(i + " ");
        }

        System.out.println("");

    }

    private void performDFS(Integer v, List<List<Integer>> adjList, Set<Integer> visited, List<Integer> resolved) throws Exception {

        visited.add(v);

        List<Integer> edges = adjList.get(v);

        if (edges != null && edges.size() > 0) {

            for (Integer node : edges) {
                if (!resolved.contains(node)) {
                    if (visited.contains(node)) {
                        throw new Exception("circular dep " + node + " <-> " + v);
                    }
                    performDFS(node, adjList, visited, resolved);
                }
            }
        }

        resolved.add(v);

    }
}
