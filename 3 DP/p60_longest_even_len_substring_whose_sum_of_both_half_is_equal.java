import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
 * 
 * Given a string ‘str’ of digits, find the length of the longest substring of ‘str’
 * 
 * such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
 * 
 * =========
 * example:
 * =========
 * 
 * Input: str = "123123"
 * Output: 6
 * The complete string is of even length and sum of first and second half digits is same
 * 
 * input: str = "1538023"
 * Output: 4
 * The longest substring with same first and second half sum is "5380"
 * 
 *
 *
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
 * using prefix sum
 *
 * ===========
 * TC = O(n^2)
 * SC = O(n)
 * 
 * 
 * 
 * 
 */


public class p60_longest_even_len_substring_whose_sum_of_both_half_is_equal {

    public static void main(String[] args) {
        // String str = "1538023";//expected = 4

        String str = "123123";//expected = 6


        int answer = function(str);
        System.out.println(answer);
    }

    static int function(String input) {

        int n = input.length();
        int[] prefix_sum = new int[n + 1];

        int answer = 0;

        prefix_sum[0] = (input.charAt(0) - '0');

        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + (input.charAt(i) - '0');
        }

        int max_even_len = (n % 2 == 0) ? n : n - 1;
        for (int len = 2; len <= max_even_len; len += 2) {

            // System.out.println("len : " + len);

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                int sub_arr_sum = (i == 0) ? prefix_sum[j] : prefix_sum[j] - prefix_sum[i - 1];

                int half_sub_arr_sum = (i == 0) ? prefix_sum[j / 2] : prefix_sum[(i + j) / 2] - prefix_sum[i - 1];

                // System.out.print(i + "  " + j + " ");
                // System.out.print(half_sub_arr_sum + "  " + sub_arr_sum);
                // System.out.print(sub_arr_sum);
                // System.out.println();

                if (2 * half_sub_arr_sum == sub_arr_sum) {
                    answer = Math.max(answer, len);
                }

            }
        }

        return answer;

    }

}