/*

https://leetcode.com/problems/gray-code/

An n-bit gray code sequence is a sequence of 2n integers where:
1. Every integer is in the inclusive range [0, 2n - 1],
2. The first integer is 0,
3. An integer appears no more than once in the sequence,
4. The binary representation of every pair of adjacent integers differs by exactly one bit, and
5. The binary representation of the first and last integers differs by exactly one bit.

Given an integer n, return any valid n-bit gray code sequence.

Constraints:
1. 1 <= n <= 16

Input: n = 2
Output: [0,1,3,2]
    Explanation:
    The binary representation of [0,1,3,2] is [00,01,11,10].
    - 00 and 01 differ by one bit
    - 01 and 11 differ by one bit
    - 11 and 10 differ by one bit
    - 10 and 00 differ by one bit
    [0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
    - 00 and 10 differ by one bit
    - 10 and 11 differ by one bit
    - 11 and 01 differ by one bit
    - 01 and 00 differ by one bit

Input: n = 1
Output: [0,1]

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {
    public static void main(String[] args) {
        GrayCode lc = new GrayCode();

        System.out.println(lc.grayCode(2));
        System.out.println(lc.grayCode(1));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        helper(0, n, set, res);

        return res;
    }

    private void helper(int idx, int n, Set<Integer> set, List<Integer> res) {
        if (set.contains(idx))
            return;

        set.add(idx);
        res.add(idx);

        for (int i = 0; i < n; i++) {
            helper((idx ^ (1 << i)), n, set, res);
        }
    }

    public List<Integer> grayCodeBitManip(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, n); i++) {
            res.add(i ^ (i >> 1));
        }

        return res;
    }
}
