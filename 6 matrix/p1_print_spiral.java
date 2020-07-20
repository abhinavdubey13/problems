import java.util.*;

/**
 * 
 * leetcode : 54
 * 
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *  
 */

/**
 * 
 * https://www.youtube.com/watch?v=SVFXEqn3Ceo&ab_channel=Pepcoding
 * 
 * 
 * using 
 * min_row , min_col 
 * max_row , max_col
 * as pointers
 * 
 * to print top-row , right-row , bottom-row , left-row 
 * 
 * TC=(M.N)
 * SC=O(1)
 * 
 */

class p1_print_spiral {

    public static void main(String[] args) {

        //4x4 matrix
        // int arr[][] = { { 2, 4, 6, 8 }, { 5, 9, 12, 16 }, { 2, 11, 5, 9 }, { 3, 2, 1, 8 } };

        //3x3 matrix
        // int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // 4x3 matrix
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        List<Integer> answer = Solution.function(arr);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

class Solution {
    static List<Integer> function(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        int min_row = 0;
        int min_col = 0;

        int max_row = rows - 1;
        int max_col = cols - 1;

        int counter = 0;
        int total = rows * cols;

        List<Integer> answer = new LinkedList<>();

        //IMPORTANT : counter <= total will not work
        while (counter < total) {

            //top wall
            for (int i = min_row, j = min_col; j <= max_col && counter < total; j++) {
                answer.add(arr[i][j]);
                counter++;
            }
            min_row++;

            //right wall
            for (int i = min_row, j = max_col; i <= max_row && counter < total; i++) {
                answer.add(arr[i][j]);
                counter++;
            }
            max_col--;

            //bottom wall
            for (int i = max_row, j = max_col; j >= min_col && counter < total; j--) {
                answer.add(arr[i][j]);
                counter++;
            }
            max_row--;

            //left wall
            for (int i = max_row, j = min_col; i >= min_row && counter < total; i--) {
                answer.add(arr[i][j]);
                counter++;
            }
            min_col++;

        }

        return answer;

    }
}
