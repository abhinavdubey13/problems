import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/program-nth-catalan-number/
 * 
 * Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.
 * 1) Count the number of expressions containing n pairs of parentheses which are correctly matched. 
 * For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
 * 2) Count the number of possible Binary Search Trees with n keys (See this)
 * 
 * 3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
 * 4) Given a number n, return the number of ways you can draw n chords in a circle with 2 x n points such that no 2 chords intersect.
 * 
 * 
 * 
 * applications :  https://www.geeksforgeeks.org/applications-of-catalan-numbers/
 *  
 * =========
 * example:
 * =========
 *
 * The first few Catalan numbers : 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …  
 * 
 *
 * 
 */

/**
 *  
 * 
 * =============
 * approach : 1 
 * =============
 * https://www.youtube.com/watch?v=0s20L4-chDA&ab_channel=CodingBlocks
 * 
 * u should be able to derive the formula : F(N) = sigma(i=1...N) F(i-1)*F(N-i)
 *  
 * ===========
 * TC = O(n.n)
 * SC = O(n)
 * ===========
 * 
 * 
 * =============
 * approach : 2
 * =============
 * we can also use binomial coeff. to find Nth catlan number
 * 
 * F(n) = [C(2n,n)]/n+1
 *  
 * ===========
 * TC = O(n)
 * SC = O(n)
 * ===========
 * 
 * 
 * 
 * 
 * 
 */

public class p71_nth_catlan_number {
    public static void main(String[] args) {

        int n = 6;

        int answer = function(n);
        System.out.println();
        System.out.println("N'th catlan number : " + answer);
    }

    static int function(int n) {

        if (n < 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int x = j;
                int y = i - j - 1;
                dp[i] += dp[x] * dp[y];
            }
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        return dp[n];
    }

}
