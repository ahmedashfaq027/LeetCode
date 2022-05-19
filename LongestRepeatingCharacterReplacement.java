/*

https://leetcode.com/problems/longest-repeating-character-replacement/

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Constraints:
1. 1 <= s.length <= 105
2. s consists of only uppercase English letters.
3. 0 <= k <= s.length

Input: s = "ABAB", k = 2
Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.

Input: s = "AABABBA", k = 1
Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.

*/

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement lc = new LongestRepeatingCharacterReplacement();

        System.out.println(lc.characterReplacement("ABAB", 2));
        System.out.println(lc.characterReplacement("AABABBA", 1));
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> maps = new HashMap<>();

        int i = 0, result = 0;
        int maxRepeat = 0;
        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);
            maps.put(ch, maps.getOrDefault(ch, 0) + 1);
            maxRepeat = Math.max(maxRepeat, maps.get(ch));

            if ((j - i + 1) - maxRepeat > k) {
                char x = s.charAt(i++);
                maps.put(x, maps.get(x) - 1);
            }

            result = Math.max(result, (j - i + 1));
        }

        return result;
    }
}
