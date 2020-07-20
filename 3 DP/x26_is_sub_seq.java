import java.util.*;

/**
 * leetcode id : 392
 * 
 * Given 2 strings : s1 and s2
 * check if s2 is subsequence of s1
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters 
 * without disturbing the relative positions of the remaining characters. 
 * 
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * 
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * 
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
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
 * 2D array
 *
 * 
 * ===========
 * TC=O(n1.n2)
 * SC=O(n1.n2)
 * 
 * 
 * 
 */

class x26_is_sub_seq {

    public static void main(String[] args) {

        // expected = true
        // String s1 = "ahbgdc";
        // String s2 = "abc";

        // expected = false
        // String s1 = "ahbgdc";
        // String s2 = "axc";

        //expected = false
        String s1 = "acb";
        String s2 = "abc";

        boolean answer = function(s2, s1);
        System.out.println(answer);
    }

    static boolean function(String s2, String s1) {

        if (s2 == null || s2.length() == 0) {
            return true;
        }

        if (s1 == null && s2 != null || s1.length() == 0 && s2.length() != 0) {
            return false;
        }

        int n1 = s1.length();
        int n2 = s2.length();
        boolean[][] dp = new boolean[n2][n1];

        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n1; j++) {

                char s1_c = s1.charAt(j);
                char s2_c = s2.charAt(i);

                //1st row
                if (i == 0) {
                    boolean prev = (j - 1 >= 0) ? dp[i][j - 1] : false;
                    dp[i][j] = (s2_c == s1_c) ? true : prev;
                }

                //1st column : only if 1st characters match :  then true 
                //else if len of s2>s1 : s2 cannot be subsequence of s1 obvioulsy
                else if (j == 0) {
                    dp[i][j] = (i == 0 && j == 0 && s1_c == s2_c) ? true : false;
                }

                else {
                    boolean diagonal = (i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] : false;
                    boolean left = (j - 1 > 0) ? dp[i][j - 1] : false;
                    dp[i][j] = (s2_c == s1_c) ? diagonal : left;
                }

            }
        }

        return dp[n2 - 1][n1 - 1];

    }

}
