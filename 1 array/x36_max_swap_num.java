import java.util.*;

/**
 * leetcode id : 670
 * 
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get
 * 
 * ===========
 * example -1
 * ===========
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * 
 * 
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
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
 * Use buckets to record the last position of digit 0 ~ 9 in this num.
 * 
 * Loop through the num array from left to right. For each position, we check whether there exists a larger digit in this num (start from 9 to current digit). 
 * 
 * We also need to make sure the position of this larger digit is behind the current one. If we find it, simply swap these two digits and return the result.
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x36_max_swap_num {
    public static void main(String[] args) {

        // int x = 2736;
        // int x = 98368;
        int x = 1993;
        // int x = 98368;

        int answer = function(x);

        System.out.println(answer);
    }

    static int function(int num) {

        char[] nums = Integer.toString(num, 10).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] - '0'] = i;
        }

        for (int i = 0; i < nums.length; i++) {

            int current_digit = nums[i] - '0';

            for (int k = 9; k > current_digit; k--) {

                int last_idx = buckets[k];

                if (last_idx > i) {
                    char tmp = nums[i];
                    nums[i] = nums[last_idx];
                    nums[last_idx] = tmp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }

        return num;

    }
}
