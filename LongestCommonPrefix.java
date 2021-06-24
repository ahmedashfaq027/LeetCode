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

class Trie {
    Trie[] c;
    int count;

    public Trie() {
        c = new Trie[26];
        count = 0;
        for (int i = 0; i < 26; i++) {
            c[i] = null;
        }
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
            insertIntoTrie(root, i);

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

    public void insertIntoTrie(Trie root, String w) {
        for (char ch : w.toCharArray()) {
            int idx = ch - 'a';
            if (root.c[idx] == null) {
                root.c[idx] = new Trie();
            }
            root = root.c[idx];
            root.count++;
        }
    }
}
