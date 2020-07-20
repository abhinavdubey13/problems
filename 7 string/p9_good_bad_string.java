import java.util.*;

/**
 * leetcode id : 
 * 
 * A string S is composed of lowercase alphabets and a wildcard character ('?') 
 * 
 * Here, '?' can be replaced by any of the lowercase alphabets. Now you have to classify the given String on the basis of following rules:
 * 
 * If there are more than 3 consonants together or more than 5 vowels together, the String is considered to be "BAD". 
 * 
 * A String is considered "GOOD" only if it is not “BAD”.
 * 
 * print the status of string as "GOOD" or "BAD"
 * 
 *  
 * =========
 * example 
 * =========
 * i/p : abcdef
 * o/p : GOOD
 * 
 *  
 */

/**
 *  
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * maintaining running count of consonant and vowels
 *
 * 
 * ============
 * TC = O(n)
 * SC = O(1) //when using optimal strategy
 * 
 * 
 * 
 */

class p9_good_bad_string {

    public static void main(String[] args) {
        // String input = "aaabbaabbb?";

        String input = "abcdef";

        // String answer = function(input);
        String answer = function_2(input);

        System.out.println(answer);
    }

    static String function(String input) {

        if (input.length() <= 3) {
            return "GOOD";
        }

        char[] arr = input.toCharArray();
        int n = arr.length;

        int[][] helper = new int[2][n];

        helper[0][0] = (is_vowel(arr[0])) ? 1 : 0;
        helper[1][0] = (!is_vowel(arr[0])) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            boolean is_prev_vowel = (arr[i - 1] == '?' || is_vowel(arr[i - 1]));
            boolean is_prev_consonant = (arr[i - 1] == '?' || !is_vowel(arr[i - 1]));

            if (arr[i] == '?') {
                helper[0][i] = (is_prev_vowel) ? helper[0][i - 1] + 1 : 1;
                helper[1][i] = (is_prev_consonant) ? helper[1][i - 1] + 1 : 1;
            }

            else if (is_vowel(arr[i])) {
                helper[0][i] = (is_prev_vowel) ? helper[0][i - 1] + 1 : 1;
            }

            else {
                helper[1][i] = (is_prev_consonant) ? helper[1][i - 1] + 1 : 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (helper[0][i] > 5 || helper[1][i] > 3) {
                return "BAD";
            }
        }

        return "GOOD";

    }

    static String function_2(String input) {

        if (input.length() <= 3) {
            return "GOOD";
        }

        char[] arr = input.toCharArray();

        int vowelsCount = 0;
        int consonentCount = 0;

        for (char c : arr) {
            if (is_vowel(c)) {
                vowelsCount++;
                consonentCount = 0; //reset
            } else if (c == '?') {
                // if its ?, it can appear for both consonent and vowel
                vowelsCount++;
                consonentCount++;
            } else {
                consonentCount++;
                vowelsCount = 0; //reset
            }

            if (vowelsCount > 5 || consonentCount > 3) {
                return "BAD";
            }
        }

        return "GOOD";

    }

    static boolean is_vowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

}
