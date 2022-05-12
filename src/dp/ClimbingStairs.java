package dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public int climbStairs(int n) {

        return backtrack(n, 0, new HashMap<Integer, Integer>());

    }

    private int backtrack(int n, int i, Map<Integer, Integer> cache) {

        if (i == n) {
            return 1;
        }

        if (i > n) {
            return 0;
        }

        if (!cache.containsKey(i)) {
            int jump1Ways = backtrack(n, i + 1, cache);
            int jump2Ways = backtrack(n, i + 2, cache);
            cache.put(i, jump1Ways + jump2Ways);
        }

        return cache.get(i);

    }
}
