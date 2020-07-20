
import java.util.*;

/**
 * 
 * Consider an array A[n]  , A[i] represents a PROFIT
 * 
 * A's lenght is even
 * 
 * We play a game against an opponent by alternating turns. 
 * 
 * In each turn, a player selects either the first or last coin from the array, removes it from A[] permanently, and receives the PROFIT  
 * 
 * Determine the MAXIMUM PROFIT the 1st player can get
 * 
 * Note: The opponent is as clever as the user.
 * 
 */

/**
 * x-axis = start index 
 * y-axis = end index 
 *  
 * dp-array = 2D
 * array-filling = diagonally , considering number of coins as 1, then 2 , then 3 ....till number of coins = length of input array
 * 
 * 
 * at any point of time the 1st player can select either the 1st or last coin : let A[] = {5,3,7,10}
 *  
 * if he chooses 1st coin  (which is 5 ) => on his next chance he will see either {3,7} or {7,10}
 * if he chooses last coin (which is 10) => on his next chance he will see either {5,3} or {3,7}
 * 
 * thus on next chance he will have ONLY 3 possibilites {3,7} or {5,3} or {7,10}
 * 
 * ===============================
 * let number of coins = n
 * 
 * TC = O(n^2)
 * TC = O(n^2)
 * 
 */

class p21_alternateCoinGame {

    public static void main(String[] args) {
        int[] coins = { 20, 30, 2, 2, 2, 10 };
        // int[] coins = { 5, 3, 7, 10 };
        int answer = calulator(coins);
        System.out.println(answer);
    }

    static int calulator(int[] coins) {

        int n = coins.length;

        int[][] table = new int[n][n];

        for (int len = 1; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 1) {
                    // here i = j
                    table[i][j] = coins[i];
                    continue;
                }

                int x = (is_valid_ij(i + 2, j, n)) ? table[i + 2][j] : 0;
                int y = (is_valid_ij(i + 1, j - 1, n)) ? table[i + 1][j - 1] : 0;
                int z = (is_valid_ij(i, j - 2, n)) ? table[i][j - 2] : 0;

                int min1 = Math.min(x, y);
                int min2 = Math.min(y, z);

                table[i][j] = Math.max(coins[i] + min1, coins[j] + min2);

            }
        }
        return table[0][n - 1];
    }

    //this is used to check the table[i][j] we are accessing above
    static boolean is_valid_ij(int i, int j, int n) {
        return (i >= 0 && i < n && j >= 0 && j < n && i <= j);
    }
}