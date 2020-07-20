import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/number-ways-form-heap-n-distinct-integers/
 * 
 * Given n, how many distinct Max Heap can be made from n distinct integers?
 * 
 * 
 * 
 *
 * 
 */

/**
 *  
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * https://www.geeksforgeeks.org/number-ways-form-heap-n-distinct-integers/
 * 
 * 
 * basically the root node is fixed : ie max number will be the root (value = N)
 * 
 * now , number_of_nodes_in_LST + number_of_nodes_in_RST = N-1
 * 
 * or L+R = n-1
 * 
 * we need to select L nodes out of N-1 nodes , and then find the number of arrangement forming heap
 * 
 * 
 * 
 *
 * 
 *  
 * 
 */

public class p73_count_number_of_heaps_with_n_nodes {
    public static void main(String[] args) {
        int n = 10;//expected 3360
        int answer = Solution.function(n);
        System.out.println("possible heaps  : " + answer);
    }

}

class Solution {

    static int function(int n) {
        int[] count_dp = new int[n + 1];
        int[][] nCk_dp = new int[n + 1][n + 1];
        int[] log2_dp = new int[n + 1];

        set_combination(nCk_dp, n, n);
        set_log_dp(log2_dp, n);

        Arrays.fill(count_dp, -1);
        return num_of_heaps(n, count_dp, nCk_dp, log2_dp);
    }

    public static int num_of_heaps(int n, int[] count_dp, int[][] nCk_dp, int[] log2_dp) {
        if (n <= 1) {
            return 1;
        }

        if (count_dp[n] != -1) {
            return count_dp[n];
        }

        int left = num_of_nodes_in_left_subtree(log2_dp, n);

        //number of ways selecting l nodes for LST , and then arranging them
        int possible_left = nCk_dp[n - 1][left] * num_of_heaps(left, count_dp, nCk_dp, log2_dp);
        int possible_right = num_of_heaps(n - 1 - left, count_dp, nCk_dp, log2_dp);

        int ans = possible_left * possible_right;
        count_dp[n] = ans;

        return ans;
    }

    static int num_of_nodes_in_left_subtree(int[] dp, int total_heap_nodes) {

        if (total_heap_nodes == 1) {
            return 0;
        }

        int ht = dp[total_heap_nodes];

        // max number of elements that can be present in the hth level of any heap  
        int max_at_h_height = (int) Math.pow(2, ht);

        // number of elements that are actually present in last level = (2^h - 1)  
        int actual_at_h_height = total_heap_nodes - (max_at_h_height - 1);

        // if more than half-filled  
        if (actual_at_h_height >= (max_at_h_height / 2)) {
            return max_at_h_height - 1;
        } else {
            return max_at_h_height - 1 - ((max_at_h_height / 2) - actual_at_h_height);
        }

    }

    static void set_log_dp(int[] dp, int n) {
        int curr_log_2 = -1;
        int curr_pow_2 = 1; //starting with 2^0 , log(2^0) = 0

        // for each power of two find logarithm  
        for (int i = 1; i <= n; i++) {
            if (curr_pow_2 == i) {
                curr_log_2++;
                curr_pow_2 *= 2;
            }
            dp[i] = curr_log_2;
        }
    }

    static void set_combination(int[][] dp, int n, int k) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {

                // Base Cases
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                }

                // Calculate current value using previously stored values
                // C(n,k) = C(n-1 , k-1) + C(n-1 , k)
                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
    }

}
