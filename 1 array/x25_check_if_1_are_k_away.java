import java.util.*;

/**
 * leetcode id : 1437
 * 
 * Given an array nums of 0s and 1s and an integer k, 
 * 
 * return True if all 1's are at least k places away from each other, otherwise return False.
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: nums = [1,0,0,0,1,0,0,1], k = 2
 * Output: true
 * 
 * Explanation: Each of the 1s are at least 2 places away from each other.
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * 
 * check distance between 2 consecutive index of 1
 *   
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x25_check_if_1_are_k_away {

    public static void main(String[] args) {

        // int[] arr = { 1, 0, 0, 0, 1, 0, 0, 1 };
        // int k = 2;


        // int[] arr = { 1,1,1,1,1 };
        // int k = 0;

        int[] arr = { 1,0,0,1,0,1 };
        int k = 2;

        boolean answer = function(arr, k);

        System.out.println(answer);
        // for (int i = 0; i < len; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
    }

    static boolean function(int[] arr, int k) {

        int n = arr.length;

        int prev_idx_of_1 = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                prev_idx_of_1 = i;
                break;
            }
        }

        boolean answer = true;
        for (int i = prev_idx_of_1 + 1; i < n; i++) {

            if (arr[i] == 1) {
                int distance = Math.abs(prev_idx_of_1 - i)-1;

                answer &= (distance >= k) ? true : false;
                prev_idx_of_1 = i;
            }

        }

        return answer;

    }

}
