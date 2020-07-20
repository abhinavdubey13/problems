import java.util.*;

/**
 * 
 * leetcode id : 289
 *
 * 
 * 
 * The board is made up of an m x n grid of cells, where each cell has an initial state: 
 * live (represented by a 1) or 
 * dead (represented by a 0). 
 * 
 * Each cell interacts with its 8 neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * 
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * 
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. 
 * Given the current state of the m x n grid board, return the next state. 
 *
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
 *
 */

/**
 * 
 * optimal approach : 
 * using but manipulation
 * 
 * 
 * TC = n^2
 * SC = 1
 * 
 * 
 * 
 */

class p35_4_sum_2 {

    public static void main(String[] args) {

        int[][] arr = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

        Helper.print(arr);
        // new Solution_normal().function(arr);
        new Solution_optimal().function(arr);

        Helper.print(arr);
    }
}

class Solution_normal {

    int ROWS;
    int COLS;
    int[] x_ngbr = { -1, 1, 0, 0, 1, 1, -1, -1 };
    int[] y_ngbr = { 0, 0, -1, 1, 1, -1, 1, -1 };

    void function(int[][] arr) {

        ROWS = arr.length;
        COLS = arr[0].length;

        int[][] temp = new int[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                int live = get_live(arr, i, j);

                if (arr[i][j] == 1) {

                    if (live == 2 || live == 3) {
                        temp[i][j] = 1;
                    } else if (live > 3 || live < 2) {
                        temp[i][j] = 0;
                    }

                } else if (arr[i][j] == 0) {
                    temp[i][j] = (live == 3) ? 1 : 0;
                }

            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                arr[i][j] = temp[i][j];
            }
        }

    }

    int get_live(int[][] arr, int x, int y) {
        int live = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + x_ngbr[i];
            int ny = y + y_ngbr[i];
            if (is_safe(nx, ny)) {
                live += (arr[nx][ny] == 1) ? 1 : 0;
            }
        }
        return live;
    }

    boolean is_safe(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS;
    }
}

class Solution_optimal {

    int ROWS;
    int COLS;
    int[] x_ngbr = { -1, 1, 0, 0, 1, 1, -1, -1 };
    int[] y_ngbr = { 0, 0, -1, 1, 1, -1, 1, -1 };

    void function(int[][] arr) {

        ROWS = arr.length;
        COLS = arr[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                int live = get_live(arr, i, j);

                if (arr[i][j] == 1) {

                    //next state wil be live : ie 11 
                    //11 : live-live
                    //MSB : next state , LSB : current state
                    if (live == 2 || live == 3) {
                        arr[i][j] = 3;
                    }

                    //next state wil be dead : ie 01 
                    //01 : dead-live
                    else if (live > 3 || live < 2) {
                        arr[i][j] = 1;
                    }

                }

                //next state wil be live : ie 10 
                //10 : live-dead
                //MSB : next state , LSB : current state
                else if (arr[i][j] == 0 && live == 3) {
                    arr[i][j] = 2;
                }

            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                arr[i][j] >>= 1;
            }
        }

    }

    int get_live(int[][] arr, int x, int y) {
        int live = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + x_ngbr[i];
            int ny = y + y_ngbr[i];
            if (is_safe(nx, ny)) {
                live += (arr[nx][ny] & 1);
            }
        }
        return live;
    }

    boolean is_safe(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS;
    }
}

class Helper {
    static void print(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}