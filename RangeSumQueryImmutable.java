/*

https://leetcode.com/problems/range-sum-query-immutable/

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:
1. NumArray(int[] nums) Initializes the object with the integer array nums.
2. int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

Constraints:
1. 1 <= nums.length <= 104
2. -105 <= nums[i] <= 105
3. 0 <= left <= right < nums.length
4. At most 104 calls will be made to sumRange.

Input:
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output: [null, 1, -1, -3]

    Explanation
    NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
    numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
    numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
    numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

*/

class NumArray {
    int[] ar, presum;
    int n;

    public NumArray(int[] nums) {
        ar = nums;
        n = nums.length;

        prefixSum();
    }

    public int sumRange(int left, int right) {
        return left == 0 ? presum[right] : presum[right] - presum[left - 1];
    }

    private void prefixSum() {
        presum = new int[n];
        presum = ar;
        for (int i = 1; i < n; i++) {
            presum[i] += presum[i - 1];
        }
    }
}

public class RangeSumQueryImmutable {
    NumArray obj;

    public static void main(String[] args) {
        RangeSumQueryImmutable lc = new RangeSumQueryImmutable();

        lc.handle(new String[]{"NumArray", "sumRange", "sumRange", "sumRange"}, new int[][]{{-2, 0, 3, -5, 2, -1}, {0, 2}, {2, 5}, {0, 5}});
    }

    public void handle(String[] queries, int[][] q) {
        int n = queries.length;

        for (int i = 0; i < n; i++) {
            if (queries[i].equals("NumArray")) {
                obj = new NumArray(q[i]);
                System.out.println("null");
            } else if (queries[i].equals("sumRange")) {
                System.out.println(obj.sumRange(q[i][0], q[i][1]));
            }
        }
    }
}
