package array;

/*
 * LeetCode: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * NeetCode: https://www.youtube.com/watch?v=cQ1Oz4ckceM&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=5
 *
 */
public class TwoSum2 {

    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        if (nums != null && nums.length > 0) {

            int l = 0;
            int r = nums.length - 1;

            while (l < r) {

                int currSum = nums[l] + nums[r];

                if (currSum == target) {
                    res[0] = l + 1;
                    res[1] = r + 1;
                    break;
                }

                if (currSum > target) {
                    r--;
                } else {
                    l++;
                }

            }
        }

        return res;
    }
}

