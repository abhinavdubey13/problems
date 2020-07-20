import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/painters-partition-problem/
 * 
 * https://www.youtube.com/watch?v=zNVT8SnGRig&t=599s&ab_channel=TECHDOSE * 
 * 
 * We have to paint n boards of length {A1, A2…An}. 
 * 
 * There are k painters available and each takes 1 unit time to paint 1 unit of board. 
 * 
 * The problem is to find the minimum time to get this job done under the constraints that any painter will only paint continuous sections of boards, 
 * 
 * say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 * 
 *  
 * ============
 * example : 1
 * ============
 * Input : k = 2, A = {10, 20, 30, 40} 
 * Output : 60.
 * Here we can divide first 3 boards for one painter and the last board for second painter
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
 * using DP , with base cases as
 * 0. if no paintings or no painters
 * 1. if number if paintings = 1
 * 2. if number of painters = 1
 * ==============
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * 
 * NOTE : 
 * if the array is sorted , we can use a binary search approach 
 * but DP approach works whether the array is sorted or not
 * 
 * 
 * 
 * 
 * 
 * 
 */

class p52_painter_partition {

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 40 };
        int painters = 4;

        int answer = function(arr, painters);
        System.out.println(answer);
    }

    static int function(int[] arr, int painters) {

        int n = arr.length;
        int[][] dp = new int[painters + 1][n + 1];

        //i stands for number of painters
        //j stands for number of paintings
        for (int i = 0; i <= painters; i++) {
            for (int j = 0; j <= n; j++) {

                //if no painters , or no paintings , the time taken = 0 
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }

                //if number of painters is 1 , then answers is sum of the paintings considered
                else if (i == 1) {
                    dp[i][j] = sum(arr, 0, j - 1);
                }

                //if only 1 painting is there (ie. arr[0] ) , then time will be equal to that paiting only
                else if (j == 1) {
                    dp[i][j] = arr[0];
                }

                //painters>1 && paitings>1
                else {
                    int best = Integer.MAX_VALUE;

                    for (int num_paitings = 1; num_paitings <= j; num_paitings++) {
                        int a = dp[i - 1][num_paitings];
                        int b = sum(arr, num_paitings, j - 1);

                        best = Math.min(best, Math.max(a, b));
                    }

                    dp[i][j] = best;
                }

            }
        }

        return dp[painters][n];
    }



    static int sum(int arr[], int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++) {
            total += arr[i];
        }
        return total;
    }

}
