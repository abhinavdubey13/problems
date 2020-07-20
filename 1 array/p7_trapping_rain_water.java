import java.util.*;

/**
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * 
 * ==========
 * example :
 * ==========
 * 
 * input  = {3,0,2,0,4}
 * output = 7
 * 
 * 
 * Input  = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * Output =  6
 * 
 * 
 */

/**
 * ============
 * approach : 1
 * ============
 * 
 * Create two array max_left and max_right of size n
 * 
 * Run one loop from start to end. In each iteration update max_left[i] to store the max element in left part , including arr[i]
 * 
 * Run another loop from end to start. In each iteration update max_right[i] to store the max element in right part , including arr[i]
 * 
 * Traverse the array from start to end
 * 
 * The amount of water that will be stored in this column = min(a,b) – array[i]
 * (where a = left[i] and b = right[i]) 
 * 
 * 
 * add this value to total amount of water stored
 *
 * Print the total amount of water stored.
 * 
 * =========================================================
 * input array size = N 
 * TC = O(N)
 * SC = O(N)
 * 
 * 
 * 
 * ============
 * approach : 2
 * ============
 * we can do it in O(1) space also
 * 
 * maintain 2 index pointers , 
 * 1. left = 0    .....initially
 * 2. right = n-1 .....initially
 * 
 * and 2 max_variables , 
 * 1. max_left = arr[0]     .....initially
 * 2. max_right = arr[n-1]  .....initially
 * 
 * loop while left<=right
 *      -check which has a lower value : arr[left] or arr[right]
 *      -add the diff wih with max_left/max_right to answer
 *      -update max_left/max_right if required
 *      -increment left / decrement right
 * 
 * 
 */

class p7_trapping_rain_water {

    public static void main(String[] args) {
        //expected = 6
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        //expected = 7
        // int arr[] = { 3, 0, 2, 0, 4 };

        // function(arr);
        function_space_efficient(arr);
    }

    static void function(int arr[]) {

        int[] max_left = new int[arr.length];

        int[] max_right = new int[arr.length];

        int max_till_now = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max_till_now = Math.max(max_till_now, arr[i]);
            max_left[i] = max_till_now;
        }

        max_till_now = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            max_till_now = Math.max(max_till_now, arr[i]);
            max_right[i] = max_till_now;
        }

        int water_trapped = 0;
        for (int i = 0; i < arr.length; i++) {
            int min_of_2_ht = Math.min(max_left[i], max_right[i]);
            water_trapped += (min_of_2_ht - arr[i]);
        }

        System.out.println(water_trapped);
    }

    static void function_space_efficient(int arr[]) {

        int left = 0;
        int right = arr.length - 1;
        int water_trapped = 0;

        int max_left = arr[0];
        int max_right = arr[arr.length - 1];

        while (left <= right) {

            if (arr[left] < arr[right]) {
                water_trapped += Math.max(max_left - arr[left], 0);
                max_left = Math.max(arr[left], max_left);
                left++;
            }

            else {
                water_trapped += Math.max(max_right - arr[right], 0);
                max_right = Math.max(arr[right], max_right);
                right--;
            }

        }

        System.out.println(water_trapped);
    }

}