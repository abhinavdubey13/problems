import java.util.ArrayList;

/**
 *  https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 */

/**
 * 
 * approach 1  : https://www.youtube.com/watch?v=SoxrXQbhCPI&ab_channel=Pepcoding
 * 
 * 1. transpose
 * 2. reverser each row
 * 
 * 
 * using 2 loops
 * 
 * TC=(M.N)
 * SC=O(1)
 * 
 */

enum Direction {
    LEFT_TO_RIGHT, TOP_TO_BOTTOM, RIGHT_TO_LEFT, BOTTOM_TO_TOP
}

class p3_rotate_square_matrix_90_clockwise {

    public static void main(String[] args) {
        //3x4 matrix (rectangular)
        // int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        //3x3 matrix (square)
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // function(arr);

        System.out.println("before");
        Helper.print_matrix(arr);
        Solution_2.function(arr);
        System.out.println("after");
        Helper.print_matrix(arr);

    }

}

class Solution {

    static void function(int[][] arr) {

        int row_begin = 0;
        int row_end = arr.length - 1;

        int col_begin = 0;
        int col_end = arr[0].length - 1;

        Direction curr_direction = Direction.LEFT_TO_RIGHT;
        int exchange = 0;
        int num_of_rings = arr.length / 2;

        while (row_begin <= row_end && col_begin <= col_end) {

            //this is for mid element of nxn whre n is odd
            if (num_of_rings == 0) {
                break;
            }

            num_of_rings--;

            if (curr_direction == Direction.LEFT_TO_RIGHT) {

                exchange = arr[row_begin + 1][col_begin];

                for (int i = col_begin; i <= col_end; i++) {
                    int temp = arr[row_begin][i];
                    arr[row_begin][i] = exchange;
                    exchange = temp;

                }
                row_begin++;
                curr_direction = Direction.TOP_TO_BOTTOM;

            }

            else if (curr_direction == Direction.TOP_TO_BOTTOM) {

                for (int i = row_begin; i <= row_end; i++) {
                    // System.out.print(arr[i][col_end] + " ");
                    int temp = arr[i][col_end];
                    arr[i][col_end] = exchange;
                    exchange = temp;

                }
                col_end--;
                curr_direction = Direction.RIGHT_TO_LEFT;

            }

            else if (curr_direction == Direction.RIGHT_TO_LEFT) {

                for (int i = col_end; i >= col_begin; i--) {
                    // System.out.print(arr[row_end][i] + " ");
                    int temp = arr[row_end][i];
                    arr[row_end][i] = exchange;
                    exchange = temp;

                }
                row_end--;
                curr_direction = Direction.BOTTOM_TO_TOP;

            }

            else if (curr_direction == Direction.BOTTOM_TO_TOP) {

                for (int i = row_end; i >= row_begin; i--) {
                    // System.out.print(arr[i][col_begin] + " ");
                    int temp = arr[i][col_begin];
                    arr[i][col_begin] = exchange;
                    exchange = temp;

                }
                col_begin++;
                curr_direction = Direction.LEFT_TO_RIGHT;
            }

        }

    }
}

class Solution_2 {

    static void function(int[][] arr) {
        transpose(arr);
        for (int[] a : arr) {
            reverse_arr(a);
        }
    }

    static void transpose(int[][] arr) {
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

    static void reverse_arr(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
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