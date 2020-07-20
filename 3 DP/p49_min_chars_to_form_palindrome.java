
/**
 * 
 * Problem : https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
 * 
 * 
 * Given a string str, the task is to find the minimum number of characters to be inserted to convert it to palindrome.
 *  
 * ==========
 * example : 
 * ==========
 * 
 * i/p : ab
 * o/p : 1  (bab or aba)
 * 
 * i/p : aa
 * o/p : 0
 * 
 * i/p : abcd
 * o/p : 3
 *
 * 
 */

/**
 * =============
 * APPROACH : 1
 * =============
 * 
 * minInsertions(str[l+1…..h-1]) if str[l] is equal to str[h]
 * 
 * min(minInsertions(str[l…..h-1]), minInsertions(str[l+1…..h])) + 1 otherwise
 * 
 * ===========
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * 
 * ================================================
 * APPROACH : 2 using longest common sub-seq (LCS)
 * ================================================
 * 
 * The problem of finding minimum insertions can also be solved using Longest Common Subsequence (LCS) Problem. 
 * If we find out LCS of string and its reverse, we know how many maximum characters can form a palindrome. 
 * We need insert remaining characters. Following are the steps.
 * 
 * 1. Find the length of LCS of input string and its reverse. Let the length be ‘l’.
 * 2. The minimum number insertions needed is length of input string minus ‘l’.
 * 
 * ===========
 * TC = O(n^2)
 * SC = O(n^2)
 *
 * 
 */

public class p49_min_chars_to_form_palindrome {

    public static void main(String[] args) {

        // String str = "abcd"; //expected = 3

        String str = "abcde"; //expected = 4


        int answer = function(str);
        System.out.println(answer);
    }

    static int function(String str) {
        int n = str.length();

        if (n < 2) {
            return 0;
        }

        char[] arr = str.toCharArray();
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 1) {
                    dp[i][j] = 0;
                }

                else if (len == 2) {
                    dp[i][j] = (arr[i] == arr[j]) ? 0 : 1;
                }

                else {
                    int a = (is_valid_ij(i + 1, j - 1, n) && arr[i] == arr[j]) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                    int b = (is_valid_ij(i + 1, j, n)) ? 1 + dp[i + 1][j] : Integer.MAX_VALUE;
                    int c = (is_valid_ij(i, j - 1, n)) ? 1 + dp[i][j - 1] : Integer.MAX_VALUE;

                    dp[i][j] = Math.min(a, Math.min(b, c));

                }

            }
        }

        return dp[0][n - 1];

    }

    static boolean is_valid_ij(int i, int j, int n) {
        return (i >= 0 && j >= 0 && i < n && j < n && i <= j);
    }

}