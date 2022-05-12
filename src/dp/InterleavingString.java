package dp;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/decode-ways/
 * NeetCode: https://www.youtube.com/watch?v=6aEyTjOwlJU&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO&index=8
 *
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s3 == null || s3.length() == 0) {
            return true;
        }

        if (s1 == null || s1.length() == 0) {
            return s3.equals(s2);
        }

        if (s2 == null || s2.length() == 0) {
            return s3.equals(s1);
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] DP = new boolean[s1.length() + 1][s2.length() + 1];

        DP[0][0] = true;

        for (int i = 0; i < s2.length(); i++) {
            DP[0][i + 1] = DP[0][i] && s2.charAt(i) == s3.charAt(i);
        }

        for (int i = 0; i < s1.length(); i++) {
            DP[i + 1][0] = DP[i][0] && s1.charAt(i) == s3.charAt(i);
        }

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {

                DP[i + 1][j + 1] = DP[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1);
                DP[i + 1][j + 1] = DP[i + 1][j + 1] || (DP[i + 1][j] && s2.charAt(j) == s3.charAt(i + j + 1));

            }
        }

        return DP[s1.length()][s2.length()];

    }

    public boolean isInterleave_recursive(String s1, String s2, String s3) {

        if (s3 == null || s3.length() == 0) {
            return true;
        }

        if (s1 == null || s1.length() == 0) {
            return s3.equals(s2);
        }

        if (s2 == null || s2.length() == 0) {
            return s3.equals(s1);
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return backtrack(s1, s2, s3, 0, 0, 0, new HashMap<>());
    }

    private boolean backtrack(String s1, String s2, String s3, int i, int j, int k, Map<String, Boolean> cache) {

        if (k >= s3.length()) {
            return true;
        }

        if (i >= s1.length() && j >= s2.length()) {
            return false;
        }

        if ((i < s1.length() && s1.charAt(i) != s3.charAt(k))
                && (j < s2.length() && s2.charAt(j) != s3.charAt(k))) {
            return false;
        }

        String key = String.format("%s::%s", i, j);

        if (!cache.containsKey(key)) {

            boolean found1 = false;
            boolean found2 = false;

            if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
                found1 = backtrack(s1, s2, s3, i + 1, j, k + 1, cache);
            }

            if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
                found2 = backtrack(s1, s2, s3, i, j + 1, k + 1, cache);
            }

            cache.put(key, found1 || found2);
        }

        return cache.get(key);

    }
}
