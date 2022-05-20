/*

https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

You are given a string s.
A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.
Return the number of good splits you can make in s.

Constraints:
1. 1 <= s.length <= 105
2. s consists of only lowercase English letters.

Input: s = "aacaba"
Output: 2
    Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
    ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
    ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
    ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
    ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
    ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.

Input: s = "abcd"
Output: 1
    Explanation: Split the string as follows ("ab", "cd").

*/

import java.util.HashMap;
import java.util.HashSet;

public class NumberofGoodWaystoSplitaString {
    public static void main(String[] args) {
        NumberofGoodWaystoSplitaString lc = new NumberofGoodWaystoSplitaString();

        System.out.println(lc.numSplits("aacaba"));
        System.out.println(lc.numSplits("abcd"));
    }

    public int numSplits(String s) {
        int n = s.length();
        HashSet<Character> freq = new HashSet<>();

        int[] pre = new int[n], post = new int[n];

        for (int i = 0; i < n; i++) {
            freq.add(s.charAt(i));
            pre[i] = freq.size();
        }

        freq.clear();
        for (int i = n - 1; i >= 0; i--) {
            freq.add(s.charAt(i));
            post[i] = freq.size();
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            if (pre[i - 1] == post[i])
                res++;
        }

        return res;
    }

    public int numSplitsMaps(String s) {
        int n = s.length();

        if (n == 1) {
            return 0;
        }

        HashMap<Character, Integer> left = new HashMap<>(), right = new HashMap<>();
        int leftDistinct = 0, rightDistinct = 0;
        for (char i : s.toCharArray()) {
            left.put(i, 0);
            if (!right.containsKey(i)) {
                rightDistinct++;
            }
            right.put(i, right.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (left.get(ch) == 0) {
                leftDistinct++;
            }
            left.put(ch, left.get(ch) + 1);
            if (right.get(ch) == 1) {
                rightDistinct--;
            }
            right.put(ch, right.get(ch) - 1);


            if (leftDistinct == rightDistinct) {
                count++;
            }
        }

        return count;
    }
}
