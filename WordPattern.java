/*

https://leetcode.com/problems/word-pattern/

Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Constraints:
1. 1 <= pattern.length <= 300
2. pattern contains only lower-case English letters.
3. 1 <= s.length <= 3000
4. s contains only lower-case English letters and spaces ' '.
5. s does not contain any leading or trailing spaces.
6. All the words in s are separated by a single space.

Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

Input: pattern = "abba", s = "dog dog dog dog"
Output: false

*/

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        WordPattern lc = new WordPattern();

        //        System.out.println(lc.wordPattern("abba", "dog cat cat dog"));
        //        System.out.println(lc.wordPattern("abba", "dog cat cat fish"));
        //        System.out.println(lc.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(lc.wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] a = s.trim().split("\\s+");
        Map<Character, String> mp1 = new HashMap<>();
        Map<String, Character> mp2 = new HashMap<>();

        if (pattern.length() != a.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (!mp1.containsKey(pattern.charAt(i)) && !mp2.containsKey(a[i])) {
                mp1.put(pattern.charAt(i), a[i]);
                mp2.put(a[i], pattern.charAt(i));
            } else if (mp1.containsKey(pattern.charAt(i)) ^ mp2.containsKey(a[i])) {
                return false;
            } else if (!mp1.get(pattern.charAt(i)).equals(a[i]) && !mp2.get(a[i]).equals(pattern.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
