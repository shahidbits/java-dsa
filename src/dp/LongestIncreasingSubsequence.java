package dp;

/*
 * LeetCode: https://leetcode.com/problems/longest-increasing-subsequence/
 * NeetCode: https://www.youtube.com/watch?v=cjWnW0hdF1Y&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO&index=13
 *
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] LIS = new int[nums.length];

        LIS[LIS.length - 1] = 1;

        for (int i = LIS.length - 2; i >= 0; i--) {

            int maxRight = Integer.MIN_VALUE;

            for (int j = i + 1; j < LIS.length; j++) {
                if (nums[i] < nums[j]) {
                    maxRight = Math.max(maxRight, LIS[j]);
                }
            }

            LIS[i] = Math.max(1, 1 + maxRight);
        }

        int max = Integer.MIN_VALUE;

        for (int lis : LIS) {
            max = Math.max(max, lis);
        }

        return max;
    }
}
