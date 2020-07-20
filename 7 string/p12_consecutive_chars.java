import java.util.*;

/**
 * leetcode id : 
 * 
 * For a given string delete the elements which are appearing more than once consecutively. All letters are of lowercase
 * 
 *  
 * =========
 * example 
 * =========
 * i/p : aababbccd
 * o/p : ababcd
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * if current is equal to prev , do NOT add it to answer 
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class p12_consecutive_chars {

    public static void main(String[] args) {
        String input = "aababbccd";
        String answer = function(input);
        System.out.println(answer);
    }

    static String function(String input) {
        char[] arr = input.toCharArray();
        int n = arr.length;
        StringBuffer answer = new StringBuffer();

        answer.append(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                answer.append(arr[i]);
            }
        }

        return answer.toString();
    }

}
