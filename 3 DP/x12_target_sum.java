import java.util.*;

/**
 * leetcode id : 494
 * 
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * 
 * Explanation: 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * Similar to Subset Sum Problem
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

class x12_target_sum {

    public static void main(String[] args) {

        // int[] arr = { 1, 1, 1, 1, 1 };
        // int k = 3;

        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
        int k = 1;

        int answer = function(arr, k);

        System.out.println(answer);
    }

    static int function(int[] arr, int k) {

        if (arr.length == 0)
            return 0;

        if (arr.length == 1)
            return (arr[0] == Math.abs(k)) ? 1 : 0;

        int total_sum = 0;

        for (int a : arr) {
            total_sum += a;
        }

        if (k > total_sum || k < -total_sum || k + total_sum < 0 || (k + total_sum) % 2 == 1) {
            return 0;
        }

        int n = arr.length;
        int required_sum = (total_sum + k) / 2;
        int[][] dp = new int[n + 1][required_sum + 1];

        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int current_sum = 0; current_sum <= required_sum; current_sum++) {

                int sum_remaining = current_sum - arr[i - 1];

                int excluding = dp[i - 1][current_sum];

                int including = (sum_remaining >= 0) ? dp[i - 1][sum_remaining] : 0;

                if (current_sum < arr[i - 1])
                    dp[i][current_sum] = excluding;
                else
                    dp[i][current_sum] = excluding + including;

            }
        }

        //finding wat is max sum of s2 possible
        return dp[n][required_sum];

    }

}
