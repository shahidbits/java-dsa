package dp;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/coin-change-2/
 * NeetCode: https://www.youtube.com/watch?v=Mjy4hd2xgrs&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO&index=4
 *
 */
public class CoinChange2 {

    //// T=O(A*C), S=O(A)
    public int change(int amount, int[] coins) {

        if (coins == null || coins.length == 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        int[] M = new int[amount + 1];

        M[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                M[j] += M[j - coins[i]];
            }
        }

        return M[M.length - 1];
    }

    //// T=O(A*C), S=O(A*C)
    public int change_dp1(int amount, int[] coins) {

        if (coins == null || coins.length == 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        int[][] M = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < M.length; i++) {
            M[i][0] = 1;
        }

        for (int j = 0; j < M[0].length; j++) {
            M[0][j] = 0;
        }

        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[i].length; j++) {

                if (j >= coins[i - 1]) {
                    M[i][j] = M[i - 1][j] + M[i][j - coins[i - 1]];
                } else {
                    M[i][j] = M[i - 1][j];
                }

            }
        }

        return M[M.length - 1][M[0].length - 1];
    }

    //// T=O(A*C), S=O(A*C)
    public int change_recursiveMemo(int amount, int[] coins) {

        if (coins == null || coins.length == 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        return backtrack(amount, coins, 0, 0, new HashMap<String, Integer>());

    }

    private int backtrack(int amount, int[] coins, int idx, int sum, Map<String, Integer> cache) {

        if (sum == amount) {
            return 1;
        }

        if (idx == coins.length || sum > amount) {
            return 0;
        }

        String key = String.format("%s::%s", idx, sum);

        if (!cache.containsKey(key)) {
            int count = backtrack(amount, coins, idx, sum + coins[idx], cache) +
                    backtrack(amount, coins, idx + 1, sum, cache);

            cache.put(key, count);
        }

        return cache.get(key);

    }
}
