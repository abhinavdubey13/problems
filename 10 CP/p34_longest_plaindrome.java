import java.util.*;

/**
 * 
 * leetcode id : 5
 * 
 * Given a string s, return the longest palindromic substring in s.
 *
 * 
 *  
 */

/**
 * 
 * DP
 *  
 * 
 * TC = n^2
 * SC = n^2
 * 
 * 
 * 
 */

class p34_longest_plaindrome {

    public static void main(String[] args) {

        String s = "babad";

        String answer = Solution.function(s);
        System.out.println(answer);

    }
}

class Solution {

    static String function(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 1;
        int si = 0;
        int sj = 0;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = true;
                } else if (len == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? true : false;

                    if (dp[i][j]) {
                        si = i;
                        sj = j;
                        ans = 2;
                    }
                } else if (len > 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) ? true : false;

                    if (dp[i][j]) {
                        ans = Math.max(len, ans);
                        si = i;
                        sj = j;
                    }
                }

            }
        }

        return s.substring(si, sj+1);

    }
}
