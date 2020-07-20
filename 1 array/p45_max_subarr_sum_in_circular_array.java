import java.util.*;

/**
 * 
 * leetcode id : 
 *
 * Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.
 * 
 * ==========
 * example :
 * ==========
 * 
 * Input: a[] = {8, -8, 9, -9, 10, -11, 12}
 * Output: 22 (12 + 8 - 8 + 9 - 9 + 10)
 * 
 * Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1} 
 * Output:  23 (7 + 6 + 5 - 4 -1 + 10) 
 * 
 * Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1}
 * Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)
 * 
 * 
 */

/**
 * ============
 * approach : 1
 * =============
 * 
 * In this method, modify Kadane’s algorithm to find a minimum contiguous subarray sum and the maximum contiguous subarray sum, 
 * 
 * then check for maximum value among the max_value and the value left after subtracting min_value from the total sum
 * 
 * 1. We will calculate the total sum of the given array
 * 
 * 2. We will declare variable curr_max, max_so_far, curr_min, min_so_far as the first value of the array
 * 
 * 3. Now we will use Kadane’s Algorithm to find maximum subarray sum and minimum subarray sum
 * 
 * 4. Check for all the values in the array:-
 *      4.1 If min_so_far is equaled to sum, i.e. all values are negative, then we return max_so_far
 *      4.2 Else, we will calculate the maximum value of max_so_far and (sum – min_so_far) and return it
 * ===============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class p45_max_subarr_sum_in_circular_array {

    public static void main(String[] args) {
        int arr[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int n = arr.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return (arr[0] > 0) ? arr[0] : 0;
        }

        int arr_sum = 0;
        for (int i : arr) {
            arr_sum += i;
        }

        int min_so_far = arr[0];
        int cur_min = arr[0];
        int max_so_far = arr[0];
        int cur_max = arr[0];

        for (int i = 1; i < n; i++) {
            cur_min = Math.min(cur_min + arr[i], arr[i]);
            min_so_far = Math.min(min_so_far, cur_min);

            cur_max = Math.max(cur_max + arr[i], arr[i]);
            max_so_far = Math.max(max_so_far, cur_max);
        }

        //if all numbers in array are negative
        if (min_so_far == arr_sum) {
            return max_so_far;
        }

        return Math.max(max_so_far, arr_sum - min_so_far);
    }

}
