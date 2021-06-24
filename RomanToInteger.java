/*

https://leetcode.com/problems/roman-to-integer/

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
1. I can be placed before V (5) and X (10) to make 4 and 9.
2. X can be placed before L (50) and C (100) to make 40 and 90.
3. C can be placed before D (500) and M (1000) to make 400 and 900.
4. Given a roman numeral, convert it to an integer.

Constraints:
1. 1 <= s.length <= 15
2. s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
3. It is guaranteed that s is a valid roman numeral in the range [1, 3999].

Input: s = "III"
Output: 3

Input: s = "IV"
Output: 4

Input: s = "IX"
Output: 9

Input: s = "LVIII"
Output: 58
    Explanation: L = 50, V= 5, III = 3.

Input: s = "MCMXCIV"
Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger lc = new RomanToInteger();

        System.out.println(lc.romanToInt("XC"));
        System.out.println(lc.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int res = 0;
        HashMap<Character, Integer> romans = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int i = 0;
        while (i < s.length()) {
            if (i == s.length() - 1) {
                res += romans.get(s.charAt(i));
                return res;
            }

            int cur = romans.get(s.charAt(i));
            int next = romans.get(s.charAt(i + 1));

            if (cur >= next) {
                res += cur;
                i++;
            } else {
                res += next - cur;
                i += 2;
            }
        }

        return res;
    }
}
