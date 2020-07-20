import java.util.*;

/**
 * 
 * Given an array of size N ,  which is initially increasing and then MAY-BE decreasing (ie , its bitonic)
 * 
 * find the maximum value in the array
 * 
 * https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
 * 
 * 
 */

/**
 * =============
 * approach   : 
 * =============
 * 
 * 
 * using binary search 
 *  
 * ==============
 * TC= O(log n)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p18_max_in_bitonic_arr {

    public static void main(String[] args) {

        // int arr[] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };

        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 80, 9 };

        int arr[] = { 1, 200, 9, 8, 7, 5 };

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int arr[]) {

        int high = arr.length - 1;
        int low = 0;
        int mid;
        int idx_to_return = high;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (mid == arr.length - 1 || arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return arr[idx_to_return];
            }

            //mid is in 2nd half : which is descding order
            else if (arr[mid] > arr[mid + 1]) {
                high = mid - 1;
            }

            //mid is in ist half : which is ascding order
            else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }

        }

        return arr[idx_to_return];

    }

}

//returns the max element itself , not the index
//it is a better approach i guess
class Practise {

    static int function(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int curr = arr[mid];
            Integer prev = (mid >= 1) ? arr[mid - 1] : null;
            Integer next = (mid + 1 < n) ? arr[mid + 1] : null;

            if (mid == 0 || mid == n - 1) {
                return curr;

            }

            if (prev != null && next != null && curr > prev && curr > next) {
                return curr;
            }

            //search in RHS
            else if (prev != null && curr > prev) {
                low = mid + 1;
            }

            //search in LHS
            else if (next != null && curr > next) {
                high = mid - 1;

            }

        }

        return -1;

    }

}