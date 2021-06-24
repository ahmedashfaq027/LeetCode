/*

https://leetcode.com/problems/valid-parentheses/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Constraints:
1. 1 <= s.length <= 104
2. s consists of parentheses only '()[]{}'.

Input: s = "()"
Output: true

Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false

Input: s = "([)]"
Output: false

Input: s = "{[]}"
Output: true

*/

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis lc = new ValidParenthesis();

        System.out.println(lc.isValid("("));
        System.out.println(lc.isValid("()"));
        System.out.println(lc.isValid("()[]{}"));
        System.out.println(lc.isValid("()[{]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> brackets = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else {
                if (!st.empty()) {
                    Character popp = st.pop();
                    if (popp != brackets.get(ch)) {
                        return false;
                    }
                } else
                    return false;
            }
        }

        return st.empty();
    }
}
