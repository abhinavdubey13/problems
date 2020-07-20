import java.util.*;

/**
 * 
 * leetcode : 188
 * 
 * 
 * 1 transaction = (1 buy + 1 sell) operation
 * 
 * u can do atmost k transactions
 * NOTE : buy should happen before selling
 * 
 * 
 * ie : only BSBS... this type of tranactions are allowed
 * 
 * BBSS : such overlapping txn not allowed
 * 
 */

/**
 * 
 * https://www.youtube.com/watch?v=3YILP-PdEJA&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=36&ab_channel=Pepcoding
 * 
 * 
 * 
 * using DP
 * 
 * dp[i][j] : 
 *      number of allowed txn = i 
 *      till j'th day
 * 
 * 
 */

class p3_stock_buy_n_sell_atmost_k_txn {

    public static void main(String[] args) {
        int[] arr = { 9, 6, 7, 3, 8 };
        int k = 3;

        int answer = Solution.function(arr, k);
        System.out.println(answer);
    }

}

class Solution {
    static int function(int[] arr, int k) {

        int n = arr.length;

        if (n < 2) {
            return 0;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {

                //if no txn or 0th day : we cannot make profit
                //1st row and colum
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                //if all txn are over : then left cell is the profit  
                dp[i][j] = dp[i][j - 1];
                for (int p = 0; p < j; p++) {
                    int profit_by_ith_txn = arr[j] - arr[p]; //selling - buying : we sell today 
                    int profit_by_all_prev_txn = dp[i - 1][p];

                    int overall = profit_by_all_prev_txn + profit_by_ith_txn;
                    dp[i][j] = Math.max(dp[i][j], overall);
                }

            }

        }

        return dp[k][n - 1];

    }
}