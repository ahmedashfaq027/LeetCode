/*

https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

You are given an integer array arr.
We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array.

Constraints:
1. 1 <= arr.length <= 2000
2. 0 <= arr[i] <= 108

Input: arr = [5,4,3,2,1]
Output: 1
    Explanation:
    Splitting into two or more chunks will not return the required result.
    For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.

Input: arr = [2,1,3,4,4]
Output: 4
    Explanation:
    We can split into two chunks, such as [2, 1], [3, 4, 4].
    However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.

*/

public class MaxChunksToMakeSortedII {
    public static void main(String[] args) {
        MaxChunksToMakeSortedII lc = new MaxChunksToMakeSortedII();

        System.out.println(lc.maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        System.out.println(lc.maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
        System.out.println(lc.maxChunksToSorted(new int[]{1, 1, 0, 1, 1}));
        System.out.println(lc.maxChunksToSorted(new int[]{4, 2, 2, 1, 1}));
    }

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        int[] rMin = new int[n + 1];
        rMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rMin[i] = Math.min(rMin[i + 1], arr[i]);
        }

        int cuts = 0;
        int lMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lMax = Math.max(lMax, arr[i]);
            if (lMax <= rMin[i + 1]) {
                cuts++;
            }
        }

        return cuts;
    }
}
