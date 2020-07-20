import java.util.*;

/**
 * leetcode id : 1052
 * 
 * Today, the bookstore owner has a store open for customers.length minutes. 
 * Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
 * On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  
 * 
 * When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
 * 
 * The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
 * 
 * Return the maximum number of customers that can be satisfied throughout the day.
 *  
 * =========
 * example
 * =========
 * 
 * customers = [1,0,1,2,1,1,7,5], 
 * grumpy    = [0,1,0,1,0,1,0,1], 
 * X = 3
 * 
 * Output: 16
 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * 
 * 
 * customers = [4,10,10], 
 * grumpy    = [1,1,0], 
 * X = 2
 * 
 * Output: 24
 * Explanation: The bookstore owner keeps themselves not grumpy for the first 2 minutes. 
 * The maximum number of customers that can be satisfied = 4+10+10 = 24
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * using sliding window , 
 * 
 * STEP:1 we first find the window in which we need to use special technique to be NON grumpy
 * STEP:2 then add all customers in that window and for other customers outside of window , just add if non-grumpy
 * 
 * for STEP:1
 * we find what is the max sum impacted , 
 * this is done only when owner grumpy
 * 
 * the window which caused most impact is selected
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x46_grumpy_owner {

    public static void main(String[] args) {

        //expected = 16
        // int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        // int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        // int X = 3;

        //expected = 24
        int[] customers = { 4, 10, 10 };
        int[] grumpy = { 1, 1, 0 };
        int X = 2;

        int answer = function(customers, grumpy, X);

        System.out.println(answer);

    }

    static int function(int[] customers, int[] grumpy, int X) {

        int n = grumpy.length;

        int max_window_start = 0;
        int max_window_end = -1;

        int max_sum_impacted = 0;

        int cur_sum_impacted = 0;
        for (int i = 0; i < X; i++) {
            cur_sum_impacted += (grumpy[i] == 1) ? customers[i] : 0;
        }

        max_sum_impacted += cur_sum_impacted;

        for (int start = 1; (start + X - 1) < n; start++) {

            int end_of_cur_wndow = start + X - 1;

            cur_sum_impacted += (grumpy[end_of_cur_wndow] == 1) ? customers[end_of_cur_wndow] : 0;
            cur_sum_impacted -= (grumpy[start - 1] == 1) ? customers[start - 1] : 0;

            if (cur_sum_impacted > max_sum_impacted) {
                max_sum_impacted = cur_sum_impacted;
                max_window_start = start;
            }

        }

        max_window_end = max_window_start + X - 1;

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (i >= max_window_start && i <= max_window_end) {
                answer += customers[i];
            } else {
                answer += (grumpy[i] == 0) ? customers[i] : 0;
            }
        }

        return answer;

    }

}
