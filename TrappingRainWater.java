/*

https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Constraints:
1. n == height.length
2. 1 <= n <= 2 * 104
3. 0 <= height[i] <= 105

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Input: height = [4,2,0,3,2,5]
Output: 9

*/

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater lc = new TrappingRainWater();

        System.out.println(lc.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(lc.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    public int trap(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n], rightMax = new int[n];
        int lmax = -1, rmax = -1;
        for (int i = 0; i < n; i++) {
            lmax = Math.max(lmax, height[i]);
            leftMax[i] = lmax;
        }

        for (int i = n - 1; i >= 0; i--) {
            rmax = Math.max(rmax, height[i]);
            rightMax[i] = rmax;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }
}
