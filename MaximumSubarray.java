/*

https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Constraints:
1. 1 <= nums.length <= 105
2. -104 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

Input: nums = [1]
Output: 1

Input: nums = [5,4,-1,7,8]
Output: 23

*/

class MSAResult {
    int max, sum;
    int lmax, rmax;

    public MSAResult(int max, int sum, int lmax, int rmax) {
        this.max = max;
        this.sum = sum;
        this.lmax = lmax;
        this.rmax = rmax;
    }
}

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray lc = new MaximumSubarray();

        System.out.println(lc.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(lc.maxSubArray(new int[]{1}));
        System.out.println(lc.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(lc.maxSubArray(new int[]{-1, 0, -2}));
    }

    public int maxSubArray(int[] nums) {
        return maxSubArrayMerge(nums, 0, nums.length - 1).max;
    }

    private MSAResult maxSubArrayMerge(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return new MSAResult(nums[lo], nums[lo], nums[lo], nums[lo]);
        }

        int mid = (lo + hi) / 2;
        MSAResult left = maxSubArrayMerge(nums, lo, mid);
        MSAResult right = maxSubArrayMerge(nums, mid + 1, hi);

        int lmax = Math.max(left.lmax, left.sum + right.lmax);
        int rmax = Math.max(right.rmax, right.sum + left.rmax);

        int max = Math.max(left.max, right.max);
        max = Math.max(max, left.rmax + right.lmax);

        return new MSAResult(max, left.sum + right.sum, lmax, rmax);
    }

    /*
        Explanation:
            Following is Kadane's algorithm. We follow the strategy to reset the current sum to 0 if it goes negative.
            Then update the maximum sum so far.
    */
    public int maxSubArrayK(int[] nums) {
        int n = nums.length;
        int maxsf = Integer.MIN_VALUE;

        int currSum = 0;
        for (int num : nums) {
            currSum = Math.max(currSum, 0);
            currSum += num;
            maxsf = Math.max(maxsf, currSum);
        }

        return maxsf;
    }
}
