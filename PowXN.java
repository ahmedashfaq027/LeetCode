/*

https://leetcode.com/problems/powx-n/

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Constraints:
1. -100.0 < x < 100.0
2. 231 <= n <= 231-1
3. -104 <= xn <= 104

Input: x = 2.00000, n = 10
Output: 1024.00000

Input: x = 2.10000, n = 3
Output: 9.26100

Input: x = 2.00000, n = -2
Output: 0.25000
    Explanation: 2-2 = 1/22 = 1/4 = 0.25

*/

public class PowXN {
    public static void main(String[] args) {
        PowXN lc = new PowXN();

        System.out.println(lc.myPow(2.00000, 10));
        System.out.println(lc.myPow(2.10000, 3));
        System.out.println(lc.myPow(2.00000, -2));
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        double t = myPow(x * x, n / 2);
        if (n % 2 == 0) {
            return t;
        } else {
            return (n < 0 ? 1 / x : x) * t;
        }
    }
}
