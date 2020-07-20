import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/
 * 
 * Given two integers ‘n’ and ‘sum’, find count of all n digit numbers with sum of digits as ‘sum’. Leading 0’s are not counted as digits.
 * 
 * =========
 * Example:
 * =========
 * 
 * Input:  n = 2, sum = 2
 * Output: 2
 * Explanation: Numbers are 11 and 20
 * 
 * Input:  n = 2, sum = 5
 * Output: 5
 * Explanation: Numbers are 14, 23, 32, 41 and 50
 * 
 * 
 * Input:  n = 3, sum = 6
 * Output: 21
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
 * similar to some prev solved qstion : like colored balls
 *
 * 
 * 
 * 
 * TC = O()
 * SC = O()
 * 
 * 
 * 
 * 
 */

public class p56_count_of_N_digit_numbers_whose_sum_of_digits_equals_to_given_sum {

    public static void main(String[] args) {

        // //expected = 2
        // int digits_allowed = 2;
        // int sum = 2;

        // //expected = 5
        // int digits_allowed = 2;
        // int sum = 5;

        //expected = 21
        int digits_allowed = 3;
        int sum = 6;

        int answer = function_util(digits_allowed, sum);
        System.out.println(answer);
    }

    static int function_util(int digits_allowed, int sum) {

        Map<String, Integer> dp = new HashMap<>();

        function(digits_allowed, sum, true, dp);

        String key = digits_allowed + "" + sum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        return -1;
    }

    static int function(int digits_left, int sum_left, boolean isStart, Map<String, Integer> dp) {

        //if no digits and no sum
        if (digits_left == 0 && sum_left == 0) {
            return 1;
        }

        //if digits left and sum req == 0 : only trailing zeros are allowed (ie isStart = false)
        else if (digits_left != 0 && sum_left == 0 && isStart == false) {
            return 1;
        }

        //if no more digits : return zero
        else if (digits_left == 0 && sum_left > 0) {
            return 0;
        }

        String key = digits_left + "" + sum_left;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int count = 0;

        for (int i = 0; i <= 9; i++) {

            //cannot include 0 in beginning
            if (i == 0 && isStart) {
                continue;
            }

            //only include i if sum left is non-negative
            if (sum_left - i >= 0) {
                count += function(digits_left - 1, sum_left - i, false, dp);
            }
        }

        dp.put(key, count);
        return count;

    }

}