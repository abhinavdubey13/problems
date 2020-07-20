import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/find-element-bitonic-array/
 * 
 */

/**
 * ===========
 * approach :
 * ===========
 * 
 * application of binary search
 * 
 * TC= O(logN)
 * SC= O(1) 
 * 
 */

class p27_search_in_bitonic {

    public static void main(String[] args) {

        // int arr[] = { 1, 2, 3, 4, 5, 6 };
        int arr[] = { 6, 5, 4, 3, 2, 1 };
        // int arr[] = { -3, 9, 8, 20, 17, 5, 1 };
        int target = 17;

        function(arr, target);
    }

    static void function(int arr[], int target) {
        int pivot = get_turn_over_idx(arr);
        System.out.println(pivot);

        //if pivot == -1 : array is sorted , do a binarysearch on entire array
        //if pivot != -1 and arr[pivot]==target , return pivot
        //if pivot != -1 and arr[pivot] > target , search in Left , else search in right
    }

    static int get_turn_over_idx(int[] arr) {

        int high = arr.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean isFound = (mid - 1 >= 0 && mid + 1 < arr.length && arr[mid] > arr[mid - 1]
                    && arr[mid] > arr[mid + 1]) ? true : false;

            if (isFound) {
                return mid;
            }

            else if (mid >= arr.length - 1) {
                return -1; //array is sorted
            }

            if (arr[mid] > arr[mid + 1]) {
                high = mid - 1;
            }

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }

        }
        return -1;
    }

}