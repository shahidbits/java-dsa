package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/permutations-ii/
 * NeetCode: https://www.youtube.com/watch?v=qhBVWf0YafA&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=3
 *
 */

public class Permutations2 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> countMap = populateNumberCountMap(nums);

        if (nums != null && nums.length > 0) {
            backtrack(countMap, nums.length, result, new ArrayList<>());
        }

        return result;
    }

    private void backtrack(Map<Integer, Integer> countMap, int size, List<List<Integer>> result, List<Integer> sol) {

        if (sol.size() == size) {
            result.add(new ArrayList<>(sol));
            return;
        }

        for (Iterator<Map.Entry<Integer, Integer>> it = countMap.entrySet().iterator(); it.hasNext(); ) {

            Map.Entry<Integer, Integer> entry = it.next();

            if (entry.getValue() > 0) {

                sol.add(entry.getKey());
                countMap.put(entry.getKey(), entry.getValue() - 1);

                backtrack(countMap, size, result, sol);

                sol.remove(sol.size() - 1);
                countMap.put(entry.getKey(), entry.getValue() + 1);
            }

        }
    }

    private Map<Integer, Integer> populateNumberCountMap(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], 1 + countMap.get(nums[i]));
            } else {
                countMap.put(nums[i], 1);
            }
        }

        return countMap;
    }
}
