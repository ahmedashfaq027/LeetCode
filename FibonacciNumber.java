/*

https://leetcode.com/problems/fibonacci-number/

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Constraints:
1. 0 <= n <= 30

Input: n = 2
Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Input: n = 3
Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Input: n = 4
Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

*/

public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber lc = new FibonacciNumber();

        System.out.println(lc.fib(2));
        System.out.println(lc.fib(3));
        System.out.println(lc.fib(30));
    }

    public int fib(int n) {
        if (n <= 1)
            return n;

        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

        return res[n];
    }
}
