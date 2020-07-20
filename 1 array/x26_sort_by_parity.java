import java.util.*;

/**
 * leetcode id : 905
 * 
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * 
 * you may return any answer array that satisfies this condition.
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: [3,1,2,4]
 * 
 * Output: [2,4,3,1]
 * 
 * outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
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
 * same as sorting an array of 0's and 1's
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x26_sort_by_parity {

    public static void main(String[] args) {

        // int[] arr = { 2, 0, 9, 1, 0, 2, 4 };
        int[] arr = { 3, 1, 2, 4 };

        int[] answer = function(arr);

        // System.out.println(answer);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] function(int[] arr) {

        int n = arr.length;

        int start = 0;
        int end = n - 1;

        while (start < end) {

            if (arr[start] % 2 == 1) {

                swap(arr, start, end);
                end--;

            } else {
                start++;
            }

        }

        return arr;

    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
