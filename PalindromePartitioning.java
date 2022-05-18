/*

https://leetcode.com/problems/palindrome-partitioning/

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.

Constraints:
1. 1 <= s.length <= 16
2. s contains only lowercase English letters.

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Input: s = "a"
Output: [["a"]]

*/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning lc = new PalindromePartitioning();

        System.out.println(lc.partition("aab"));
        System.out.println(lc.partition("a"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int idx, List<String> currPerm, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(currPerm));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                currPerm.add(s.substring(idx, i + 1));
                dfs(s, i + 1, currPerm, res);
                currPerm.remove(currPerm.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }

            lo++;
            hi--;
        }

        return true;
    }
}
