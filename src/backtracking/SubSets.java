package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode: https://leetcode.com/problems/subsets/
 * NeetCode: https://www.youtube.com/watch?v=REOH22Xwdkk&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=4
 *
 */

public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> sol = new ArrayList<>();

        backtrack(nums, 0, sol, result);

        return result;

    }

    private void backtrack(int[] nums, int idx, List<Integer> sol, List<List<Integer>> result) {

        if (idx >= nums.length) {
            result.add(new ArrayList<>(sol));
            return;
        }

        sol.add(nums[idx]);
        backtrack(nums, idx + 1, sol, result);

        sol.remove(sol.size() - 1);
        backtrack(nums, idx + 1, sol, result);

    }
}
