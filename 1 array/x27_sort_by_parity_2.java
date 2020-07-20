import java.util.*;

/**
 * leetcode id : 922
 * 
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * 
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: [4,2,5,7]
 * 
 * Output: [4,5,2,7]
 * 
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * 
 *  similar to previous qstn  , but here we use 2 pointers,
 * 
 * one for even indices
 * other for odd
 * 
 * increment each by 2
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x27_sort_by_parity_2 {

    public static void main(String[] args) {

        int[] arr = { 4, 2, 5, 7 };
        // int[] arr = { 4, 1, 2, 1 };

        int[] answer = function(arr);

        // System.out.println(answer);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] function(int[] arr) {

        int n = arr.length;

        int i = 0;
        int j = 1;

        while (i < n && j < n) {

            while (i < n && j < n && i % 2 == 0 && arr[i] % 2 == 0)
                i += 2;
            // i++;

            while (i < n && j < n && j % 2 == 1 && arr[j] % 2 == 1)
                j += 2;
            // j--;

            if (i < n && j < n) {
                swap(arr, i, j);
                // i++;
                // j--;
                i += 2;
                j += 2;
            }

        }

        return arr;

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
