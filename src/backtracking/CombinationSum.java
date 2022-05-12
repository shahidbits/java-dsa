package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * LeetCode: https://leetcode.com/problems/combination-sum/
 * NeetCode: https://www.youtube.com/watch?v=GBKI9VSKdGg&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=8
 *
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (candidates != null && candidates.length > 0 && target > 0) {
            backtrack(candidates, target, 0, result, new ArrayList<>(), 0);
        }

        return result;
    }

    private void backtrack(int[] candidates, int target, int i, List<List<Integer>> result, List<Integer> sol, int currSum) {

        // we ran out of candidates, but the target sum was not achieved
        if (i >= candidates.length || currSum > target) {
            return;
        }

        if (currSum == target) {
            result.add(new ArrayList<>(sol));
            return;
        }

        sol.add(candidates[i]);
        backtrack(candidates, target, i, result, sol, currSum + candidates[i]);

        sol.remove(sol.size() - 1);
        backtrack(candidates, target, i + 1, result, sol, currSum);

    }

    private int calculateSum(List<Integer> sol) {
        AtomicInteger sum = new AtomicInteger();
        sol.stream().forEach(i -> sum.addAndGet(i));
        return sum.get();
    }

}
