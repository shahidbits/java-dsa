package array;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/two-sum/
 * NeetCode: https://www.youtube.com/watch?v=KLlXCFG5TnA&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=2
 *
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        if (nums != null && nums.length > 0) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                if (map.containsKey(target - nums[i])) {
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                    break;
                }

                map.put(nums[i], i);

            }
        }

        return res;
    }
}

