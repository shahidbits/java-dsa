package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode: https://leetcode.com/problems/restore-ip-addresses/
 * NeetCode: https://www.youtube.com/watch?v=61tN4YEdiTM&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=15&ab_channel=NeetCode
 *
 */

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();

        if (s == null || s.length() <= 3 || s.length() > 12) {
            return res;
        }

        backtrack(s, 0, 0, "", res);
        return res;

    }

    private void backtrack(String s, int idx, int dots, String sol, List<String> res) {

        if (dots == 4 && idx == s.length()) {
            res.add(sol.substring(0, sol.length() - 1));
            return;
        }

        if (dots > 4 || idx > s.length()) {
            return;
        }

        for (int i = idx; i < s.length() && i <= idx + 2; i++) {

            String part = s.substring(idx, i + 1);

            if (!isValidPart(part)) {
                continue;
            }

            backtrack(s, i + 1, dots + 1, sol + part + ".", res);
        }
    }

    private boolean isValidPart(String p) {

        if (Integer.parseInt(p) > 255) {
            return false;
        }

        if (p.startsWith("0") && p.length() > 1) {
            return false;
        }

        return true;
    }
}
