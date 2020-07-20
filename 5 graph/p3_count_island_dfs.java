import java.util.*;

/**
 * 
 * leetcode id : 200
 * 
 * Given a binary 2D matrix, each 0 represents water block , and 1 means land
 * 
 * a group of 1's adjacent horizontally n vertically can be grouped to form 1 island
 * 
 * find the number of islands. 
 * 
 * 
 * https://www.geeksforgeeks.org/find-number-of-islands/
 *  
 */

/**
 * 
 * ============
 * approach :
 * ============
 * 
 * iterate each cell of matrix
 * use dfs when 1 is found and marks subsequent 1s as visited
 * 
 * https://www.geeksforgeeks.org/find-number-of-islands/
 * or
 * https://www.youtube.com/watch?v=__98uL6wst8&ab_channel=TECHDOSE
 * 
 * TC=O(R.C)
 * SC=O(R.C)
 *   
 * 
 * 
 */

class p3_count_island_dfs {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        int answer = Solution.function(matrix);
        System.out.println(answer);
    }

}

class Solution {

    static int function(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int island_count = 0;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    island_count++;
                    dfs(i, j, visited, matrix);
                }
            }
        }

        return island_count;

    }

    static void dfs(int row, int col, boolean[][] visited, int[][] matrix) {
        if (is_safe(row, col, visited, matrix)) {
            visited[row][col] = true;
            dfs(row + 1, col, visited, matrix);
            dfs(row - 1, col, visited, matrix);
            dfs(row, col + 1, visited, matrix);
            dfs(row, col - 1, visited, matrix);
        }
    }

    static boolean is_safe(int row, int col, boolean[][] visited, int[][] matrix) {
        int total_rows = visited.length;
        int total_cols = visited[0].length;
        if (row < total_rows && col < total_cols && row >= 0 && col >= 0 && visited[row][col] == false
                && matrix[row][col] == 1) {
            return true;
        }
        return false;
    }

}