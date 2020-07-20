import java.util.*;

/**
 * 
 * leetcode id : 1091
 * 
 * 
 * 
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 * 
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * 
 * All the visited cells of the path are 0.
 * 
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * 
 * The length of a clear path is the number of visited cells of this path.
 * 
 * 
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * 
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
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
 * 
 * BFS
 * 
 * 
 */

class x11_shortest_clear_path {

    public static void main(String[] args) {

        int[][] arr = { { 0, 1 }, { 1, 0 } }; //expected : 2

        // int[][] arr = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }; //expected : 4

        int ans = new Solution().function(arr);
        System.out.println(ans);

    }

}

class Q_obj {
    int x;
    int y;
    int step;

    Q_obj(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.step = s;
    }
}

class Solution {

    int[] x_ngbr = { -1, 1, 0, 0, 1, 1, -1, -1 };
    int[] y_ngbr = { 0, 0, 1, -1, -1, 1, -1, 1 };

    int function(int[][] arr) {

        Queue<Q_obj> q = new LinkedList<>();

        int rows = arr.length;
        int cols = arr[0].length;

        if (rows == 1 && cols == 1) {
            return 0;
        }

        if (arr[0][0] == 1) {
            return -1;
        }

        q.offer(new Q_obj(0, 0, 0));

        while (q.size() > 0) {

            Q_obj popped = q.poll();

            for (int i = 0; i < x_ngbr.length; i++) {
                int nx = popped.x + x_ngbr[i];
                int ny = popped.y + y_ngbr[i];

                if (is_safe(arr, nx, ny) && arr[nx][ny] == 0) {
                    int new_step = popped.step + 1;
                    q.add(new Q_obj(nx, ny, new_step));
                    arr[nx][ny] = 1; //update status

                    if (nx == rows - 1 && ny == cols - 1) {
                        return new_step+1;
                    }
                }

            }

        }

        return -1;

    }

    boolean is_safe(int[][] graph, int x, int y) {
        int rows = graph.length;
        int cols = graph[0].length;
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }
}
