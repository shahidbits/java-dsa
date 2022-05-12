package tree;

/*
 * LeetCode: https://leetcode.com/problems/unique-binary-search-trees/
 * NeetCode: https://www.youtube.com/watch?v=Ox0TenN3Zpg&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&index=9&ab_channel=NeetCode
 *
 */
public class UniqueBST {

    public int numTrees(int n) {

        // numTrees(4) = numTrees(0) * numTrees(3) +
        //               numTrees(1) * numTrees(2) +
        //               numTrees(2) * numTrees(1) +
        //               numTrees(3) * numTrees(0)

        int[] res = new int[n + 1];

        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }

        for (int i = 2; i <= n; i++) {

            int total = 0;

            for (int j = 1; j <= i; j++) {

                int left = j - 1;
                int right = i - j;

                total += (res[left] * res[right]);

            }

            res[i] = total;
        }

        return res[n];
    }
}
