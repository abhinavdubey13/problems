import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/remove-minimum-elements-either-side-2min-max/
 * 
 * Given an unsorted array, trim the array such that twice of minimum is greater than maximum in the trimmed array. 
 * Elements should be removed either end of the array.
 * Number of removals should be minimum.
 * =========
 * example:
 * =========
 * 
 * arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}
 * Output: 4
 * We need to remove 4 elements (4, 5, 100, 200) so that 2*min becomes more than max.
 * 
 * arr[] = {4, 7, 5, 6}
 * Output: 0
 * We don't need to remove any element as  4*2 > 7 (Note that min = 4, max = 8)
 * 
 * arr[] = {20, 7, 5, 6}
 * Output: 1
 * We need to remove 20 so that 2*min becomes more than max
 * 
 *
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
 * The idea is to find the maximum sized subarray such that 2*min > max. 
 * 
 * We run two nested loops, the outer loop chooses a starting point and the inner loop chooses ending point for the current starting point. 
 * 
 * We keep track of longest subarray with the given property.
 *
 * ===========
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * 
 * 
 */

class Detail {
    int min;
    int max;

    
    Detail(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

public class p61_remove_minimum_elements_from_either_side_so_that_twice_min_greater_than_max {

    public static void main(String[] args) {

        // int[] arr = { 4, 5, 100, 9, 10, 11, 12, 15, 200 };//expected = 4

        // int[] arr = { 4, 5, 6, 7 };//expected = 0

        // int[] arr = { 20, 4, 1, 3 };//expected = 3

        int[] arr = { 20, 7, 5, 6 };//expected = 1

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {
        int n = arr.length;
        int answer = Integer.MAX_VALUE;

        Detail[][] dp = new Detail[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (len == 1) {
                    dp[i][j] = new Detail(arr[i], arr[i]);
                }

                else if (len == 2) {
                    dp[i][j] = new Detail(Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j]));
                }

                else {
                    Detail left = dp[i][j - 1];
                    Detail down = dp[i + 1][j];

                    dp[i][j] = new Detail(Math.min(left.min, down.min), Math.max(left.max, down.max));

                    if (2 * dp[i][j].min > dp[i][j].max) {
                        answer = Math.min(answer, n - len);
                    }
                }

            }
        }

        if (answer == Integer.MAX_VALUE) {
            return special_case(arr);
        } else {
            return answer;
        }

    }

    static int special_case(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        if (2 * min > max) {
            return 0;
        } else {
            return arr.length - 1;
        }
    }

}