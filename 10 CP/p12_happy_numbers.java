import java.util.*;

/**
 * 
 * leetcode id : 202
 * 
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * 1. Starting with any positive integer, 
 * 2. replace the number by the sum of the squares of its digits.
 * 3. repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * 4. Those numbers for which this process ends in 1 are happy.
 * 
 * 
 * Return true if n is a happy number, and false if not.
 *  
 */

/**
 * 
 *
 * 
 * 
 * TC = depends
 * SC = depends
 * 
 */

class p12_happy_numbers {

    public static void main(String[] args) {

        int n = 25;
        boolean answer1 = Solution.function(n);
        System.out.println(answer1);
    }
}

class Solution {

    static boolean function(int n) {

        Set<Integer> st = new HashSet<>();

        int i = n;

        while (true) {

            int sum_of_sq = sum_of_sq_of_digits(i);

            if (sum_of_sq == 1) {
                return true;
            }

            else if (st.contains(sum_of_sq)) {
                return false;
            }

            else {
                st.add(sum_of_sq);
                i = sum_of_sq;
            }
        }

    }

    //check from 2- sqrt(n)
    static int sum_of_sq_of_digits(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }

}
