import java.util.*;

/**
 * leetcode id : 746
 * 
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. 
 * You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * 
 * 
 * ==========
 * example : 
 * ==========
 * 
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * 
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
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
 * min cost using prev 2 step
 * 
 * ===========
 * TC=O(n)
 * SC=O(n)
 * 
 * 
 * 
 */

class x27_min_cost_stair_climbing {

    public static void main(String[] args) {

        int[] arr = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int n = arr.length;
        if (n < 2) {
            return 0;
        }

        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int cost_1 = arr[i - 1] + dp[i - 1];
            int cost_2 = arr[i - 2] + dp[i - 2];
            dp[i] = Math.min(cost_1, cost_2);
        }

        return dp[n];

    }

}
