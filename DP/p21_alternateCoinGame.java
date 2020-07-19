
// Consider an array A[n]  , A[i] represents a PROFIT
// A's lenght is even
// We play a game against an opponent by alternating turns. 
// In each turn, a player selects either the first or last coin from the array, removes it from A[] permanently, and receives the PROFIT  
// Determine the MAXIMUM PROFIT the 1st player can get
// Note: The opponent is as clever as the user.

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
 */

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.border.EmptyBorder;

class p21_alternateCoinGame {

    public static void main(String[] args) {
        // int[] coins = { 20, 30, 2, 2, 2, 10 };
        int[] coins = { 5, 3, 7, 10 };
        int answer = calulator(coins);
        System.out.println(answer);
    }

    static int calulator(int[] coins) {
        int[][] table = new int[coins.length][coins.length];

        for (int numCoinsToConsider = 1; numCoinsToConsider <= coins.length; numCoinsToConsider++) {

            for (int startIndex = 0, endIndex = startIndex + numCoinsToConsider
                    - 1; endIndex < coins.length; startIndex++, endIndex++) {

                if (numCoinsToConsider == 1) {
                    // here startIndex = endIndex
                    table[startIndex][endIndex] = coins[startIndex];
                    continue;
                }

                int x = (startIndex + 2 <= endIndex) ? table[startIndex + 2][endIndex] : 0;
                int y = (startIndex + 1 <= endIndex - 1) ? table[startIndex + 1][endIndex - 1] : 0;
                int z = (startIndex <= endIndex - 2) ? table[startIndex][endIndex - 2] : 0;

                int min1 = Math.min(x, y);
                int min2 = Math.min(y, z);

                table[startIndex][endIndex] = Math.max(coins[startIndex] + min1, coins[endIndex] + min2);

            }
        }

        return table[0][coins.length - 1];
    }
}