import java.util.*;

/**
 * 
 * leetcode id : 994
 * 
 * 
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * 
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * 
 * 
 * 
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
 *  using BFS
 * 
 * 
 */

class x10_rotten_oranges {

    public static void main(String[] args) {

        // int[][] arr = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }; //expected : 4

        int[][] arr = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }; //expected : -1

        int ans = new Solution().function(arr);
        System.out.println(ans);

    }

}

class Q_obj {
    int x;
    int y;
    int time;

    Q_obj(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.time = t;
    }
}

class Solution {

    int EMPTY = 0;
    int FRESH = 1;
    int ROTTEN = 2;

    int[] x_ngbr = { -1, 1, 0, 0 };
    int[] y_ngbr = { 0, 0, 1, -1 };

    int function(int[][] arr) {

        Queue<Q_obj> q = new LinkedList<>();

        int rows = arr.length;
        int cols = arr[0].length;

        int answer = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == ROTTEN) {
                    q.offer(new Q_obj(i, j, 0));
                }
            }
        }

        while (q.size() > 0) {

            Q_obj popped = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = popped.x + x_ngbr[i];
                int ny = popped.y + y_ngbr[i];

                if (is_safe(arr, nx, ny) && arr[nx][ny] == FRESH) {
                    int new_time = popped.time + 1;
                    q.add(new Q_obj(nx, ny, new_time));
                    arr[nx][ny] = ROTTEN; //update status
                    answer = Math.max(answer, new_time);
                }

            }

        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == FRESH) {
                    return -1;
                }
            }
        }

        return answer;

    }

    boolean is_safe(int[][] graph, int x, int y) {
        int rows = graph.length;
        int cols = graph[0].length;
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }
}
