/*

https://leetcode.com/problems/max-chunks-to-make-sorted/

You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array.

Constraints:
1. n == arr.length
2. 1 <= n <= 10
3. 0 <= arr[i] < n
4. All the elements of arr are unique.

Input: arr = [4,3,2,1,0]
Output: 1
    Explanation:
    Splitting into two or more chunks will not return the required result.
    For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

Input: arr = [1,0,2,3,4]
Output: 4
    Explanation:
    We can split into two chunks, such as [1, 0], [2, 3, 4].
    However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.

*/

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        MaxChunksToMakeSorted lc = new MaxChunksToMakeSorted();

        System.out.println(lc.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(lc.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        int cuts = 0, max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                cuts++;
            }
        }

        return cuts;
    }
}
