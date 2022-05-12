package tree;

import util.TreeNode;

/*
 * LeetCode: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * NeetCode: https://www.youtube.com/watch?v=0K0uCMYq5ng&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=5
 *
 */
public class SortedArrayToBalancedBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTUtil(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTUtil(int[] nums, int low, int high) {

        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBSTUtil(nums, low, mid - 1);
        node.right = sortedArrayToBSTUtil(nums, mid + 1, high);

        return node;

    }

}
