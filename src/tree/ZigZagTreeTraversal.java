package tree;

import util.TreeNode;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 *
 */
public class ZigZagTreeTraversal {

    public void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {

            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                System.out.print(node.val + " ");

                if (node.left != null) {
                    s2.push(node.left);
                }

                if (node.right != null) {
                    s2.push(node.right);
                }
            }

            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                System.out.print(node.val + " ");

                if (node.right != null) {
                    s1.push(node.right);
                }

                if (node.left != null) {
                    s1.push(node.left);
                }
            }
        }
    }


}
