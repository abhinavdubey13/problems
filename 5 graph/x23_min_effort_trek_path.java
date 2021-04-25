import java.util.*;

/**
 * 
 * leetcode id : 1631
 * 
 * You are a hiker preparing for an upcoming hike. 
 * You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). 
 * 
 * You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
 * 
 * You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * 
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * 
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
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
 * using shortest path algo
 * 
 * 
 * 1 .Initialize all min efforts as Integer.MAX_VALUE/math.inf, except start(0, 0), which is 0;
 * 
 * 2. Use BFS to traverse all reachable cells from start, update the corresponding efforts whenever we can have a smaller value; 
 * otherwise, ignore that cell; Note: when forwarding one step on each path, update the current value with the currently found max effort value;
 * 
 * 3. Repeat 2 till all efforts reach their minimum values.
 * 
 * 4. Return the effort of end(m - 1, n - 1) as solution.
 * 
 * 
 * 
 *
 * 
 */

class x23_min_effort_trek_path {

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
        int answer = Solution.function(heights);
        System.out.println(answer);
    }

}

class Solution {

    static int[] x_ngbr = { -1, 1, 0, 0 };
    static int[] y_ngbr = { 0, 0, -1, 1 };

    static int function(int[][] heights) {

        int R = heights.length;
        int C = heights[0].length;

        int[][] effort = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        effort[0][0] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, 0 });

        while (q.size() > 0) {

            int[] polled = q.poll();
            int effort_cx_cy = polled[0];
            int cx = polled[1];
            int cy = polled[2];

            for (int i = 0; i < x_ngbr.length; i++) {
                int nx = cx + x_ngbr[i];
                int ny = cy + y_ngbr[i];

                //if safe
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    int effort_nx_ny = Math.max(effort_cx_cy, Math.abs(heights[cx][cy] - heights[nx][ny]));
                    
                    //if relaxable
                    if (effort[nx][ny] > effort_nx_ny) {
                        effort[nx][ny] = effort_nx_ny;
                        q.add(new int[] { effort[nx][ny], nx, ny });
                    }
                }
            }

        }

        return effort[R - 1][C - 1];

    }

}
