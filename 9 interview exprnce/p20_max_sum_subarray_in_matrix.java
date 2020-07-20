import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/
 * 
 * Given a 2D array, find the maximum sum subarray in it. 
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 
 *
 * using kadane algo .
 * 
 * c1 : 0->cols
 * c2 : c1->cols
 * 
 * 
 * check for sub array from c1 to c2
 * 
 * https://www.youtube.com/watch?v=pbajVSlZYDA&ab_channel=AnuragCodes
 * 
 * 
 * ============
 * TC : O(n^3)
 * SC : O(row)
 * 
 *  
 */

class p20_max_sum_subarray_in_matrix {

    public static void main(String[] args) {

        //expected : 34
        // int[][] arr = { { 1, 2, -1, 4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };

        //expected : 18
        int[][] arr = { { 2, 1, -3, -4, 5 }, { 0, 6, 3, 4, 1 }, { 2, -2, -1, 4, -5 }, { -3, 3, 1, 0, 3 } };

        int answer = Solution.function(arr);
        System.out.println(answer);

    }

}

class Solution {

    static int function(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[] dp = new int[rows];
        int answer = Integer.MIN_VALUE;

        for (int c1 = 0; c1 < cols; c1++) {
            Arrays.fill(dp, 0);
            for (int c2 = c1; c2 < cols; c2++) {

                for (int i = 0; i < rows; i++) {
                    dp[i] += arr[i][c2];
                }
                int tmp = kadane(dp);
                answer = Math.max(answer, tmp);
            }
        }

        return answer;
    }

    static int kadane(int[] arr) {
        int n = arr.length;
        int answer = arr[0];
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            int curr = arr[i];
            temp = Math.max(temp + curr, curr);
            answer = Math.max(answer, temp);
        }
        return answer;
    }

}
