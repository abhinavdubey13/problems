import java.util.*;

/**
 * given a sorted-rotated-array with no duplicates 
 * 
 * find pivot index
 * 
 * --------------------------------------------------------------------------
 * DEFINATION OF PIVOT : index whose value is greater than next idx's value
 * --------------------------------------------------------------------------
 * 
 * 
 * =========
 * example-1
 * =========
 * 
 * arr = { 6, 7, 1, 2, 3, 4, 5 }; 
 * pivot number = 7
 * expected = 1
 * 
 * arr = { 2, 3, 4, 5, 6, 7, 1 }; 
 * pivot number = 7
 * expected = 5
 * 
 * arr = { 1, 2, 3, 4, 5, 6, 7 }; 
 * since array is sorted (and not rotated) , pivot does not exist
 * expected = -1
 * 
 * 
 */

/**
 * ==========
 * approach :
 * ===========
 * 
 * similar to binary search
 *
 * 
 * 1. find mid , and check if arr[mid] , arr[mid-1] is pivot
 * 2. if not , move the low/high pointers accordingly
 * 
 * USE : exactly 1 of the below will be sorted   =>    (this is a fact , it is always true)
 * 1. arr[low....mid] ,or 
 * 2. arr[mid+1 .... high] will be sorted    
 * 
 * go in the direction of the one which is NOT sorted
 * 
 * 
 * 
 * =================
 * input array size
 * TC = O(N)
 * SC = O(1)
 * 
 * 
 */

class p4_find_pivot_in_sorted_rotated_array {

    public static void main(String[] args) {

        int[] arr = { 6, 7, 1, 2, 3, 4, 5 }; //expected = 1
        // int[] arr = { 2, 3, 4, 5, 6, 7, 1 }; //expected = 5
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7 }; //expected = -1

        int pivot = find_pivot(arr);
        System.out.println(pivot);
    }

    static int find_pivot(int arr[]) {

        if (arr.length < 2) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            //arr[mid] is pivot : indices explored are mid , mid+1
            if (isPivot(arr, mid)) {
                return mid;
            }

            //if array is sorted from (low....mid) : then pivot must be right side ie (mid+1.....high)
            else if (arr[low] <= arr[mid]) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }

        }

        return -1;
    }

    static boolean isPivot(int[] arr, int idx) {
        int n = arr.length;
        return (idx + 1 < n) && (arr[idx] > arr[idx + 1]);
    }

}