/*

https://leetcode.com/problems/implement-trie-prefix-tree/

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:
1. Trie() Initializes the trie object.
2. void insert(String word) Inserts the string word into the trie.
3. boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
4. boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Constraints:
1. 1 <= word.length, prefix.length <= 2000
2. word and prefix consist only of lowercase English letters.
3. At most 3 * 104 calls in total will be made to insert, search, and startsWith.

Input
    ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
    [null, null, true, false, true, null, true]
Explanation
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");   // return True
    trie.search("app");     // return False
    trie.startsWith("app"); // return True
    trie.insert("app");
    trie.search("app");     // return True

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

    public boolean search(String word) {
        int n = word.length();
        Trie temp = this;

        for (int i = 0; i < n; i++) {
            int ch = word.charAt(i) - 'a';

            if (temp.c[ch] == null)
                return false;

            temp = temp.c[ch];
        }

        return temp.isEndofWord;
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        Trie temp = this;

        for (int i = 0; i < n; i++) {
            int ch = prefix.charAt(i) - 'a';

            if (temp.c[ch] == null)
                return false;

            temp = temp.c[ch];
        }

        return true;
    }
}

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie obj = new Trie();

        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }
}
