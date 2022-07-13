package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
 * LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class LongestSubstringWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> charSet = new HashSet<>();

        int l = 0;
        int r = 0;

        int maxLen = Integer.MIN_VALUE;

        while (r < s.length() && l < s.length()) {

            char ch = s.charAt(r);

            while (!charSet.contains(ch)) {
                charSet.add(ch);
                r++;

                if (r == s.length()) {
                    break;
                }

                ch = s.charAt(r);
            }

            maxLen = Math.max(maxLen, r - l);

            charSet.remove(s.charAt(l));
            l++;
        }

        return maxLen;

    }
}
