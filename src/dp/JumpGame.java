package dp;

/*
 * LeetCode: https://leetcode.com/problems/jump-game/
 * NeetCode: https://www.youtube.com/watch?v=Yan0cv2cLy8&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO&index=21
 *
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        int goal = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (i + nums[i] >= goal) {
                goal = i;
            }

        }

        return goal == 0;
    }
}
