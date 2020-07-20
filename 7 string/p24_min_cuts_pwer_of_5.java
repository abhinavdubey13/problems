import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a binary string str. 
 * The task is to find the smallest positive integer C such that 
 * 
 * the binary string can be cut into C pieces (sub-strings) and 
 * each sub-string should be a power of 5 with no leading zeros.
 *  
 * =========
 * example 
 * =========
 * i/p : 101101101
 * o/p : 3
 * The string “101101101” can be cut into three binary strings “101”, “101”, “101”
 * each of which is a power of 5.
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * https://www.geeksforgeeks.org/minimum-number-of-sub-strings-of-a-string-such-that-all-are-power-of-5/
 * 
 * variation of Longest increasing sub-seq
 * 
 * we need to scan form LHS only , scanning from RHS will not work
 * 
 * ie in the binary number , we start from MSB (most significant bit)
 * 
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n)
 * 
 * 
 * 
 */

class p24_min_cuts_pwer_of_5 {

    public static void main(String[] args) {
        String input = "101101101"; //expected = 3

        // String input = "1111101"; //expected = 1

        int answer = function(input);
        System.out.println(answer);
    }

    static int function(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, n + 1);

        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            if (arr[i] == '0') {
                continue;
            }

            for (int j = 0; j < i; j++) {

                if (arr[j] == '0') {
                    continue;
                }

                long decimal = binary_to_decimal(arr, j, i);
                boolean is_pw_5 = is_power_of_5(decimal);

                if (is_pw_5) {
                    dp[i] = Math.min(dp[i], (j - 1 >= 0) ? dp[j - 1] + 1 : 1);
                }

            }
        }

        return (dp[n - 1] < n + 1) ? dp[n - 1] : -1;

    }

    static boolean is_power_of_5(long num) {
        if (num == 0) {
            return true;
        }

        long current = num;
        while (current % 5 == 0) {
            current /= 5;
        }
        return current == 1;
    }

    

    static long binary_to_decimal(char[] arr, int start, int end) {
        long return_val = 0;
        for (int i = start; i <= end; i++) {
            return_val = return_val * 2 + (arr[i] - '0');
        }
        return return_val;
    }

}
