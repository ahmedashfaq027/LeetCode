/*

https://leetcode.com/problems/ugly-number-ii/

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return the nth ugly number.

Constraints:
1. 1 <= n <= 1690

Input: n = 10
Output: 12
    Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

Input: n = 1
Output: 1
    Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

*/

import java.util.PriorityQueue;
import java.util.TreeSet;

public class UglyNumberII {
    public static void main(String[] args) {
        UglyNumberII lc = new UglyNumberII();

        System.out.println(lc.nthUglyNumber(10));
        System.out.println(lc.nthUglyNumber(1));
        System.out.println(lc.nthUglyNumber(4));
    }

    public int nthUglyNumber(int n) {
        TreeSet<Long> pq = new TreeSet<>();

        pq.add(1L);
        int i = 1;
        while (i < n) {
            long tmp = pq.pollFirst();

            pq.add(tmp * 2);
            pq.add(tmp * 3);
            pq.add(tmp * 5);

            i++;
        }

        return (int) ((long) pq.pollFirst());
    }
}
