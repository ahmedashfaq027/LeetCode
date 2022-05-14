/*

https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Constraints:
1. 1 <= strs.length <= 200
2. 0 <= strs[i].length <= 200
3. strs[i] consists of only lower-case English letters.

Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
    Explanation: There is no common prefix among the input strings.

*/

import java.util.Arrays;

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

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix lc = new LongestCommonPrefix();

        System.out.println(lc.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(lc.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();

        Trie root = new Trie();
        for (String i : strs)
            root.insert(i);

        for (int i = 0; i < strs[0].length(); i++) {
            int idx = strs[0].charAt(i) - 'a';

            if (root.c[idx] == null) {
                break;
            } else {
                if (root.c[idx].count == strs.length) {
                    char ch = (char) (idx + 'a');
                    res.append(ch);
                } else {
                    break;
                }
                root = root.c[idx];
            }
        }

        return res.toString();
    }
}
