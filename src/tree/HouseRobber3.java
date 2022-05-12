package tree;

import util.TreeNode;

/*
 * LeetCode: https://leetcode.com/problems/house-robber-iii/
 * NeetCode: https://www.youtube.com/watch?v=nHR8ytpzz7c&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=13&ab_channel=NeetCode
 *
 */
public class HouseRobber3 {

    public int rob(TreeNode root) {

        int[] res = robUtil(root);
        return Math.max(res[0], res[1]);
    }

    // res[0] -> including root
    // res[1] -> excluding root
    public int[] robUtil(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        int[] leftMax = robUtil(node.left);
        int[] rightMax = robUtil(node.right);

        int includeRootMax = node.val + leftMax[1] + rightMax[1];
        int excludeRootMax = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);

        return new int[]{includeRootMax, excludeRootMax};

    }
}
