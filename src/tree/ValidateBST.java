package tree;

import util.TreeNode;

/*
 * LeetCode: https://leetcode.com/problems/validate-binary-search-tree/
 * NeetCode: https://www.youtube.com/watch?v=s6ATEkipzow&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=6
 *
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTUtil(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidBSTUtil(node.left, min, node.val) && isValidBSTUtil(node.right, node.val, max);
    }

}
