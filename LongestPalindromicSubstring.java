/*

https://leetcode.com/problems/longest-palindromic-substring

Given a string s, return the longest palindromic substring in s.

Constraints:
1. 1 <= s.length <= 1000
2. s consist of only digits and English letters (lower-case and/or upper-case),

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: s = "cbbd"
Output: "bb"

Input: s = "a"
Output: "a"

Input: s = "ac"
Output: "a"

*/

import java.util.*;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring lc = new LongestPalindromicSubstring();

        System.out.println(lc.longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int ptr1 = 0, ptr2 = 0;
        int ans = 0;
        int minIdx = 0, maxIdx = 0;

        // Odd length - 2 ptr technique
        for (int i = 0; i < n; i++) {
            ptr1 = ptr2 = i;

            while (ptr1 >= 0 && ptr2 < n) {
                if (s.charAt(ptr1) == s.charAt(ptr2)) {
                    ptr1--;
                    ptr2++;
                } else
                    break;
            }
            if (ans < (ptr2 - ptr1 - 1)) {
                ans = ptr2 - ptr1 - 1;
                minIdx = ptr1 + 1;
                maxIdx = ptr2 - 1;
            }
        }

        // Even length - 2 ptr technique
        for (int i = 0; i < n; i++) {
            ptr1 = i;
            ptr2 = i + 1;

            while (ptr1 >= 0 && ptr2 < n) {
                if (s.charAt(ptr1) == s.charAt(ptr2)) {
                    ptr1--;
                    ptr2++;
                } else
                    break;
            }
            if (ans < (ptr2 - ptr1 - 1)) {
                ans = ptr2 - ptr1 - 1;
                minIdx = ptr1 + 1;
                maxIdx = ptr2 - 1;
            }
        }

        return s.substring(minIdx, maxIdx + 1);
    }
}
