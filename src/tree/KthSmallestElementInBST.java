package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * LeetCode: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * NeetCode: https://www.youtube.com/watch?v=5LUXSvjmGCw&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=11&ab_channel=NeetCode
 *
 */
public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
//        return kthSmallestRecursive(root, k);
        return kthSmallestIterative(root, k);
    }


    //// Iterative Solution

    public int kthSmallestIterative(TreeNode node, int k) {

        if (node == null) {
            return -1;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = node;

        int itr = 0;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            itr++;

            if (itr == k) {
                return curr.val;
            }

            curr = curr.right;

        }

        return -1;
    }

    private void kthSmallestIterativeUtil(TreeNode node, Stack<Integer> res) {

        if (node == null) {
            return;
        }

        kthSmallestRecursiveUtil(node.left, res);
        res.add(node.val);
        kthSmallestRecursiveUtil(node.right, res);

    }

    //// Recursive Solution

    public int kthSmallestRecursive(TreeNode node, int k) {
        List<Integer> res = new ArrayList<>();
        kthSmallestRecursiveUtil(node, res);

        if (res.size() > k - 1) {
            return res.get(k - 1);
        }

        return -1;
    }

    private void kthSmallestRecursiveUtil(TreeNode node, List<Integer> res) {

        if (node == null) {
            return;
        }

        kthSmallestRecursiveUtil(node.left, res);
        res.add(node.val);
        kthSmallestRecursiveUtil(node.right, res);

    }
}
