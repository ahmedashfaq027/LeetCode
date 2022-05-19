/*

https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Constraints:
1. 1 <= s.length, p.length <= 3 * 104
2. s and p consist of lowercase English letters.

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".

Input: s = "abab", p = "ab"
Output: [0,1,2]
    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        FindAllAnagramsinaString lc = new FindAllAnagramsinaString();

        System.out.println(lc.findAnagrams("cbaebabacd", "abc"));
        System.out.println(lc.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length(), n2 = p.length();
        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> maps1 = new HashMap<>(), maps2 = new HashMap<>();
        for (char i : p.toCharArray()) {
            maps2.put(i, maps2.getOrDefault(i, 0) + 1);
        }

        int i = 0;
        for (int j = 0; j < n1; j++) {
            char ch = s.charAt(j);
            maps1.put(ch, maps1.getOrDefault(ch, 0) + 1);

            if ((j - i + 1) == n2) {
                if (maps1.equals(maps2)) {
                    res.add(i);
                }

                char x = s.charAt(i++);
                if (maps1.get(x) == 1)
                    maps1.remove(x);
                else
                    maps1.put(x, maps1.get(x) - 1);
            }
        }


        return res;
    }
}
