package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode: https://leetcode.com/problems/palindrome-partitioning/
 * NeetCode: https://www.youtube.com/watch?v=3jvWodd7ht0&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=5
 *
 */

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int i, List<String> sol, List<List<String>> result) {

        if (i >= s.length()) {
            result.add(new ArrayList<>(sol));
            return;
        }

        for (int j = i; j < s.length(); j++) {

            String subStr = s.substring(i, j + 1);

            if (isPalindrome(subStr)) {

                sol.add(subStr);

                backtrack(s, j + 1, sol, result);

                sol.remove(sol.size() - 1);

            }
        }
    }

    private boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
