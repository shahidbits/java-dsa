package tree;

import util.TreeNode;

/*
 * LeetCode: https://leetcode.com/problems/balanced-binary-tree/
 * NeetCode: https://www.youtube.com/watch?v=OnSn2XEQ4MY&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=14
 *
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        boolean isBalanced = isBalancedUtil(root)[0] == 1 ? true : false;
        return isBalanced;
    }

    // [0] = isBalanced, [1] = height
    private int[] isBalancedUtil(TreeNode node) {

        if (node == null) {
            return new int[]{1, 0};
        }

        int[] leftBal = isBalancedUtil(node.left);
        int[] rightBal = isBalancedUtil(node.right);

        int h = Math.max(leftBal[1], rightBal[1]);

        if (leftBal[0] == 0 || rightBal[0] == 0) {
            return new int[]{0, h + 1};
        }

        if (Math.abs(leftBal[1] - rightBal[1]) > 1) {
            return new int[]{0, h + 1};
        }

        return new int[]{1, h + 1};
    }

}
