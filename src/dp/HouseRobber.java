package dp;

/*
 * LeetCode: https://leetcode.com/problems/house-robber/
 * NeetCode: https://www.youtube.com/watch?v=73r3KWiEvyk&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=5
 *
 */
public class HouseRobber {

    public int rob(int[] nums) {

        int rob1 = 0;
        int rob2 = 0;

        if (nums != null && nums.length > 0) {

            for (int n : nums) {

                int tmp = Math.max(rob1 + n, rob2);
                rob1 = rob2;
                rob2 = tmp;
            }
        }

        return rob2;
    }

    public int rob2(int[] nums) {

        int max = 0;

        if (nums != null && nums.length > 0) {

            int inclSum = nums[0];
            int exclSum = 0;

            for (int i = 1; i < nums.length; i++) {

                int tmp = inclSum;
                inclSum = nums[i] + exclSum;

                exclSum = Math.max(tmp, exclSum);
            }

            max = Math.max(inclSum, exclSum);

        }

        return max;

    }
}
