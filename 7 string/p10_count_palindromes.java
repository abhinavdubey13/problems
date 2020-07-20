import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a string, the task is to count all palindromic sub-strings of lenght atleast 2 present in it.
 *  
 * =========
 * example 
 * =========
 * i/p : abaab
 * o/p : 3 (aa , aba , baab)
 * 
 * i/p : abbaeae
 * o/p : 4 (bb , eae , aea , abba)
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *  using DP
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * 
 */

class p10_count_palindromes {

    public static void main(String[] args) {
        // String input = "abaab";

        String input = "abbaeae";


        int answer = function(input);
        System.out.println(answer);
    }

    static int function(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        int count = 0;

        boolean dp[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 2) {
                    dp[i][j] = (arr[i] == arr[j]) ? true : false;
                    count += (dp[i][j]) ? 1 : 0;
                    continue;
                }

                dp[i][j] = (arr[i] == arr[j] && i + 1 < n && dp[i + 1][j - 1]) ? true : false;
                count += (dp[i][j]) ? 1 : 0;

            }

        }

        return count;
    }

}
