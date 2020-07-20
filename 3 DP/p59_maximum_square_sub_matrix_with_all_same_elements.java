import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/finding-the-maximum-square-sub-matrix-with-all-equal-elements/
 * 
 * Given a N x N matrix, determine the maximum K such that K x K is a submatrix with all equal elements 
 * 
 * all the elements in this submatrix must be same.
 * 
 * =========
 * example:
 * =========
 * 
 * Input : a[][] = {{2, 3, 3},
 *  {2, 3, 3}
 *  {2, 2, 2}}
 * 
 * Output : 2
 * Explanation: A 2x2 matrix is formed from index A0,1 to A1,2
 * 
 * Input : a[][]  = {{9, 9, 9, 8},
 * {9, 9, 9, 6},
 * {9, 9, 9, 3},
 * {2, 2, 2, 2}
 * 
 * Output : 3
 * Explanation : A 3x3 matrix is formed from index A0,0 to A2,2
 *
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
 * For each cell (i, j), we store the largest value of K such that K x K is a submatrix with all equal elements and position of (i, j) 
 * 
 * being the bottom-right most element.
 * 
 * And DPi,j depends upon {DPi-1, j, DPi, j-1, DPi-1, j-1}
 * 
 * ===========
 * TC = O(row.col)
 * SC = O(row.col)
 * 
 * 
 * 
 * 
 */

public class p59_maximum_square_sub_matrix_with_all_same_elements {

    public static void main(String[] args) {
        int[][] arr = { { 5, 5, 7, 7, 7, 4 }, { 1, 2, 7, 7, 7, 4 }, { 4, 4, 7, 7, 7, 4 }, { 5, 5, 5, 1, 2, 7 },
                { 8, 7, 9, 4, 4, 4 } };

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        int[][] dp = new int[rows][cols];
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If elements is at top row or first column,  it can only form 1x1  sq. sub-matrix 
                if (i == 0 || j == 0)
                    dp[i][j] = 1;

                else {
                    // Check if adjacent elements are equal 
                    if (arr[i][j] == arr[i - 1][j] && arr[i][j] == arr[i][j - 1] && arr[i][j] == arr[i - 1][j - 1]) {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }

                    // If not equal, then it will form  1x1 submatrix 
                    else {
                        dp[i][j] = 1;
                    }
                }

                // Update result at each (i,j) 
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

}