import java.util.*;

/**
 * 
 * 
 * 
 * https://www.algebra.com/algebra/homework/Permutations/Permutations.faq.question.389512.html
 *
 *
 * 
 */

/**
 * 
 * There are 5P4 = 120 ways of forming 4-digit numbers with each digit appearing at most once. (5C4 * 4!)
 * 
 * 
 * Consider first the one's place. In those 120 numbers, 1,2,3,4, and 5 appear exactly the same number of times, 
 * that is, each digit appears 120/5 = 24 times.  (numbers of numbers divided by number of digits)
 * 
 * 
 * For the tens place, same thing: 1,2,3,4,and 5 appear equally the same number of times. 
 * Each digit appears 24 times. 
 * 
 * The argument for the hundreds and thousands places are the same. 
 * 
 * Thus the sum of all those distinct 120 numbers is
 * 
 * 1,000*24*(1+2+3+4+5)+ 100*24*(1+2+3+4+5) + 10*24*(1+2+3+4+5) + 1*24*(1+2+3+4+5) = 1,111*24*(1+2+3+4+5) = 1,111*24*15 = 399,960.
 * 
 * 
 *
 *
 * 
 * 
 */

class x43_sum_of_all_numbers_formed_using_given_digits {

    public static void main(String[] args) {

        int[] digits = { 1, 2, 3 };
        int ans = Solution.function(arr);
        System.out.println(ans);

    }

}

class Solution {

    static int function(int[] digits) {

        int sum = 0;
        for (int i : digits) {
            sum += i;
        }

        int num_of_numbers = find_count_of_nums(digits.length);

        return -1;
    }

}