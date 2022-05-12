package tree;

import util.PrintUtil;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 *
 */
public class RootToLeafPaths {

    public TreeNode print(TreeNode root) {

        dfs(root, new ArrayList<>());
        return root;
    }

    private void dfs(TreeNode node, List<Integer> A) {

        if (node == null) {
            return;
        }

        A.add(node.val);

        dfs(node.left, A);

        if (node.left == null && node.right == null) {
            PrintUtil.printArrayList(A);
        }

        dfs(node.right, A);

        A.remove(A.size() - 1);
    }


}
