import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a function that takes a binary string. The task is to return the longest size of contiguous substring containing only ‘1’
 *  
 * =========
 * example 
 * =========
 * i/p : 1110110
 * o/p : 3
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * similar to reversing the words problem
 * 
 * ============
 * TC = O(1)
 * SC = O(1)
 * 
 * 
 * 
 */

class p7_longest_substring_of_1 {

    public static void main(String[] args) {
        String input = "1110110";

        int answer = function(input);
        System.out.println(answer);
    }

    static int function(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        int max_len = 0;

        int start = 0, end = 0;

        while (end < n) {

            if (end + 1 == n || arr[end + 1] == '0') {

                int curr_len = end - start + 1;
                max_len = Math.max(max_len, curr_len);

                end += 2;
                start = end;
            } else {
                end++;
            }

        }

        return max_len;

    }

}
