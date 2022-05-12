package tree;

import util.TreeNode;

/*
 * LeetCode: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * NeetCode: https://www.youtube.com/watch?v=7cp5imvDzl4&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=2
 *
 */
public class CountGoodNodesInBT {

    public int goodNodes(TreeNode root) {
        return goodNodesUtil(root, Integer.MIN_VALUE);
    }

    private int goodNodesUtil(TreeNode node, int max) {

        if (node == null) {
            return 0;
        }

        int currMax = Math.max(max, node.val);

        int left = goodNodesUtil(node.left, currMax);
        int right = goodNodesUtil(node.right, currMax);

        int total = (node.val >= max ? 1 : 0) + left + right;
        return total;

    }

}
