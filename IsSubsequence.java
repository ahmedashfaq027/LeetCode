/*

https://leetcode.com/problems/is-subsequence/

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Constraints:
1. 0 <= s.length <= 100
2. 0 <= t.length <= 104
3. s and t consist only of lowercase English letters.

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

Input: s = "abc", t = "ahbgdc"
Output: true

Input: s = "axc", t = "ahbgdc"
Output: false

*/

public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence lc = new IsSubsequence();

        System.out.println(lc.isSubsequence("abc", "ahbgdc"));
        System.out.println(lc.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i, j;

        for (i = 0, j = 0; i < n && j < m; i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }

        return j == m;
    }
}
