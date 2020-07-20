import java.util.*;

/**
 * leetcode id : 647
 * 
 * Given a string, your task is to count how many palindromic substrings in this string.
 * 
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters
 * 
 * 
 * 
 * ============
 * example : 1
 * ============
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * ============
 * example : 2
 * ============
 * Input: "aaa"
 * Output: 6
 * Explanation: Three palindromic strings: "a", "a", "a" , "aa" , "aa" , "aaa"
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
 * simple 2D array of boolena
 * 
 * ==============
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * 
 * 
 * 
 * 
 */

class x24_count_palindromic_substrings {

    public static void main(String[] args) {
        String str = "abxbc";
        int answer = function(str);
        System.out.println(answer);
    }

    static int function(String str) {

        if (str == null) {
            return 0;
        }

        int n = str.length();

        if (n < 2) {
            return n;
        }

        boolean[][] dp = new boolean[n][n];
        int answer = 0;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = (len == 1 || len == 2 || (i + 1 < n && j - 1 >= 0 && dp[i + 1][j - 1])) ? true : false;
                    answer += (dp[i][j]) ? 1 : 0;
                }

            }
        }

        return answer;

    }

}
