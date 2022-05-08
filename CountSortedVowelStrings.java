/*

https://leetcode.com/problems/count-sorted-vowel-strings/

Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

Constraints:
1. 1 <= n <= 50

Input: n = 1
Output: 5
    Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

Input: n = 2
Output: 15
    Explanation: The 15 sorted strings that consist of vowels only are
    ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
    Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

Input: n = 33
Output: 66045

*/

public class CountSortedVowelStrings {
    public static void main(String[] args) {
        CountSortedVowelStrings lc = new CountSortedVowelStrings();

        System.out.println(lc.countVowelStrings(2));
        System.out.println(lc.countVowelStrings(33));
    }

    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];

        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < 6; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n][5];
    }
}
