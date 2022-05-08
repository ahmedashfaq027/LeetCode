/*

https://leetcode.com/problems/counting-bits/

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Constraints:
0 <= n <= 105

Follow up:
It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?

Input: n = 2
Output: [0,1,1]
    Explanation:
    0 --> 0
    1 --> 1
    2 --> 10

Input: n = 5
Output: [0,1,1,2,1,2]
    Explanation:
    0 --> 0
    1 --> 1
    2 --> 10
    3 --> 11
    4 --> 100
    5 --> 101

*/

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        CountingBits lc = new CountingBits();

        System.out.println(Arrays.toString(lc.countBits(2)));
        System.out.println(Arrays.toString(lc.countBits(5)));
    }

    /*
        Explanation:
            Let there be 2 numbers X and Y such that X/2 = Y
            No. of setbits in X - No. of setbits in Y <= 1

            Eg: X = 7 and Y = 3
            7/2 = 3 and diff is 3 - 2 <= 1

            if X is ODD
            1. then the (LSB) Least Significant Bit will always be set and dividing by 2 means right shifting the number by 1 bit.
            2. so if last bit is set and right shift it by 1 bit than the last set bit will be lost.
            3. therfore the new number Y has 1 set bit less than in compare to X

            But if X is Even
            1. then LSB will be equal to 0, therefore even we do right shift by1 bit then only this 0 bit will be lost and no set bit got lost

            so When we have X has Even
            1. no of set bit in X = no of set bit in Y

            and When X is ODD
            1. no of set bit in X = 1 + no of set bit in Y
    */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        res[0] = 0;
        for (int i = 0; i < n + 1; i++) {
            res[i] = res[i / 2] + i % 2;
        }

        return res;
    }
}
