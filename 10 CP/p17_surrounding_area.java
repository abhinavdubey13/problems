import java.util.*;

/**
 * 
 * LC id : 130
 * 
 * 
 *  
 */

/**
 * 
 * 
 * 
 * 
 * 
 */

class p17_surrounding_area {

    public static void main(String[] args) {

        // char[][] arr = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
        //         { 'X', 'O', 'X', 'X' } };

        char[][] arr = { { 'X' } };

        new Solution().function_util(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Solution {

    void function_util(char[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < cols; i++) {
            dfs(arr, 0, i);
            dfs(arr, rows - 1, i);
        }

        for (int i = 0; i < rows; i++) {
            dfs(arr, i, 0);
            dfs(arr, i, cols - 1);
        }

        // System.out.println();
        // improvise
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 'a') {
                    arr[i][j] = 'O';
                } else if (arr[i][j] == 'O') {
                    arr[i][j] = 'X';
                }
            }
        }

    }

    void dfs(char[][] arr, int x, int y) {
        if (is_safe(arr, x, y) && arr[x][y] == 'O') {
            arr[x][y] = 'a';
            dfs(arr, x + 1, y);
            dfs(arr, x - 1, y);
            dfs(arr, x, y + 1);
            dfs(arr, x, y - 1);
        }
    }

    boolean is_safe(char[][] arr, int x, int y) {
        int rows = arr.length;
        int cols = arr[0].length;
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }

}
