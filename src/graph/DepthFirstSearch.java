package graph;

import util.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {

    public void performDFS(Node node) {
        dfsUtil(node, new HashSet<>());
        System.out.println("");
    }

    public void performDFSAdjList(List<List<Integer>> adjList) {

        if (adjList != null && adjList.size() > 0) {

            Set<Integer> visited = new HashSet<>();

            for (int i = 0; i < adjList.size(); i++) {
                if (!visited.contains(i)) {
                    dfsUtilAdjList(i, adjList, visited);
                }
            }

        }

        System.out.println("");
    }

    private void dfsUtilAdjList(Integer v, List<List<Integer>> adjList, Set<Integer> visited) {

        visited.add(v);
        System.out.print(v + " ");

        List<Integer> edges = adjList.get(v);

        if (edges != null && edges.size() > 0) {

            for (Integer node : adjList.get(v)) {

                if (!visited.contains(node)) {
                    dfsUtilAdjList(node, adjList, visited);
                }

            }

        }

    }

    private void dfsUtil(Node node, Set<Node> visited) {

        if (node == null) {
            return;
        }

        if (visited.contains(node)) {
            return;
        }

        System.out.print(node.val + " ");
        visited.add(node);

        for (Iterator<Node> it = node.neighbors.iterator(); it.hasNext(); ) {
            Node neighbor = it.next();

            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }

    }
}
