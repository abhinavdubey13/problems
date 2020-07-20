import java.util.*;

/**
 * given a sorted-rotated-array with no duplicates , and KEY to be searched , 
 * 
 * find index of KEY if present
 * 
 *
 * 
 * ==========
 * example :
 * ==========
 * 
 * arr = {3,4,8,1,2}
 * KEY = 8
 * 
 * output = 2
 */

/**
 * ==========
 * approach :
 * ===========
 * here we use 1 pass of binary search
 * 
 * step 1 : find MID
 * 
 * step 2 : either arr[low....mid] or arr[mid+1 .... high] will be sorted     =>    (this is a fact , it is always true)
 * 
 * step 3 : if the key lies between the boundary  : check in sorted part (left or right) , else checking in unsorted part recursively 
 * 
 * NOTE :  we are checking in sorted part only  , bcz for binary search we need sorted array
 *
 * 
 * 
 * input array size = N 
 * TC = O(N)
 * SC = O(1)
 * 
 * 
 */

class p4_search_in_sorted_rotated_array {

    public static void main(String[] args) {
        // int arr[] = { 3, 4, 6, 7, 8, 1, 2 };
        int arr[] = { 3, 1 };
        int KEY = 1;
        int n = arr.length;
        int idx = Solution_iterative.function_itr(arr, n, 0, arr.length - 1, KEY);
        System.out.println(idx);

    }
}

class Solution_iterative {

    // iterative method
    static int function_itr(int[] arr, int n, int low, int high, int KEY) {

        while (low <= high) {

            int mid = low + ((high - low) / 2);

            if (arr[mid] == KEY) {
                return mid;
            }

            boolean is_left_half_sorted = (arr[low] < arr[mid]);

            if (is_left_half_sorted) {
                boolean is_key_in_range = (KEY >= arr[low] && KEY <= arr[mid]);

                if (is_key_in_range) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            else {
                boolean is_key_in_range = (mid + 1 < n && KEY >= arr[mid + 1] && KEY <= arr[high]);
                if (is_key_in_range) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return -1;

    }
}