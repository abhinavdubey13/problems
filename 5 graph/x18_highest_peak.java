import java.util.*;

/**
 * 
 * leetcode id : 1765
 * 
 * 
 * You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
 * 
 * If isWater[i][j] == 0, cell (i, j) is a land cell.
 * If isWater[i][j] == 1, cell (i, j) is a water cell.
 * 
 * You must assign each cell a height in a way that follows these rules:
 * 
 * The height of each cell must be non-negative.
 * If the cell is a water cell, its height must be 0.
 * 
 * Any two adjacent cells must have an absolute height difference of at most 1. 
 * A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
 * 
 * Find an assignment of heights such that the maximum height in the matrix is maximized.
 * 
 * Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. 
 * 
 * If there are multiple solutions, return any of them.
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * using BFS and visited set
 * 
 * assign all water in queue initially , 
 * 
 * then use that queue and timer
 *
 *
 * 
 */

class x18_highest_peak {

    public static void main(String[] args) {

        int[][] matrix = { { 0, 1 }, { 0, 0 } };

        int[][] answer = new Solution().function(matrix);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                System.out.print(answer[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();

    }

}

class Cell {
    int x;
    int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    final int WATER = 1;
    final int LAND = 0;

    int[][] function(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;

        int[][] ans = new int[R][C];

        Queue<Cell> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == WATER) {
                    q.add(new Cell(i, j));
                    ans[i][j] = 0;
                    vis.add("" + i + "@" + j);
                }
            }
        }

        int timer = 1;
        while (q.size() > 0) {

            int n = q.size();

            for (int i = 0; i < n; i++) {
                Cell polled = q.poll();

                int x1 = polled.x + 1;
                int y1 = polled.y;

                int x2 = polled.x - 1;
                int y2 = polled.y;

                int x3 = polled.x;
                int y3 = polled.y + 1;

                int x4 = polled.x;
                int y4 = polled.y - 1;

                if (isSafe(x1, y1, R, C) && !vis.contains("" + x1 + "@" + y1)) {
                    ans[x1][y1] = timer;
                    vis.add("" + x1 + "@" + y1);
                    q.add(new Cell(x1, y1));

                }

                if (isSafe(x2, y2, R, C) && !vis.contains("" + x2 + "@" + y2)) {
                    ans[x2][y2] = timer;
                    vis.add("" + x2 + "@" + y2);
                    q.add(new Cell(x2, y2));

                }

                if (isSafe(x3, y3, R, C) && !vis.contains("" + x3 + "@" + y3)) {
                    ans[x3][y3] = timer;
                    vis.add("" + x3 + "@" + y3);
                    q.add(new Cell(x3, y3));


                }

                if (isSafe(x4, y4, R, C) && !vis.contains("" + x4 + "@" + y4)) {
                    ans[x4][y4] = timer;
                    vis.add("" + x4 + "@" + y4);
                    q.add(new Cell(x4, y4));

                }
            }

            timer++;

        }

        return ans;

    }

    boolean isSafe(int x, int y, int R, int C) {
        return (x >= 0 && x < R && y >= 0 && y < C);
    }

}