import java.util.*;

/**
 * 
 * leetcode id : 50
 * 
 * 
 * Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
 * 
 * 
 * 
 *  
 */

/**
 * 
 * 1. x^0 = 1 (base case)
 * 2. x^(-k) = (1/x)^k (x goes to the denominator)
 *  
 * 
 * TC = log n
 * SC = stack size
 * 
 * 
 * 
 */

class p32_implement_power_method {

    public static void main(String[] args) {

        // double n = 2;
        // int k = -2;

        double n = 2;
        int k = Integer.MIN_VALUE;

        double answer = Solution.function(n, k);
        System.out.println(answer);

    }
}

class Solution {

    //n^k
    static double function(double n, int k) {

        if (k == 0) {
            return 1;
        }

        if (k < 0) {
            n = 1 / n;
            k = -1 * k; //make positive

            return n * function(n, k - 1);
        }

        return (k % 2 == 0) ? function(n * n, k / 2) : n * function(n * n, k / 2);

    }
}
