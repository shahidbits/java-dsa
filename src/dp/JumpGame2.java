package dp;

/*
 * LeetCode: https://leetcode.com/problems/jump-game-ii/submissions/
 * NeetCode: https://www.youtube.com/watch?v=dJ7sWiOoK7g&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO&index=22
 *
 */
public class JumpGame2 {

    public int jump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // if (nums[0] == 0 || nums.length == 1) {
        //     return 0;
        // }

        int l=0;
        int r=0;

        int jumps = 0;

        while (r < nums.length - 1) {

            int farthest = 0;

            for (int i=l; i<=r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r+1;
            r = farthest;

            jumps++;
        }

        return jumps;

    }
}
