import java.util.*;

/**
 * 
 * leetcode id : 240
 * 
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * 
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * 
 */

/**
 * We start search the matrix from top right corner, 
 * 
 * initialize the current position to top right corner,
 * 
 * if the target is greater than the value in current position, 
 * then the target can not be in entire row of current position because the row is sorted, 
 * 
 * 
 * if the target is less than the value in current position, 
 * then the target can not in the entire column because the column is sorted too. 
 * 
 * 
 * We can rule out one row or one column each time, 
 * 
 * 
 * TC :  O(m+n)
 * 
 *
 * 
 * 
 */

class p39_search_in_sorted_matrix {

    public static void main(String[] args) {
        int[][] arr = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };

        int target = 500;
        boolean present = Solution.function(arr, target);
        System.out.println(present);
    }
}

class Solution {

    static boolean function(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;
        int max_row = 0;
        int max_col = cols - 1;

        while (max_row < rows && max_col >= 0) {
            int curr = arr[max_row][max_col];
            if (curr == target) {
                return true;
            } else if (curr < target) {
                max_row++;
            } else if (curr > target) {
                max_col--;
            }
        }

        return false;
    }

}