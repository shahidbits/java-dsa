package string;

import java.util.Arrays;

/*
 * LeetCode: https://leetcode.com/problems/valid-anagram/
 * NeetCode: https://www.youtube.com/watch?v=9UtInBqnCgA&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ
 *
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s == null && t == null) {
            return true;
        }

        if ("".equals(s) && "".equals(t)) {
            return true;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        s = new StringBuffer().append(sArr).toString();
        t = new StringBuffer().append(tArr).toString();

        return (s.equals(t));
    }
}
