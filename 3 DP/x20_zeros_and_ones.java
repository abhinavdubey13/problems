import java.util.*;

/**
 * leetcode id : 474
 * 
 * You are given an array of binary strings arr and two integers max_0 and max_1.
 * 
 * Return the size of the largest subset of arr such that there are at most max_0 0's and max_1 1's in the subset.
 * 
 * A set x is a subset of a set y if all elements of x are also elements of y
 * 
 * ==========
 * example : 
 * ==========
 * 
 * Input: arr = ["10","0001","111001","1","0"], max_0 = 5, max_1 = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
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
 * 
 * 
 */

class x20_zeros_and_ones {

    public static void main(String[] args) {

        String[] arr = { "10", "0001", "111001", "1", "0" };
        int max_0 = 5;
        int max_1 = 3;

        int answer = function(arr, max_0, max_1);

        System.out.println(answer);
    }

    static int function(String[] arr, int max_0, int max_1) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[][] dp = new int[max_0 + 1][max_1 + 1];

        for (String s : arr) {
            int num_0 = count_zeros(s);
            int num_1 = s.length() - num_0;

            for (int curr_0 = num_0; curr_0 <= max_0; curr_0++) {
                for (int curr_1 = num_1; curr_1 <= max_1; curr_1++) {

                    int no_pick = dp[curr_0][curr_1];

                    int pick = 0;
                    if (curr_0 - num_0 >= 0 && curr_1 - num_1 >= 0) {
                        pick = 1 + dp[curr_0 - num_0][curr_1 - num_1];
                    }

                    dp[curr_0][curr_1] = Math.max(pick, no_pick);
                    System.out.println(pick + " " + no_pick);
                }
            }
        }

        return dp[max_0][max_1];

    }

    static int count_zeros(String str) {
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            answer += (str.charAt(i) == '0') ? 1 : 0;
        }
        return answer;
    }

}
