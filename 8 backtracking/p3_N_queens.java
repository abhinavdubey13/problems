
import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
 * 
 * 
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. 
 * 
 * For example, following is a solution for 4 Queen problem.
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
 * 
 * we fill the board row-wise
 * 
 * using backtracking
 *   
 * solutions exist for N=4 onwards
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * 
 */

class p3_N_queens {

    static int COUNT = 0;

    public static void main(String[] args) {
        int N = 5;
        function_util(N);
        System.out.println("number of solutions : " + COUNT);
    }

    static void function_util(int N) {
        int[][] board = new int[N][N];
        function(board, 0, 0, N);
    }

    static void function(int[][] board, int x, int y, int N) {

        //if we have reached end of the board
        if (x >= N) {
            print_board(board);
            COUNT++;
            return;
        }

        int next_x = x + 1;
        int next_y = 0;

        //check all columns in current row 
        for (int i = 0; i < N; i++) {
            boolean is_valid = check_placement_valid(board, x, i, N);
            if (is_valid) {
                board[x][i] = 1;
                function(board, next_x, next_y, N);
                board[x][i] = 0;
            }
        }

    }

    static boolean check_placement_valid(int[][] board, int x, int y, int N) {

        //checking row
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == 1) {
                return false;
            }
        }

        //checking column
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == 1) {
                return false;
            }
        }

        //checking diagonal
        for (int i = 1; i <= N; i++) {
            int d1_x = x + i;
            int d1_y = y + i;

            int d2_x = x - i;
            int d2_y = y - i;

            int d3_x = x + i;
            int d3_y = y - i;

            int d4_x = x - i;
            int d4_y = y + i;

            //down right
            if (d1_x >= 0 && d1_y >= 0 && d1_x < N && d1_y < N && board[d1_x][d1_y] == 1) {
                return false;
            }

            //up left
            if (d2_x >= 0 && d2_y >= 0 && d2_x < N && d2_y < N && board[d2_x][d2_y] == 1) {
                return false;
            }

            //down left
            if (d3_x >= 0 && d3_y >= 0 && d3_x < N && d3_y < N && board[d3_x][d3_y] == 1) {
                return false;
            }

            //up right
            if (d4_x >= 0 && d4_y >= 0 && d4_x < N && d4_y < N && board[d4_x][d4_y] == 1) {
                return false;
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

        System.out.println();
    }

}
