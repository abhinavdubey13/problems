import java.util.*;

/**
 * 
 * given a matrix , each row is sorted and contains only 0's and 1's
 * 
 * find the row with maximum 1's
 * 
 * https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
 * 
 */

/**
 *  
 * =============
 * approach : 
 * =============
 *
 * using binary search
 * 
 * let rows in matrix = R
 * let columns in matrix = C
 * 
 * TC= O(R . logC)
 * SC= O(1) 
 * 
 */

class p30_row_with_max_1s {

    public static void main(String[] args) {
        int arr[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
        function(arr);
    }

    static void function(int arr[][]) {

        int row_with_max_1 = -1;
        int num_of_1_in_answer_row = -1;

        for (int i = 0; i < arr.length; i++) {
            int idx = first_idx_of_1(arr[i]);

            int num_of_1 = (idx != -1) ? arr[i].length - idx : 0;

            if (num_of_1 > num_of_1_in_answer_row) {
                num_of_1_in_answer_row = num_of_1;
                row_with_max_1 = i;
            }

        }

        System.err.println((row_with_max_1));

    }

    static int first_idx_of_1(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {

                if (mid == 0 || arr[mid - 1] == 0) {
                    return mid;
                }

                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}