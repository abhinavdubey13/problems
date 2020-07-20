import java.util.*;

/**
 * leetcode id : 221
 * 
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: matrix = 
 * [1,0,1,0,0]
 * [1,0,1,1,1]
 * [1,1,1,1,1]
 * [1,0,0,1,0]
 * 
 * Output: 4 (maximum is 2x2 submatrix with all 1's : area = 4 )
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *  https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 *
 *  
 * 
 * ============
 * TC = O(n.n)
 * SC = O(n.n)
 * 
 * 
 * 
 */

class x19_max_square_submatrix {

    public static void main(String[] args) {

        char[][] arr = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };

        // int answer = Brute_force.function(arr);
        int answer = Dynamic_prog.function(arr);

        System.out.println(answer);
    }

}

class Dynamic_prog {

    static int function(char[][] arr) {

        if (arr == null || arr.length == 0 || arr[0].length == 0)
            return 0;

        int max = 0, n = arr.length, m = arr[0].length;

        // dp(i, j) represents the length of the square 
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        // return the area
        return max * max;

    }

}

class Brute_force {

    static int function(char[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        int max_size = Math.min(rows, cols);

        for (int curr_size = max_size; curr_size >= 1; curr_size--) {
            for (int i = 0; i + curr_size - 1 < rows; i++) {
                for (int j = 0; j + curr_size - 1 < cols; j++) {
                    boolean check = check_sub_matrix(arr, i, j, curr_size);
                    if (check) {
                        return curr_size * curr_size;
                    }
                }
            }
        }

        return 0;

    }

    static boolean check_sub_matrix(char[][] arr, int x, int y, int size) {
        int end_row = x + size - 1;
        int end_col = y + size - 1;
        for (int i = x; i <= end_row; i++) {
            for (int j = y; j <= end_col; j++) {
                boolean is_invalid = (arr[i][j] == '0');
                if (is_invalid) {
                    return false;
                }
            }
        }
        return true;
    }
}