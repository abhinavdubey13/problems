import java.util.*;

/**
 * leetcode id : 
 * 
 * https://www.geeksforgeeks.org/binomial-coefficient-dp-9/
 * 
 * https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
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
 * =============
 * approach : 1 
 * =============
 * 
 * https://www.youtube.com/watch?v=3D_Oj16EtD8&ab_channel=GeeksforGeeks
 * 
 * 
 * there are 2 approaches 
 * 
 * dp : C(n,k) = C(n-1 , k-1) + C(n-1 , k)
 * TC = (n.k)
 * SC = (n.k)
 * 
 * 
 * without dp
 * TC = (k)
 * SC = (1)
 * 
 * 
 *  
 * 
 */

public class p72_binomial_coeff {
    public static void main(String[] args) {

        int n = 6;
        int k = 3;

        int answer = Space_efficient.function(n, k);
        System.out.println("C(n,k) : " + answer);
    }

}

class Dynamic_prog {
    static int function(int n, int k) {

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {

                // Base Cases
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                }

                // Calculate current value using previously stored values
                // C(n,k) = C(n-1 , k-1) + C(n-1 , k)
                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }
}

//this is used when we just want to find C(n,k)
class Space_efficient {

    static int function(int n, int k) {

        if (k == 0 || k == n) {
            return 1;
        }

        int answer = 1;
        k = Math.min(k, n - k); //C(n,k) = C(n , n-k)

        for (int i = 1; i <= k; i++) {
            answer *= (n + 1 - i);
            answer /= (i);
        }

        return answer;

    }
}