import java.util.*;

/**
 * 
 * 
 * leetcode id : 1254
 * 
 * Given a 2D grid consists of 0s (land) and 1s (water).  
 * 
 * An island is a maximal 4-directionally connected group of 0s and 
 * A closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * 
 * Return the number of closed islands.
 * 
 * 
 * 
 *
 * =========
 * example : 
 * ========
 * 
 * 
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation: Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * 
 * 
 * 
 */

/**
 * =============
 * APPROACH : 
 * =============
 * 
 * 
 * First, we need to remove all land connected to the edges using flood fill.
 * 
 * Then, we can count and flood-fill the remaining islands.
 * 
 * https://leetcode.com/problems/number-of-closed-islands/discuss/425150/JavaC%2B%2B-with-picture-Number-of-Enclaves
 * 
 * using dfs
 * 
 * 
 * 
 * 
 * 
 */

public class x4_count_island_2 {

    public static void main(String[] args) {

        int[][] graph = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };

        int answer = Solution.function(graph);
        System.out.println(answer);

    }

}

class Solution {

    static int LAND = 0;
    static int WATER = 1;

    static int function(int[][] graph) {

        int rows = graph.length;
        int cols = graph[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int answer = 0;

        //first row
        for (int i = 0; i < cols; i++) {
            if (graph[0][i] == 0) {
                flood_fill(0, i, rows, cols, graph);
            }
        }

        //last row
        for (int i = 0; i < cols; i++) {
            if (graph[rows - 1][i] == 0) {
                flood_fill(rows-1, i, rows, cols, graph);
            }
        }

        //first col
        for (int i = 0; i < rows; i++) {
            if (graph[i][0] == 0) {
                flood_fill(i, 0, rows, cols, graph);
            }
        }

        //last col
        for (int i = 0; i < rows; i++) {
            if (graph[i][cols - 1] == 0) {
                flood_fill(i, cols-1, rows, cols, graph);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(is_safe_and_unvisited(i, j, graph, visited)){
                    answer++;
                    dfs(i, j, graph, visited);
                }
            }
        }

        return answer;

    }

    static void flood_fill(int x, int y, int rows, int cols, int[][] graph) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && graph[x][y] == 0) {
            graph[x][y] = 1;
            flood_fill(x + 1, y, rows, cols, graph);
            flood_fill(x - 1, y, rows, cols, graph);
            flood_fill(x, y + 1, rows, cols, graph);
            flood_fill(x, y - 1, rows, cols, graph);
        }
    }

    static void dfs(int x, int y, int[][] graph, boolean[][] vis) {
        if (is_safe_and_unvisited(x, y, graph, vis)) {
            vis[x][y] = true;
            dfs(x - 1, y, graph, vis);
            dfs(x + 1, y, graph, vis);
            dfs(x, y - 1, graph, vis);
            dfs(x, y + 1, graph, vis);
        }
    }

    static boolean is_safe_and_unvisited(int x, int y, int[][] graph, boolean[][] vis) {
        int rows = graph.length;
        int cols = graph[0].length;
        return (x > 0 && x < rows && y > 0 && y < cols && graph[x][y] == LAND && !vis[x][y]);
    }

    // static boolean can_be_in_island(int x, int y, int[][] graph, boolean[][] vis) {
    //     int rows = graph.length;
    //     int cols = graph[0].length;
    //     return (x > 0 && x < rows && y > 0 && y < cols && graph[x][y] == LAND && !vis[x][y]);
    // }

}
