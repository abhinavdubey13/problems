import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
 * 
 * Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s. 
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
 * Step1: Get the index of first (or leftmost) 1 in the first row.
 * Step2: Do following for every row after the first row 
 * 
 * IF the element on left of previous leftmost 1 is 0, ignore this row. 
 * ELSE Move left until a 0 is found. Update the leftmost index to this index and max_row_index to be the current row.
 * 
 * 
 *
 * ============
 * TC = O(r + c)  : we can possibly go as far left as we came ahead in the first step
 * SC = O(1)
 * 
 * 
 */

class p15_row_with_max_1_in_2d_matrix {

    public static void main(String[] args) {

        int[][] arr = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };

        int answer_idx = Solution.function(arr);
        System.out.println(answer_idx);

        //testing custom binary search
        // int[] arr = { 0, 0, 0, 1, 1, 1 };//expected : 3
        // int[] arr = { 0, 0, 0, 1};//expected : 3
        // int[] arr = { 0, 0, 0};//expected : -1
        // int[] arr = {1,1,1,1};//expected : 0
        // int answer_idx = Solution.binary_search(arr, 1, 0, arr.length - 1);
        // System.out.println(answer_idx);

    }

}

class Solution {

    static int function(int arr[][]) {

        int rows = arr.length;
        int cols = arr[0].length;

        //this is the index at which we are having a 1 in the row
        int min_idx_of_1 = binary_search(arr[0], 1, 0, cols - 1);

        //if 1st row has only 0
        if (min_idx_of_1 == -1) {
            min_idx_of_1 = cols - 1;
        }

        int answer_idx = 0;

        for (int i = 1; i < rows; i++) {

            while (min_idx_of_1 >= 0 && arr[i][min_idx_of_1] == 1) {
                min_idx_of_1--;
                answer_idx = i;
            }

            //if at any point , the sub array has only 1's , that is our answer
            if (min_idx_of_1 == -1) {
                return answer_idx;
            }

        }

        return answer_idx;

    }

    static int binary_search(int[] arr, int x, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int ele_found = arr[mid];

            if (ele_found == x) {

                if (mid == 0) {
                    return mid;
                } else if (arr[mid] > arr[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }

            else if (ele_found > x) {
                high = mid - 1;
            }

            else if (ele_found < x) {
                low = mid + 1;
            }
        }

        return -1;
    }

}
