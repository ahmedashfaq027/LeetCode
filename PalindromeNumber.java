/*
https://leetcode.com/problems/palindrome-number

Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

Constraints:
1. -231 <= x <= 231 - 1

Input: x = 121
Output: true

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Input: x = -101
Output: false

*/

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber lc = new PalindromeNumber();

        System.out.println(lc.isPalindrome(-121));
    }

    public boolean isPalindrome(int x) {
        int rev = 0, tmp = x;

        while (tmp > 0) {
            rev = rev * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        return (rev == x);
    }

}
