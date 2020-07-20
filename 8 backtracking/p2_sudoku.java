
import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/sudoku-backtracking-7/
 * 
 * Given a partially filled 9×9 2D array ‘grid[9][9]’, 
 * the goal is to assign digits (from 1 to 9) to the empty cells so that 
 * 
 * every row, column, and subgrid of size 3×3 contains exactly one instance of the digits from 1 to 9. 
 * 
 * ===========
 * example -1
 * ===========
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * using back-tracking
 * 
 * we fill the board from left to right  (ie. row-wise)
 * 
 * https://www.youtube.com/watch?v=LliQjLnbhx8&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=2&ab_channel=Pepcoding
 *
 *  
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * 
 */

class p2_sudoku {

    public static void main(String[] args) {

        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        function(board, 0, 0);
        System.out.println();

    }

    static void function(int[][] board, int x, int y) {

        //if we have reached last_1 row => solved sudoku
        if (x == board.length) {
            print_board(board);
            return;
        }

        int next_x, next_y;

        // calulate i,j for next call
        if (y == board[0].length - 1) {
            next_x = x + 1;
            next_y = 0;
        } else {
            next_x = x;
            next_y = y + 1;
        }

        //if already filled , goto next cell
        if (board[x][y] != 0) {
            function(board, next_x, next_y);
        } else {

            //check if value is possible
            for (int possible = 1; possible <= 9; possible++) {
                boolean is_valid = check_placement_valid(board, x, y, possible);
                if (is_valid) {
                    board[x][y] = possible;
                    function(board, next_x, next_y);
                    board[x][y] = 0;
                }
            }
        }

    }

    static boolean check_placement_valid(int[][] board, int x, int y, int value) {

        //checking row
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == value) {
                return false;
            }
        }

        //checking column
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == value) {
                return false;
            }
        }

        int header_x = x - (x % 3);
        int header_y = y - (y % 3);

        //checking 3x3 sub-matrix
        for (int i = header_x; i <= header_x + 2; i++) {
            for (int j = header_y; j <= header_y + 2; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;

    }

    static void print_board(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }
    }

}
