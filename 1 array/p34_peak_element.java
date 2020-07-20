import java.util.*;

/**
 * 
 * peak element is the element which is greater than or equal to both of its neighbours (for corner elements , there is 1 neighbour)
 * 
 * https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * 
 */

/**
 *  
 * ============
 * approach : 1
 * ============
 * 
 * simple scan
 * 
 * TC= O(N)
 * SC= O(1)
 * 
 * ==============
 * approach : 2
 * ==============
 * using binary search (divide and conquer)
 * 
 * 
 * 
 * TC= O(log.N)
 * SC= O(1)
 */

class p34_peak_element {

    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 }; //expected = 5
        // int arr[] = { 1, 3, 20, 4, 1, 0 }; //expected = 20
        function(arr);
    }

    static void function(int arr[]) {

        int n = arr.length;
        int high = n - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean corner_1 = (mid == 0 && arr[mid] >= arr[mid + 1]);
            boolean corner_2 = (mid == n - 1 && arr[mid] >= arr[mid - 1]);
            boolean non_corner = (mid > 0 && mid < n - 1 && arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]);

            if (corner_1 || corner_2 || non_corner) {
                System.out.println("peak element : " + arr[mid]);
                return;
            }

            else if (mid + 1 < n - 1 && arr[mid + 1] >= arr[mid]) {
                low = mid + 1;
            }

            else if (mid - 1 >= 0 && arr[mid - 1] >= arr[mid]) {
                high = mid - 1;
            }
        }
    }

}
