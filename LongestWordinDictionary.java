/*

https://leetcode.com/problems/longest-word-in-dictionary/

Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.
If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Constraints:
1. 1 <= words.length <= 1000
2. 1 <= words[i].length <= 30
3. words[i] consists of lowercase English letters.

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
    Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
    Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

*/

import java.util.Arrays;
import java.util.HashSet;

class Trie {

    Trie[] c;
    int count;
    boolean isEndofWord;

    public Trie() {
        c = new Trie[26];
        Arrays.fill(c, null);
    }

    public void insert(String word) {
        int n = word.length();
        Trie temp = this;

        for (int i = 0; i < n; i++) {
            int ch = word.charAt(i) - 'a';

            if (temp.c[ch] == null) {
                temp.c[ch] = new Trie();
            }

            temp.count++;
            temp = temp.c[ch];
        }

        temp.isEndofWord = true;
    }
}

public class LongestWordinDictionary {
    public static void main(String[] args) {
        LongestWordinDictionary lc = new LongestWordinDictionary();

        System.out.println(lc.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(lc.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(lc.longestWord(new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"}));
    }

    public String longestWord(String[] words) {
        Trie root = new Trie();

        for (String word : words) {
            root.insert(word);
        }

        HashSet<String> wordsSet = new HashSet<>();
        dfs(root, wordsSet, new StringBuilder());

        String res = "";
        for (String i : wordsSet) {
            if (i.length() > res.length()) {
                res = i;
            }

            if (i.length() == res.length()) {
                if (i.compareTo(res) < 0) {
                    res = i;
                }
            }
        }

        return res;
    }

    public void dfs(Trie root, HashSet<String> words, StringBuilder sb) {
        if (root == null)
            return;

        if (root.isEndofWord)
            words.add(sb.toString());

        for (int i = 0; i < 26; i++) {
            if (root.c[i] != null && root.c[i].isEndofWord) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append((char) (i + 'a'));
                dfs(root.c[i], words, tmp);
            }
        }
    }
}
