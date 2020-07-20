import java.util.*;

/**
 * leetcode id : 1035
 * 
 * 
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 * 
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 * 1. A[i] == B[j];
 * 2. The line we draw does not intersect any other connecting (non-horizontal) line.
 * 
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 * 
 * Return the maximum number of connecting lines we can draw in this way
 * 
 * 
 * ===========
 * example -1
 * ===========
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * 
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
 * 
 *   
 * ===========
 * example -2
 * ===========
 * 
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
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
 * using dp , similar to LCS
 *  
 * 
 * ============
 * TC = O(a.b)
 * SC = O(a.b)
 * 
 * 
 * 
 */

class x33_uncrossed_lines {

    public static void main(String[] args) {

        // int[] a = { 2, 5, 1, 2, 5 };
        // int[] b = { 10, 5, 2, 1, 5, 2 };
        int[] a = { 1, 2, 4 };
        int[] b = { 1, 4, 2 };

        int answer = function(a, b);

        System.out.println(answer);
    }

    static int function(int[] A, int[] B) {

        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {

                if (A[i - 1] == B[j - 1]) {

                    dp[i][j] = Math.max(1 + dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[A.length][B.length];

    }

}
