package tree;

import util.TreeNode;

/*
 * LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * NeetCode: https://www.youtube.com/watch?v=gs2LMfuOR9k&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=18
 *
 */
public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode curr = root;

        while (curr != null) {

            if (curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            } else if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorUtil(root, p, q);
    }

    private TreeNode lowestCommonAncestorUtil(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return null;
        }

        if (node.val == p.val || node.val == q.val) {
            return node;
        }

        if ((node.val > p.val && node.val < q.val) ||
                (node.val > q.val && node.val < p.val)) {
            return node;
        }

        if (node.val > p.val && node.val > q.val) {
            return lowestCommonAncestorUtil(node.left, p, q);
        } else {
            return lowestCommonAncestorUtil(node.right, p, q);
        }
    }

}
