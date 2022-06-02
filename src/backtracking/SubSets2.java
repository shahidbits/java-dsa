package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode: https://leetcode.com/problems/subsets-ii/
 * NeetCode: https://www.youtube.com/watch?v=Vn2v6ajA7U0&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=19&ab_channel=NeetCode
 *
 */

public class SubSets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> sol, List<List<Integer>> res) {

        if (i == nums.length) {
            res.add(new ArrayList<>(sol));
            return;
        }

        sol.add(nums[i]);
        backtrack(nums, i + 1, sol, res);
        sol.remove(sol.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        backtrack(nums, i + 1, sol, res);

    }
}
