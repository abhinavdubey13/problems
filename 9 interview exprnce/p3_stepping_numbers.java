import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/stepping-numbers/
 * 
 * Given two integers ‘n’ and ‘m’, find all the stepping numbers in range [n, m]. 
 * A number is called stepping number if all adjacent digits have an absolute difference of 1. 321 is a Stepping Number while 421 is not.
 * 
 * 
 */

/**
 * 
 * using DFS
 * 
 * 
 */

class p3_stepping_numbers {

    public static void main(String[] args) {

        int a = 100;
        int b = 150;

        Solution.function(a, b);

    }

}

class Solution {

    static void function(int a, int b) {

        for (int i = 1; i < 10; i++) {
            dfs(i, i, a, b);
        }
    }

    static void dfs(int last_digit, int num_till_now, int a, int b) {

        if (num_till_now > b) {
            return;
        }

        if (num_till_now >= a && num_till_now <= b) {
            System.out.println(num_till_now);
        }

        int plus_1 = (last_digit == 9) ? -1 : last_digit + 1;
        int minus_1 = (last_digit == 0) ? -1 : last_digit - 1;

        if (minus_1 != -1) {
            dfs(minus_1, num_till_now * 10 + minus_1, a, b);
        }

        if (plus_1 != -1) {
            dfs(plus_1, num_till_now * 10 + plus_1, a, b);
        }

    }

}
