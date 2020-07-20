import java.util.*;

/**
 * 
 * Given an array of size N consisting of only 0's and 1's. 
 * The array is sorted in such a manner that all the 1's are placed first and then they are followed by all the 0's. 
 * 
 * Find the count of all the 0's.
 *  
 * 
 */

/**
 * =============
 * approach   : 
 * =============
 * using binary search with repeated elements
 *  
 * TC= O(log n)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p16_count_zeros {

    public static void main(String[] args) {

        // int arr[] = { 1, 1, 1, 1, 1, 1, 1, 0, 0 }; //2 zeros
        // int arr[] = { 1, 0, 0, 0, 0 }; //4 zeros
        // int arr[] = { 0, 0, 0, 0, 0 }; //5 zeros
        int arr[] = { 1, 1, 1, 1, }; //no zeros

        function(arr);
    }

    static void function(int arr[]) {

        int high = arr.length - 1;
        int low = 0;
        int mid = 0;

        int first_idx_of_zero = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (arr[mid] == 0) {
                if (mid == 0 || arr[mid - 1] == 1) {
                    first_idx_of_zero = mid;
                    break;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (first_idx_of_zero == -1) {
            System.out.println("total 0's are : " + 0);
            return;
        }

        int num_of_0 = arr.length - first_idx_of_zero;
        System.out.println("total 0's are : " + num_of_0);

    }

}