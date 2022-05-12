package graph;

import util.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearchIterative {

    public void performDFS(Node node) {

        if (node == null) {
            return;
        }

        Set<Node> visited = new HashSet<>();

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.isEmpty()) {

            Node topNode = nodeStack.pop();

            if (visited.contains(topNode)) {
                continue;
            }

            System.out.print(topNode.val + " ");
            visited.add(topNode);

            for (Iterator<Node> it = topNode.neighbors.iterator(); it.hasNext(); ) {

                Node neighbor = it.next();

                if (!visited.contains(neighbor)) {
                    nodeStack.push(neighbor);
                }

            }

        }

        System.out.println("");
    }
}
