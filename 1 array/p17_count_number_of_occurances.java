import java.util.*;

/**
 * 
 * Given an array of size N , possibly having duplicates
 * The array is sorted in ascending order . 
 * 
 * Find the count of a given target element.
 *  
 * 
 */

/**
 * =============
 * approach   : 
 * =============
 * using binary search with repeated elements , find 1st and last occurance of target element
 *  
 * TC= O(log n)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p17_count_number_of_occurances {

    public static void main(String[] args) {

        int arr[] = { 1, 1, 2, 2, 2, 2, 3, 3 };
        int target = 3;

        int firstIdx = firstIdx(arr, target);

        if (firstIdx == -1) {
            System.out.println("Target not in array");
        } else {
            int lastIdx = lastIdx(arr, target);
            System.out.print("number of occurances of " + target + " : ");
            System.out.print(lastIdx - firstIdx + 1);
            System.out.println();
        }

    }

    static int firstIdx(int arr[], int target) {

        int high = arr.length - 1;
        int low = 0;
        int mid;
        int idx_to_return = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] == target) {

                if (mid == 0 || arr[mid - 1] < arr[mid]) {
                    idx_to_return = mid;
                    break;
                }

                high = mid - 1;

            }

        }

        return idx_to_return;

    }

    static int lastIdx(int arr[], int target) {

        int high = arr.length - 1;
        int low = 0;
        int mid;
        int idx_to_return = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] == target) {

                if (mid == arr.length - 1 || arr[mid] < arr[mid + 1]) {
                    idx_to_return = mid;
                    break;
                }
                low = mid + 1;
            }
        }

        return idx_to_return;

    }

}