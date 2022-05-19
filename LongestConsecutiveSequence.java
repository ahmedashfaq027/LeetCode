/*

https://leetcode.com/problems/longest-consecutive-sequence/

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Constraints:
1. 0 <= nums.length <= 105
2. -109 <= nums[i] <= 109

Input: nums = [100,4,200,1,3,2]
Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

*/

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lc = new LongestConsecutiveSequence();

        System.out.println(lc.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(lc.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        for (int j : nums) {
            set.add(j);
        }

        int maxStreak = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currStreak = 0;

                while (set.contains(num)) {
                    currStreak++;
                    num++;
                }

                maxStreak = Math.max(maxStreak, currStreak);
            }
        }

        return maxStreak;
    }
}
