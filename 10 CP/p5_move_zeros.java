import java.util.*;

/**
 * 
 * leetcode id : 283
 * 
 * 
 * Given an array , write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * 
 *  
 */

/**
 * 
 * 
 * move all non zero in front in advance
 * 
 * then fill remaining cells with 0
 *
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class p5_move_zeros {

    public static void main(String[] args) {

        // int[] arr = { 0, 1, 0, 3, 12 };

        // int[] arr = { 0,0,0,0 };

        // int[] arr = { 1 };

        // int[] arr = { 1,2,3,4 };

        int[] arr = { 0, 0, 0, 1, 2 };

        Solution_optimised.function(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}

class Solution_brute_force {

    static void function(int[] arr) {

        int n = arr.length;

        int i = 0;
        int j = 0;

        for (; i < n;) {

            //find zero element idx
            while (i < n && arr[i] != 0) {
                i++;
            }

            //find non-zero element idx
            j = i;
            while (j < n && arr[j] == 0) {
                j++;
            }

            if (i < n && j < n) {
                swap(arr, i, j);
                i = i + 1;
            } else {
                return;
            }

        }

    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

class Solution_optimised {

    static void function(int[] arr) {

        int n = arr.length;
        int j = 0;

        // move all the nonzero elements advance
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }

        for (; j < n; j++) {
            arr[j] = 0;
        }
    }

}