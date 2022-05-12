package array;

/*
 * LeetCode: https://leetcode.com/problems/maximum-subarray/
 * NeetCode: https://www.youtube.com/watch?v=5WZl3MMT0Eg&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=3
 *
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;

        if (nums != null && nums.length > 0) {

            int currSum = 0;

            for (int i = 0; i < nums.length; i++) {

                currSum += nums[i];

                if (currSum > 0) {
                    if (currSum > maxSum) {
                        maxSum = currSum;
                    }
                } else {
                    if (currSum > maxSum) {
                        maxSum = currSum;
                    }
                    currSum = 0;
                }

            }


        }

        return maxSum;
    }
}
