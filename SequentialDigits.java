/*

https://leetcode.com/problems/sequential-digits/

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

Constraints:
1. 10 <= low <= high <= 10^9

Input: low = 100, high = 300
Output: [123,234]

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        SequentialDigits lc = new SequentialDigits();

        System.out.println(lc.sequentialDigits(100, 300));
        System.out.println(lc.sequentialDigits(1000, 13000));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            backtrack(low, high, i, 0, res);
        }

        Collections.sort(res);
        return res;
    }

    private void backtrack(int lo, int hi, int i, int num, List<Integer> res) {
        if (num > hi || i > 10)
            return;

        if (lo <= num && num <= hi)
            res.add(num);

        backtrack(lo, hi, i + 1, num * 10 + i, res);
    }
}
