
import java.util.*;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

/**
 * leetcode id : 
 * 
 * Given a string S, find the longest palindromic substring in S. 
 * 
 * Palindrome string: A string which reads the same backwards. 
 * More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).
 * 
 * NOTE: Required Time Complexity O(n2).
 *
 * 
 * ===========
 * example -1
 * ===========
 * input : aaaabbaa
 * 
 * longest palindromic substring = aabbaa (last 6 characters)
 * length = 6
 * 
 * 
 */

/**
 *  
 * 
 * =====================
 * approach : using DP
 * ====================
 * 
 * Maintain a boolean table[n][n] that is filled in bottom up manner.
 * 
 * The value of table[i][j] is true, if the substring is palindrome, otherwise false.
 * 
 * To calculate table[i][j], check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true.
 * 
 * Otherwise, the value of table[i][j] is made false.
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 * ===============================
 * approach : without dp using DP
 * ===============================
 * 
 * consider each i from 1 till n-2 , as the center point of a palindrome
 * 
 * 1. generate odd length palindrome from i-1 and i+1
 * 2. generate even length palindrome from i-1 and i
 *  
 * ============
 * TC = O(n^2)
 * SC = O(1)
 * 
 * 
 * 
 */

class p1_largest_palindromic_substr {

    public static void main(String[] args) {
        // String input = "aaaabbaa"; //expected = 6

        String input = "forgeeksskeegfor"; //expected =10

        int answer = Dynamic_approach.function(input);
        System.out.println(answer);

        int answer2 = Generate_substring.function(input);
        System.out.println(answer2);

    }

}

class Dynamic_approach {

    static int function(String s) {

        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int answer = Integer.MIN_VALUE;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 1) {
                    dp[i][j] = true;
                    answer = Math.min(answer, 1);
                    continue;
                }

                if (len == 2) {
                    dp[i][j] = (arr[j] == arr[j - 1]) ? true : false;
                    answer = (dp[i][j]) ? 2 : answer;
                    continue;
                }

                if (arr[i] == arr[j]) {
                    dp[i][j] = (i + 1 < n && j - 1 >= 0 && j - 1 < n && dp[i + 1][j - 1]) ? true : false;
                    answer = (dp[i][j]) ? len : answer;
                }

            }

        }
        return answer;
    }
}

class Generate_substring {

    static int function(String s) {

        int n = s.length();
        char[] arr = s.toCharArray();

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < n - 1; i++) {

            int odd_i = i - 1;
            int odd_j = i + 1;

            while (odd_i >= 0 && odd_j < n) {
                if (arr[odd_i] != arr[odd_j]) {
                    break;
                }
                odd_i--;
                odd_j++;
            }

            int odd_palin_len = (odd_j - 1) - (odd_i + 1) + 1;

            int even_i = i - 1;
            int even_j = i;

            while (even_i >= 0 && even_j < n) {
                if (arr[even_i] != arr[even_j]) {
                    break;
                }
                even_i--;
                even_j++;
            }

            int even_palin_len = (even_j - 1) - (even_i + 1) + 1;

            answer = Math.max(answer, Math.max(odd_palin_len, even_palin_len));

        }

        return answer;

    }
}