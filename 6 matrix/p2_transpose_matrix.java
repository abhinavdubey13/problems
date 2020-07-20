import java.util.*;

/**
 * 
 * find transpose of a square matrix
 * 
 * 
 */

/**
 * 
 * approach : 
 * 
 * in transpose : rows become column (or col become row)
 * 
 * in case of square matrix , for a transpose , swap every (i,j) with (j,i) 
 *basically taking mirror image using (i,i) ie. diagonal line as mirror
 * 
 * 
 * 
 * 
 * 
 * using 2 loops
 * TC=(M.N)
 * SC=O(1)
 * 
 */



class p2_transpose_matrix {

    public static void main(String[] args) {
        //4x4 matrix
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        //3x3 matrix
        // int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println("before");
        Helper.print_matrix(arr);
        Solution.function(arr);
        System.out.println("after");
        Helper.print_matrix(arr);

    }

}

class Solution {

    static void function(int[][] arr) {

        int rows = arr.length;
        int cols = rows; //square matrix;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (j < i) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }

            }
        }

    }

}

class Helper {

    static void print_matrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

}