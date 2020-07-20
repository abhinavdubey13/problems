import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/find-if-string-is-k-palindrome-or-not/
 * 
 * Given a string, find out if the string is K-Palindrome or not. 
 * 
 * A k-palindrome string transforms into a palindrome on removing at most k characters from it.
 * 
 * =========
 * example:
 * =========
 * Input : String - abcdecba, k = 1
 * Output : Yes
 * String can become palindrome by removing 1 character i.e. either d or e
 * 
 * 
 * Input  : String - abcdeca, K = 2
 * Output : Yes
 * Can become palindrome by removing 2 characters b and e.
 * 
 * Input : String - acdcb, K = 1
 * Output : No
 * String can not become palindrome by removing only one character. 
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
 * consider each sub string , and check if 1st and last chars are same
 * 
 * if yes , we need to make remaining sub string palindrome
 * 
 * if no , we need to drop 1 of the end/beginning char and the check for min chars to be removed
 *
 * 
 * 
 * ===========
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * 
 * 
 */

public class p57_check_if_string_is_k_palindrome {

    public static void main(String[] args) {

        // //expected = true
        // String str = "abcxycba";
        // int k = 2;

        //expected = false
        String str = "abcdefgh";
        int k = 2;

        boolean answer = function(str, k);
        System.out.println(answer);
    }

    static boolean function(String str, int k) {

        int n = str.length();

        if (n < 2) {
            return (k >= 0) ? true : false;
        }

        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                //len 1 string is already palindrome , so no removal needed
                if (len == 1) {
                    dp[i][j] = 0;
                }

                //at most 1 char must be removed from len 2 string
                else if (len == 2) {
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) ? 0 : 1;
                }

                //len= 3 onwards
                else {

                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i + 1][j]);
                    }

                }
            }
        }

        return (dp[0][n - 1] <= k) ? true : false;

    }

}