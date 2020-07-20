import java.util.Arrays;

/**
 * given a sorted-rotated-array with no duplicates , and SUM to be searched , 
 * 
 * check if there exist a pair with that SUM
 * 
 *
 * 
 * ==========
 * example :
 * ==========
 * 
 * arr = {3,4,8,1,2}
 * KEY = 6
 * 
 * output = true  (4,2)
 */

/**
 * ==========
 * approach :
 * ===========
 * 
 * 1. find pivot in the sorted rotated array
 * 
 * 2. initialize 2 pointers , one at the largest element  , other at the smallest
 * 
 * 3. use 2 pointer technique 
 * 
 * 
 * input array size = N 
 * TC = O(N)
 * SC = O(1)
 * 
 * 
 */

class p5_check_pair_with_given_sum_in_sorted_rotated_array {

    public static void main(String[] args) {
        // int arr[] = { 7, 14, 16, 17, 1, 2 };
        int arr[] = { 1, 2, 7, 14, 16, 17 };

        int SUM = 9;
        boolean result = function(arr, SUM);
        System.out.println(result);
    }

    static boolean function(int[] arr, int SUM) {

        int n = arr.length;
        int pivot = find_pivot(arr);

        //if array is not rotated : pivot = -1
        int largest_idx = (pivot == -1) ? n - 1 : pivot;
        int smallest_idx = (pivot == -1) ? 0 : pivot + 1;

        while (true) {
            int found_sum = arr[largest_idx] + arr[smallest_idx];

            if (found_sum == SUM) {
                return true;
            } else if (found_sum < SUM && smallest_idx < arr.length - 1) {
                smallest_idx++;
            } else if (found_sum > SUM && largest_idx > 0) {
                largest_idx--;
            } else {
                return false;
            }
        }
    }

    // TODO : do it in optimal manner using binary search method
    static int find_pivot(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1])
                return i;
        }

        return -1;
    }

}