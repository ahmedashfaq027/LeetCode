/*
https://leetcode.com/problems/longest-substring-without-repeating-characters

Given a string s, find the length of the longest substring without repeating characters.

Constraints:
1. 0 <= s.length <= 5 * 104
2. s consists of English letters, digits, symbols and spaces.

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Input: s = ""
Output: 0

*/

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lc = new LongestSubstringWithoutRepeatingCharacters();

        String str = "abcabcbb";
        System.out.println(lc.lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            int res = 0;
            for (int j = i; j < n; j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    res++;
                } else
                    break;
            }
            ans = Math.max(ans, res);
        }

        return ans;
    }
}
