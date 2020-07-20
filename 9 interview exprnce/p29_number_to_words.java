import java.util.*;

/**
 * 
 * Write code to convert a given number into words.
 * https://www.geeksforgeeks.org/program-to-convert-a-given-number-to-words-set-2/
 *
 *  
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 *
 * 
 * 
 * ============
 * TC = O(1)
 * SC = O(1)
 * 
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */

class p29_number_to_words {

    public static void main(String[] args) {

        // int n = 438237764;
        int n = 89;

        String ans = new Solution().function(n);
        System.out.println(ans);

    }

}

class Solution {

    // Strings at index 0 is not used, it is to make array indexing simple 
    String one[] = { "", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ",
            "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ",
            "nineteen " };

    // Strings at index 0 and 1 are not used, they is to make array indexing simple 
    String ten[] = { "", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety " };

    final int CRORE = 10000000;
    final int LAKH = 100000;
    final int THOUSAND = 1000;
    final int HUNDRED = 100;

    String len_2_num_to_word(int n, String suffix) {
        String str = "";

        if (n > 19) {
            str = ten[n / 10] + one[n % 10];
        } else {
            str = one[n];
        }

        if (n > 0) {
            str += suffix;
        }

        return str;
    }

    String function(int n) {

        String answer = "";

        //43,82,37,764
        // %100 is done to extract last 2 digits only

        answer += len_2_num_to_word((n / CRORE), "crore ");
        answer += len_2_num_to_word((n / LAKH) % 100, "lakh "); // %100 to extract 82 out of 4382
        answer += len_2_num_to_word((n / THOUSAND) % 100, "thousand ");
        answer += len_2_num_to_word((n / HUNDRED) % 10, "hundred ");
        answer += len_2_num_to_word(n % 100, "");

        return answer;

    }

}