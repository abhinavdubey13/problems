import java.util.*;

/**
 * leetcode ID : 768
 * 
 * This question is the same as "Max Chunks to Make Sorted" except
 * 
 * the integers of the given array are not necessarily distinct, 
 * the input array could be up to length 2000, and 
 * the elements could be up to 10**8.
 * 
 */

/**
 *   
 * ===========
 * approach : 
 * ===========
 * use extra arr to copy
 * and then sort the copy array
 * 
 * use prefix sum ie. ( sum arr[0...i] , including i'th element)
 * of the arr and copy_arr to check the number of chunks
 *  
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class x19_max_number_of_chunks {

    public static void main(String[] args) {

        int[] arr = { 14, 13, 12, 11, 10 }; // expected =1
        // int[] arr = { 1, 0, 2, 3, 4 }; // expected=4
        // int[] arr = { 2, 0, 1 }; // expected =1

        int answer = function(arr);

        System.out.println(answer);
        // for (int i = 0; i < len; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
    }

    static int function(int[] arr) {

        int n = arr.length;
        int chunks = 0;

        int[] copy_arr = arr.clone();
        Arrays.sort(copy_arr);

        int sum_1 = 0;
        int sum_2 = 0;
        
        for (int i = 0; i < n; i++) {
            sum_1 += arr[i];
            sum_2 += copy_arr[i];
            if (sum_1 == sum_2) {
                chunks++;
            }
        }

        return chunks;
    }

}
