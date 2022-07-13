package drivers;

import slidingwindow.LongestSubstringWithoutRepeatingChar;
import slidingwindow.MaximumErasureValue;
import slidingwindow.MinimumWindowSubstring;

/*
 * LeetCode: https://leetcode.com/problems/number-of-islands/
 * NeetCode: https://www.youtube.com/watch?v=pV2kpPD66nE&list=PLot-Xpze53ldBT_7QA8NVot219jFNr_GI&index=5&ab_channel=NeetCode
 *
 */
public class SlidingWindowDriver {

    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingChar longestSubstringWithoutRepeatingChar = new LongestSubstringWithoutRepeatingChar();
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring("aa"));
    }

    public void maximumUniqueSubarray() {
        MaximumErasureValue maximumErasureValue = new MaximumErasureValue();
        System.out.println(maximumErasureValue.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }

    public void minimumWindowSubstring() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }
}
