import java.util.*;

/**
 * leetcode id : 
 * 
 * 
 * Given two strings S1 and S2, find the number of times the second string occurs in the first string, whether continuous or discontinuous.
 * 
 * ============
 * example : 1
 * ============
 * 
 * Input: 
 * S1 = geeksforgeeks
 * S2 = gks
 * 
 * Output: 4 
 * Explaination: For the first 'g' there  are 3 ways and for the second 'g' there  is one way. Total 4 ways.
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
 * simple 2D dp array
 * 
 * 
 * ===========
 * TC=O(n1.n2)
 * SC=O(n1.n2)
 * 
 * 
 * 
 */

class p53_string_sub_seq {

    public static void main(String[] args) {

        String s1 = "geeksforgeeks";
        String s2 = "gks";

        int answer = function(s1, s2);
        System.out.println(answer);
    }

    static int function(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n2 + 1][n1 + 1];

        for (int i = 1; i <= n2; i++) {
            for (int j = 1; j <= n1; j++) {

                char a = s2.charAt(i - 1);
                char b = s1.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = (i == 1) ? 1+dp[i][j-1] : dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }

            }
        }

        return dp[n2][n1];
    }

}
