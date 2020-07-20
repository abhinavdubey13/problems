import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/find-sum-of-all-elements-in-a-matrix-except-the-elements-in-given-row-andor-column-2/
 * 
 * Given a 2D matrix and a set of cell indexes e.g., an array of (i, j) where i indicates row and j column. 
 * For every given cell index (i, j), find sums of all matrix elements except the elements present in i’th row and/or j’th column.
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 
 * An Efficient Solution can compute all sums in O(R x C + n) time. The idea is to precompute total sum, row and column sums before processing the given array of indexes. Below are details
1. Calculate sum of matrix, call it sum.
2. Calculate sum of individual rows and columns. (row[] and col[])
3. For a cell index (i, j), the desired sum will be “sum- row[i] – col[j] + arr[i][j]”
 * 
 * 
 * ============
 * TC : O(R x C + n)
 * SC : O(R + C)
 * 
 *  
 */

class p19_matrix_sum_except_cells_in_given_row_column {

    public static void main(String[] args) {

        int[][] arr = { { 1, 1, 2 }, { 3, 4, 6 }, { 5, 3, 2 } };

        int[][] cells = { { 0, 0 }, { 1, 1 }, { 0, 1 } };

        int[] answer = Solution.function(arr, cells);

        for (int i : answer) {
            System.out.println(i);
        }

    }

}

class Solution {

    static int[] function(int[][] arr, int[][] cells) {

        int rows = arr.length;
        int cols = arr[0].length;

        int[] row_sum = new int[rows];
        int[] col_sum = new int[cols];

        Arrays.fill(row_sum, 0);
        Arrays.fill(col_sum, 0);
        int overall_sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curr = arr[i][j];
                overall_sum += curr;
                row_sum[i] += curr;
                col_sum[j] += curr;
            }
        }

        int[] answer = new int[cells.length];

        for (int i = 0; i < cells.length; i++) {
            int row_remove = cells[i][0];
            int col_remove = cells[i][1];
            answer[i] = overall_sum - row_sum[row_remove] - col_sum[col_remove] + arr[row_remove][col_remove];
        }

        return answer;

    }

}
