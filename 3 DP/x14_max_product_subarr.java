import java.util.*;

/**
 * leetcode id : 152
 * 
 * Given an integer array nums, find the contiguous subarray(size >=1) within the array , which has the largest product.
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * using prefix array concept
 * 
 * product [i....j] = product[0....j]/product[0....i] 
 * 
 * there is a corner case , in which arr[i]= 0 , we need to divide the input array and continue
 *
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class x14_max_product_subarr {

    public static void main(String[] args) {
        int[] arr = { -2, -3, 0, -2, -40 };//expected = 80
        // int[] arr = { -2, 3, -4 }; //expected=24

        // int[] arr = { -1, -2, -9, -6 }; //expected=108

        // int[] arr = { 2, -5, -2, -4, 3 }; //expected=24

        // int[] arr = { 0, 2 }; //expected=2

        // int[] arr = { 1, 0, -1, 2, 3, -5, -2 }; //expected=60

        int answer = function(arr);
        System.out.println(answer);

    }

    static int function(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int n = arr.length;

        if (arr[0] == 0) {
            int[] _arr = Arrays.copyOfRange(arr, 1, n);
            return function(_arr);
        }

        int[] running = new int[n];
        running[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                int[] left_arr = Arrays.copyOfRange(arr, 0, i);
                int[] right_arr = Arrays.copyOfRange(arr, i + 1, n);

                int l = function(left_arr);
                int r = function(right_arr);
                return Math.max(0, Math.max(l, r));

            } else {
                running[i] = running[i - 1] * arr[i];
            }
        }

        int answer = arr[0];
        Integer max_negative = (arr[0] >= 0) ? null : arr[0];

        //for example : take the array : [2,3,-2,-4]
        //it correct answer : 48
        for (int i = 1; i < n; i++) {
            int current = running[i];
            int temp = 0;

            //if running product is +ive , we dont need any processing
            if (current > 0) {
                temp = current;
            }

            //if running product is -ive , we need to divide it with the max -ive product we have encountered
            else if (current < 0) {
                //if we have seen a negative number before
                if (max_negative != null) {
                    temp = Math.abs(current) / Math.abs(max_negative.intValue());
                    max_negative = Math.max(current, max_negative.intValue());
                }

                //if this is the 1st time seeing a -ive number
                else {
                    max_negative = current;
                }
            }

            answer = Math.max(answer, Math.max(temp, current));
        }

        return answer;

    }

}
