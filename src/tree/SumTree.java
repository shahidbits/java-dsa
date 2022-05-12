package tree;

import util.TreeNode;

/*
 * https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 *
 */
public class SumTree {

    public TreeNode convert(TreeNode root) {

        dfs(root);
        return root;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int initVal = node.val;
        node.val = dfs(node.left) + dfs(node.right);

        return initVal + node.val;

    }
}
