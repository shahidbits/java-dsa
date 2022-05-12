package string;

/*
 * LeetCode: https://leetcode.com/problems/word-break/
 * NeetCode: https://www.youtube.com/watch?v=XYQecbcd6_c&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO&index=7
 *
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        String res = "";
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd Length Palindromes
            int[] odd = getMaxPalindrome(s, i, i);

            if (odd[0] >= 0 && odd[1] >= 0 && odd[1] - odd[0] + 1 > maxLen) {
                maxLen = odd[1] - odd[0] + 1;
                res = s.substring(odd[0], odd[1] + 1);
            }

            // Even Length Palindromes
            int[] even = getMaxPalindrome(s, i, i + 1);

            if (even[0] >= 0 && even[1] >= 0 && even[1] - even[0] + 1 > maxLen) {
                maxLen = even[1] - even[0] + 1;
                res = s.substring(even[0], even[1] + 1);
            }
        }

        return res;
    }

    private int[] getMaxPalindrome(String s, int l, int r) {

        int max = 0;
        int[] res = new int[]{-1, -1};

        while (l >= 0 && r < s.length() &&
                s.charAt(l) == s.charAt(r)) {

            int currLen = r - l + 1;

            if (currLen > max) {
                res[0] = l;
                res[1] = r;
            }

            l--;
            r++;
        }

        return res;

    }
}
