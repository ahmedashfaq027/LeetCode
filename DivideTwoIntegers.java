/*

https://leetcode.com/problems/divide-two-integers/

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
Return the quotient after dividing dividend by divisor.
The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.

Constraints:
1. -231 <= dividend, divisor <= 231 - 1
2. divisor != 0

Input: dividend = 10, divisor = 3
Output: 3
    Explanation: 10/3 = truncate(3.33333..) = 3.

Input: dividend = 7, divisor = -3
Output: -2
    Explanation: 7/-3 = truncate(-2.33333..) = -2.

Input: dividend = 0, divisor = 1
Output: 0

Input: dividend = 1, divisor = 1
Output: 1

*/

public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers lc = new DivideTwoIntegers();

        System.out.println(lc.divide(10, 3));
        System.out.println(lc.divide(7, -3));
        System.out.println(lc.divide(0, 1));
        System.out.println(lc.divide(1, 1));
        System.out.println(lc.divide(-1, -1));
        System.out.println(lc.divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        long quo = 0;
        boolean positive = true;
        long dividendL = dividend, divisorL = divisor;

        if (dividendL < 0 && divisorL < 0) {
            dividendL = Math.abs(dividendL);
            divisorL = Math.abs(divisorL);
        } else if (dividendL < 0 || divisorL < 0) {
            positive = false;
            dividendL = Math.abs(dividendL);
            divisorL = Math.abs(divisorL);
        }

        while (dividendL >= divisorL) {
            quo = quo * 10 + ((dividendL / divisorL));
            dividendL = dividendL % divisorL;
        }

        if (quo > Integer.MAX_VALUE)
            if (positive)
                quo = Integer.MAX_VALUE;
            else
                quo = Integer.MIN_VALUE;

        return positive ? (int) quo : (int) -quo;
    }
}
