package string;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> countMap = new HashMap<>();

        int l = 0;
        int r = 0;

        int res = 0;
        int maxCount = 0;

        while (l <= r && r < s.length()) {

            char ch = s.charAt(r);

            int updatedCount = 0;
            if (countMap.containsKey(ch)) {
                updatedCount = countMap.get(ch) + 1;
            } else {
                updatedCount = 1;
            }
            countMap.put(ch, updatedCount);

            maxCount = Math.max(maxCount, updatedCount);

            int substrLen = r - l + 1;

            if (substrLen - maxCount <= k) {
                res = substrLen;
            } else {
                char charAtLeft = s.charAt(l);
                countMap.put(charAtLeft, countMap.get(charAtLeft) - 1);
                l++;
            }

            r++;

        }

        return res;

    }

}
