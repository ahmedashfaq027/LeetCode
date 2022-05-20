/*

https://leetcode.com/problems/valid-anagram/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Constraints:
1. 1 <= s.length, t.length <= 5 * 104
2. s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false

*/

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram lc = new ValidAnagram();

        System.out.println(lc.isAnagram("anagram", "nagaram"));
        System.out.println(lc.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> maps = new HashMap<>(), mapt = new HashMap<>();

        for (char i : s.toCharArray()) {
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }

        for (char i : t.toCharArray()) {
            mapt.put(i, mapt.getOrDefault(i, 0) + 1);
        }

        return maps.equals(mapt);
    }
}
