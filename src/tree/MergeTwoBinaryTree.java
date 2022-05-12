package tree;

import util.TreeNode;

/*
 * LeetCode: https://leetcode.com/problems/merge-two-binary-trees/
 * NeetCode: https://www.youtube.com/watch?v=QHH6rIK3dDQ&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=16
 *
 */
public class MergeTwoBinaryTree {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTreesUtil(root1, root2);
    }

    private TreeNode mergeTreesUtil(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return null;
        }

        TreeNode node = new TreeNode();

        if (node1 == null) {
            node.val = node2.val;
        } else if (node2 == null) {
            node.val = node1.val;
        } else {
            node.val = node1.val + node2.val;
        }

        node.left = mergeTreesUtil(node1 != null ? node1.left : null, node2 != null ? node2.left : null);
        node.right = mergeTreesUtil(node1 != null ? node1.right : null, node2 != null ? node2.right : null);

        return node;
    }

}
