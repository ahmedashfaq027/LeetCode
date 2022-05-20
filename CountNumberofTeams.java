/*

https://leetcode.com/problems/count-number-of-teams/

There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
You have to form a team of 3 soldiers amongst them under the following rules:
1. Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
2. A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).

Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

Constraints:
1. n == rating.length
2. 3 <= n <= 1000
3. 1 <= rating[i] <= 105
4. All the integers in rating are unique.

Input: rating = [2,5,3,4,1]
Output: 3
    Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).

Input: rating = [2,1,3]
Output: 0
    Explanation: We can't form any team given the conditions.

Input: rating = [1,2,3,4]
Output: 4

*/

public class CountNumberofTeams {
    public static void main(String[] args) {
        CountNumberofTeams lc = new CountNumberofTeams();

        System.out.println(lc.numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(lc.numTeams(new int[]{2, 1, 3}));
        System.out.println(lc.numTeams(new int[]{1, 2, 3, 4}));
    }

    public int numTeams(int[] rating) {
        int n = rating.length;

        int count = 0;
        for (int mid = 0; mid < n; mid++) {

            int smallLeft = 0, largeLeft = 0;
            for (int left = 0; left < mid; left++) {
                if (rating[left] < rating[mid]) {
                    smallLeft++;
                }

                if (rating[left] > rating[mid]) {
                    largeLeft++;
                }
            }

            int smallRight = 0, largeRight = 0;
            for (int right = mid + 1; right < n; right++) {
                if (rating[mid] < rating[right]) {
                    largeRight++;
                }

                if (rating[mid] > rating[right]) {
                    smallRight++;
                }
            }

            int incSequences = smallLeft * largeRight;
            int decSequences = largeLeft * smallRight;

            count += incSequences + decSequences;
        }

        return count;
    }

    public int numTeamsBounds(int[] rating) {
        int n = rating.length;

        int[] lowerBoundsDP = new int[n], upperBoundsDP = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    count += upperBoundsDP[j];
                    upperBoundsDP[i] += 1;
                } else {
                    count += lowerBoundsDP[j];
                    lowerBoundsDP[i] += 1;
                }
            }
        }

        return count;
    }
}
