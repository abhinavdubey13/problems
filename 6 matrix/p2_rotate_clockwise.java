import java.util.ArrayList;

/**
 *  https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 */

/**
 * 
 * approach 1  : https://www.youtube.com/watch?v=siKFOI8PNKM&ab_channel=mycodeschool
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

class p2_rotate_clockwise {

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

    public static void main(String[] args) {
        //4x4 matrix
        // int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        //3x3 matrix
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        function(arr);

        //print matric

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

    }

}