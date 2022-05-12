package dp;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/decode-ways/
 * NeetCode: https://www.youtube.com/watch?v=6aEyTjOwlJU&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO&index=8
 *
 */
public class DecodeWays {

    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] DP = new int[s.length() + 1];

        DP[DP.length - 1] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '0') {
                DP[i] = 0;
            } else {
                DP[i] = DP[i + 1];
            }

            if (i + 1 < s.length() &&
                    (s.charAt(i) == '1' ||
                            (s.charAt(i) == '2' && Integer.parseInt(String.valueOf(s.charAt(i + 1))) <= 6))) {
                DP[i] += DP[i + 2];
            }

        }

        return DP[0];

    }

    public int numDecodings_recursive(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        return backtrack(s, 0, new HashMap<>());
    }

    private int backtrack(String s, int i, Map<String, Integer> cache) {

        if (i == s.length()) {
            return 1;
        }

        if (i >= s.length() || s.charAt(i) == '0') {
            return 0;
        }

        String key = String.format("%s", i);

        if (!cache.containsKey(key)) {

            int ways = 0;

            ways += backtrack(s, i + 1, cache);

            if (i + 1 < s.length() &&
                    (s.charAt(i) == '1' ||
                            (s.charAt(i) == '2' && Integer.parseInt(String.valueOf(s.charAt(i + 1))) <= 6))) {
                ways += backtrack(s, i + 2, cache);
            }

            cache.put(key, ways);
        }

        return cache.get(key);

    }
}
