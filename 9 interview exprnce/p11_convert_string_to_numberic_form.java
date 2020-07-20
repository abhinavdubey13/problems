import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/convert-sentence-equivalent-mobile-numeric-keypad-sequence/
 * 
 * Given a sentence in the form of a string, convert it into its equivalent mobile numeric keypad sequence.
 * 
 *
 * ========
 * example 
 * ========
 * 
 * Input : GEEKSFORGEEKS
 * Output : 4333355777733366677743333557777
 * For obtaining a number, we need to press a number corresponding to that character for number of times equal to position of the character. 
 * For example, for character C, we press number 2 three times and accordingly.
 * 
 * Input : HELLO WORLD
 * Output : 4433555555666096667775553
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
 * For each character, store the sequence which should be obtained at its respective position in an array, i.e. for Z, store 9999. For Y, store 999. For K, store 55 and so on
 * 
 * ============
 * TC = O(n)
 * SC = O(k)
 * 
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */

class p11_convert_string_to_numberic_form {

    public static void main(String[] args) {

        String input = "GEEKSFORGEEKS";

        String answer = Solution.function(input);

        System.out.println(answer);

    }

}

class Solution {

    static String function(String input) {

        // storing the sequence in array 
        String str[] = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666", "7",
                "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };

        String output = "";

        int n = input.length();
        for (int i = 0; i < n; i++) {
            // Checking for space 
            if (input.charAt(i) == ' ')
                output = output + "0";

            else {
                // Calculating index for each  character 
                int position = input.charAt(i) - 'A';
                output = output + str[position];
            }
        }

        return output;

    }

}
