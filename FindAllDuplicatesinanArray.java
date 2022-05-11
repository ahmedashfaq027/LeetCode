/*

https://leetcode.com/problems/find-all-duplicates-in-an-array/

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.

Constraints:
1. n == nums.length
2. 1 <= n <= 105
3. 1 <= nums[i] <= n
4. Each element in nums appears once or twice.

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Input: nums = [1,1,2]
Output: [1]

Input: nums = [1]
Output: []

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllDuplicatesinanArray {
    public static void main(String[] args) {
        FindAllDuplicatesinanArray lc = new FindAllDuplicatesinanArray();

        System.out.println(lc.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(lc.findDuplicates(new int[]{1, 1, 2}));
        System.out.println(lc.findDuplicates(new int[]{1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                res.add(num);
            }

            set.add(num);
        }

        return res;
    }

    public List<Integer> findDuplicatesCountSort(int[] nums) {
        int n = nums.length;

        List<Integer> res = new ArrayList<>();
        int[] count = new int[n];
        for (int num : nums) {
            count[num - 1]++;
            if (count[num - 1] > 1) {
                res.add(num);
            }
        }

        return res;
    }
}
