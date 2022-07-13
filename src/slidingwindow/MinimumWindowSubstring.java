package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/minimum-window-substring/
 * NeetCode: https://www.youtube.com/watch?v=jSto0O4AJbM&ab_channel=NeetCode
 *
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        int currMatch = 0;
        int reqMatch = 0;

        for (char ch : t.toCharArray()) {
            int cnt = tMap.getOrDefault(ch, 0);
            tMap.put(ch, 1 + cnt);
        }

        reqMatch = tMap.size();

        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;

        int initL = l;

        while (r < s.length()) {

            char c = s.charAt(r);

            if (!tMap.containsKey(c)) {
                r++;
                continue;
            }

            int sCount = 1 + sMap.getOrDefault(c, 0);
            sMap.put(c, sCount);

            System.out.println(String.format("l=%s r=%s c=%s sCount=%s tCount=%s",
                    l, r, c, sCount, tMap.get(c)));

            if (sCount == tMap.get(c)) {
                currMatch++;
            }

            System.out.println(String.format("reqMatch=%s currMatch=%s", reqMatch, currMatch));
            if (currMatch == reqMatch) {

                System.out.println(String.format("EQUAL reqMatch=%s currMatch=%s", reqMatch, currMatch));

                while (currMatch == reqMatch) {

                    int newLen = r - l + 1;
                    if (newLen < minLen) {
                        minLen = newLen;
                        initL = l;
                    }

                    char cRemove = s.charAt(l);

                    if (tMap.containsKey(cRemove)) {

                        int newCount = sMap.get(cRemove) - 1;
                        sMap.put(cRemove, Math.max(newCount, 0));

                        System.out.println(String.format("REMOVE l=%s r=%s c=%s sCount=%s tCount=%s newLen=%s cRemove=%s",
                                l, r, c, sCount, tMap.get(c), newLen, cRemove));

                        if (tMap.get(cRemove) > newCount) {
                            currMatch--;
                        }
                    }
                    l++;
                }

                r++;

            } else {

                System.out.println(String.format("NOT FOUND"));

                r++;
            }

        }

        return s.substring(initL, initL + minLen);
    }
}
