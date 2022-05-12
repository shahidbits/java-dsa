package tree;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * NeetCode: https://www.youtube.com/watch?v=ihj4IQGZ2zc&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=15&ab_channel=NeetCode
 *
 */
public class ConstructBTFromPreorderAndInorder {

    private int preorderIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0 ||
                inorder == null || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        TreeNode root = buildTreeUtil(preorder, inorder, inorderIndexMap, 0, inorder.length - 1);
        return root;

    }

    public TreeNode buildTreeUtil(int[] preorder, int[] inorder, Map<Integer, Integer> inorderIndexMap, int l, int r) {

        if (l > r || preorderIdx >= preorder.length) {
            return null;
        }

        int val = preorder[preorderIdx++];
        TreeNode root = new TreeNode(val);

        // it is a leaf node
        if (l == r) {
            return root;
        }

        int inorderIdx = inorderIndexMap.get(val);

        root.left = buildTreeUtil(preorder, inorder, inorderIndexMap, l, inorderIdx - 1);
        root.right = buildTreeUtil(preorder, inorder, inorderIndexMap, inorderIdx + 1, r);

        return root;

    }
}
