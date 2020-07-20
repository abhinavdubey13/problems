import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/program-to-find-whether-a-no-is-power-of-two/
 * 
 * Given a positive integer, write a function to find if it is a power of two or not.
 *
 *
 * 
 */

/**
 * 
 * 
 * if a number is power of 2 , number of set bits in its binary representation will be only 1
 * 
 * 2 = 10
 * 4 = 100
 * 8 = 1000
 * 16 = 10000 .... and so on
 * 
 * 
 * how to count set bits : 
 * https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 *
 * 
 * 
 */

class x40_check_power_of_2 {

    public static void main(String[] args) {
        int n = 32;
        boolean is_pow_2 = Solution.function(n);
        System.out.println(is_pow_2);
    }

}

class Solution {

    static boolean function(int n) {

        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        int set_bits = Helper.count_set_bits(n);
        return set_bits == 1;

    }
}

class Helper {

    static int count_set_bits(int n) {
        if (n == 0) {
            return 0;
        }
        return 1 + count_set_bits(n & (n - 1));
    }

}