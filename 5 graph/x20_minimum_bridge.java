import java.util.*;

/**
 * 
 * leetcode id : 934
 * 
 * 
 * In a given 2D binary array A, there are two islands.  
 * (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 * 
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * 
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
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
 * using BFS
 * 
 * 
 * gather cordinates of any 1 island 
 * 
 * using those cordinated , move 1 step towards other island using BFS
 * 
 * 
 * 
 *
 * 
 */

class x20_minimum_bridge {

    public static void main(String[] args) {

        //expected : 1
        int[][] matrix = { { 0, 1 }, { 1, 0 } };

        //expected : 2
        // int[][] matrix = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };

        //expected : 1
        // int[][] matrix = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 },
        //         { 1, 1, 1, 1, 1 } };

        int answer = new Solution().function(matrix);

        System.out.println(answer);

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

class Helper {
    LinkedList<Cell> q;
    Set<String> island;

    Helper(LinkedList<Cell> q, Set<String> island) {
        this.q = q;
        this.island = island;
    }
}

class Solution {

    int[] x_ngbr = { -1, 1, 0, 0 };
    int[] y_ngbr = { 0, 0, -1, 1 };

    int function(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;

        Helper h = get_1st_island_cells(matrix);
        Queue<Cell> island_1_q = h.q;
        Set<String> island_1_set = h.island;

        Set<String> vis = new HashSet<>();

        int timer = 0;

        while (island_1_q.size() > 0) {

            int n = island_1_q.size();

            timer++;
            for (int i = 0; i < n; i++) {
                Cell polled = island_1_q.poll();

                for (int j = 0; j < x_ngbr.length; j++) {
                    int nx = polled.x + x_ngbr[j];
                    int ny = polled.y + y_ngbr[j];
                    String key = nx + "@" + ny;

                    if (is_safe(nx, ny, R, C) && !island_1_set.contains(key) && !vis.contains(key)) {
                        if (matrix[nx][ny] == 1) {
                            return timer - 1;
                        } else {
                            island_1_q.add(new Cell(nx, ny));
                            vis.add(key);
                        }
                    }
                }
            }
        }

        return -1;

    }

    Helper get_1st_island_cells(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        Set<String> vis = new HashSet<>();
        Queue<Cell> q = new LinkedList<>();
        LinkedList<Cell> return_q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            boolean found = false;
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1) {
                    q.offer(new Cell(i, j));
                    vis.add(i + "@" + j);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        while (q.size() > 0) {
            Cell polled = q.poll();
            return_q.offer(new Cell(polled.x, polled.y));

            for (int i = 0; i < x_ngbr.length; i++) {
                int nx = polled.x + x_ngbr[i];
                int ny = polled.y + y_ngbr[i];
                if (is_safe(nx, ny, R, C) && !vis.contains(nx + "@" + ny) && matrix[nx][ny] == 1) {
                    q.offer(new Cell(nx, ny));
                    vis.add(nx + "@" + ny);
                }
            }
        }

        return new Helper(return_q, vis);

    }

    boolean is_safe(int x, int y, int R, int C) {
        return (x >= 0 && x < R && y >= 0 && y < C);
    }

}
