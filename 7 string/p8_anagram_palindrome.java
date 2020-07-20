import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a string S, Check if characters of the given string can be rearranged to form a palindrome. 
 * 
 * For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”, 
 * 
 * but characters of “geeksforgeeks” cannot be rearranged to form a palindrome.
 * 
 *  
 * =========
 * example 
 * =========
 * i/p : “geeksogeeks”
 * o/p : true
 * 
 * 
 * i/p : “geeksforgeeks”
 * o/p : false
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * using the fact that in a palindrom , atmost 1 character can have od frequency , rest all characters must have even frequency
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class p8_anagram_palindrome {

    public static void main(String[] args) {
        String input = "geeksogeeks"; //expected = true

        // String input = "geeksforgeeks"; //expected = false

        boolean answer = function(input);
        System.out.println(answer);
    }

    static boolean function(String input) {

        char[] arr = input.toCharArray();


        Map<Character, Integer> freq_map = new HashMap<>();

        for (char c : arr) {
            int count = freq_map.getOrDefault(c, 0);
            count++;
            freq_map.put(c, count);
        }

        boolean is_odd_already_found = false;

        for (Map.Entry<Character, Integer> entry : freq_map.entrySet()) {

            if (entry.getValue() % 2 == 1) {
                if (is_odd_already_found) {
                    return false;
                } else {
                    is_odd_already_found = true;
                }
            }
        }

        return true;

    }

}
