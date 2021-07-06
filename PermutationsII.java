/*

https://leetcode.com/problems/permutations-ii/

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Constraints:
1. 1 <= nums.length <= 8
2. -10 <= nums[i] <= 10

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Input: nums = [1,2,3]
Output:
[[1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]]

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {
    public static void main(String[] args) {
        PermutationsII lc = new PermutationsII();

        System.out.println(lc.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(lc.permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (freq.containsKey(num))
                freq.put(num, freq.get(num) + 1);
            else
                freq.put(num, 1);
        }

        permute(nums, freq, new ArrayList<>(), res);
        return res;
    }

    private void permute(int[] nums, Map<Integer, Integer> freq, List<Integer> currPerm, List<List<Integer>> res) {
        int n = nums.length;
        if (currPerm.size() == n) {
            res.add(new ArrayList<>(currPerm));
            return;
        }

        for (int i : freq.keySet()) {
            int value = freq.get(i);
            if (value > 0) {
                freq.put(i, value - 1);
                currPerm.add(i);

                permute(nums, freq, currPerm, res);

                freq.put(i, value);
                currPerm.remove(currPerm.size() - 1);
            }
        }
    }
}
