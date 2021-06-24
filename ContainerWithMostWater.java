/*

https://leetcode.com/problems/container-with-most-water

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
Notice that you may not slant the container.

Constraints:
1. n == height.length
2. 2 <= n <= 105
3. 0 <= height[i] <= 104

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Input: height = [1,1]
Output: 1

Input: height = [4,3,2,1,4]
Output: 16

Input: height = [1,2,1]
Output: 2

*/

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater lc = new ContainerWithMostWater();

        System.out.println(lc.maxArea(new int[]{1, 1}));
        System.out.println(lc.maxArea(new int[]{1, 2, 1}));
        System.out.println(lc.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    private int maxArea(int[] height) {
        int n = height.length;

        int i = 0, j = n - 1;
        int finalRes = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }

            finalRes = Math.max(finalRes, Math.min(height[i], height[j]) * (j - i));
        }

        return finalRes;
    }
}
