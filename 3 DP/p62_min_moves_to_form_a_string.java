import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/minimal-moves-form-string-adding-characters-appending-string/
 * 
 * Given a string S, we need to write a program to check if it is possible to construct the given string S 
 * 
 * by performing any of the below operations any number of times. In each step, we can:
 * 1. Add any character at the end of the string. or, 
 * 2. append the string to the string itself.
 * 
 * the above steps can be applied any number of times. We need to write a program to print the minimum steps required to form the string.
 * 
 * =========
 * example:
 * =========
 * Input : aaaaaaaa
 * Output : 4 
 * Explanation: move 1: add 'a' to form "a"
 * move 2: add 'a' to form "aa"
 * move 3: append "aa" to form "aaaa" 
 * move 4: append "aaaa" to form "aaaaaaaa" 
 * 
 * Input: aaaaaa
 * Output: 4 
 * Explanation: move 1: add 'a' to form "a"
 * move 2: add 'a' to form "aa"
 * move 3: add 'a' to form "aaa" 
 * move 4: append "aaa" to form "aaaaaa" 
 * 
 * Input: abcabca
 * Output: 5   
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
 * The idea to solve this problem is to use Dynamic Programming to count the minimum number of moves.
 * 
 * Create an array named dp of size n, where n is the length of the input string. 
 * 
 * dp[i] stores the minimum number of moves that are required to make substring (0…i). According to the question there are two moves that are possible:
 * 
 * 1. when-ever the len is even , we check the 2 half substring , if they are equal , the we append 1st half to get overall string
 * 2. if overall length is odd , we donot have option
 * 
 * 
 * ===========
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 * 
 */

public class p62_min_moves_to_form_a_string {

    public static void main(String[] args) {
        // String str = "aaaaaaaa";//expected = 4
        // String str = "aaaaaa";//expected = 4
        String str = "abcabca";//expected = 5

        int answer = function(str);
        System.out.println(answer);
    }

    static int function(String str) {

        int n = str.length();

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 1;

        for (int i = 1; i < n; i++) {

            //when-ever the len is even , we check the 2 half substring
            //if they are equal , the we append 1st half to get overall string
            if (i % 2 == 1) {
                String first_half = str.substring(0, i / 2 + 1);
                String second_half = str.substring(i / 2 + 1, i + 1);

                if (first_half.equals(second_half)) {
                    dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i - 1]);
                }

            } 
            
            //if overall length is odd , we donot have option
            else {
                dp[i] = Math.min(dp[i], 1 + dp[i - 1]);

            }

        }

        return dp[n - 1];
    }

}