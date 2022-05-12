package drivers;

import stack.ValidParentheses;

public class StackDriver {

    public void validParentheses() {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println("isValid = " + validParentheses.isValid("()[]{}"));
//        System.out.println("isValid = " + validParentheses.isValid("(]"));
    }
}
