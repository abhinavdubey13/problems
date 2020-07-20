import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/
 *
 * Given an array, find the subarray (containing at least k numbers) which has the largest sum.
 * 
 * ==========
 * example :
 * ==========
 * 
 * Input : arr[] = {-4, -2, 1, -3} k = 2
 * Output : -1
 * The sub array is {-2, 1}
 * 
 * Input : arr[] = {1, 1, 1, 1, 1, 1} 
 * k = 2
 * Output : 6 
 * The sub array is {1, 1, 1, 1, 1, 1}
 * 
 */

/**
 * ============
 * approach : 1
 * =============
 * 
 * https://www.youtube.com/watch?v=OodoQ95se20&ab_channel=Pepcoding
 * 
 * application of kadane's algorithm
 * 
 * 
 * 1) We first compute maximum sum till every index and store it in an array maxSum[].
 * 
 * 2) After filling the array, we use the sliding window concept of size k.
 * Keep track of sum of current k elements. To compute sum of current window, remove first element of previous window and add current element. 
 * After getting the sum of current window, we add the maxSum of the previous window, if it is greater than current max, then update it else not.
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

class p52_max_sum_subarray_with_atleast_k_numbers {

    public static void main(String[] args) {

        //expected = -4
        int arr[] = { 1, 2, 3, -10, -3 };
        int k = 4;

        //expected = -1
        // int arr[] = { -4, -2, 1, -3 };
        // int k = 2;

        //expected = 6
        // int arr[] = { 1,1,1,1,1,1};
        // int k = 2;

        int answer = function(arr, k);
        System.out.println(answer);
    }

    static int function(int[] arr, int k) {

        int n = arr.length;

        int[] kadane = new int[n];

        kadane[0] = arr[0];

        int sum_till_now = arr[0];

        for (int i = 1; i < n; i++) {
            sum_till_now += arr[i];
            kadane[i] = Math.max(sum_till_now, arr[i]);
        }

        // Sum of first k elements 
        int window_sum = 0;
        for (int i = 0; i < k; i++) {
            window_sum += arr[i];
        }

        //init answer with first k sized window
        int answer = window_sum;

        for (int i = k; i < n; i++) {

            int idx_before_window_start = i - k;

            // Compute sum of k elements ending with a[i]. 
            window_sum = window_sum + arr[i] - arr[idx_before_window_start];

            // Update result if required : consider window of exactly K elements and window of atleast K elements
            answer = Math.max(answer, Math.max(window_sum, window_sum + kadane[idx_before_window_start]));

        }

        return answer;

    }

}
