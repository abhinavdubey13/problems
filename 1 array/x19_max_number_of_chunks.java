import java.util.*;

/**
 * leetcode ID : 769
 * 
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
 * we split the array into some number of "chunks" (partitions), and individually sort each chunk. 
 * After concatenating them, the result equals the sorted array
 * 
 * What is the most number of chunks we could have made
 * 
 * ===========
 * example -1
 * ===========
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * 
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * 
 * 
 * 
 */

/**
 *   
 * ===========
 * approach : 
 * ===========
 * 
 * We know that our arr is permutation of array 0,1,2,3,..., N-1.
 * 
 * This means that seeing some value in array we know "proper" index of this, 4 should be under index 4, 2 under 2 and so on.
 * 
 * We may observe that we are able to sort subarray only if during iterating through array max value in array till now was equals to current index.
 * 
 * So we need only to keep track of current index, and max value till now, and of course counter. And increment this counter when max==idx.
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x19_max_number_of_chunks {

    public static void main(String[] args) {

        int[] arr = { 4, 3, 2, 1, 0 }; // expected =1
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

        int max = arr[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }

}
