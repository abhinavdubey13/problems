import java.util.*;

/**
 * 
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * 
 * Recall that arr is a mountain array if and only if:
 * 
 * arr.length >= 3
 * 
 * There exists some i with 0 < i < arr.length - 1 such that:
 * 
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i] : STRICTLY IN-CREASING
 *  
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1] : STRICTLY DE-CREASING
 * 
 *
 * =========
 * examples
 * =========
 * 
 * Input: arr = [2,1]
 * Output: false
 * 
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * 
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 * 
 * 
 * 
 */

/**
 *  
 * ===========
 * approach : 1
 * ============
 * 
 * with 2 iterations :
 * 1. find the index with max value , if(max_idx==0 || max_idx==n) it means array is sorted , return false
 * 2. arr[0...max_idx] must be strictly increasing
 * 3. arr[max_idx+1 .... n] must be strictly decreasing
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * ============
 * approach : 2
 * ============
 * 
 * with 1 iterations : use 2 pointers
 * 1. increment start , if arr[start+1]>arr[start]
 * 2. decrement end , if arr[end-1]>arr[end]
 * 3. for any other case , break the loop
 * 
 * 4. check if start and end are equal
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x18_valid_mountain_array {

    public static void main(String[] args) {

        // int[] arr = { 0, 2, 3, 4, 5, 2, 1, 0 }; //true
        // int[] arr = { 3, 5, 5 }; //false
        // int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; //false
        // int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }; //false
        int[] arr = { 0, 1, 2, 1, 2 }; //false

        boolean answer = function_1_iteration(arr);

        System.out.println(answer);
        // for (int i = 0; i < len; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
    }

    //requires 2 iteration
    static boolean function_2_iteration(int[] arr) {

        if (arr.length < 3) {
            return false;
        }

        if (arr.length == 3) {
            return arr[1] > arr[0] && arr[1] > arr[2];
        }

        int max_idx = 0;
        for (int i = 0; i < arr.length; i++) {
            max_idx = (arr[i] > arr[max_idx]) ? i : max_idx;
        }

        //if array is sorted asc/desc order
        if (max_idx == arr.length - 1 || max_idx == 0) {
            return false;
        }

        boolean result = true;

        for (int i = 1; i <= max_idx; i++) {
            result &= (arr[i] > arr[i - 1]) ? true : false;
        }

        for (int i = max_idx + 1; i < arr.length - 1; i++) {
            result &= (arr[i] > arr[i + 1]) ? true : false;
        }
        return result;
    }

    //requires 1 iteration
    static boolean function_1_iteration(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        if (arr.length == 3) {
            return arr[1] > arr[0] && arr[1] > arr[2];
        }

        int n = arr.length ;
        int start = 0;
        int end = n - 1;

        while (start <= end) {

            if (start + 1 < n && arr[start + 1] > arr[start]) {
                start++;
            } else if (end - 1 >= 0 && arr[end - 1] > arr[end]) {
                end--;
            } else {
                break;
            }
        }

        return start > 0 && end < n - 1 && start == end;
    }

}
