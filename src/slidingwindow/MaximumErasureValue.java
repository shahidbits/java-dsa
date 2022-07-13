package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
 * LeetCode: https://leetcode.com/problems/maximum-erasure-value/
 *
 */
public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {

        int l = 0;
        int r = 0;

        Set<Integer> windowSet = new HashSet<>();
        int currSum = 0;
        int max = Integer.MIN_VALUE;

        while (r < nums.length) {

            if (windowSet.contains(nums[r])) {
                windowSet.remove(nums[l]);
                currSum -= nums[l];
                l++;
            } else {
                windowSet.add(nums[r]);
                currSum += nums[r];
                max = Math.max(max, currSum);
                r++;
            }

            System.out.println(String.format("l=%s r=%s curr=%s max=%s", l, r, currSum, max));
        }

        return max;
    }

}
