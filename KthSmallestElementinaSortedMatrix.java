/*

https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
You must find a solution with a memory complexity better than O(n^2).

Constraints:
1. n == matrix.length == matrix[i].length
2. 1 <= n <= 300
3. -109 <= matrix[i][j] <= 109
4. All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
5. 1 <= k <= n^2

Follow up:
1. Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
2. Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
    Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Input: matrix = [[-5]], k = 1
Output: -5

*/

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

class PairG<T1, T2> {
    public T1 x;
    public T2 y;

    public PairG(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PairG<T1, T2> pair = (PairG<T1, T2>) o;
        return x.equals(pair.x) && y.equals(pair.y);
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

public class KthSmallestElementinaSortedMatrix {
    public static void main(String[] args) {
        KthSmallestElementinaSortedMatrix lc = new KthSmallestElementinaSortedMatrix();

        System.out.println(lc.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println(lc.kthSmallest(new int[][]{{-5}}, 1));
        System.out.println(lc.kthSmallest(new int[][]{{-5, -4}, {-5, -4}}, 2));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        PriorityQueue<PairG<Integer, PairG<Integer, Integer>>> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.x));

        for (int i = 0; i < n; i++) {
            pq.add(new PairG<>(matrix[i][0], new PairG<>(i, 0)));
        }

        int x = 0, y = 0;
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            var tmp = pq.poll();

            x = tmp.y.x;
            y = tmp.y.y;

            // The next smallest element belongs to the same array
            if (y + 1 < m) {
                pq.add(new PairG<>(matrix[x][y + 1], new PairG<>(x, y + 1)));
            }
        }

        return matrix[x][y];
    }

    public int kthSmallestBS(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;

        int lo = matrix[0][0], hi = matrix[n - 1][m - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int count = 0, j = m - 1;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid)
                    j--;

                count += (j + 1);
            }

            if (count < k)
                lo = mid + 1;
            else
                hi = mid;
        }

        return hi;
    }

    public int kthSmallestN2(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
            }
        }

        int res = 0;
        while (k-- > 0) {
            res = pq.poll();
        }

        return res;
    }
}
