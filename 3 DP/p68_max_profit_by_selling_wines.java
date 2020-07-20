import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/maximum-profit-sale-wines/
 * 
 * 
 * Given n wines in a row, with integers denoting the cost of each wine respectively. 
 * 
 * Each year you can sale the first or the last wine in the row. However, the price of wines increases over time. 
 * 
 * Let the initial profits from the wines be P1, P2, P3…Pn. On the Yth year, the profit from the ith wine will be Y*Pi. 
 * 
 * For each year, your task is to print “beg” or “end” denoting whether first or last wine should be sold. 
 * 
 * calculate the maximum profit from all the wines.
 * 
 * 
 * =========
 * example:
 * =========
 * 
 * Input: Price of wines: 2 4 6 2 5
 * Output: 64
 * 
 * explaination :  beg end end beg beg 
 *
 *
 * 
 */

/**
 *  
 * 
 * ==========
 * approach : 
 * ==========
 * 
 * for each [i.....j] (len>2) we have 2 options
 * 
 * 1. sell i + max[i+1....j]
 * 2. sell j + max[i....j-1]
 * 
 * for finding max[x...y] we use prev calculated [x....y] and add sub array sum [x.....y]
 * 
 * bcz number of year will increase by 1 : thus sum will increase by sub-array sum
 * 
 * 
 *
 * 
 *
 * ===========
 * TC = O(n.n)
 * SC = O(n.n)
 * 
 * 
 * 
 * 
 */

public class p68_max_profit_by_selling_wines {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 2, 5 }; //expected = 64

        // int answer = Brute_force.function_util(arr);
        int answer = Dynamic_prog.function(arr);

        System.out.println(answer);
    }

}

class Brute_force {

    static int function_util(int[] arr) {
        int n = arr.length;

        return function(arr, 0, n - 1, 1);

    }

    static int function(int[] arr, int start, int end, int y) {
        if (start == end) {
            return (arr[start] * y);
        }
        int a = y * arr[start] + function(arr, start + 1, end, y + 1);
        int b = y * arr[end] + function(arr, start, end - 1, y + 1);
        return Math.max(a, b);

    }

}

class Dynamic_prog {

    static int function(int[] arr) {
        int n = arr.length;

        int[][] sum_dp = new int[n][n];
        int[][] dp = new int[n][n];

        //find sum of all possible sub arrays
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (len == 1) {
                    sum_dp[i][j] = arr[i];
                    continue;
                }
                sum_dp[i][j] = sum_dp[i][j - 1] + arr[j];
            }
        }

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                //when len = 1 : we have 1 object to sell
                if (len == 1) {
                    dp[i][j] = arr[i];
                }

                //when len = 2 : (1*min + 2*max) will be answer
                else if (len == 2) {
                    dp[i][j] = Math.min(arr[i], arr[j]) + 2 * Math.max(arr[i], arr[j]);
                }

                else {
                    int a = arr[i] + (dp[i + 1][j] + sum_dp[i + 1][j]);
                    int b = arr[j] + (dp[i][j - 1] + sum_dp[i][j - 1]);

                    dp[i][j] = Math.max(a, b);
                }
            }
        }

        return dp[0][n - 1];

    }

}
