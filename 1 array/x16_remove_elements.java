import java.util.*;

/**
 * 
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3]
 * 
 * Explanation: Your function should return length = 5, 
 * with the first five elements of nums containing 0, 1, 3, 0, and 4. 
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 * 
 * 
 * 
 * 
 */

/**
 *  
 * 
 * 
 * 
 * ============
 * approach : 
 * ============
 * 
 * return arr.len - (count of value to be removed)
 * 
 * for rearrangement , we use the concept in the problem : sort array of 0's and 1's
 *
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x16_remove_elements {

    public static void main(String[] args) {

        // int[] arr = { 2, 0, 9, 1, 0, 2, 4 };
        int[] arr = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val_to_be_removed = 2;

        int len = function(arr, val_to_be_removed);

        // System.out.println(answer);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int function(int[] arr, int val_to_be_removed) {

        int count = 0;
        for (int i : arr) {
            count += (i == val_to_be_removed) ? 1 : 0;
        }
        int result = arr.length - count;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            if (arr[low] == val_to_be_removed) {
                swap(arr, low, high);
                high--;
            } else {
                low++;
            }
        }

        return result;
    }

    static void swap(int[] arr, int idx_1, int idx_2) {
        int temp = arr[idx_1];
        arr[idx_1] = arr[idx_2];
        arr[idx_2] = temp;
    }

}
