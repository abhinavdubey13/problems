import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a string str and another string patt. 
 * Find the character in patt that is present at the minimum index in str. 
 * If no character of patt is present in str then print ‘No character present’.
 * 
 *  
 * =========
 * example 
 * =========
 * Input:
 * str = geeksforgeeks
 * patt = set
 * 
 * Output: e
 * Explanation: e is the character which is
 * present in given patt "geeksforgeeks"
 * and is first found in str "set".
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *  using hasmap
 * 
 * ============
 * TC = O(n)
 * SC = O(unique chars in input string)
 * 
 * 
 * 
 */

class p11_min_indexed_char {

    public static void main(String[] args) {
        // String input = "geeksforgeeks";
        // String pattern = "set";

        String input = "adcffaet";
        String pattern = "onkl";

        String answer = function(input, pattern);
        System.out.println(answer);
    }

    static String function(String input, String pattern) {

        char[] input_arr = input.toCharArray();
        char[] patt_arr = pattern.toCharArray();

        Map<Character, Integer> index_map = new HashMap<>();

        for (int i = 0; i < input_arr.length; i++) {
            int idx_of_curr = index_map.getOrDefault(input_arr[i], Integer.MAX_VALUE);
            int min_idx = Math.min(idx_of_curr, i);
            index_map.put(input_arr[i], min_idx);
        }

        String answer = "No character present";
        int min_idx = Integer.MAX_VALUE;

        for (int i = 0; i < patt_arr.length; i++) {
            int idx = index_map.getOrDefault(patt_arr[i], Integer.MAX_VALUE);

            if (idx < min_idx) {
                min_idx = idx;
                answer = String.valueOf(patt_arr[i]);
            }

        }

        return answer;

    }

}
