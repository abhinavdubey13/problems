import java.util.*;

/**
 * 
 * leetcode id : 1020
 * 
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * 
 * A move consists of walking from one land cell to another adjacent (4-directionally) 
 * land cell or walking off the boundary of the grid.
 * 
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid 
 * in any number of moves.
 * 
 * 
 * 
 * =========
 * example : 
 * =========
 * 
 *
 * 
 */

/**
 * 
 * 
 * ============= 
 * APPROACH : 
 * =============
 * using BFS
 * 
 * enque all boundary 1's , the move inwards on 1's only 
 * mark all such 1's as visited
 * 
 * at last , the unvisited 1's are the required cells
 *
 * 
 *
 *
 * 
 */

class x27_number_of_enclaves {

    public static void main(String[] args) {

        // //expected : 0
        int[][] board = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };

        // expected : 3
        // int[][] board = { { 0, 0, 0, 0 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0,
        // 0 } };

        int answer = new Solution().function(board);
        System.out.println(answer);

    }

}

class Cordinates {
    int x;
    int y;

    Cordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    int[] x_ngbr = { -1, 1, 0, 0 };
    int[] y_ngbr = { 0, 0, -1, 1 };

    int function(int[][] board) {

        int R = board.length;
        int C = board[0].length;

        boolean[][] vis = new boolean[R][C];

        Queue<Cordinates> q = new LinkedList<>();

        // 1st row
        for (int i = 0; i < R; i++) { // last row
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 1 && (i == 0 || j == 0 || i == R - 1 || j == C - 1)) {
                    q.add(new Cordinates(i, j));
                    vis[i][j] = true;
                }
            }
        }

        while (q.size() > 0) {

            Cordinates polled = q.poll();

            for (int i = 0; i < x_ngbr.length; i++) {
                int nx = polled.x + x_ngbr[i];
                int ny = polled.y + y_ngbr[i];

                if (nx >= 0 && nx < R & ny >= 0 && ny < C && !vis[nx][ny] && board[nx][ny] == 1) {
                    q.add(new Cordinates(nx, ny));
                    vis[nx][ny] = true;
                }
            }

        }

        // 1st row
        int count = 0;
        for (int i = 0; i < R; i++) { // last row
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }

        return count;

    }
}
