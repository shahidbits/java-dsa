package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode: https://leetcode.com/problems/permutations/
 * NeetCode: https://www.youtube.com/watch?v=s7AvT7cGdSo&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=2
 *
 */

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        int[] visited = new int[nums.length];

        if (nums != null && nums.length > 0) {

            backtrack(nums, result, new ArrayList<>(), visited);
        }

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> sol, int[] visited) {

        if (sol.size() == nums.length) {
            result.add(new ArrayList<>(sol));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i] == 0) {

                sol.add(nums[i]);
                visited[i] = 1;

                backtrack(nums, result, sol, visited);

                sol.remove(sol.size() - 1);
                visited[i] = 0;
            }
        }

    }
}
