/*

https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

1       2       3
--      abc     def
4       5       6
ghi     jkl     mno
7       8       9
pqrs    tuv     wxyz
*+      0       #
--      --      --

Constraints:
1. 0 <= digits.length <= 4
2. digits[i] is a digit in the range ['2', '9'].

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Input: digits = ""
Output: []

Input: digits = "2"
Output: ["a","b","c"]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsofPhoneNumber lc = new LetterCombinationsofPhoneNumber();

        List<String> res = lc.letterCombinations("23");
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> keypad = new HashMap<>() {{
            put('1', "");
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> res = new ArrayList<>();
        for (char ch : digits.toCharArray()) {
            res = makeCombinations(res, keypad.get(ch));
        }

        return res;
    }

    public List<String> makeCombinations(List<String> list, String chars) {
        if (list.isEmpty()) {
            return Arrays.asList(chars.split(""));
        }

        List<String> res = new ArrayList<>();
        for (String i : list) {
            for (char ch : chars.toCharArray()) {
                res.add(i + ch);
            }
        }

        return res;
    }
}
