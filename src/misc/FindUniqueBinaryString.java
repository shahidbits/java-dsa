package misc;

import java.util.Arrays;

/*
 * LeetCode: https://leetcode.com/problems/find-unique-binary-string/
 * NeetCode: https://www.youtube.com/watch?v=aHqn4Dynd1k&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=13&ab_channel=NeetCode
 *
 */
public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }

        int sLen = nums[0].length();

        char[] ch = new char[sLen];
        Arrays.fill(ch, '0');

        for (int i = 0; i < sLen; i++) {
            ch[i] = (nums[i].charAt(i) == '0') ? '1' : '0';
        }

        return new String(ch);

    }

}
