/*

https://leetcode.com/problems/get-maximum-in-generated-array/

You are given an integer n. A 0-indexed integer array nums of length n + 1 is generated in the following way:
1. nums[0] = 0
2. nums[1] = 1
3. nums[2 * i] = nums[i] when 2 <= 2 * i <= n
4. nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n

Return the maximum integer in the array nums​​​.

Constraints:
1. 0 <= n <= 100

Input: n = 7
Output: 3
    Explanation: According to the given rules:
      nums[0] = 0
      nums[1] = 1
      nums[(1 * 2) = 2] = nums[1] = 1
      nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
      nums[(2 * 2) = 4] = nums[2] = 1
      nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
      nums[(3 * 2) = 6] = nums[3] = 2
      nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
    Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is max(0,1,1,2,1,3,2,3) = 3.

Input: n = 2
Output: 1
    Explanation: According to the given rules, nums = [0,1,1]. The maximum is max(0,1,1) = 1.

Input: n = 3
Output: 2
    Explanation: According to the given rules, nums = [0,1,1,2]. The maximum is max(0,1,1,2) = 2.

*/

public class GetMaximuminGeneratedArray {
    public static void main(String[] args) {
        GetMaximuminGeneratedArray lc = new GetMaximuminGeneratedArray();

        System.out.println(lc.getMaximumGenerated(7));
        System.out.println(lc.getMaximumGenerated(2));
        System.out.println(lc.getMaximumGenerated(3));
    }

    public int getMaximumGenerated(int n) {
        if (n <= 1)
            return n;

        int[] dp = new int[n + 1 + 1]; // +1 to be null safe
        dp[0] = 0;
        dp[1] = 1;

        int max = 1;

        for (int i = 0; i < n + 1; i++) {
            if (2 * i < n + 1) {
                dp[2 * i] = dp[i];
                max = Math.max(max, dp[i]);
            }

            if (2 * i + 1 < n + 1) {
                dp[2 * i + 1] = dp[i] + dp[i + 1];
                max = Math.max(max, dp[i] + dp[i + 1]);
            }
        }

        return max;
    }
}
