import java.util.*;

/**
 * leetcode id : 650
 * 
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
 * 
 * 1. Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * 
 * 2. Paste: You can paste the characters which are copied last time.
 * 
 * Given a number n. 
 * You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. 
 * Output the minimum number of steps to get n 'A'.
 *  
 * ===========
 * example -1
 * ===========
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
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
 * To get the DP solution, analyse the pattern first by generating first few solutions
 * 1: 0
 * 2: 2
 * 3: 3
 * 4: 4
 * 5: 5
 * 6: 5
 * 7: 7
 * 8: 6
 * 9: 6
 * 10: 7
 * 11: 11
 * 12: 7
 * 13: 13
 * 14: 9
 * 15: 8
 * 
 * 
 * Now, check the solution.
 * Eg: n=6
 * 
 * To get 6, we need to copy 3 'A's two time. (2)
 * To get 3 'A's, copy the 1 'A' three times. (3)
 * So the answer for 6 is 5
 * 
 * Now, take n=9.
 * We need the lowest number just before 9 such that (9% number =0). So the lowest number is 3.
 * So 9%3=0. We need to copy 3 'A's three times to get 9. (3)
 * For getting 3 'A's, we need to copy 1 'A' three times. (3)
 * So the answer is 
 *  
 * 
 * ============
 * TC = O(n^2  ish)
 * SC = O(n)
 * 
 * 
 * 
 */

class x7_copy_paste_A {

    public static void main(String[] args) {
        int n = 3;
        int answer = function(n);
        System.out.println(answer);
    }

    static int function(int n) {

        if (n < 2) {
            return 0;
        }

        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 0;
        dp[2] = 2;

        if (n < 3) {
            return dp[n];
        }

        for (int i = 3; i < n + 1; i++) {
            dp[i] = i;
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    int ops_to_get_i_from_j = (i / j); // out of these 1st is for copying , rest all for just pasting
                    dp[i] = dp[j] + ops_to_get_i_from_j;
                    break;
                }
            }

        }

        return dp[n];

    }

}
