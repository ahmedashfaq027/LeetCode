/*

https://leetcode.com/problems/jump-game/

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Constraints:
1. 1 <= nums.length <= 104
2. 0 <= nums[i] <= 105

Input: nums = [2,3,1,1,4]
Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: nums = [3,2,1,0,4]
Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

*/

public class JumpGame {
    public static void main(String[] args) {
        JumpGame lc = new JumpGame();

        System.out.println(lc.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(lc.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;

        int j = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= j)
                j = i;
        }

        return j == 0;
    }
}
