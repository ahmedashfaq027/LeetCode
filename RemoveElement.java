/*

https://leetcode.com/problems/remove-element/

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:
The judge will test your solution with the following code:
    int[] nums = [...]; // Input array
    int val = ...; // Value to remove
    int[] expectedNums = [...]; // The expected answer with correct length.
                                // It is sorted with no values equaling val.

    int k = removeElement(nums, val); // Calls your implementation

    assert k == expectedNums.length;
    sort(nums, 0, k); // Sort the first k elements of nums
    for (int i = 0; i < actualLength; i++) {
        assert nums[i] == expectedNums[i];
    }
If all assertions pass, then your solution will be accepted.

Constraints:
1. 0 <= nums.length <= 100
2. 0 <= nums[i] <= 50
3. 0 <= val <= 100

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 2.
    It does not matter what you leave beyond the returned k (hence they are underscores).

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
    Note that the five elements can be returned in any order.
    It does not matter what you leave beyond the returned k (hence they are underscores).

*/

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement lc = new RemoveElement();

        System.out.println(lc.removeElement(new int[]{3, 2, 2, 3}, 2));
        System.out.println(lc.removeElement(new int[]{}, 0));
        System.out.println(lc.removeElement(new int[]{2}, 3));
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;

        // Replace occurences with -1
        for (int i = 0; i < n; i++) {
            if (nums[i] == val)
                nums[i] = -1;
        }

        // Sort
        Arrays.sort(nums);
        int lastOcc = binarySearchCeil(nums, -1);

        // Reverse
        int i = 0, j = n - 1;
        while (i < j) {
            nums[i] = nums[i] ^ nums[j] ^ (nums[j] = nums[i]);
            i++;
            j--;
        }

        return (n > 0) ? n - 1 - lastOcc : 0;
    }

    public int binarySearchCeil(int[] ar, int key) {
        int lo = 0, hi = ar.length - 1;

        int ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (ar[mid] <= key) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}