/*

https://leetcode.com/problems/jump-game-ii/

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.

Constraints:
1. 1 <= nums.length <= 104
2. 0 <= nums[i] <= 1000

Input: nums = [2,3,1,1,4]
Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: nums = [2,3,0,1,4]
Output: 2

*/

public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII lc = new JumpGameII();

        System.out.println(lc.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(lc.jump(new int[]{2, 3, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        int jump = 0;
        int maxReach = 0, curReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i];
            }

            if (i == curReach) {
                jump++;
                curReach = maxReach;
            }
        }

        return jump;
    }
}
