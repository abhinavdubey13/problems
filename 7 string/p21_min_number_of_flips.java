import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate characters
 * by flipping some of the bits, our goal is to minimize the number of bits to be flipped.
 *  
 * =========
 * example 
 * =========
 * Input : str = “001”
 * Output : 1
 * Minimum number of flips required = 1
 * We can flip 1st bit from 0 to 1 
 * 
 * Input : str = “0001010111”
 * Output : 2
 * Minimum number of flips required = 2
 * We can flip 2nd bit from 0 to 1 and 9th 
 * bit from 1 to 0 to make alternate 
 * string “0101010101”. 
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *  consider both possible outcomes
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class p21_min_number_of_flips {

    public static void main(String[] args) {
        // String input = "01010";
        String input = "1111";

        int answer = function(input);
        System.out.println(answer);
    }

    static int function(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        StringBuffer possibility_1 = new StringBuffer();
        StringBuffer possibility_2 = new StringBuffer();

        int bit = 0;
        for (int i = 0; i < n; i++) {
            possibility_1.append(bit);
            possibility_2.append(1 - bit);
            bit = 1 - bit;
        }

        return Math.min(count_deflections(input, possibility_1), count_deflections(input, possibility_2));

    }

    static int count_deflections(String a, StringBuffer b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            count += (a.charAt(i) != b.charAt(i)) ? 1 : 0;
        }
        return count;
    }

}
