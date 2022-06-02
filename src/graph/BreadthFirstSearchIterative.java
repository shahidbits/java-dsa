package graph;

import util.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearchIterative {

    public void performBfs(Node node) {

        if (node == null) {
            return;
        }

        Set<Node> visited = new HashSet<>();

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

        while (!nodeQueue.isEmpty()) {

            Node front = nodeQueue.remove();

//            if (visited.contains(front)) {
//                continue;
//            }

            System.out.print(front.val + " ");
            visited.add(front);

            for (Iterator<Node> it = front.neighbors.iterator(); it.hasNext(); ) {
                Node neighbor = it.next();

                if (!visited.contains(neighbor)) {
                    nodeQueue.add(neighbor);
                }
            }

        }

    }
}
