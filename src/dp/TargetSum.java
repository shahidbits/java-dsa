package dp;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/target-sum/
 * NeetCode: https://www.youtube.com/watch?v=g0npyaQtAQM&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO
 *
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        return findTargetSumWaysUtil(nums, target, 0, 0, 0, new HashMap<String, Integer>());
    }

    private int findTargetSumWaysUtil(int[] nums, int target, int i, int sum, int total, Map<String, Integer> cache) {

        if (i == nums.length) {
            if (sum == target) {
                return total + 1;
            }
            return 0;
        }

        String key = String.format("%s::%s", i, sum);

        if (!cache.containsKey(key)) {

            int leftTotal = findTargetSumWaysUtil(nums, target, i + 1, sum + nums[i], total, cache);
            int rightTotal = findTargetSumWaysUtil(nums, target, i + 1, sum - nums[i], total, cache);
            cache.put(key, leftTotal + rightTotal);
        }

        return cache.get(key);

    }
}
