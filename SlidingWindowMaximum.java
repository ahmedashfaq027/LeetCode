/*

https://leetcode.com/problems/sliding-window-maximum/

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Constraints:
1. 1 <= nums.length <= 105
2. -104 <= nums[i] <= 104
3. 1 <= k <= nums.length

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
    Explanation:
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

Input: nums = [1], k = 1
Output: [1]

*/

import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum lc = new SlidingWindowMaximum();

        System.out.println(Arrays.toString(lc.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(lc.maxSlidingWindow(new int[]{1}, 1)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.x - o1.x);

        int i = 0;
        for (int j = 0; j < n; j++) {
            pq.add(new Pair(nums[j], j));

            if ((j - i + 1) == k) {
                while (pq.peek().y <= (j - k)) {
                    pq.poll();
                }

                res[i++] = pq.peek().x;
            }
        }

        return res;
    }
}
