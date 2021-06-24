/*
https://leetcode.com/problems/string-to-integer-atoi/

Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:
1. Read in and ignore any leading whitespace.
2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
3. Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
6. Return the integer as the final result.

Note:
1. Only the space character ' ' is considered a whitespace character.
2. Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

Constraints:
1. 0 <= s.length <= 200
2. s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

Input: s = "42"
Output: 42
	Explanation: The underlined characters are what is read in, the caret is the current reader position.
	Step 1: "42" (no characters read because there is no leading whitespace)
			 ^
	Step 2: "42" (no characters read because there is neither a '-' nor '+')
			 ^
	Step 3: "42" ("42" is read in)
			   ^
	The parsed integer is 42.
	Since 42 is in the range [-231, 231 - 1], the final result is 42.

Input: s = "   -42"
Output: -42
	Explanation:
	Step 1: "   -42" (leading whitespace is read and ignored)
				^
	Step 2: "   -42" ('-' is read, so the result should be negative)
				 ^
	Step 3: "   -42" ("42" is read in)
				   ^
	The parsed integer is -42.
	Since -42 is in the range [-231, 231 - 1], the final result is -42.

Input: s = "4193 with words"
Output: 4193
	Explanation:
	Step 1: "4193 with words" (no characters read because there is no leading whitespace)
			 ^
	Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
			 ^
	Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
				 ^
	The parsed integer is 4193.
	Since 4193 is in the range [-231, 231 - 1], the final result is 4193.

Input: s = "words and 987"
Output: 0
	Explanation:
	Step 1: "words and 987" (no characters read because there is no leading whitespace)
			 ^
	Step 2: "words and 987" (no characters read because there is neither a '-' nor '+')
			 ^
	Step 3: "words and 987" (reading stops immediately because there is a non-digit 'w')
			 ^
	The parsed integer is 0 because no digits were read.
	Since 0 is in the range [-231, 231 - 1], the final result is 0.

Input: s = "-91283472332"
Output: -2147483648
	Explanation:
	Step 1: "-91283472332" (no characters read because there is no leading whitespace)
			 ^
	Step 2: "-91283472332" ('-' is read, so the result should be negative)
			  ^
	Step 3: "-91283472332" ("91283472332" is read in)
						 ^
	The parsed integer is -91283472332.
	Since -91283472332 is less than the lower bound of the range [-231, 231 - 1], the final result is clamped to -231 = -2147483648.

*/

import java.util.*;

public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger lc = new StringToInteger();

        System.out.println(lc.myAtoi("+1"));
        System.out.println(lc.myAtoi("-91283472332"));
        System.out.println(lc.myAtoi("-2147483647"));
        System.out.println(lc.myAtoi("21474836460"));
        System.out.println(lc.myAtoi("   00000000000012345678"));
        System.out.println(lc.myAtoi("   00000-42a1234"));
        System.out.println(lc.myAtoi("4193 with words"));
        System.out.println(lc.myAtoi("words with 987"));
        System.out.println(lc.myAtoi("9223372036854775808"));
        System.out.println(lc.myAtoi("   -42"));
        System.out.println(lc.myAtoi("   00000000   "));
    }

    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();

        boolean positive = true;
        long res = 0;
        int resLen = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (s.charAt(i) == '-') {
                    positive = false;
                    i++;
                    while (i < n && s.charAt(i) == '0') {
                        i++;
                    }
                    if (i >= n)
                        break;
                } else if (s.charAt(i) == '+') {
                    i++;
                    while (i < n && s.charAt(i) == '0') {
                        i++;
                    }
                    if (i >= n)
                        break;
                } else {
                    while (i < n && s.charAt(i) == '0') {
                        i++;
                    }
                    if (i >= n)
                        break;
                }
            }

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                res = res * 10 + (int) s.charAt(i) - '0';
                resLen++;
                if (resLen > 12)
                    break;
            } else {
                break;
            }
        }

        if (!positive) {
            res = res > Integer.MAX_VALUE ? Integer.MIN_VALUE : res;
            res = -res;
        } else {
            res = res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        }

        return (int) res;
    }
}
