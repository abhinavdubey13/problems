import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/coin-game-winner-every-player-three-choices/
 * 
 * A and B are playing a game. At the beginning there are n coins. 
 * 
 * Given two more numbers x and y. 
 * 
 * In each move a player can pick x or y or 1 coins. 
 * 
 * A always starts the game. 
 * 
 * The player who picks the last coin wins the game. 
 * 
 * For a given value of n, find if A can ne the winner (A and B both play optimally)
 * 
 * =========
 * example:
 * =========
 *
 * Input :  n = 5, x = 3, y = 4
 * Output : A
 * There are 5 coins, every player can pick 1 or 3 or 4 coins on his/her turn.
 * A can win by picking 3 coins in first chance. Now 2 coins will be left so B will pick one coin and now A can win by picking the last coin.
 * 
 * Input  : n=2  , x=3 , y=4
 * Output : B
 *
 *
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * 
 * Let us take few example values of n for x = 3, y = 4.
 * n = 0 A can not pick any coin so he losses
 * n = 1 A can pick 1 coin and win the game
 * n = 2 A can pick only 1 coin. Now B will pick 1 coin and win the game
 * n = 3 A will win the game by picking 3 coins
 * n = 4 A will win the game by picking 4 coins
 * n = 5 A will choose 3 coins. Now B will have to choose from 2 coins so A will win.
 * n = 6 A will choose 4 coins. Now B will have to choose from 2 coins so A will win.
 * 
 * We can observe that A wins game for n coins only when it loses for either 
 * 1. n-1 or 
 * 2. n-x or
 * 3. n-y coins
 *
 * ===========
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 * 
 */

public class p64_3_choice_coin_game {

    public static void main(String[] args) {

        //expected = a
        int n = 5;
        int x = 3;
        int y = 4;

        char answer = function(n, x, y);
        System.out.println("winner : " + answer);
    }

    static char function(int n, int x, int y) {

        if (n == 1 || n == x || n == y) {
            return 'a';
        }

        char[] dp = new char[n + 1];

        dp[0] = 'b'; //this is important : since there are no coins , A cannot pick the last coin
        dp[1] = 'a';

        for (int i = 2; i <= n; i++) {

            if (i == x || i == y) {
                dp[i] = 'a';
            }

            else if (i - 1 >= 0 && dp[i - 1] == 'b') {
                dp[i] = 'a';
            }

            else if (i - x >= 0 && dp[i - x] == 'b') {
                dp[i] = 'a';
            }

            else if (i - y >= 0 && dp[i - y] == 'b') {
                dp[i] = 'a';
            }

            else {
                dp[i] = 'b';
            }

        }

        return dp[n];
    }

}