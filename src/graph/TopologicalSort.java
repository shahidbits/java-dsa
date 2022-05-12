package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    public void topologicalSort(List<List<Integer>> adjList) {

        if (adjList == null || adjList.size() == 0) {
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> topoStack = new Stack<>();

        for (int i = 0; i < adjList.size(); i++) {
            if (!visited.contains(i)) {
                performDFS(i, adjList, visited, topoStack);
            }
        }

        while (!topoStack.isEmpty()) {
            System.out.print(topoStack.pop() + " ");
        }

        System.out.println("");

    }

    private void performDFS(Integer v, List<List<Integer>> adjList, Set<Integer> visited, Stack<Integer> topoStack) {

        visited.add(v);

        List<Integer> edges = adjList.get(v);

        if (edges != null && edges.size() > 0) {

            for (Integer node : edges) {
                if (!visited.contains(node)) {
                    performDFS(node, adjList, visited, topoStack);
                }
            }
        }

        topoStack.push(v);

    }
}
