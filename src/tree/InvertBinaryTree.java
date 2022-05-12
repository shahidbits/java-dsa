package tree;

import util.TreeNode;

/*
 * LeetCode: https://leetcode.com/problems/invert-binary-tree/
 * NeetCode: https://www.youtube.com/watch?v=OnSn2XEQ4MY&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=14
 *
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        return invertTreeUtil(root);

    }

    private TreeNode invertTreeUtil(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode tmp = node.left;
        node.left = invertTreeUtil(node.right);
        node.right = invertTreeUtil(tmp);

        return node;

    }

}
