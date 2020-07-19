//given a 2D array , each cell representing a cost , find min cost to go from top-left corner to bottom-right corner
//we can move either right or below any particular cell


/**
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom  
 * 
 * 
 * table[i][j] = min cost to reach [i][j]
 * 
 *  table[i][j] = min ( cost to reach [i-1][j] , cost to reach [i][j-1] )
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

class p14_minCost2D {

    public static void main(String[] args) {
        int[][] arr = { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 } };
        int answer = calulator(arr);
        System.out.println(answer);
    }

    static int calulator(int[][] arr) {

        int[][] table = new int[arr.length][arr[0].length];

        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[0].length; column++) {

                if (row == 0) {
                    table[0][column] = (column == 0) ? arr[0][0] : table[0][column - 1] + arr[0][column];
                    continue;
                }

                if (column == 0) {
                    table[row][0] = (row == 0) ? arr[0][0] : table[row - 1][0] + arr[row][0];
                    continue;
                }

                table[row][column] = arr[row][column] + Math.min(table[row - 1][column], table[row][column - 1]);

            }
        }
        return table[arr.length - 1][arr[0].length - 1];
    }
}