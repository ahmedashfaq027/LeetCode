/*

https://leetcode.com/problems/two-sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Constraints:
1. 2 <= nums.length <= 104
2. -109 <= nums[i] <= 109
3. -109 <= target <= 109
4. Only one valid answer exists.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Input: nums = [3,2,4], target = 6
Output: [1,2]

Input: nums = [3,3], target = 6
Output: [0,1]

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

*/

import java.util.*;

class Pair {
    public int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Pair{x=" + x + ", y=" + y + "}";
    }
}

public class TwoSum {
    public static void main(String[] args) {
        TwoSum lc = new TwoSum();

        int[] nums = new int[]{2, 7, 11, 15};
        int[] ans = lc.twoSum(nums, 9);

        System.out.println(Arrays.toString(ans));
        

    }

    public int[] twoSum(int[] nums, int target) {
        // Sort with pairs (ar[i], i)***************
        List<Pair> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(new Pair(nums[i], i));
        }
        arr.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                return pair.x - t1.x;
            }
        });
        // *****************************************

        List<Pair> ans = new ArrayList<>();
        int idx = 0;
        for (Pair i : arr) {
            int p = i.x;
            int q = target - p;
            idx++;

            Pair res = BS(arr, q, idx, arr.size() - 1);
            if (res != null)
                return new int[]{i.y, res.y};
        }

        /*
        for (Pair i : ans) {
            System.out.println(i.toString());
        }
        */

        return new int[0];
    }

    private Pair BS(List<Pair> ar, int k, int lo, int hi) {
        int ans = -1, idx = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            Pair tmp = ar.get(mid);
            // System.out.println(tmp.toString());
            if (tmp.x == k) {
                return new Pair(k, tmp.y);
            } else if (tmp.x < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        // System.out.println(lo + " " + hi);
        return null;
    }
}
