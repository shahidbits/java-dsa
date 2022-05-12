package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode: https://leetcode.com/problems/combination-sum-ii/
 * NeetCode: https://www.youtube.com/watch?v=rSA3t6BDDwg&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=11
 *
 */

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (candidates != null && candidates.length > 0 && target > 0) {
            Arrays.sort(candidates);
            backtrack(candidates, target, 0, result, new ArrayList<>(), 0);
        }

        return result;
    }

    private void backtrack(int[] candidates, int target, int i, List<List<Integer>> result, List<Integer> sol, int currSum) {

        if (currSum == target) {
            result.add(new ArrayList<>(sol));
            return;
        }

        if (currSum > target || i >= candidates.length) {
            return;
        }

        sol.add(candidates[i]);
        backtrack(candidates, target, i + 1, result, sol, currSum + candidates[i]);

        sol.remove(sol.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(candidates, target, i + 1, result, sol, currSum);

    }
}
