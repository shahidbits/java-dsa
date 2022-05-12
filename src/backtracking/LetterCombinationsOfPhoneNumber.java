package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * LeetCode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * NeetCode: https://www.youtube.com/watch?v=0snEunUacZY&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=6
 *
 */
public class LetterCombinationsOfPhoneNumber {

    private static Map<Character, String> map;

    static {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits != null && digits.length() > 0) {
            backtrack(digits, 0, result, new char[digits.length()]);
        }

        return result;
    }

    private void backtrack(String digits, int idx, List<String> result, char[] sol) {

        if (idx >= digits.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(sol);
            result.add(sb.toString());
            return;
        }

        String possibleChars = map.get(digits.charAt(idx));

        for (int i = 0; i < possibleChars.length(); i++) {

            sol[idx] = possibleChars.charAt(i);

            backtrack(digits, idx + 1, result, sol);

//            sol[idx] = ' ';
        }

    }
}
