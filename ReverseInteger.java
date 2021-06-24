/*
https://leetcode.com/problems/reverse-integer/

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Constraints:
1. -231 <= x <= 231 - 1

Input: x = 123
Output: 321

Input: x = -123
Output: -321

Input: x = 120
Output: 21

Input: x = 0
Output: 0

*/

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger lc = new ReverseInteger();

        System.out.println(lc.reverse(123));
        System.out.println(lc.reverse(1534236469));
    }

    public int reverse(int x) {
        long rev = 0, tmp = Math.abs(x);

        while (tmp > 0) {
            rev = rev * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
            return 0;

        return x > 0 ? (int) rev : (int) -rev;
    }
}
