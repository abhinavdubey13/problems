
// Given a M X N matrix with your initial position at the top-left cell, find the number of possible unique paths to reach the bottom-right cell of the matrix from the initial position.
//Note: Possible moves can be either down or right at any point in time, i.e., we can move to matrix[i+1][j] or matrix[i][j+1] from matrix[i][j].

/**
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom  
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

class p16_pathsToReacBottom {

    public static void main(String[] args) {
        int numRows = 3;
        int numCols = 4;
        int answer = calulator(numRows, numCols);
        System.out.println(answer);
    }

    static int calulator(int numRows, int numCols) {
        int[][] table = new int[numRows][numCols];

        // first column
        for (int i = 0; i < numCols; i++) {
            table[0][i] = 1;
        }

        // first row
        for (int i = 0; i < numRows; i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }

        return table[numRows - 1][numCols - 1];
    }
}