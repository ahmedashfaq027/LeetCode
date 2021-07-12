/*

https://leetcode.com/problems/super-pow/

Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Constraints:
1. 1 <= a <= 231 - 1
2. 1 <= b.length <= 2000
3. 0 <= b[i] <= 9
4. b doesn't contain leading zeros.

Example 1:

Input: a = 2, b = [3]
Output: 8
Example 2:

Input: a = 2, b = [1,0]
Output: 1024
Example 3:

Input: a = 1, b = [4,3,3,8,5,2]
Output: 1
Example 4:

Input: a = 2147483647, b = [2,0,0]
Output: 1198

*/

public class SuperPow {
    public static void main(String[] args) {
        SuperPow lc = new SuperPow();

        System.out.println(lc.superPow(2, new int[]{3}));
        System.out.println(lc.superPow(2, new int[]{1, 0}));
        System.out.println(lc.superPow(1, new int[]{4, 3, 3, 8, 5, 2}));
        System.out.println(lc.superPow(2147483647, new int[]{2, 0, 0}));
    }

    public int superPow(int a, int[] b) {
        final int mod = 1337;
        a = a % mod;

        int ans = 1, base = a;
        for (int i = b.length - 1; i >= 0; i--) {
            ans = (ans * fastPow(base, b[i], mod)) % mod;
            base = fastPow(base, 10, mod);
        }

        return ans;
    }

    private int fastPow(int base, int pow, int mod) {
        long ans = 1;

        while (pow > 0) {
            if (pow % 2 == 0) {
                base = (base * base) % mod;
                pow /= 2;
            } else {
                pow--;
                ans = (ans * base) % mod;
            }

        }

        return (int) ans % mod;
    }
}
