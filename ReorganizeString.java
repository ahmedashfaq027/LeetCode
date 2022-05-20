/*

https://leetcode.com/problems/reorganize-string/

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.

Constraints:
1. 1 <= s.length <= 500
2. s consists of lowercase English letters.

Input: s = "aab"
Output: "aba"

Input: s = "aaab"
Output: ""

*/

import java.util.HashMap;
import java.util.PriorityQueue;

class PairG<T1, T2> {
    public T1 x;
    public T2 y;

    public PairG(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{x=" + x + ", y=" + y + "}";
    }
}

public class ReorganizeString {
    public static void main(String[] args) {
        ReorganizeString lc = new ReorganizeString();

        System.out.println(lc.reorganizeString("aab"));
        System.out.println(lc.reorganizeString("aaab"));
        System.out.println(lc.reorganizeString("vvvlo"));
    }

    public String reorganizeString(String s) {
        int n = s.length();
        HashMap<Character, Integer> maps = new HashMap<>();
        PriorityQueue<PairG<Integer, Character>> pq = new PriorityQueue<>((o1, o2) -> (o2.x - o1.x));

        for (char i : s.toCharArray()) {
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }

        for (char i : maps.keySet()) {
            pq.add(new PairG<>(maps.get(i), i));
        }

        StringBuilder res = new StringBuilder();
        while (pq.size() > 1) {
            PairG<Integer, Character> a = pq.poll();
            PairG<Integer, Character> b = pq.poll();

            res.append(a.y).append(b.y);

            a.x -= 1;
            b.x -= 1;

            if (a.x > 0) {
                pq.add(a);
            }

            if (b.x > 0) {
                pq.add(b);
            }
        }

        if (!pq.isEmpty()) {
            if (pq.peek().x > 1) {
                return "";
            } else {
                res.append(pq.peek().y);
            }
        }

        return res.toString();
    }
}
