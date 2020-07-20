import java.util.*;

/**
 * leetcode id : 
 * 
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
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
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class zz_sample {

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[][] arr) {

        if (arr.length == 1) {
            return find_min(arr[0]);
        }

        int[][] dp = new int[2][arr[0].length];

        for (int i = 0; i < arr[0].length; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 0; i < arr[0].length; i++) {
            dp[0][i] = arr[0][i];
            dp[1][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                int left_diag = ((j - 1) >= 0) ? dp[0][j - 1] + arr[i][j] : Integer.MAX_VALUE;
                int top = dp[0][j] + arr[i][j];
                int right_diag = ((j + 1) < arr[0].length) ? dp[0][j + 1] + arr[i][j] : Integer.MAX_VALUE;

                dp[1][j] = Math.min(top, Math.min(left_diag, right_diag));
            }

            copy_arr(dp);
        }

        return find_min(dp[0]);

    }

    static void copy_arr(int[][] dp) {
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = dp[1][i];
            dp[1][i] = Integer.MAX_VALUE;
        }
    }

    static int find_min(int[] arr) {
        int ans = Integer.MAX_VALUE;
        for (int i : arr) {
            ans = Math.min(ans, i);
        }
        return ans;
    }

}
