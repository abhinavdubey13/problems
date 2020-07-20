import java.util.*;

/**
 * 
 * 
 * https://www.geeksforgeeks.org/number-of-paths-with-exactly-k-coins/
 * 
 * Given a matrix where every cell has some number of coins. 
 * 
 * Count number of ways to reach bottom right from top left with exactly k coins. We can move to (i+1, j) and (i, j+1) from a cell (i, j).
 * 
 * 
 *
 *
 * 
 */

/**
 * 
 * using DFS
 *
 * 
 */

class x44_number_of_coins_with_exactly_k_coins {

    public static void main(String[] args) {

        int[][] arr = { { 1, 2, 3 }, { 4, 6, 5 }, { 3, 2, 1 } };

        int coins = 12;

        int ans = new Solution().function(arr, coins);
        System.out.println(ans);

    }

}

class Solution {

    int COUNT;
    int ROWS;
    int COLS;

    int function(int[][] arr, int coins) {
        COUNT = 0;
        ROWS = arr.length;
        COLS = arr[0].length;
        dfs(arr, 0, 0, coins);
        return COUNT;
    }

    void dfs(int arr[][], int x, int y, int coin_left) {

        if (!is_safe(x, y)) {
            return;
        }

        else if (x == ROWS - 1 && y == COLS - 1) {
            COUNT += (coin_left == arr[ROWS - 1][COLS - 1]) ? 1 : 0;
        }

        else if (coin_left > 0) {
            int coins_req_here = arr[x][y];
            int coins_left_now = coin_left - coins_req_here;
            dfs(arr, x + 1, y, coins_left_now);
            dfs(arr, x, y + 1, coins_left_now);
        }

    }

    boolean is_safe(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS;
    }

}