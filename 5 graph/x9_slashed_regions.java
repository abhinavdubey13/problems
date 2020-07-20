import java.util.*;

/**
 * 
 * leetcode id : 959
 * 
 * 
 * In a N x N grid composed of 1 x 1 squares, 
 * each 1 x 1 square consists of a /, \, or blank space.  
 * These characters divide the square into contiguous regions.
 * 
 * (Note that backslash characters are escaped, so a \ is represented as "\\".)
 * 
 * Return the number of regions.
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
 * convert it into count numer of island problem somehow (use DFS after that)
 * 
 * '/'  can be converted to
 * 
 * 001
 * 010
 * 100
 * 
 * 
 * 
 * '\\' can be converted to
 * 100
 * 010
 * 001 
 * 
 * 
 */

class x9_slashed_regions {

    public static void main(String[] args) {

        String[] arr = { " /", "/ " };

        int ans = Solution.function(arr);
        System.out.println(ans);

    }

}

class Solution {

    static int function(String[] arr) {

        int count = 0;

        int rows = arr.length;
        int cols = arr[0].length();

        int[][] graph = new int[rows * 3][cols * 3];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                char curr = arr[i].charAt(j);

                if (curr == '/') {
                    graph[i * 3][j * 3 + 2] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3 + 2][j * 3] = 1;
                } else if (curr == '\\') {
                    graph[i * 3][j * 3] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 0) {
                    count++;
                    dfs(graph, i, j);
                }
            }
        }
        return count;
    }

    static void dfs(int[][] graph, int x, int y) {

        if (!is_safe(graph, x, y) || graph[x][y] == 1) {
            return;
        }

        graph[x][y] = 1;

        dfs(graph, x + 1, y);//down
        dfs(graph, x - 1, y);//top
        dfs(graph, x, y + 1);//right
        dfs(graph, x, y - 1);//left

    }

    static boolean is_safe(int[][] graph, int x, int y) {
        int rows = graph.length;
        int cols = graph[0].length;
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }
}
