
import java.util.*;

/**
 *
 * leetcode id : 417
 * 
 * You are given an m x n integer matrix heights representing the height of each unit cell in a continent. 
 * The Pacific ocean touches the continent's left and top edges, and 
 * the Atlantic ocean touches the continent's right and bottom edges.
 * 
 * Water can only flow in four directions: up, down, left, and right. 
 * Water flows from a cell to an adjacent one with an equal or lower height.
 * 
 * Return a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.
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
 *
 * 1 .Two Queue and add all the Pacific border to one queue; Atlantic border to another queue.
 * 
 * 2. Keep a visited matrix for each queue. In the end, add the cell visited by two queue to the result.
 * 
 * BFS: Water flood from ocean to the cell. 
 * Since water can only flow from high/equal cell to low cell, add the neighboor cell 
 * with height larger or equal to current cell to the queue and mark as visited.
 *
 */

class x34_pacific_atlantic {

    public static void main(String[] args) {

        int[][] heights = { { 12, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };

        List<List<Integer>> answer = new Solution().function(heights);

        System.out.println(answer);
    }

}

class Solution {

    int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<List<Integer>> function(int[][] heights) {

        List<List<Integer>> res = new LinkedList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) { //Vertical border
            pQueue.offer(new int[] { i, 0 });
            aQueue.offer(new int[] { i, m - 1 });
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        for (int i = 0; i < m; i++) { //Horizontal border
            pQueue.offer(new int[] { 0, i });
            aQueue.offer(new int[] { n - 1, i });
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }
        bfs(heights, pacific, pQueue);
        bfs(heights, atlantic, aQueue);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;

    }

    void bfs(int[][] heights, boolean[][] vis, Queue<int[]> q) {
        int R = heights.length;
        int C = heights[0].length;
        while (q.size() > 0) {
            int[] polled = q.poll();
            for (int i = 0; i < direction.length; i++) {
                int nx = polled[0] + direction[i][0];
                int ny = polled[1] + direction[i][1];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    int next_ht = heights[nx][ny];
                    int curr_ht = heights[polled[0]][polled[1]];
                    if (!vis[nx][ny] && next_ht >= curr_ht) {
                        vis[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
    }
}
