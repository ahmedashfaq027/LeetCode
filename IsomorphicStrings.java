/*

https://leetcode.com/problems/isomorphic-strings/

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Constraints:
1. 1 <= s.length <= 5 * 104
2. t.length == s.length
3. s and t consist of any valid ascii character.

Input: s = "egg", t = "add"
Output: true

Input: s = "foo", t = "bar"
Output: false

Input: s = "paper", t = "title"
Output: true

*/

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings lc = new IsomorphicStrings();

        System.out.println(lc.isIsomorphic("egg", "add"));
        System.out.println(lc.isIsomorphic("foo", "bar"));
        System.out.println(lc.isIsomorphic("paper", "title"));
        System.out.println(lc.isIsomorphic("bbbaaaba", "aaabbbba"));
        System.out.println(lc.isIsomorphic("a", "a"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> h1 = new HashMap<>(), h2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (h1.containsKey(s.charAt(i))) {
                if (h1.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if (h2.containsKey(t.charAt(i)))
                    return false;

                h1.put(s.charAt(i), t.charAt(i));
                h2.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}
