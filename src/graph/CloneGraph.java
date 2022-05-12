package graph;

import util.Node;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/clone-graph/
 * NeetCode: https://www.youtube.com/watch?v=EgI5nU9etnU&list=PLot-Xpze53ldBT_7QA8NVot219jFNr_GI&index=2&ab_channel=NeetCode
 *
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);

    }

    private void dfs(Node node, Map<Node, Node> map) {

        if (node != null && !map.containsKey(node)) {

            Node cloneNode = new Node(node.val);
            map.put(node, cloneNode);

            for (Node neighbor : node.neighbors) {

                if (!map.containsKey(neighbor)) {
                    dfs(neighbor, map);
                }

                cloneNode.neighbors.add(map.get(neighbor));

            }

        }

    }


}
