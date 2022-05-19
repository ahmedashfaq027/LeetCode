/*

https://leetcode.com/problems/permutation-in-string/

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Constraints:
1. 1 <= s1.length, s2.length <= 104
2. s1 and s2 consist of lowercase English letters.

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
    Explanation: s2 contains one permutation of s1 ("ba").

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

*/

import java.util.HashMap;

public class PermutationinString {
    public static void main(String[] args) {
        PermutationinString lc = new PermutationinString();

        System.out.println(lc.checkInclusion("ab", "eidbaooo"));
        System.out.println(lc.checkInclusion("ab", "eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        HashMap<Character, Integer> maps1 = new HashMap<>(), maps2 = new HashMap<>();

        for (char i : s1.toCharArray()) {
            maps1.put(i, maps1.getOrDefault(i, 0) + 1);
        }

        int i = 0;
        for (int j = 0; j < n2; j++) {
            char ch = s2.charAt(j);
            maps2.put(ch, maps2.getOrDefault(ch, 0) + 1);

            if ((j - i + 1) == n1) {
                if (maps1.equals(maps2))
                    return true;

                char x = s2.charAt(i++);
                if (maps2.get(x) == 1)
                    maps2.remove(x);
                else
                    maps2.put(x, maps2.get(x) - 1);
            }
        }

        return false;
    }
}
