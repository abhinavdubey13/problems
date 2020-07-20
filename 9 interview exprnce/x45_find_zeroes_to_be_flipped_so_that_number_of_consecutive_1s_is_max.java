import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/
 * 
 * 
 * Given a binary array and an integer m, 
 * 
 * find the longest substring length , containing only 1's , 
 * you are allowed to flip m 0's to 1's atmost
 *
 *
 * 
 */

/**
 * 
 * using sliding window
 * 
 * The main steps are:
 * 
 * – While zeroCount is no more than m: expand the window to the right (wR++) and update the count zeroCount.
 * – While zeroCount exceeds m, shrink the window from left (wL++), update zeroCount;
 * – Update the widest window along the way. The positions of output zeros are inside the best window.
 *
 * 
 */

class x45_find_zeroes_to_be_flipped_so_that_number_of_consecutive_1s_is_max {

    public static void main(String[] args) {

        //expected : 9
        // int[] arr = { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 };
        // int m = 2;

        //expected : 5
        int[] arr = { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 };
        int m = 1;

        int ans = new Solution().function(arr, m);
        System.out.println(ans);

    }

}

class Solution {

    int function(int[] arr, int m) {

        int wR = 0, wL = 0;
        int ans = 0;

        int zeros_in_windows = (arr[0] == 0) ? 1 : 0;

        int n = arr.length;

        if (m >= n) {
            return n;
        }

        while (wR < n) {

            if (zeros_in_windows <= m) {
                if (arr[wR] == 0) {
                    zeros_in_windows++;
                }
                wR++;
            }

            if (zeros_in_windows > m) {
                if (arr[wL] == 0) {
                    zeros_in_windows--;
                }
                wL++;
            }

            if (zeros_in_windows <= m) {
                ans = Math.max(ans, wR - wL + 1);
            }

        }

        return (ans - 1);
    }

}