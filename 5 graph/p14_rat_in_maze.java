import java.util.*;

/**
 * 
 *
 *  
 */

/**
 * 
 * ============
 * approach :
 * ============

 *   
 * 
 * 
 */

class p14_rat_in_maze {

    static boolean is_safe(int row, int col, boolean[][] visited, int[][] matrix) {
        int total_rows = visited.length;
        int total_cols = visited[0].length;
        if (row < total_rows && col < total_cols && row >= 0 && col >= 0 && visited[row][col] == false
                && matrix[row][col] == 1) {
            return true;
        }
        return false;
    }

    static int count_paths_util(int row, int col, boolean[][] visited, int[][] matrix) {
        boolean y = is_safe(row, col, visited, matrix);
        if (!y) {
            return 0;
        }

        else if (row == matrix.length-1 && col == matrix[0].length-1) {
            return 1;
        }

        visited[row][col] = true;

        int t = count_paths_util(row - 1, col, visited, matrix);
        int b = count_paths_util(row + 1, col, visited, matrix);       
        int l = count_paths_util(row, col - 1, visited, matrix);
        int r = count_paths_util(row, col + 1, visited, matrix);


        visited[row][col] = false;
        int x = l + r + t + b;
        return x;
    }

    static int count_paths(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int paths = count_paths_util(0, 0, visited, matrix);
        return paths;
    }

    public static void main(String[] args) {

        // int[][] matrix = { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 1, 1 } };

        // int[][] matrix = { { 1, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };

        // int[][] matrix = { { 1, 0, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };

        int matrix[][] = { { 1, 0, 0, 0 }, 
        { 1, 1, 0, 1 }, 
        { 0, 1, 0, 0 }, 
        { 1, 1, 1, 1 } }; 

        System.out.println(count_paths(matrix));
    }

}
