package tree;

import util.TreeNode;

/*
 * LeetCode: https://leetcode.com/problems/validate-binary-search-tree/
 * NeetCode: https://www.youtube.com/watch?v=s6ATEkipzow&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=6
 *
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sumNumbersUtil(root, 0);
    }

    private int sumNumbersUtil(TreeNode node, int num) {

        if (node == null) {
            return 0;
        }

        num = (num * 10) + node.val;

        if (node.left == null && node.right == null) {
            return num;
        }

        int leftSum = sumNumbersUtil(node.left, num);
        int rightSum = sumNumbersUtil(node.right, num);

        return leftSum + rightSum;
    }

}
