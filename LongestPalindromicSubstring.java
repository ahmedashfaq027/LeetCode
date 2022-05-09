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

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring lc = new LongestPalindromicSubstring();

        System.out.println(lc.longestPalindrome("babad"));
        System.out.println(lc.longestPalindrome("cbbd"));
        System.out.println(lc.longestPalindrome("a"));
        System.out.println(lc.longestPalindrome("ac"));
        System.out.println(lc.longestPalindrome("aacabdkacaa"));
    }

    /*
        Explanation:
            DP Equation: dp[i][j] = dp[i+1][j-1] + 2 only if str[i] == str[j] and dp[i+1][j-1] > 0
    */
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int st = 0, length = 0;

        for (int len = 0; len < n; len++) {
            for (int i = 0, j = len; j < n; i++, j++) {
                if (len == 0)
                    dp[i][j] = 1;
                else if (len == 1 && s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (dp[i + 1][j - 1] > 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }

                if (dp[i][j] > length) {
                    length = dp[i][j];
                    st = i;
                }

            }
        }

        return s.substring(st, st + length);
    }

    public String longestPalindromePtr(String s) {
        int n = s.length();
        int ptr1, ptr2;
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
