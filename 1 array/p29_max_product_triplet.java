import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/
 * 
 */

/**
 * =============
 * approach : 1
 * =============
 * sort the array and return the MAX(first * second * last , last 3 element's product)
 * TC= O(logN)
 * SC= O(1) 
 * 
 * =============
 * approach : 2
 * =============
 * scan the array and store the 3 maximum and 2 minimums 
 * 
 * TC= O(N)
 * SC= O(1) 
 * 
 */

class p29_max_product_triplet {

    public static void main(String[] args) {
        // int arr[] = { 1, 4, 3, -6, -7, 0 }; //168
        int arr[] = { -10, -3, -5, -6, -20 }; //-90

        function_1(arr);
        function_2(arr);
    }

    static void function_2(int arr[]) {

        //initialization with 0 will NOT work
        int min_1 = Integer.MAX_VALUE; //smallest
        int min_2 = Integer.MAX_VALUE; //2nd smallest

        int max_1 = Integer.MIN_VALUE; //largest
        int max_2 = Integer.MIN_VALUE; //2nd largest
        int max_3 = Integer.MIN_VALUE; //3rd largest

        for (int current : arr) {

            if (current > max_1) {
                max_3 = max_2;
                max_2 = max_1;
                max_1 = current;
            }

            else if (current > max_2) {
                max_3 = max_2;
                max_2 = current;
            }

            else if (current > max_3) {
                max_3 = current;
            }

            if (current < min_1) {
                min_2 = min_1;
                min_1 = current;
            } else if (current < min_2) {
                min_2 = current;
            }

        }

        int result_1 = min_1 * min_2 * max_1;
        int result_2 = max_1 * max_2 * max_3;

        System.out.println(Math.max(result_1, result_2));

    }

    static void function_1(int[] arr) {
        Arrays.sort(arr);

        int min_1 = arr[0];
        int min_2 = arr[1];

        int last_1 = arr[arr.length - 1];
        int last_2 = arr[arr.length - 2];
        int last_3 = arr[arr.length - 3];

        int result_1 = min_1 * min_2 * last_1;
        int result_2 = last_1 * last_2 * last_3;

        System.out.println(Math.max(result_1, result_2));
        
    }

}