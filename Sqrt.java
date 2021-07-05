/*

https://leetcode.com/problems/sqrtx/

Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

Constraints:
1. 0 <= x <= 231 - 1

Input: x = 4
Output: 2

Input: x = 8
Output: 2
    Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

*/

public class Sqrt {
    public static void main(String[] args) {
        Sqrt lc = new Sqrt();

        System.out.println(lc.mySqrt(0));
        System.out.println(lc.mySqrt(4));
        System.out.println(lc.mySqrt(8));
        System.out.println(lc.mySqrt(2147395600));
        System.out.println(lc.mySqrt(2147483647));
    }

    public int mySqrt(int x) {
        long ans = 1;
        long lo = 0, hi = (x / 2) + 1;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            long square = mid * mid;
            if (square == x)
                return (int) mid;

            if (square < x) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return (int) ans;
    }
}
