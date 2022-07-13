package dp;

/*
 * LeetCode: https://leetcode.com/problems/trapping-rain-water/
 *
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        // int[] result = new int[height.length];

        leftMax[0] = 0;
        int lMax = 0;

        rightMax[rightMax.length - 1] = 0;
        int rMax = 0;

        for (int i = 1; i < height.length; i++) {
            lMax = Math.max(lMax, height[i - 1]);
            leftMax[i] = lMax;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            rMax = Math.max(rMax, height[i + 1]);
            rightMax[i] = rMax;
        }

        // for (int i=0; i < height.length-1; i++) {
        //     System.out.println("[" + i +"] " + leftMax[i] + " " + rightMax[i]);
        // }

        int res = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int tmp = Math.min(leftMax[i], rightMax[i]) - height[i];
            res += (tmp > 0 ? tmp : 0);
        }

        return res;
    }
}
