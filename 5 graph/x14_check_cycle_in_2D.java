import java.util.*;

/**
 * 
 * leetcode id : 1559
 * 
 * Given a 2D array of characters grid of size m x n, 
 * you need to find if there exists any cycle consisting of the same value in grid.
 * 
 * A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. 
 * From a given cell, you can move to one of the cells adjacent to it - in one of the four directions 
 * (up, down, left, or right), if it has the same value of the current cell.
 * 
 * Also, you cannot move to the cell that you visited in your last move. 
 * For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
 * 
 * Return true if any cycle of the same value exists in grid, otherwise, return false.
 * 
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * dfs
 * 
 *
 * 
 * 
 * 
 */

class x14_check_cycle_in_2D {

    public static void main(String[] args) {

        char[][] arr = { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' },
                { 'a', 'a', 'a', 'a' } };

        // char[][] arr = { { 'a', 'a' }, { 'a', 'a' } };

        // char[][] arr = { { 'a', 'b', 'b' }, { 'b', 'z', 'b' }, { 'b', 'b', 'a' } };

        boolean ans = new Solution().function(arr);
        System.out.println(ans);

    }

}

class Solution {

    boolean answer;

    int[] x_ngbr = { 0, 0, -1, 1 };
    int[] y_ngbr = { 1, -1, 0, 0 };

    boolean function(char[][] graph) {

        int rows = graph.length;
        int cols = graph[0].length;

        answer = false;

        boolean[][] vis = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                answer = false;
                dfs(graph, vis, i, j, i, j, graph[i][j]);
                if (answer) {
                    return true;
                }
            }
        }

        return false;

    }

    void dfs(char[][] graph, boolean[][] vis, int prev_x, int prev_y, int cx, int cy, char value) {

        if (!is_safe(graph, vis, cx, cy) || graph[cx][cy] != value) {
            return;
        }

        // else if (cx == sx && cy == sy && cells > 1) {
        if (vis[cx][cy]) {
            answer = true;
            // vis[cx][cy] = false;
            return;
        }

        vis[cx][cy] = true;

        for (int i = 0; i < x_ngbr.length; i++) {
            int nx = cx + x_ngbr[i];
            int ny = cy + y_ngbr[i];

            if (nx == prev_x && ny == prev_y) {
                continue;
            } else {
                dfs(graph, vis, cx, cy, nx, ny, value);
            }
        }

        vis[cx][cy] = false;

    }

    boolean is_safe(char[][] graph, boolean[][] vis, int x, int y) {
        int rows = graph.length;
        int cols = graph[0].length;
        return (x >= 0 && x < rows && y >= 0 && y < cols);

        // return (x >= 0 && x < rows && y >= 0 && y < cols && !vis[x][y]);

    }

}
