/*

https://leetcode.com/problems/word-search-ii/

Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Constraints:
1. m == board.length
2. n == board[i].length
3. 1 <= m, n <= 12
4. board[i][j] is a lowercase English letter.
5. 1 <= words.length <= 3 * 104
6. 1 <= words[i].length <= 10
7. words[i] consists of lowercase English letters.
8. All the strings of words are unique.

o a a n
e t a e
i h k r
i f l v
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

a b
c d
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Trie {
    Trie[] c;
    int count;
    List<String> words;

    Trie() {
        c = new Trie[26];
        Arrays.fill(c, null);
        words = new ArrayList<>();
    }

    void insert(String word) {
        int n = word.length();

        Trie temp = this;
        for (int i = 0; i < n; i++) {
            int ch = word.charAt(i) - 'a';

            if (temp.c[ch] == null) {
                temp.c[ch] = new Trie();
                count++;
            }

            temp = temp.c[ch];
        }

        temp.words.add(word);
    }

    boolean contains(char c) {
        int ch = c - 'a';
        return this.c[ch] != null;
    }

    Trie get(char c) {
        int ch = c - 'a';
        return this.c[ch];
    }
}

public class WordSearchII {
    public static void main(String[] args) {
        WordSearchII lc = new WordSearchII();

        System.out.println(lc.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
        System.out.println(lc.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcb"}));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();

        int maxLen = 0;
        for (String i : words) {
            root.insert(i);
            maxLen = Math.max(maxLen, i.length());
        }

        List<String> avWords = new ArrayList<>();
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (root.contains(board[i][j])) {
                    backtrack(board, root.get(board[i][j]), i, j, n, m, 1, maxLen, avWords, visited);
                }
            }
        }

        return avWords;
    }

    int[][] dir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private void backtrack(char[][] board, Trie root, int i, int j, int n, int m, int currSteps, int maxLen, List<String> res, boolean[][] visited) {
        if (currSteps > maxLen)
            return;

        if (root == null)
            return;

        if (!root.words.isEmpty()) {
            res.addAll(root.words);
            root.words.clear();
        }

        visited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (isValid(x, y, n, m, visited)) {
                Trie tmp = root.get(board[x][y]);
                backtrack(board, tmp, x, y, n, m, currSteps + 1, maxLen, res, visited);
            }
        }

        visited[i][j] = false;
    }

    private boolean isValid(int i, int j, int n, int m, boolean[][] vis) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j])
            return false;
        return true;
    }
}
