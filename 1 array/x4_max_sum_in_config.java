import java.util.*;

/**
 * 
 * Given an array(0-based indexing), you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. 
 * 
 * The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.
 * 
 *
 * ==========
 * example : 
 * ==========
 * 
 * Input:
 * A[] = {8,3,1,2}
 * 
 * Output: 29
 * 
 * 
 * Explanation: Above the configuration
 * possible by rotating elements are
 * 3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
 * 1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
 * 2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
 * 8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11
 * 
 * Here the max sum is 29 
 * 
 */

/**
 *  
 * ============
 * approach : 1
 * ============
 * using brute force and finding all possible dot products
 * ============
 * TC = O(n^2)
 * SC = O(1)
 * 
 * 
 * ============
 * approach : 2
 * ============
 * 
 * we need to derive a formula for finding the next possible product , from the initial product
 * 
 * to derive this formula we need 
 * 1. sum of the array
 * 2. initial product : i*arr[i]
 * 
 * https://www.youtube.com/watch?v=3YNs_Ggqb-Q&feature=emb_logo&ab_channel=alGOds
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class x4_max_sum_in_config {

    public static void main(String[] args) {
        int[] input = { 8, 3, 1, 2 }; // expected = 1

        int answer = function(input);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int product = 0;
        int sum = 0;
        int result = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            product += arr[i] * i;
            sum += arr[i];
        }

        result = product;
        for (int i = 1; i < n; i++) {

            product = product - sum + n * arr[i - 1]; // this is the formula derived

            result = Math.max(result, product);

        }

        return result;

    }

}
