package backtracking;

/*
 * LeetCode: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 * NeetCode: https://www.youtube.com/watch?v=mBk4I0X46oI&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=16&ab_channel=NeetCode
 *
 */

import java.util.Arrays;
import java.util.Collections;

public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        nums = Arrays.stream(nums).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        if (sum % k != 0) {
            return false;
        }

        boolean[] used = new boolean[nums.length];

        return backtrack(nums, k, 0, (sum / k), 0, used);
    }

    private boolean backtrack(int[] nums, int k, int i, int targetSum, int currSum, boolean[] used) {

        if (k == 0) {
            return true;
        }

        if (currSum == targetSum) {
            return backtrack(nums, k - 1, 0, targetSum, 0, used);
        }

        for (int j = i; j < nums.length; j++) {

            if (used[j] || currSum + nums[j] > targetSum) {
                continue;
            }

            used[j] = true;

            if (backtrack(nums, k, j + 1, targetSum, currSum + nums[j], used)) {
                return true;
            }

            used[j] = false;
        }

        return false;

    }
}
