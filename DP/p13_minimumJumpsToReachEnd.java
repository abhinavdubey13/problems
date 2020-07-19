//given an array , A[] , each cell A[i] represents the number of steps we can take from this cell , find the min jump required to reach the end of the array ie A[n-1]

/**
 * dp-array = 1D
 * array-filling => i= from 1 to n  &&  for each i : j = fom 0  to i-1
 * 
 * table[i] = min steps to reach i'th index 
 * 
 * 
 */


import java.util.ArrayList;
import java.util.Arrays;

class p13_minimumJumpsToReachEnd {

    public static void main(String[] args) {

        // int[] arr = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
        // int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        int[] arr = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        int answer = calulator(arr);
        System.out.println(answer);
    }

    static int calulator(int[] arr) {

        int[] table = new int[arr.length];

        table[0] = 0;

        for (int destinationIndex = 1; destinationIndex < arr.length; destinationIndex++) {
            table[destinationIndex] = 10000;
            for (int startIndex = 0; startIndex < destinationIndex; startIndex++) {

                if (startIndex + arr[startIndex] >= destinationIndex) {
                    table[destinationIndex] = Math.min(table[destinationIndex], 1 + table[startIndex]);
                }

            }
        }
        return table[table.length - 1];
    }
}