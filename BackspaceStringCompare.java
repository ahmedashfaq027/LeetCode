/*

https://leetcode.com/problems/backspace-string-compare/

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.

Constraints:
1. 1 <= s.length, t.length <= 200
2. s and t only contain lowercase letters and '#' characters.

Follow up: Can you solve it in O(n) time and O(1) space?

Input: s = "ab#c", t = "ad#c"
Output: true
    Explanation: Both s and t become "ac".

Input: s = "ab##", t = "c#d#"
Output: true
    Explanation: Both s and t become "".

Input: s = "a#c", t = "b"
Output: false
    Explanation: s becomes "c" while t becomes "b".

*/

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        BackspaceStringCompare lc = new BackspaceStringCompare();

        System.out.println(lc.backspaceCompare("ab#c", "ad#c"));
        System.out.println(lc.backspaceCompare("ab##", "c#d#"));
        System.out.println(lc.backspaceCompare("a#c", "b"));
        System.out.println(lc.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!st1.isEmpty())
                    st1.pop();
            } else
                st1.push(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!st2.isEmpty())
                    st2.pop();
            } else
                st2.push(t.charAt(i));
        }

        System.out.println(st1.toString() + " " + st2.toString());

        return st1.equals(st2);
    }
}
