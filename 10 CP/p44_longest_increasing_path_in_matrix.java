import java.util.*;

/**
 * 
 * leetcode id : 329
 * 
 * 
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * From each cell, you can either move in four directions: left, right, up, or down. 
 * 
 * You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 * 
 * 
 * 
 */

/**
 * 
 *
 * using DFS and DP
 * 
 * to avoid recalculations 
 * 
 * 
 * it will not fall into infinite loop : bcz if the constraint , we can move to strictly increasing neighbout
 * which is one way relation
 *
 *
 * 
 * 
 */

class p44_longest_increasing_path_in_matrix {

    public static void main(String[] args) {
        // int[][] arr = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };

        int[][] arr = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 2, 1 } };

        // int[][] arr = { { 1 } };

        int answer = new Solution().function(arr);
        System.out.println(answer);
    }
}

class Solution {

    int ROWS;
    int COLS;

    Map<String, Integer> cache;

    int function(int[][] arr) {
        ROWS = arr.length;
        COLS = arr[0].length;
        cache = new HashMap<>();
        int answer = 1;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int temp = dfs(arr, i, j, null);
                answer = Math.max(answer, temp);

            }
        }
        return answer;
    }

    int dfs(int[][] arr, int x, int y, Integer prev) {

        if (!is_safe(x, y)) {
            return 0;
        }

        int curr = arr[x][y];

        if (prev != null && prev >= curr) {
            return 0;
        }

        String key = x + "@" + y;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int a = dfs(arr, x + 1, y, curr);
        int b = dfs(arr, x - 1, y, curr);
        int c = dfs(arr, x, y - 1, curr);
        int d = dfs(arr, x, y + 1, curr);
        int ans = Math.max(Math.max(a, b), Math.max(c, d)) + 1;
        cache.put(key, ans);
        return ans;

    }

    boolean is_safe(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS;
    }

}