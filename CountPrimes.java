/*

https://leetcode.com/problems/count-primes/

Given an integer n, return the number of prime numbers that are strictly less than n.

Constraints:
1. 0 <= n <= 5 * 106

Input: n = 10
Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Input: n = 0
Output: 0

Input: n = 1
Output: 0

*/

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes lc = new CountPrimes();

        System.out.println(lc.countPrimes(10));
        System.out.println(lc.countPrimes(0));
        System.out.println(lc.countPrimes(1));
        System.out.println(lc.countPrimes(2));
    }

    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
                for (int j = i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return count;
    }
}
