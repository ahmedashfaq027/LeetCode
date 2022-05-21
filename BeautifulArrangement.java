/*

https://leetcode.com/problems/beautiful-arrangement/

Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
1. perm[i] is divisible by i.
2. i is divisible by perm[i].

Given an integer n, return the number of the beautiful arrangements that you can construct.

Constraints:
1. 1 <= n <= 15

Input: n = 2
Output: 2
    Explanation:
    The first beautiful arrangement is [1,2]:
        - perm[1] = 1 is divisible by i = 1
        - perm[2] = 2 is divisible by i = 2
    The second beautiful arrangement is [2,1]:
        - perm[1] = 2 is divisible by i = 1
        - i = 2 is divisible by perm[2] = 1

Input: n = 1
Output: 1

*/

public class BeautifulArrangement {
    public static void main(String[] args) {
        BeautifulArrangement lc = new BeautifulArrangement();

        System.out.println(lc.countArrangement(2));
        System.out.println(lc.countArrangement(1));
        System.out.println(lc.countArrangement(4));
    }

    public int countArrangement(int n) {
        int[] count = new int[1];
        dfs(n, 1, new boolean[n], count);
        return count[0];
    }

    private void dfs(int n, int currNum, boolean[] visited, int[] count) {
        if (currNum == n) {
            count[0]++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i - 1])
                continue;

            currNum += 1;
            if ((i % currNum == 0) || (currNum % i == 0)) {
                visited[i - 1] = true;
                dfs(n, currNum, visited, count);
                visited[i - 1] = false;
            }
            currNum -= 1;
        }
    }
}
