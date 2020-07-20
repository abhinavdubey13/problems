import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/count-of-palindromic-substrings-in-an-index-range/
 * 
 * Given a string str of small alphabetic characters other than this we will be given many substrings of this string in form of index tuples. 
 * 
 * We need to find out the count of the palindromic substrings in given substring range.
 * 
 * =========
 * example:
 * =========
 * 
 * Input : String str = "xyaabax"
 * Range1 = (3, 5)   
 * Range2 = (2, 3) 
 * 
 * output : 4 and  3
 * 
 * For Range1,  substring is "aba" : Count of palindromic substring in "aba" is 4 : "a", "b", "aba", "a"
 * For Range2,  substring is "aa"  : Count of palindromic substring in "aa" is  3 : "a", "a", "aa"
 *  
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
 * We can solve this problem using dynamic programming. 
 * 
 * First we will make a 2D array isPalin, isPalin[i][j] will be TRUE if string(i..j) is a palindrome otherwise it will be FALSE 
 * 
 * After constructing isPalin we will construct another 2D array dp, 
 * count_dp[i][j] will tell the count of palindromic substring in string(i..j)
 * 
 * 
 * Now we can write the relation among isPalin and dp values as shown below,
 * dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1] + isPalin[i][j]
 * 
 * Similar to set theory we can write the relation among dp values as,
 * dp[i][j] will be addition of number of palindromes from  i to j-1 and i+1 to j  
 * subtracting palindromes from i+1 to j-1 because they are counted twice once in dp[i][j-1] 
 * 
 * and then in dp[i + 1][j] plus 1 if str(i..j) is also a palindrome
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

public class p63_count_palindrome_substr_in_given_idx_range {

    public static void main(String[] args) {

        String str = "xyaabax";

        // expected = 4
        // int start = 3;
        // int end = 5;

        // expected = 3
        int start = 2;
        int end = 3;

        int answer = function(str, start, end);
        System.out.println(answer);
    }

    static int function(String str, int start, int end) {

        int n = str.length();
        boolean[][] isPalin = new boolean[n][n];
        int[][] count_dp = new int[n][n];

        make_is_palidrom_dp(isPalin, str);

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 1) {
                    count_dp[i][j] = 1;
                }

                else if (len == 2) {
                    //example : 'aa' : 'a','a','aa' ie 3 palidromic subtrings
                    count_dp[i][j] = (str.charAt(i) == str.charAt(j)) ? 3 : 2;
                }

                else {
                    int left = count_dp[i][j - 1];
                    int down = count_dp[i + 1][j];
                    int diagonal_down_left = count_dp[i + 1][j - 1];

                    count_dp[i][j] = (left + down - diagonal_down_left);

                    if (isPalin[i + 1][j - 1]) {
                        count_dp[i][j] += 1;
                    }

                }
            }

        }

        return count_dp[start][end];

    }

    static void make_is_palidrom_dp(boolean[][] dp, String str) {

        int n = str.length();

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 1) {
                    dp[i][j] = true;
                }

                else if (len == 2) {
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) ? true : false;
                }

                else {
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) ? dp[i + 1][j - 1] : false;
                }
            }
        }
    }

}