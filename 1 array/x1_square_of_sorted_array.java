import java.util.*;

/**
 * Given an array of integers A sorted in non-decreasing order, 
 * return an array of the squares of each number,
 * also in sorted non-decreasing order.
 * 
 * 
 * ========
 * example
 * ========
 * Input: [-4,-1,0,3,10]
 * 
 * Output: [0,1,9,16,100]
 * 
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * using 2 pointer technique
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class x1_square_of_sorted_array {

    public static void main(String[] args) {
        // int[] input = { -4, -1, 0, 3, 10 };
        int[] input = {-7,-3,2,3,11};
        int[] output = function(input);
        print_array(output);
    }

    static int[] function(int[] input) {

        int[] output = new int[input.length];

        int start = 0;
        int end = input.length - 1;
        int i = input.length - 1;

        while (start < end) {

            if (Math.abs(input[start]) > Math.abs(input[end])) {
                output[i] = input[start] * input[start];
                start++;
            } else {
                output[i] = input[end] * input[end];
                end--;
            }

            i--;

        }

        output[0] = input[start] * input[start];
        return output;

    }

    static void print_array(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
