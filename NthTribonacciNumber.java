/*

https://leetcode.com/problems/n-th-tribonacci-number/

The Tribonacci sequence Tn is defined as follows:
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.

Constraints:
1. 0 <= n <= 37
2. The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

Input: n = 4
Output: 4
    Explanation:
    T_3 = 0 + 1 + 1 = 2
    T_4 = 1 + 1 + 2 = 4

Input: n = 25
Output: 1389537

*/

public class NthTribonacciNumber {
    public static void main(String[] args) {
        NthTribonacciNumber lc = new NthTribonacciNumber();

        System.out.println(lc.tribonacci(4));
        System.out.println(lc.tribonacci(25));
    }

    public int tribonacci(int n) {
        int[] res = new int[n + 1 + 2]; // +2 to be Null safe
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            res[i] = res[i - 1] + res[i - 2] + res[i - 3];
        }

        return res[n];
    }
}
