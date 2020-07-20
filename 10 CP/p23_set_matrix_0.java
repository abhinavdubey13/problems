import java.util.*;

/**
 * 
 * leetcode id : 73
 * 
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 * 
 * Follow up:
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * 
 * Could you devise a constant space solution?
 * 
 * 
 *  
 */

/**
 * 
 * 
 * 
 * use 1 rows and 1 col of matrix ,  as helper
 * and set the status for other rows/cols using those helper row and col
 * 
 * https://www.youtube.com/watch?v=6_KMkeh5kEc&ab_channel=Errichto
 * 
 * 
 * TC = r.c
 * SC = 1
 * 
 */

class p23_set_matrix_0 {

    public static void main(String[] args) {

        int[][] arr = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

        Solution.function(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

    }

}

class Solution {

    static void function(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        int rr = -1, rc = -1;

        //finding rough row and rough col : 1st (i,j) with value = 0 
        for (int i = 0; i < rows; i++) {
            boolean found = false;
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    rr = i;
                    rc = j;
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        //use rough row and col to set values , for row/cols to be set as zero at last
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i == rr || j == rc) {
                    continue;
                }

                if (arr[i][j] == 0) {
                    arr[rr][j] = 0;
                    arr[i][rc] = 0;
                }
            }
        }

        //set zeros for determined cells (or rows and cols)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == rr || j == rc) {
                    continue;
                }

                if (arr[i][rc] == 0 || arr[rr][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        //set rough row and col as zero
        for (int i = 0; i < cols; i++) {
            arr[rr][i] = 0;
        }

        for (int i = 0; i < rows; i++) {
            arr[i][rc] = 0;
        }

    }

}
