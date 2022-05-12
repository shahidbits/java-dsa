package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * LeetCode: https://leetcode.com/problems/binary-tree-right-side-view/
 * NeetCode: https://www.youtube.com/watch?v=d4zLyf32e3I&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=10&ab_channel=NeetCode
 *
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root != null) {


            Queue<TreeNode> q = new LinkedList<>();

            q.add(root);

            while (!q.isEmpty()) {

                res.add(q.peek().val);

                int len = q.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = q.remove();

                    if (node.right != null) {
                        q.add(node.right);
                    }

                    if (node.left != null) {
                        q.add(node.left);
                    }
                }

            }
        }

        return res;

    }
}
