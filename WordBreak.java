/*

https://leetcode.com/problems/word-break/

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Constraints:
1. 1 <= s.length <= 300
2. 1 <= wordDict.length <= 1000
3. 1 <= wordDict[i].length <= 20
4. s and wordDict[i] consist of only lowercase English letters.
5. All the strings of wordDict are unique.

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    Note that you are allowed to reuse a dictionary word.

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

*/

import java.util.*;

class Trie {
    Trie[] c;
    int count;
    boolean isEndOfWord;

    public Trie() {
        count = 0;
        isEndOfWord = false;
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
                temp.count++;
            }

            temp = temp.c[ch];
        }

        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        int n = word.length();
        Trie temp = this;

        for (int i = 0; i < n; i++) {
            int ch = word.charAt(i) - 'a';

            if (temp.c[ch] == null) {
                return false;
            }

            temp = temp.c[ch];
        }

        return temp.isEndOfWord;
    }
}

public class WordBreak {
    public static void main(String[] args) {
        WordBreak lc = new WordBreak();

        System.out.println(lc.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(lc.wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
        System.out.println(lc.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
        System.out.println(lc.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<String, Boolean> cache = new HashMap<>();

        if (n == 0)
            return true;

        return isPossible(s, set, cache);
    }

    private boolean isPossible(String s, HashSet<String> set, HashMap<String, Boolean> cache) {
        if (s.length() == 0)
            return true;

        if (set.contains(s))
            return true;

        if (cache.containsKey(s))
            return cache.get(s);

        for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                boolean temp = isPossible(s.substring(i), set, cache);
                cache.put(s.substring(i), temp);
                if (temp)
                    return true;
            }
        }

        return false;
    }

    /*
        Explanation:
            TIME LIMIT EXCEEDED ERROR - as Trie will be left skewed.
            This could be modified to implement caching/memoization to make it work
    */
    public boolean wordBreakTrie(String s, List<String> wordDict) {
        int n = s.length();

        Trie root = new Trie();
        for (String i : wordDict) {
            root.insert(i);
        }

        return isPossible(root, s);
    }

    private boolean isPossible(Trie root, String s) {
        int n = s.length();

        if (n == 0)
            return true;

        for (int i = 1; i <= n; i++) {
            if (root.search(s.substring(0, i)) && isPossible(root, s.substring(i))) {
                return true;
            }
        }

        return false;
    }
}
