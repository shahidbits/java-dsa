package dp;

import java.util.List;

/*
 * LeetCode: https://leetcode.com/problems/word-break/
 * NeetCode: https://www.youtube.com/watch?v=Sx9NNgInc3A&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO&index=6
 *
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) {
            return true;
        }

        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }

        boolean[] res = new boolean[s.length() + 1];

        res[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {

            for (String w : wordDict) {

                if (i + w.length() <= s.length() &&
                        s.substring(i, i + w.length()).equals(w)) {
                    res[i] = res[i + w.length()];
                }

                if (res[i] == true) {
                    break;
                }
            }
        }

        return res[0];

    }
}
