/*

https://leetcode.com/problems/divisor-game/

Alice and Bob take turns playing a game, with Alice starting first.
Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
1. Choosing any x with 0 < x < n and n % x == 0.
2. Replacing the number n on the chalkboard with n - x.
3. Also, if a player cannot make a move, they lose the game.
Return true if and only if Alice wins the game, assuming both players play optimally.

Constraints:
1. 1 <= n <= 1000

Input: n = 2
Output: true
    Explanation: Alice chooses 1, and Bob has no more moves.

Input: n = 3
Output: false
    Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.

*/

public class DivisorGame {
    public static void main(String[] args) {
        DivisorGame lc = new DivisorGame();

        System.out.println(lc.divisorGame1(2));
        System.out.println(lc.divisorGame1(3));

        System.out.println(lc.divisorGame(2));
        System.out.println(lc.divisorGame(3));
    }

    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1 + 2]; // +2 to be NullPointer safe
        dp[0] = false;
        dp[1] = true;
        dp[2] = false;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = !dp[i - 1];
        }

        return dp[n];
    }

    public boolean divisorGame1(int n) {
        return n % 2 == 0;
    }
}
