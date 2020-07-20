import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a string of digits, 
 * find the length of the longest substring , such that : 
 * 
 * 1. the length of the substring is even , and 
 * 2. sum(left half) = sum(right half)
 *  
 * =========
 * example 
 * =========
 * Input: str = "123123"
 * Output: 6
 * The complete string is of even length and sum of first and second
 * half digits is same
 * 
 * Input: str = "1538023"
 * Output: 4
 * The longest substring with same first and second half sum is "5380"
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 *  using DP to store sum of all possible sub arrays and then comparing sum of even length sub arrays
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * ============
 * approach : 2
 * ============
 * 1. using prefix-sum to store sum of prefix arrays 
 * 2. consider even length subarrays and check the sum of 1st half and 2nd half
 * 
 * if equal , update answer
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n)
 * 
 * 
 * 
 */

class p18_longest_even_len_substring {

    public static void main(String[] args) {
        // String input = "1234123"; //expected =4

        // String input = "153803"; //expected =4 

        String input = "123123"; //expected =6


        int answer = function(input);
        System.out.println(answer);
    }

    static int function(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        int[] prefix_sum = new int[n];
        prefix_sum[0] = arr[0] - '0';

        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + (arr[i] - '0');
        }

        int answer = 0;
        int largest_even_possible = (n % 2 == 0) ? n : n - 1;

        for (int len = 2; len <= largest_even_possible; len += 2) {

            for (int i = 0; i + len - 1 < n; i++) {

                int end_1st_half = i + len / 2 - 1;
                int end_2nd_half = i + len - 1;

                int sum_1st_half = (i - 1 >= 0) ? prefix_sum[end_1st_half] - prefix_sum[i - 1]
                        : prefix_sum[end_1st_half];

                int sum_2nd_half = prefix_sum[end_2nd_half] - prefix_sum[end_1st_half];

                if (sum_1st_half == sum_2nd_half) {
                    answer = Math.max(answer, len);
                }

                // System.out.println(len + " : " + i + " " + end_1st_half + " " + end_2nd_half);

            }

        }

        return answer;

    }

}
