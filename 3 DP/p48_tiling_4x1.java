
/**
 * 
 * Problem : https://www.geeksforgeeks.org/count-number-of-ways-to-fill-a-n-x-4-grid-using-1-x-4-tiles/
 * 
 * Given a number n, count number of ways to fill a n x 4 grid using 1 x 4 tiles.
 * 
 * 
 * 
 * ==========
 * example : 
 * ==========
 * 
 * i/p : n=3
 * o/p : 1
 * 
 * i/p : n=5
 * o/p : 3
 *
 * 
 */

/**
 * ==========
 * APPROACH :
 * ==========
 * 
 * 1-D DP array required
 *  
 * we have 2 choices :
 *
 * 1. Place the first tile horizontally : If we place first tile horizontally, the problem reduces to “count(n-1)”
 * 
 * 2. Place the first tile vertically : If we place first tile vertically, then we must place 3 more tiles vertically. So the problem reduces to “count(n-4)”
 *
 * 
 * ==============
 * TC = O(n)
 * SC = O(n)
 * 
 *
 * 
 */

public class p48_tiling_4x1 {

    public static void main(String[] args) {
        int n = 5;//expected = 3

        int answer = function(n);
        System.out.println(answer);
    }

    static int function(int n) {
        if (n < 4) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i < 4) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 4];
            }
        }

        return dp[n];

    }

}