import java.util.*;

/**
 * 
 * Given an array, reverse every sub-array formed by consecutive k elements.
 * 
 * https://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/
 * 
 * 
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * Consider every sub-array of size k starting from the beginning of the array and reverse it. 
 * 
 * We need to handle some special cases. If N is not multiple of K (where N is the size of the array ):
 * for the last group we will have less than k elements left, we need to reverse all remaining elements. 
 * 
 * 
 * If k = 1, the array should remain unchanged. If k >= n, we reverse all elements present in the array.
 * 
 * TC= O(N)
 * SC= O(1) 
 * 
 */

class p40_reverse_arr_in_group_of_K {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 3;

        function(arr, k);

        //printing
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void function(int arr[], int k) {

        if (k <= 1) {
            return;
        }

        //reverser the entire array when k>=arr.len
        if (k >= arr.length) {
            reverser_arr(arr, 0, arr.length - 1);
            return;
        }

        // 2 <= K < arr.length
        for (int i = 0; i < arr.length; i += k) {
            int start = i;
            int end = Math.min(arr.length - 1, start + k - 1);
            reverser_arr(arr, start, end);
        }

    }

    static void reverser_arr(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
