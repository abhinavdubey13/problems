import java.util.*;

/**
 * https://www.geeksforgeeks.org/printing-brackets-matrix-chain-multiplication-problem/
 *
 * 
 * 
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
 * 
 * The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
 * 
 * We have many options to multiply a chain of matrices because matrix multiplication is associative. 
 * 
 * In other words, no matter how we parenthesize the product, the result will be the same
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
 *
 *
 * ===========
 * TC=O(n^3)
 * SC=O(n^2)
 * 
 * 
 * 
 */

class p74_matrix_multiplication {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int min_mult = Solution.function(arr);
        System.out.println(min_mult);
    }

}

class Solution {

    static int function(int[] arr) {

        int n = arr.length;

        //For simplicity of the program, one extra row and one extra column are allocated in m[][].  
        //0th row and 0th column of m[][] are not used 
        int dp[][] = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 < n; i++) {
                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int multiplications = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], multiplications);
                }

            }
        }

        return dp[1][n - 1];

    }
}