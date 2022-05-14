/*

https://leetcode.com/problems/concatenated-words/

Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Constraints:
1. 1 <= words.length <= 104
2. 0 <= words[i].length <= 30
3. words[i] consists of only lowercase English letters.
4. 0 <= sum(words[i].length) <= 105

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
    Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
    "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
    "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords {
    public static void main(String[] args) {
        ConcatenatedWords lc = new ConcatenatedWords();

        System.out.println(lc.findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
        System.out.println(lc.findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"}));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        for (String i : words) {
            set.remove(i);
            if (isPossible(set, i))
                res.add(i);
            set.add(i);
        }

        return res;
    }

    private boolean isPossible(HashSet<String> wordsSet, String word) {
        if (wordsSet.contains(word))
            return true;

        for (int i = 1; i < word.length(); i++) {
            if (wordsSet.contains(word.substring(0, i)) && isPossible(wordsSet, word.substring(i)))
                return true;
        }

        return false;
    }
}
