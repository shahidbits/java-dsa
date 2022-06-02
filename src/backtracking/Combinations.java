package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, res, new ArrayList<>());
        return res;

    }

    private void backtrack(int n, int k, int idx, List<List<Integer>> res, List<Integer> sol) {

        if (sol.size() == k) {
            res.add(new ArrayList<>(sol));
            return;
        }

        for (int i = idx; i <= n; i++) {

            sol.add(i);
            backtrack(n, k, i + 1, res, sol);
            sol.remove(sol.size() - 1);

        }

    }
}
