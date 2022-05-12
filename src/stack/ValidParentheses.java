package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    static Map<Character, Character> bracketMap;

    static {
        bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');
    }

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                if (!stack.isEmpty()) {

                    char stackTop = stack.pop();

                    if (!bracketMap.containsKey(stackTop) || bracketMap.get(stackTop) != c) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
