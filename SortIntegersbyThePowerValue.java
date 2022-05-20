/*

https://leetcode.com/problems/sort-integers-by-the-power-value/

The power of an integer x is defined as the number of steps needed to transform x into 1 using the following steps:
1. if x is even then x = x / 2
2. if x is odd then x = 3 * x + 1
For example, the power of x = 3 is 7 because 3 needs 7 steps to become 1 (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).

Given three integers lo, hi and k. The task is to sort all integers in the interval [lo, hi] by the power value in ascending order, if two or more integers have the same power value sort them by ascending order.
Return the kth integer in the range [lo, hi] sorted by the power value.

Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will transform into 1 using these steps and that the power of x is will fit in a 32-bit signed integer.

Constraints:
1. 1 <= lo <= hi <= 1000
2. 1 <= k <= hi - lo + 1

Input: lo = 12, hi = 15, k = 2
Output: 13
    Explanation: The power of 12 is 9 (12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1)
    The power of 13 is 9
    The power of 14 is 17
    The power of 15 is 17
    The interval sorted by the power value [12,13,14,15]. For k = 2 answer is the second element which is 13.
    Notice that 12 and 13 have the same power value and we sorted them in ascending order. Same for 14 and 15.

Input: lo = 7, hi = 11, k = 4
Output: 7
    Explanation: The power array corresponding to the interval [7, 8, 9, 10, 11] is [16, 3, 19, 6, 14].
    The interval sorted by power is [8, 10, 11, 7, 9].
    The fourth number in the sorted array is 7.

*/

import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

class Pair {
    public int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{x=" + x + ", y=" + y + "}";
    }
}

public class SortIntegersbyThePowerValue {
    public static void main(String[] args) {
        SortIntegersbyThePowerValue lc = new SortIntegersbyThePowerValue();

        System.out.println(lc.getKth(12, 15, 2));
        System.out.println(lc.getKth(7, 11, 4));
    }

    HashMap<Integer, Integer> powerMap = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> (o1.y == o2.y) ? (o1.x - o2.x) : (o1.y - o2.y));

        for (int i = lo; i <= hi; i++) {
            pq.add(new Pair(i, getPower(i)));
        }

        int res = 0;
        while (k-- > 0) {
            res = pq.poll().x;
        }

        return res;
    }

    private int getPower(int n) {
        if (n == 1) {
            return 0;
        }

        if (powerMap.containsKey(n)) {
            return powerMap.get(n);
        }

        int res = (n % 2 == 0) ? (1 + getPower(n / 2)) : (2 + getPower((3 * n + 1) / 2));
        powerMap.put(n, res);

        return res;
    }
}
